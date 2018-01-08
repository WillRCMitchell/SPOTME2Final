package ca.on.conestogac.www.spotme;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.view.View;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;
import helpers.InputValidation;
import modal.User;
import sql.DatabaseHelper;
import ca.on.conestogac.www.spotme.R;


    public class Login extends AppCompatActivity implements OnClickListener,
            OnEditorActionListener {
        private EditText username;
        private EditText password;
        private Button loginButton;
        private InputValidation inputValidation;
        private DatabaseHelper databaseHelper;

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
            initObjects();
        }
        int counter = 3;

        public void onClick(View view) {

                verifyFromSQLite();

            counter--;
            if (counter == 0) {
                loginButton.setEnabled(false);
            }

        }
        private void initObjects() {
            databaseHelper = new DatabaseHelper(Login.this);
            inputValidation = new InputValidation(Login.this);

        }
        public void onClickSignUp(View view) {

                Toast.makeText(getApplicationContext(), "Redirecting",
                        Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this,SignUpScreen.class));
        }
        public void onClickForgot(View view) {

            Toast.makeText(getApplicationContext(), "Redirecting",
                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this,forgotPasswordScreen.class));
        }
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            return false;
        }

        private void verifyFromSQLite() {

            if (databaseHelper.checkUser(username.getText().toString().trim()
                    , password.getText().toString().trim())) {

                Toast.makeText(getApplicationContext(), "Redirecting",
                        Toast.LENGTH_SHORT).show();
                Intent accountsIntent = new Intent(Login.this, userProfile.class);
                accountsIntent.putExtra("USERNAME", username.getText().toString().trim());
                emptyInputEditText();
                startActivity(accountsIntent);


            } else {
                Toast.makeText(getApplicationContext(), "error",
                        Toast.LENGTH_SHORT).show();
            }
        }
        private void emptyInputEditText() {
            username.setText(null);
            password.setText(null);
        }
    }
