package com.example.sandipghosh.mainbraintech;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by sandipghosh on 06/07/17.
 */

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText firstname, lastname,dob,email,phone,function;
    private Spinner location, experience, qualification;
    private ImageView image;
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
    Calendar dateSelected;
    private DatePickerDialog datePickerDialog;

    static final int DATE_DIALOG_ID = 0;
    private int pYear;
    private int pMonth;
    private int pDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

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

        dateSelected =  Calendar.getInstance();

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



            if(phone.getText().toString().isEmpty()) {
                errorMessage = "Please fill mobile no";
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


        } else if(v==agree) {

            checkBox.toggle();
        } else if(v==image) {

            showDialog(DATE_DIALOG_ID);
        }
    }

    private DatePickerDialog.OnDateSetListener pDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    pYear = year;
                    pMonth = monthOfYear;
                    pDay = dayOfMonth;
                    updateDisplay();
                }
            };

    private void updateDisplay() {
        dob.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(pMonth + 1).append("/")
                        .append(pDay).append("/")
                        .append(pYear).append(" "));
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        pDateSetListener,
                        pYear, pMonth, pDay);
        }
        return null;
    }
}
