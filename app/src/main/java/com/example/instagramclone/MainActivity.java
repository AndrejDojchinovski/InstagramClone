package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //ui components
    private EditText edtEmail, edtUsername, edtPassword;
    private Button btnSignUp, btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Sign Up");

        edtEmail = findViewById(R.id.edtEmail);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);

        btnSignUp.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        if (ParseUser.getCurrentUser() != null) {
            ParseUser.getCurrentUser().logOut();
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnSignUp:

                 final ParseUser appUser = new ParseUser();
                 appUser.setEmail(edtEmail.getText().toString());
                 appUser.setUsername(edtUsername.getText().toString());
                 appUser.setPassword(edtPassword.getText().toString());

                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("Signing up " + edtUsername.getText().toString());
                progressDialog.show();

                 appUser.signUpInBackground(new SignUpCallback() {
                     @Override
                     public void done(ParseException e) {
                         if (e == null) {
                             FancyToast.makeText(MainActivity.this,
                                                                appUser.getUsername() + " is signed up",
                                     FancyToast.LENGTH_SHORT, FancyToast.SUCCESS,
                                                                false).show();
                         } else {
                             FancyToast.makeText(MainActivity.this,
                                     "There was an error: " + e.getMessage(),
                                     FancyToast.LENGTH_LONG,
                                     FancyToast.ERROR,
                                     false).show();
                         }

                         progressDialog.dismiss();
                     }
                 });

                break;
            case R.id.btnLogin:

                Intent intent = new Intent (MainActivity.this, LoginActivity.class);
                startActivity(intent);

                break;

        }

    }
}