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
import ca.on.conestogac.www.spotme.R;


public class SignUpScreen extends AppCompatActivity implements OnClickListener {
    private View view;
    private EditText fullName, emailId,
            password, confirmPassword;
    private TextView login;
    private Button signUpButton;
    private CheckBox terms_conditions;
    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;

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
        initObjects();
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

    private void initObjects() {
        inputValidation = new InputValidation(SignUpScreen.this);
        databaseHelper = new DatabaseHelper(SignUpScreen.this);
        user = new User();

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

        else {

            if (!databaseHelper.checkUser(emailId.getText().toString().trim())) {

                user.setName(fullName.getText().toString().trim());
                user.setEmail(emailId.getText().toString().trim());
                user.setPassword(password.getText().toString().trim());

                databaseHelper.addUser(user);

                // Snack Bar to show success message that record saved successfully
                Toast.makeText(getApplicationContext(), "Registered",
                        Toast.LENGTH_SHORT).show();

                startActivity(new Intent(SignUpScreen.this, Login.class));
            } else {
                Toast.makeText(getApplicationContext(), "error",
                        Toast.LENGTH_SHORT).show();
            }
        }

    }
    private void emptyInputEditText() {
        fullName.setText(null);
        emailId.setText(null);
        password.setText(null);
        confirmPassword.setText(null);
    }
}
