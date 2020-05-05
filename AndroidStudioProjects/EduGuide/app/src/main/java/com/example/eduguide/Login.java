package com.example.eduguide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText emailID, password;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    Button applyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailID = findViewById(R.id.email_id);
        password = findViewById(R.id.pass);
        applyButton = (Button) findViewById(R.id.loginButton);
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null){
                    Toast.makeText(Login.this, "You are logged in.",Toast.LENGTH_SHORT);
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivityForResult(intent, 1);
                }
                else{
                    Toast.makeText(Login.this, "Please log in.",Toast.LENGTH_SHORT);
                }

            }
        };

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailStr = emailID.getText().toString();
                String pwdStr = password.getText().toString();
                if (emailStr.isEmpty()){
                    emailID.setError("Please enter email id");
                    emailID.requestFocus();
                }
                else if (pwdStr.isEmpty()){
                    password.setError("Please enter password");
                    password.requestFocus();
                }
                else if(emailStr.isEmpty() && pwdStr.isEmpty()){
                    Toast.makeText(Login.this, "Fields are empty!",Toast.LENGTH_SHORT);
                }
                else if(!(emailStr.isEmpty() && pwdStr.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(emailStr,pwdStr).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(Login.this, "Login Error! Please log in again.",Toast.LENGTH_SHORT);
                            }
                            else{
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                startActivityForResult(intent, 1);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Login.this, "An error occurred while logging in.",Toast.LENGTH_SHORT);
                }
            }
        });


        SpannableString ss = new SpannableString("Don't have an account? Sign Up");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                startActivity(new Intent(Login.this, SignUp.class));
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#FF42BDB1"));
                ds.setUnderlineText(false);
            }
        };
        final StyleSpan boldSpan = new StyleSpan(android.graphics.Typeface.BOLD);
        ss.setSpan(boldSpan, 23, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpan, 23, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = (TextView) findViewById(R.id.textHelp);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}
