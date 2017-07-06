package com.example.sandipghosh.mainbraintech;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;

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
    private TextInputLayout experienceInput;
    private TextInputLayout qualificationInput;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

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

        initlayout();
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
        scrollView = (ScrollView) findViewById(R.id.applicationScroll);

    }

    @Override
    public void onClick(View v) {

        if(v==submit) {


        }

    }
}
