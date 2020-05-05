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
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eduguide.ui.home.Department;
import com.example.eduguide.ui.home.University;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    private static final String TAG = "Logging ";
    EditText emailID, password,fullName,phone,rollNumber,degree,departmentID,universityID;
    FirebaseAuth mFirebaseAuth;
    FirebaseDatabase database;
    DatabaseReference mDatabase;
    Button applyButton;
    private User user;
    ArrayList<HashMap<String, Object>> universityList;
    ArrayList<HashMap<String, Object>> departmentList;
    ArrayList<String> spinnerUnivList;
    ArrayList<String> spinnerDeptList;
    HashMap<String, Object> uniList;
    static String uniName;
    static String deptName;
    String[] universities = { "Select University","LUMS", "FAST-NUCES", "UET", "COMSATS", "PUCIT","UET" };
    String[] departments = { "Select Department","Computer Science", "Electrical Engineering", "Civil Engineering", "Business Administration"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailID = findViewById(R.id.emailID);
        password = findViewById(R.id.pass);
        fullName = findViewById(R.id.userName);
        phone = findViewById(R.id.phoneNumber);
        rollNumber = findViewById(R.id.rollNumber);
        degree = findViewById(R.id.DegreeName);
        String uniID;

        database = FirebaseDatabase.getInstance();

        spinnerUnivList = new ArrayList<>();

        final ArrayList<University> uniList = new ArrayList<>();

        DatabaseReference uniRef = database.getReference("universities");
        uniRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                universityList = new ArrayList<>();
                Object fieldsObj = new Object();
                HashMap fldObj;
                String tempName;
                String tempID;
                String tempPic;
                String tempLoc;
                for (DataSnapshot shot : dataSnapshot.getChildren()){
                    try {
                        fldObj = (HashMap)shot.getValue(fieldsObj.getClass());
                        tempName = shot.child("universityName").getValue(String.class);
                        tempID = shot.child("ID").getValue(String.class);
                        tempPic = shot.child("picture").getValue(String.class);
                        tempLoc = shot.child("location").getValue(String.class);
                       // uniList.add(new University(tempID,tempName,tempPic, tempLoc));

                        spinnerUnivList.add(tempName);
                    } catch (Exception ex){
                        continue;
                    }
                    fldObj.put("recKeyID", shot.getKey());
                    universityList.add(fldObj);
                    Log.d("UNIVERSITY TAG", "List of all Universities: "+ universityList);
                }

                Spinner spinnerUniv = (Spinner) findViewById(R.id.universityName);
                spinnerUniv.setPrompt("Select University");
                ArrayAdapter<String> universityAdapter = new ArrayAdapter<String>(SignUp.this, android.R.layout.simple_spinner_item, spinnerUnivList);
                universityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerUniv.setAdapter(universityAdapter);
                universityAdapter.notifyDataSetChanged();

                spinnerUniv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        uniName = parent.getItemAtPosition(position).toString();
                        //Toast.makeText(getApplicationContext(), "Selected University: "+ spinnerUnivList.get(position) ,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });




        spinnerDeptList = new ArrayList<>();
        DatabaseReference deptRef = database.getReference("departments");
        deptRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                departmentList = new ArrayList<>();
                Object fieldsObj = new Object();
                String name;
                String deptUni;
                String tempUniName;
                String uniCode;
                HashMap fldObj;
                for (DataSnapshot shot : dataSnapshot.getChildren()){
                    try {
                        fldObj = (HashMap)shot.getValue(fieldsObj.getClass());
                        name = shot.child("deptName").getValue(String.class);
                        uniCode = shot.child("universityCode").getValue(String.class);

                    } catch (Exception ex){
                        continue;
                    }
                    fldObj.put("recKeyID", shot.getKey());
                    if (!uniList.isEmpty()){
                        for (int j = 0; j< uniList.size(); j++){
                            tempUniName = uniList.get(j).getUniversityName();
                            if (tempUniName.equals(uniName)) {
                                spinnerDeptList.add(name);
                            }
                        }
                    }
                    departmentList.add(fldObj);

                    Log.d("TAAGG", " "+ name);

                    Log.d("DEPARTMENTS TAG", "List of all Departments: "+ departmentList);
                }
                Spinner spinDept = (Spinner) findViewById(R.id.departmentName);
                spinDept.setPrompt("Select Department");
                ArrayAdapter<String> departmentAdapter = new ArrayAdapter<String>(SignUp.this, android.R.layout.simple_spinner_item, spinnerDeptList);
                departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinDept.setAdapter(departmentAdapter);
                departmentAdapter.notifyDataSetChanged();

                spinDept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        deptName = parent.getItemAtPosition(position).toString();
                        // Toast.makeText(getActivity(), "Selected Department: "+ departments[position] ,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });





        applyButton=(Button) findViewById(R.id.signupButton);
        applyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String emailStr = emailID.getText().toString();
                String pwdStr = password.getText().toString();
                if (emailStr.isEmpty()){
                    emailID.setError("Please enter email address!");
                    emailID.requestFocus();
                }
                else if (pwdStr.isEmpty()){
                    password.setError("Please enter password!");
                    password.requestFocus();
                }
                else if(emailStr.isEmpty() && pwdStr.isEmpty()){
                    Toast.makeText(SignUp.this, "Fields are empty!",Toast.LENGTH_SHORT);
                }
                else if(!(emailStr.isEmpty() && pwdStr.isEmpty())){
                    String nameStr = fullName.getText().toString();
                    String phoneStr = phone.getText().toString();
                    String rollNumberStr = rollNumber.getText().toString();
                    String degreeStr = degree.getText().toString();
                    user = new User(emailStr,pwdStr,nameStr,phoneStr,"12","11",rollNumberStr,degreeStr);
                    registerUser(emailStr,pwdStr);
                }
                else {
                    Toast.makeText(SignUp.this, "An error occurred while signing up!",Toast.LENGTH_SHORT);
                }
            }
        });

        SpannableString ss = new SpannableString("Have an account? Sign In");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                startActivity(new Intent(SignUp.this, Login.class));
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#FF42BDB1"));
                ds.setUnderlineText(false);
            }
        };
        final StyleSpan boldSpan = new StyleSpan(android.graphics.Typeface.BOLD);
        ss.setSpan(boldSpan, 17, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpan, 17, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = (TextView) findViewById(R.id.textHelp);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void registerUser(String emailStr, String pwdStr){
        mFirebaseAuth.createUserWithEmailAndPassword(emailStr,pwdStr).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(SignUp.this, "Sign Up Unsuccessful! Please try again.",Toast.LENGTH_SHORT);
                }
                else {
                    FirebaseUser mUser = mFirebaseAuth.getCurrentUser();
                    updateUI(mUser);
                }
            }
        });
    }

    public void updateUI(FirebaseUser currentUser){

        mDatabase = database.getReference();
        DatabaseReference usersRef = mDatabase.child("users");
        /*String keyID = usersRef.push().getKey();
        Map<String, User> users = new HashMap<>();
        users.put(keyID, user);*/
        usersRef.push().setValue(user);
        Intent intent = new Intent(SignUp.this,MainActivity.class);
        startActivityForResult(intent,1);
    }


}
