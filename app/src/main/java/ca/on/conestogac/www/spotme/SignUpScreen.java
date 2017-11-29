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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import modal.User;
import helpers.InputValidation;
import sql.DatabaseHelper;

public class SignUpScreen extends AppCompatActivity implements OnClickListener {
    private View view;
    private EditText fullName, emailId,
            password, confirmPassword;
    private TextView login;
    private Button signUpButton;
    private CheckBox terms_conditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        fullName =  (EditText)findViewById(R.id.fullName);
        emailId =  (EditText)findViewById(R.id.userEmailId);
        password =  (EditText)findViewById(R.id.password);
        confirmPassword =  (EditText)findViewById(R.id.confirmPassword);
        signUpButton =  (Button)findViewById(R.id.signUpBtn);
        login =  (TextView)findViewById(R.id.already_user);
        terms_conditions =  (CheckBox)findViewById(R.id.terms_conditions);
        signUpButton.setOnClickListener(this);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpBtn:

                checkValidation();
                break;

            case R.id.already_user:
                startActivity(new Intent(SignUpScreen.this, Login.class));
                break;
        }

    }

    private void checkValidation() {

        String getFullName = fullName.getText().toString();
        String getEmailId = emailId.getText().toString();
        String getPassword = password.getText().toString();
        String getConfirmPassword = confirmPassword.getText().toString();

        if (getFullName.equals("") || getFullName.length() == 0
                || getEmailId.equals("") || getEmailId.length() == 0
                || getPassword.equals("") || getPassword.length() == 0
                || getConfirmPassword.equals("")
                || getConfirmPassword.length() == 0)

            Toast.makeText(getApplicationContext(), "All fields are required",
                    Toast.LENGTH_SHORT).show();

        else if (getFullName.equals("BEARS"))
            Toast.makeText(getApplicationContext(), "Your email is invalid",
                    Toast.LENGTH_SHORT).show();

        else if (!getConfirmPassword.equals(getPassword))
            Toast.makeText(getApplicationContext(), "Password do not match",
                    Toast.LENGTH_SHORT).show();

        else if (!terms_conditions.isChecked())
            Toast.makeText(getApplicationContext(), "Please select terms and conditions",
                    Toast.LENGTH_SHORT).show();

        else{
            Toast.makeText(getApplicationContext(), "Signup Complete",
                    Toast.LENGTH_SHORT).show();
        startActivity(new Intent(SignUpScreen.this,Login.class));}
    }
}