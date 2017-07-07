package com.example.sandipghosh.mainbraintech;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.R.attr.bitmap;

/**
 * Created by sandipghosh on 06/07/17.
 */

public class Application extends AppCompatActivity implements View.OnClickListener {

    EditText aadhar,name,phone,dob,email,father_first,father_last,mother_first,mother_last;

    EditText c_add1,c_add2,c_pin,c_city,c_dist,c_state;

    EditText p_add1,p_add2,p_pin,p_city,p_dist,p_state;

    Spinner s_region,s_gender,s_material,s_examlevel,s_passingyear,s_board,s_post,s_category,s_office,s_pay;

    Spinner s_duties,s_exactname,s_organization,s_duration,s_jobdes;

    EditText marks,division,major_study,nature,total_emolu,additional_info,remarks,form_date,to_date;

    EditText lastdate,lastsignature,fullname;

    ImageView dobimage,toimage,formimage,dateimage,signatureimage;

    Button submit;
    int p;

    private TextInputLayout aadharInput;
    private TextInputLayout nameInput;
    private TextInputLayout phoneInput;
    private TextInputLayout dobInput;
    private TextInputLayout cadd1Input;
    private TextInputLayout cadd2Input;
    private TextInputLayout cpinInput;
    private TextInputLayout ccityInput;
    private TextInputLayout cdistInput;
    private TextInputLayout cstateInput;
    private TextInputLayout padd1Input;
    private TextInputLayout padd2Input;
    private TextInputLayout emailInput;
    private TextInputLayout fatherfirstInput;
    private TextInputLayout fatherlastInput;
    private TextInputLayout motherfirstInput;
    private TextInputLayout motherlastInput;
    private TextInputLayout ppinInput;
    private TextInputLayout pcityInput;
    private TextInputLayout pdistInput;
    private TextInputLayout pstateInput;
    private TextInputLayout lastdateInput;
    private TextInputLayout fullnameInput;
    private TextInputLayout signatureInput;

    private TextInputLayout religionInput;
    private TextInputLayout genderInput;
    private TextInputLayout maritalInput;
    private TextInputLayout examlevelInput;
    private TextInputLayout passingyearInput;
    private TextInputLayout boardInput;
    private TextInputLayout marksInput;
    private TextInputLayout divitionInput;
    private TextInputLayout majorstudyInput;
    private TextInputLayout castInput;
    private ScrollView scrollView;

    private CheckBox c2p,acceptbox;
    private TextView confirm,ptext;
    private ImageView photo;

    Calendar calendar;
    Calendar calendar1;
    Calendar calendar2;
    Calendar calendar3;

    private ImageView sigimg,back;

    String currentDate;
    private int PICK_IMAGE_REQUEST = 1;
    private Bitmap bitmap;
    private static final int STORAGE_PERMISSION_CODE = 123;
    private static final int PICK_FILE_REQUEST = 1;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        requestStoragePermission();

