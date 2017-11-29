package ca.on.conestogac.www.spotme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ca.on.conestogac.www.spotme.R;

public class forgotPasswordScreen extends AppCompatActivity implements
        OnClickListener {

    private  EditText emailId;
    private  Button submit;
    private  Button back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_screen);
        emailId = (EditText) findViewById(R.id.registered_emailid);
        submit = (Button) findViewById(R.id.forgot_button);
        back = (Button) findViewById(R.id.backToLoginBtn);
        back.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backToLoginBtn:
                startActivity(new Intent(forgotPasswordScreen.this, Login.class));
                break;
            case R.id.forgot_button:

                submitButtonTask();
                break;

        }

    }

    private void submitButtonTask() {
        String getEmailId = emailId.getText().toString();


        if (getEmailId.equals("") || getEmailId.length() == 0)

            Toast.makeText(getApplicationContext(), "Please enter your email",
                    Toast.LENGTH_SHORT).show();

        else if (getEmailId.equals(""))
            Toast.makeText(getApplicationContext(), "Your Email is invalid",
                    Toast.LENGTH_SHORT).show();

        else{
            Toast.makeText(getApplicationContext(), "Password Reset",
                    Toast.LENGTH_SHORT).show();
        startActivity(new Intent(forgotPasswordScreen.this,Login.class));}
    }

}
