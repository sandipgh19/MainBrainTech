package com.example.sandipghosh.mainbraintech;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name,mobile,password;
    ImageView imgshow;
    Button submit;

    private TextInputLayout emailInput;
    private TextInputLayout passwordInput;
    private TextInputLayout nameInput;
    private TextInputLayout mobileInput;

    int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        mobile = (EditText) findViewById(R.id.mobile);
        password = (EditText) findViewById(R.id.password);

        imgshow = (ImageView) findViewById(R.id.imgshow);

        submit = (Button) findViewById(R.id.stated);



    }

    @Override
    public void onClick(View v) {

        if(v==imgshow) {

            if(flag == 1) {

                password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                flag = 0;

            } else {

                password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                flag = 1;

            }
        }
        if(v==submit) {

            String username,userpassword,usermobile;

            username = name.getText().toString();
            userpassword = password.getText().toString();
            usermobile = mobile.getText().toString();

            if(!username.isEmpty()&&!usermobile.isEmpty()&&!userpassword.isEmpty()) {

                Intent intent = new Intent(this,SignUp.class);
                startActivity(intent);


            }else {

                Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_LONG).show();
            }


        }
    }
}