        setTitle("");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        aadhar = (EditText) findViewById(R.id.aadhar);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.mobile);
        dob = (EditText) findViewById(R.id.dob);
        email = (EditText) findViewById(R.id.email);
        father_first = (EditText) findViewById(R.id.father_first);
        father_last = (EditText) findViewById(R.id.father_last);
        mother_first = (EditText) findViewById(R.id.mother_first);
        mother_last = (EditText) findViewById(R.id.mother_last);
        c_add1 = (EditText) findViewById(R.id.cadd1);
        c_add2 = (EditText) findViewById(R.id.cadd2);
        c_pin = (EditText) findViewById(R.id.cpin);
        c_city = (EditText) findViewById(R.id.ccity);
        c_dist = (EditText) findViewById(R.id.cdist);
        c_state = (EditText) findViewById(R.id.cstate);
        p_add1 = (EditText) findViewById(R.id.padd1);
        p_add2 = (EditText) findViewById(R.id.padd2);
        p_pin = (EditText) findViewById(R.id.ppin);
        p_city = (EditText) findViewById(R.id.pcity);
        p_dist = (EditText) findViewById(R.id.pdist);
        p_state = (EditText) findViewById(R.id.pstate);
        s_region = (Spinner) findViewById(R.id.sregion);
        s_gender = (Spinner) findViewById(R.id.sgender);
        s_material = (Spinner) findViewById(R.id.smarital);
        s_examlevel = (Spinner) findViewById(R.id.sexamlavel);
        s_passingyear = (Spinner) findViewById(R.id.spassyear);
        s_board = (Spinner) findViewById(R.id.sboard);
        s_post = (Spinner) findViewById(R.id.spost);
        s_category = (Spinner) findViewById(R.id.scast);
        s_office = (Spinner) findViewById(R.id.soffice);
        s_pay = (Spinner) findViewById(R.id.spay);
        s_duties = (Spinner) findViewById(R.id.snature);
        s_exactname = (Spinner) findViewById(R.id.sexactname);
        s_organization = (Spinner) findViewById(R.id.sorganization);
        s_duration = (Spinner) findViewById(R.id.sduration);
        s_jobdes = (Spinner) findViewById(R.id.sjobdescription);
        marks = (EditText) findViewById(R.id.marks);
        division = (EditText) findViewById(R.id.cgpa);
        major_study = (EditText) findViewById(R.id.majorstudy);
        nature = (EditText) findViewById(R.id.employment);
        total_emolu = (EditText) findViewById(R.id.totalemoluments);
        additional_info = (EditText) findViewById(R.id.additionalInfo);
        remarks = (EditText) findViewById(R.id.remarks);
        form_date = (EditText) findViewById(R.id.dateform);
        to_date = (EditText) findViewById(R.id.dateto);
        dobimage = (ImageView) findViewById(R.id.dobimg);
        toimage = (ImageView) findViewById(R.id.imgto);
        formimage = (ImageView) findViewById(R.id.imgform);
        dateimage = (ImageView) findViewById(R.id.lastimgdate);
        signatureimage = (ImageView) findViewById(R.id.imgsignature);
        lastdate = (EditText) findViewById(R.id.lastdate);
        fullname = (EditText) findViewById(R.id.fullname);
        lastsignature = (EditText) findViewById(R.id.signature);
        submit = (Button) findViewById(R.id.register);
        c2p = (CheckBox) findViewById(R.id.c2p);
        acceptbox = (CheckBox) findViewById(R.id.lastbox);
        confirm = (TextView) findViewById(R.id.confirm);
        ptext = (TextView) findViewById(R.id.ptext);
        photo = (ImageView) findViewById(R.id.photo);
        sigimg = (ImageView) findViewById(R.id.sigimg);
        back = (ImageView) findViewById(R.id.back);

        initlayout();
        initSpinner();
        calendar = Calendar.getInstance();
        calendar1 = Calendar.getInstance();
        calendar2 = Calendar.getInstance();
        calendar3 = Calendar.getInstance();
        confirm.setOnClickListener(this);
        submit.setOnClickListener(this);
        c2p.setOnClickListener(this);
        dateimage.setOnClickListener(this);
        dobimage.setOnClickListener(this);
        toimage.setOnClickListener(this);
        formimage.setOnClickListener(this);
        ptext.setOnClickListener(this);
        photo.setOnClickListener(this);
        signatureimage.setOnClickListener(this);
        back.setOnClickListener(this);
    }


    private void initlayout() {

        aadharInput = (TextInputLayout) findViewById(R.id.aadharInput);
        nameInput = (TextInputLayout) findViewById(R.id.nameInput);
        phoneInput = (TextInputLayout) findViewById(R.id.mobileInput);
        dobInput = (TextInputLayout) findViewById(R.id.dobInput);
        emailInput = (TextInputLayout) findViewById(R.id.emailInput);
        fatherfirstInput = (TextInputLayout) findViewById(R.id.father_first_layout);
        fatherlastInput = (TextInputLayout) findViewById(R.id.father_last_layout);
        motherfirstInput = (TextInputLayout) findViewById(R.id.mother_first_layout);
        motherlastInput = (TextInputLayout) findViewById(R.id.mother_last_layout);
        cadd1Input = (TextInputLayout) findViewById(R.id.cadd1Input);
        cadd2Input = (TextInputLayout) findViewById(R.id.cadd2Input);
        cpinInput = (TextInputLayout) findViewById(R.id.cpinInput);
        ccityInput = (TextInputLayout) findViewById(R.id.ccityInput);
        cdistInput = (TextInputLayout) findViewById(R.id.cdistInput);
        cstateInput = (TextInputLayout) findViewById(R.id.cstateInput);
        padd1Input = (TextInputLayout) findViewById(R.id.padd1Input);
        padd2Input = (TextInputLayout) findViewById(R.id.padd2Input);
        ppinInput = (TextInputLayout) findViewById(R.id.ppinInput);
        pcityInput = (TextInputLayout) findViewById(R.id.pcityInput);
        pdistInput = (TextInputLayout) findViewById(R.id.pdistInput);
        pstateInput = (TextInputLayout) findViewById(R.id.pstateInput);
        religionInput = (TextInputLayout) findViewById(R.id.regionInput);
        genderInput = (TextInputLayout) findViewById(R.id.genderInput);
        maritalInput = (TextInputLayout) findViewById(R.id.maritalInput);
        examlevelInput = (TextInputLayout) findViewById(R.id.examInput);
        passingyearInput = (TextInputLayout) findViewById(R.id.passyearInput);
        boardInput = (TextInputLayout) findViewById(R.id.boardInput);
        marksInput = (TextInputLayout) findViewById(R.id.marksInput);
        divitionInput = (TextInputLayout) findViewById(R.id.cgpaInput);
        majorstudyInput = (TextInputLayout) findViewById(R.id.majorstudyInput);
        castInput = (TextInputLayout) findViewById(R.id.castInput);
        lastdateInput = (TextInputLayout) findViewById(R.id.lastdateInput);
        signatureInput = (TextInputLayout) findViewById(R.id.signatureInput);
        fullnameInput = (TextInputLayout) findViewById(R.id.fullnameInput);

        scrollView = (ScrollView) findViewById(R.id.applicationScroll);

    }

    @Override
    public void onClick(View v) {

        if(v==submit) {

            aadharInput.setErrorEnabled(false);
            nameInput.setErrorEnabled(false);
            phoneInput.setErrorEnabled(false);
            dobInput.setErrorEnabled(false);
            emailInput.setErrorEnabled(false);
            fatherfirstInput.setErrorEnabled(false);
            fatherlastInput.setErrorEnabled(false);
            motherfirstInput.setErrorEnabled(false);
            motherlastInput.setErrorEnabled(false);
            cadd1Input.setErrorEnabled(false);
            cadd2Input.setErrorEnabled(false);
            cpinInput.setErrorEnabled(false);
            ccityInput.setErrorEnabled(false);
            cdistInput.setErrorEnabled(false);
            cstateInput.setErrorEnabled(false);
            padd1Input.setErrorEnabled(false);
            padd2Input.setErrorEnabled(false);
            ppinInput.setErrorEnabled(false);
            pcityInput.setErrorEnabled(false);
            pdistInput.setErrorEnabled(false);
            pstateInput.setErrorEnabled(false);
            religionInput.setErrorEnabled(false);
            genderInput.setErrorEnabled(false);
            maritalInput.setErrorEnabled(false);
            examlevelInput.setErrorEnabled(false);
            passingyearInput.setErrorEnabled(false);
            boardInput.setErrorEnabled(false);
            marksInput.setErrorEnabled(false);
            divitionInput.setErrorEnabled(false);
            majorstudyInput.setErrorEnabled(false);
            castInput.setErrorEnabled(false);
            lastdateInput.setErrorEnabled(false);
            fullnameInput.setErrorEnabled(false);
            signatureInput.setErrorEnabled(false);

            String errorMessage;
            if(aadhar.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                aadharInput.setErrorEnabled(true);
                aadharInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, aadharInput.getTop());
                return;
            }

            if(name.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                nameInput.setErrorEnabled(true);
                nameInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, nameInput.getTop());
                return;
            }

            if(phone.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                phoneInput.setErrorEnabled(true);
                phoneInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, phoneInput.getTop());
                return;
            }

            if(dob.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                dobInput.setErrorEnabled(true);
                dobInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, dobInput.getTop());
                return;
            }

            if(email.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                emailInput.setErrorEnabled(true);
                emailInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, emailInput.getTop());
                return;
            }

            if(father_first.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                fatherfirstInput.setErrorEnabled(true);
                fatherfirstInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, fatherfirstInput.getTop());
                return;
            }


            if(mother_first.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                motherfirstInput.setErrorEnabled(true);
                motherfirstInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, motherfirstInput.getTop());
                return;
            }

            if(c_add1.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                cadd1Input.setErrorEnabled(true);
                cadd1Input.setError(errorMessage);
                scrollView.smoothScrollTo(0, cadd1Input.getTop());
                return;
            }

            if(c_add2.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                cadd2Input.setErrorEnabled(true);
                cadd2Input.setError(errorMessage);
                scrollView.smoothScrollTo(0, cadd2Input.getTop());
                return;
            }

            if(c_pin.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                cpinInput.setErrorEnabled(true);
                cpinInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, cpinInput.getTop());
                return;
            }

            if(c_city.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                ccityInput.setErrorEnabled(true);
                ccityInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, ccityInput.getTop());
                return;
            }

            if(c_dist.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                cdistInput.setErrorEnabled(true);
                cdistInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, cdistInput.getTop());
                return;
            }

            if(c_state.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                cstateInput.setErrorEnabled(true);
                cstateInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, cstateInput.getTop());
                return;
            }

            if(p_add1.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                padd1Input.setErrorEnabled(true);
                padd1Input.setError(errorMessage);
                scrollView.smoothScrollTo(0, padd1Input.getTop());
                return;
            }

            if(p_add2.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                padd2Input.setErrorEnabled(true);
                padd2Input.setError(errorMessage);
                scrollView.smoothScrollTo(0, padd2Input.getTop());
                return;
            }
            if(p_pin.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                ppinInput.setErrorEnabled(true);
                ppinInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, ppinInput.getTop());
                return;
            }
            if(p_city.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                pcityInput.setErrorEnabled(true);
                pcityInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, pcityInput.getTop());
                return;
            }
            if(p_dist.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                pdistInput.setErrorEnabled(true);
                pdistInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, pdistInput.getTop());
                return;
            }

            if(p_state.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                pstateInput.setErrorEnabled(true);
                pstateInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, pstateInput.getTop());
                return;
            }

            if(s_region.getSelectedItem().toString().equals("Religion")) {
                errorMessage = "Please select this";
                religionInput.setErrorEnabled(true);
                religionInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, religionInput.getTop());
                return;
            }
            if(s_gender.getSelectedItem().toString().equals("Gender")) {
                errorMessage = "Please select this";
                genderInput.setErrorEnabled(true);
                genderInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, genderInput.getTop());
                return;
            }
            if(s_material.getSelectedItem().toString().equals("Marital Status")) {
                errorMessage = "Please select this";
                maritalInput.setErrorEnabled(true);
                maritalInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, maritalInput.getTop());
                return;
            }
            if(s_examlevel.getSelectedItem().toString().equals("Examination Level")) {
                errorMessage = "Please select this";
                examlevelInput.setErrorEnabled(true);
                examlevelInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, examlevelInput.getTop());
                return;
            }
            if(s_passingyear.getSelectedItem().toString().equals("Passing Year")) {
                errorMessage = "Please select this";
                passingyearInput.setErrorEnabled(true);
                passingyearInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, passingyearInput.getTop());
                return;
            }
            if(s_board.getSelectedItem().toString().equals("Board/University")) {
                errorMessage = "Please select this";
                boardInput.setErrorEnabled(true);
                boardInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, boardInput.getTop());
                return;
            }
            if(marks.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                marksInput.setErrorEnabled(true);
                marksInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, marksInput.getTop());
                return;
            }
            if(division.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                divitionInput.setErrorEnabled(true);
                divitionInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, divitionInput.getTop());
                return;
            }
            if(major_study.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                majorstudyInput.setErrorEnabled(true);
                majorstudyInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, majorstudyInput.getTop());
                return;
            }
            if(s_category.getSelectedItem().toString().equals("Cast Category")) {
                errorMessage = "Please select this";
                castInput.setErrorEnabled(true);
                castInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, castInput.getTop());
                return;
            }

            if(lastdate.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                lastdateInput.setErrorEnabled(true);
                lastdateInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, lastdateInput.getTop());
                return;
            }


            if(fullname.getText().toString().isEmpty()) {
                errorMessage = "Please fill this";
                fullnameInput.setErrorEnabled(true);
                fullnameInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, fullnameInput.getTop());
                return;
            }
            if(sigimg.getVisibility() == View.GONE) {

                errorMessage = "Please fill this";
                signatureInput.setErrorEnabled(true);
                signatureInput.setError(errorMessage);
                scrollView.smoothScrollTo(0, signatureInput.getTop());
                return;
            }

            if(!acceptbox.isChecked()) {

                Toast.makeText(this,"please click on box",Toast.LENGTH_LONG).show();
                return;

            }



        } else if(v==c2p) {

            if(!c_add1.getText().toString().isEmpty()) {

                p_add1.setText(c_add1.getText().toString());
            }

            if(!c_add2.getText().toString().isEmpty()) {

                p_add2.setText(c_add2.getText().toString());
            }
            if(!c_pin.getText().toString().isEmpty()){
                p_pin.setText(c_pin.getText().toString());
            }
            if(!c_dist.getText().toString().isEmpty()) {
                p_dist.setText(c_dist.getText().toString());
            }
            if(!c_state.getText().toString().isEmpty()) {
                p_state.setText(c_state.getText().toString());
            }
            if(!c_city.getText().toString().isEmpty()) {
                p_city.setText(c_city.getText().toString());
            }


        } else if(v==confirm) {
            acceptbox.toggle();
        } else if(v==dobimage) {
            dateSelected();

        } else if(v==toimage) {
            dateSelected1();

        } else if (v==formimage) {
            dateSelected2();

        } else if (v==dateimage) {
            dateSelected3();
        } else if(v==ptext) {
            c2p.toggle();

            if(!c_add1.getText().toString().isEmpty()) {

                p_add1.setText(c_add1.getText().toString());
            }

            if(!c_add2.getText().toString().isEmpty()) {

                p_add2.setText(c_add2.getText().toString());
            }
            if(!c_pin.getText().toString().isEmpty()){
                p_pin.setText(c_pin.getText().toString());
            }
            if(!c_dist.getText().toString().isEmpty()) {
                p_dist.setText(c_dist.getText().toString());
            }
            if(!c_state.getText().toString().isEmpty()) {
                p_state.setText(c_state.getText().toString());
            }
            if(!c_city.getText().toString().isEmpty()) {
                p_city.setText(c_city.getText().toString());
            }
        } else if (v==photo) {
            p=1;
            showFileChooser();

        } else if (v==signatureimage){
            p=0;
            showFileChooser();

        } else if(v==back){

            finish();
        }
    }

    private void initSpinner() {

        List<String> relegion1 = new ArrayList<String>();
        relegion1.add("Religion");
        relegion1.add("Hindu");
        relegion1.add("Muslim");
        relegion1.add("Christan");
        relegion1.add("Other");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, relegion1);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_region.setAdapter(dataAdapter);

        List<String> gender1 = new ArrayList<String>();
        gender1.add("Gender");
        gender1.add("Male");
        gender1.add("Female");
        gender1.add("Others");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gender1);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_gender.setAdapter(dataAdapter1);

        List<String> status = new ArrayList<String>();
        status.add("Marital Status");
        status.add("Single");
        status.add("Married");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_material.setAdapter(dataAdapter2);


        List<String> label = new ArrayList<String>();
        label.add("Examination Level");
        label.add("A");
        label.add("B");
        label.add("C");
        label.add("D");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, label);

        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_examlevel.setAdapter(dataAdapter3);

        List<String> year = new ArrayList<String>();
        year.add("Passing Year");
        year.add("2014");
        year.add("2015");
        year.add("2016");
        year.add("2017");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, year);

        // Drop down layout style - list view with radio button
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_passingyear.setAdapter(dataAdapter4);

        List<String> uni = new ArrayList<String>();
        uni.add("Board/University");
        uni.add("ICSC");
        uni.add("CBSE");
        uni.add("State");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, uni);

        // Drop down layout style - list view with radio button
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_board.setAdapter(dataAdapter5);

        List<String> cast = new ArrayList<String>();
        cast.add("Cast Category");
        cast.add("General");
        cast.add("OBC");
        cast.add("SC");
        cast.add("ST");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cast);

        // Drop down layout style - list view with radio button
        dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_category.setAdapter(dataAdapter6);

        List<String> post = new ArrayList<String>();
        post.add("Post Held");
        post.add("A");
        post.add("B");
        post.add("C");
        post.add("D");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, post);

        // Drop down layout style - list view with radio button
        dataAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_post.setAdapter(dataAdapter7);

        List<String> office = new ArrayList<String>();
        office.add("Office/Institution/Organisation");
        office.add("Office");
        office.add("Institution");
        office.add("Organisation");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, office);

        // Drop down layout style - list view with radio button
        dataAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_office.setAdapter(dataAdapter8);

        List<String> pay = new ArrayList<String>();
        pay.add("Scale of Pay/Last Basic Pay");
        pay.add("A");
        pay.add("B");
        pay.add("C");
        pay.add("D");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter9 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pay);

        // Drop down layout style - list view with radio button
        dataAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_pay.setAdapter(dataAdapter9);

        List<String> nature = new ArrayList<String>();
        nature.add("Nature of Duties");
        nature.add("A");
        nature.add("B");
        nature.add("C");
        nature.add("D");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter10 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nature);

        // Drop down layout style - list view with radio button
        dataAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_duties.setAdapter(dataAdapter10);

        List<String> exact = new ArrayList<String>();
        exact.add("Exact name of the Post");
        exact.add("A");
        exact.add("B");
        exact.add("C");
        exact.add("D");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter11 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exact);

        // Drop down layout style - list view with radio button
        dataAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_exactname.setAdapter(dataAdapter11);

        List<String> organization = new ArrayList<String>();
        organization.add("Organization Name");
        organization.add("A");
        organization.add("B");
        organization.add("C");
        organization.add("D");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter12 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, organization);

        // Drop down layout style - list view with radio button
        dataAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_organization.setAdapter(dataAdapter12);

        List<String> duration = new ArrayList<String>();
        duration.add("Duration");
        duration.add("1 year");
        duration.add("2 year");
        duration.add("3 year");
        duration.add("4 year");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter13 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, duration);

        // Drop down layout style - list view with radio button
        dataAdapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_duration.setAdapter(dataAdapter13);

        List<String> des = new ArrayList<String>();
        des.add("Job Description");
        des.add("A");
        des.add("B");
        des.add("C");
        des.add("D");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter14 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, des);

        // Drop down layout style - list view with radio button
        dataAdapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        s_jobdes.setAdapter(dataAdapter14);

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

    private void dateSelected1() {

        final Calendar c = calendar1;
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DATE);

        DatePickerDialog datePickerDialog1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                final Calendar u = Calendar.getInstance();
                u.set(year, month, day);
                calendar1.set(Calendar.DATE, day);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.YEAR, year);
                setDateTime1(calendar1);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog1.show();
    }

    private void setDateTime1(Calendar calendar) {
        SimpleDateFormat formatMonth = new SimpleDateFormat("MMM");
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");


        int mDate = calendar.get(Calendar.DATE);
        String mMonth =formatMonth.format(calendar.getTime());
        String mYear = formatYear.format(calendar.getTime());

        to_date.setText(String.valueOf(mDate)+"/"+mMonth+"/"+mYear);
    }

    private void dateSelected2() {

        final Calendar c = calendar2;
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DATE);

        DatePickerDialog datePickerDialog1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                final Calendar u = Calendar.getInstance();
                u.set(year, month, day);
                calendar2.set(Calendar.DATE, day);
                calendar2.set(Calendar.MONTH, month);
                calendar2.set(Calendar.YEAR, year);
                setDateTime2(calendar2);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog1.show();
    }

    private void setDateTime2(Calendar calendar) {
        SimpleDateFormat formatMonth = new SimpleDateFormat("MMM");
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");


        int mDate = calendar.get(Calendar.DATE);
        String mMonth =formatMonth.format(calendar.getTime());
        String mYear = formatYear.format(calendar.getTime());

        form_date.setText(String.valueOf(mDate)+"/"+mMonth+"/"+mYear);
    }

    private void dateSelected3() {

        final Calendar c = calendar3;
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DATE);

        DatePickerDialog datePickerDialog1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                final Calendar u = Calendar.getInstance();
                u.set(year, month, day);
                calendar3.set(Calendar.DATE, day);
                calendar3.set(Calendar.MONTH, month);
                calendar3.set(Calendar.YEAR, year);
                setDateTime3(calendar3);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog1.show();
    }

    private void setDateTime3(Calendar calendar) {
        SimpleDateFormat formatMonth = new SimpleDateFormat("MMM");
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");


        int mDate = calendar.get(Calendar.DATE);
        String mMonth =formatMonth.format(calendar.getTime());
        String mYear = formatYear.format(calendar.getTime());

        lastdate.setText(String.valueOf(mDate)+"/"+mMonth+"/"+mYear);
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //Setting the Bitmap to ImageView
                if(p==1){
                    photo.setImageBitmap(bitmap);
                } else {
                    sigimg.setVisibility(View.VISIBLE);
                    sigimg.setImageBitmap(bitmap);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Requesting permission
    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }


    //This method will be called when the user will tap on allow or deny
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }

}
