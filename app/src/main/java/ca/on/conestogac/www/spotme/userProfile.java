package ca.on.conestogac.www.spotme;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.net.URL;
import ca.on.conestogac.www.spotme.R;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.picasso.Picasso;

public class userProfile extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageView showPic;
    private Context context;
    private EditText urlGettin;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        context = getApplicationContext();
        urlGettin = (EditText) findViewById(R.id.urlGetting);
        mTextMessage = (TextView) findViewById(R.id.message);
        showPic = (ImageView) findViewById(R.id.showPicture);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }
    public void onClickUserData(View view) {

        Toast.makeText(getApplicationContext(), "Redirecting",
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(userProfile.this,userData.class));
    }
    public void onClickSignOut(View view) {

        Toast.makeText(getApplicationContext(), "Redirecting",
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(userProfile.this,Login.class));
    }
    public void onClickGymMaps(View view) {

        Toast.makeText(getApplicationContext(), "Redirecting",
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(userProfile.this,MapsActivity.class));
    }

    public void onClickChangeForRealImage(View view) {

        String textValue=urlGettin.getText().toString();
        Toast.makeText(getApplicationContext(), "Image Changed",
                Toast.LENGTH_SHORT).show();
        Picasso.with(context).load(textValue).into(showPic);
    }


}
