package com.example.sandipghosh.mainbraintech;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by sandipghosh on 06/07/17.
 */

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText firstname, lastname,dob,email,phone,function;
    private Spinner location, experience, qualification;
    private ImageView image,back;
    private CheckBox checkBox;
    private Button submit;
    private TextInputLayout emailInput;
    private TextInputLayout firstInput;
    private TextInputLayout lastInput;
    private TextInputLayout dobInput;
    private TextInputLayout mobileInput;
    private TextInputLayout functionInput;
    private TextInputLayout locationInput;
    private TextInputLayout experienceInput;
    private TextInputLayout qualificationInput;
    private ScrollView scrollView;
    private TextView agree;
    Calendar calendar;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        setTitle("");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        firstname = (EditText) findViewById(R.id.firstname);

        lastname = (EditText) findViewById(R.id.lastname);
        dob = (EditText) findViewById(R.id.dob);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.mobile);
        function = (EditText) findViewById(R.id.function);

        image = (ImageView) findViewById(R.id.dobimg);
        submit = (Button) findViewById(R.id.submit);

        checkBox = (CheckBox) findViewById(R.id.lastbox);

        location = (Spinner) findViewById(R.id.sloction);
        experience = (Spinner) findViewById(R.id.stotalexp);
        qualification = (Spinner) findViewById(R.id.sacademic);

        agree = (TextView) findViewById(R.id.agree);
        back = (ImageView) findViewById(R.id.back);

        firstInput = (TextInputLayout) findViewById(R.id.first_layout);
        lastInput = (TextInputLayout) findViewById(R.id.last_layout);
        dobInput = (TextInputLayout) findViewById(R.id.dob_layout);
        emailInput = (TextInputLayout) findViewById(R.id.email_layout);
        mobileInput = (TextInputLayout) findViewById(R.id.mobile_layout);
        functionInput = (TextInputLayout) findViewById(R.id.function_layout);
        locationInput = (TextInputLayout) findViewById(R.id.location_layout);
        experienceInput = (TextInputLayout) findViewById(R.id.exp_layout);
        qualificationInput = (TextInputLayout) findViewById(R.id.academic_layout);
        scrollView = (ScrollView) findViewById(R.id.signupScroll);

        calendar = Calendar.getInstance();

        List<String> location1 = new ArrayList<String>();
        location1.add("Currect Location");
        location1.add("Bengaluru");
        location1.add("Delhi");
        location1.add("Hyderabad");
        location1.add("Kolkata");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, location1);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        location.setAdapter(dataAdapter);

        List<String> exp = new ArrayList<String>();
        exp.add("Total Experience");
        exp.add("1 year");
        exp.add("2 year");
        exp.add("3 year");
        exp.add("4 year");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterexp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exp);

        // Drop down layout style - list view with radio button
        dataAdapterexp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        experience.setAdapter(dataAdapterexp);

        List<String> academic1 = new ArrayList<String>();
        academic1.add("Academic Qualification");
        academic1.add("B.Tech");
        academic1.add("B.E.");
        academic1.add("M.Tech");
        academic1.add("Phd");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapteraca = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, academic1);

        // Drop down layout style - list view with radio button
        dataAdapteraca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        qualification.setAdapter(dataAdapteraca);




        submit.setOnClickListener(this);
        agree.setOnClickListener(this);
        image.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==submit) {

            firstInput.setErrorEnabled(false);
            lastInput.setErrorEnabled(false);
            emailInput.setErrorEnabled(false);
            dobInput.setErrorEnabled(false);
            mobileInput.setErrorEnabled(false);
            functionInput.setErrorEnabled(false);
            locationInput.setErrorEnabled(false);
            experienceInput.setErrorEnabled(false);
            qualificationInput.setErrorEnabled(false);

            String errorMessage;
            if(firstname.getText().toString().isEmpty()) {
                errorMessage = "Please fill firstname";
                firstInput.setErrorEnabled(true);
                firstInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, firstInput.getTop());
                return;
            }

            if(dob.getText().toString().isEmpty()) {
                errorMessage = "Please fill Date of Birth";
                dobInput.setErrorEnabled(true);
                dobInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, dobInput.getTop());
                return;
            }

            if(email.getText().toString().isEmpty()) {
                errorMessage = "Please fill emailid";
                emailInput.setErrorEnabled(true);
                emailInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, emailInput.getTop());
                return;
            }

            if (!User.emailValid(email.getText().toString())){
                errorMessage = "Invalid email id";
                emailInput.setErrorEnabled(true);
                emailInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, emailInput.getTop());
                return;
            }


            if(phone.getText().toString().isEmpty()) {
                errorMessage = "Please fill mobile no";
                mobileInput.setErrorEnabled(true);
                mobileInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, mobileInput.getTop());
                return;
            }

            if (!User.mobileValid(phone.getText().toString())){
                errorMessage = "10 digits required";
                mobileInput.setErrorEnabled(true);
                mobileInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, mobileInput.getTop());
                return;
            }

            if(location.getSelectedItem().toString().equals("Currect Location")) {
                errorMessage = "Please select location";
                locationInput.setErrorEnabled(true);
                locationInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, locationInput.getTop());
                return;
            }

            if(experience.getSelectedItem().toString().equals("Total Experience")) {
                errorMessage = "Please select experience";
                experienceInput.setErrorEnabled(true);
                experienceInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, experienceInput.getTop());
                return;
            }

            if(qualification.getSelectedItem().toString().equals("Academic Qualification")) {
                errorMessage = "Please select qualification";
                qualificationInput.setErrorEnabled(true);
                qualificationInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, qualificationInput.getTop());
                return;
            }

            if(function.getText().toString().isEmpty()) {
                errorMessage = "Please fill function";
                functionInput.setErrorEnabled(true);
                functionInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, functionInput.getTop());
                return;
            }

            if(!checkBox.isChecked()) {
                Toast.makeText(this,"Please select the box",Toast.LENGTH_LONG).show();
                return;
            }

            Intent intent = new Intent(this,Application.class);
            startActivity(intent);


        } else if(v==agree) {

            checkBox.toggle();
        } else if(v==image) {

            dateSelected();
        } else if(v==back) {

            finish();
        }
    }




    private void dateSelected() {

        final Calendar c = calendar;
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DATE);

        DatePickerDialog datePickerDialog1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                final Calendar u = Calendar.getInstance();
                u.set(year, month, day);
                calendar.set(Calendar.DATE, day);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.YEAR, year);
                setDateTime(calendar);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog1.show();
    }

    private void setDateTime(Calendar calendar) {
        SimpleDateFormat formatMonth = new SimpleDateFormat("MMM");
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");


        int mDate = calendar.get(Calendar.DATE);
        String mMonth =formatMonth.format(calendar.getTime());
        String mYear = formatYear.format(calendar.getTime());

        dob.setText(String.valueOf(mDate)+"/"+mMonth+"/"+mYear);
    }



}
