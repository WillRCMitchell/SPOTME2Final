package ca.on.conestogac.www.spotme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ca.on.conestogac.www.spotme.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        TextView.OnEditorActionListener {
    private EditText username;
    private EditText password;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.loginInput);
        password = (EditText) findViewById(R.id.passwordInput);
        loginButton = (Button) findViewById(R.id.loginButton);
        username.setOnEditorActionListener(this);
        password.setOnEditorActionListener(this);
        loginButton.setOnClickListener(this);
    }
    int counter = 3;

    public void onClick(View view) {
        if (username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Redirecting",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Credentials",
                    Toast.LENGTH_SHORT).show();
        }
        counter--;
        if (counter == 0) {
            loginButton.setEnabled(false);
        }
        startActivity(new Intent(MainActivity.this,userProfile.class));
    }
    public void onClickSignUp(View view) {

        Toast.makeText(getApplicationContext(), "Redirecting",
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,SignUpScreen.class));
    }
    public void onClickForgot(View view) {

        Toast.makeText(getApplicationContext(), "Redirecting",
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,forgotPasswordScreen.class));
    }
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }
}

