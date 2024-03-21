package com.markcode.printingshopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et_User;
    EditText et_password;
    Button btn_login;
    Button btn_register;
    TextView tx_login_errorMessage;

    TextView Title;



    CheckBox ibtn_seePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_User = findViewById(R.id.et_user);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        tx_login_errorMessage = findViewById(R.id.tx_login_ErrorMessage);
        Title = findViewById(R.id.txt_printType);

        ibtn_seePassword = findViewById(R.id.ibtn_seePassword);
        ibtn_seePassword.setButtonDrawable(getResources().getDrawable(R.drawable.ic_seepasswordbg));

        Typeface Titlefont = ResourcesCompat.getFont(this, R.font.title);
        Title.setTypeface(Titlefont);




        showpassword ();
        RegisterAndLoginBtn();



    }


    public void showpassword ()
    {
        ibtn_seePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    et_password.setTransformationMethod(null);
                }
                else
                    {
                    et_password.setTransformationMethod(new PasswordTransformationMethod());
                    }
            }
        });
    }

    public void RegisterAndLoginBtn()
    {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Register.class);
                startActivity(intent);

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPasswordAndUsernameRegisterd();
            }
        });

    }

    public void isPasswordAndUsernameRegisterd()
    {
        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
        List<RegisterModel> registerList=  databaseHelper.getAllUsernamePassword();

        boolean isRegistered = false;
        boolean isPasswordCorrect = false;


        for(RegisterModel resiterModel : registerList)
        {
            if(resiterModel.getUserName().equals(et_User.getText().toString()))
            {
                isRegistered = true;

                if(resiterModel.getPassword().equals(et_password.getText().toString()))
                {
                    tx_login_errorMessage.setText("Successfully Login");
                    tx_login_errorMessage.setTextColor(getResources().getColor(R.color.green));

                    isPasswordCorrect = resiterModel.getPassword().equals(et_password.getText().toString());
                    Intent intent = new Intent(MainActivity.this,MainPage.class);
                    startActivity(intent);

                }

                else if (!resiterModel.getPassword().equals(et_password.getText().toString()))
                {
                    tx_login_errorMessage.setText("Wrong password or Username");
                    tx_login_errorMessage.setTextColor(getResources().getColor(R.color.red));

                }
            }


        }

        if (!isRegistered)
        {
            tx_login_errorMessage.setText("User not registered yet");
            tx_login_errorMessage.setTextColor(getResources().getColor(R.color.red));
        }


    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}