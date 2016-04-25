package sjsu195.one2many;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    EditText firstN;
    EditText lastN;
    EditText username;
    EditText password;
    EditText passwordRe;

    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstN = (EditText) findViewById(R.id.editTextRegisterFirstN);
        lastN = (EditText) findViewById(R.id.editTextRegisterFLastN);
        username = (EditText) findViewById(R.id.editTextRegisterUsername);
        password = (EditText) findViewById(R.id.editTextRegisterPassword);
        passwordRe = (EditText) findViewById(R.id.editTextRegisterPasswordRe);

        signUp = (Button) findViewById(R.id.buttonSignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user = new ParseUser();
                if(password.getText().toString().equals(passwordRe.getText().toString())){
                    user.setUsername(username.getText().toString());
                    user.setPassword(password.getText().toString());
                    user.put("First Name", firstN.getText().toString());
                    user.put("Last Name", lastN.getText().toString());
                }

                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            // Hooray! Let them use the app now.
                            Toast a = Toast.makeText(getApplicationContext(), "Successfully Signed Up", Toast.LENGTH_LONG);
                            a.show();
                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                            Toast a = Toast.makeText(getApplicationContext(), "Sign Up Unsuccessful", Toast.LENGTH_LONG);
                            a.show();
                        }
                    }
                });
            }
        });
    }
}
