package com.markcode.printingshopapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class Register extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private Button backButton;

    private EditText BirthDate;

    private EditText UserName;
    private  EditText Password;
    private EditText FirstName;
    private EditText LastName;

    private EditText Age;

    private Button Sign_in;
    private CheckBox seePassword;
    private EditText Re_enterPassword;
    private TextView ErrorMessage;

    DatabaseHelper databaseHelper = new DatabaseHelper(Register.this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initDatePicker();


        dateButton = findViewById(R.id.btn_Date);
        ErrorMessage = findViewById(R.id.tx_errorMessage);
        BirthDate = findViewById(R.id.et_Birthdate);
        backButton = findViewById(R.id.btn_backToLogin);
        UserName = findViewById(R.id.et_R_UserName);
        Password = findViewById(R.id.et_R_Password);
        Re_enterPassword = findViewById(R.id.et_R_Re_enterPassword);
        FirstName = findViewById(R.id.et_FirstName);
        LastName = findViewById(R.id.et_LastName);
        Age = findViewById(R.id.et_age);
        BirthDate = findViewById(R.id.et_Birthdate);
        Sign_in = findViewById(R.id.btn_Sign_in);
        seePassword = findViewById(R.id.btn_see_password);
        seePassword.setButtonDrawable(R.drawable.ic_seepasswordbg);



        BirthDate.setText(getTodaysDate());

        seePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Password.setTransformationMethod(null);
                    Re_enterPassword.setTransformationMethod(null);
                }
                else{
                    Password.setTransformationMethod(new PasswordTransformationMethod());
                    Re_enterPassword.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });


        dateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openDatePicker(v);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterModel registerModel;

                String [] fieldList = { UserName.getText().toString(),
                                        Password.getText().toString(),
                                        FirstName.getText().toString(),
                                        LastName.getText().toString(),
                                        Age.getText().toString(),
                                        BirthDate.getText().toString()
                };

                if( CheckifEmpty(fieldList) && isUserNameAvailable (UserName.getText().toString()) && CheckedPassword(Password.getText().toString(),Re_enterPassword.getText().toString())) {
                    try {
                        registerModel = new RegisterModel(-1,
                                UserName.getText().toString(),
                                Password.getText().toString(),
                                FirstName.getText().toString(),
                                LastName.getText().toString(),
                                Integer.parseInt(Age.getText().toString()),
                                BirthDate.getText().toString()

                        );

                        boolean isRegister = databaseHelper.RegisterUser(registerModel);
                        Toast.makeText(Register.this, registerModel.toString(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();

                    }

                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }




    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        month = month + 1;

        return makeDateString(day,month,year);


    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = makeDateString(dayOfMonth, month,year);
                BirthDate.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this,dateSetListener,year,month,day);
    }

    private String makeDateString(int day, int month, int year)
    {

        return getMonthFormat(month)+ " " + day+ " "+year;
    }

    private String getMonthFormat(int month)
    {
        if(month ==1)
        {
            return "JAN";
        }
        else if (month ==2)
        {
            return "FEB";
        }
        else if (month ==3)
        {
            return "MAR";
        }
        else if (month ==4)
        {
            return "APR";
        }
        else if (month ==5)
        {
            return "MAY";
        }
        else if (month ==6)
        {
            return "JUN";
        }
        else if (month ==7)
        {
            return "JUL";
        }

        else if (month ==8)
        {
            return "AUG";
        }
        else if (month ==9)
        {
            return "SEP";
        }
        else if (month ==10)
        {
            return "OCT";
        }
        else if (month ==11)
        {
            return "NOV";
        }
        else if (month ==12)
        {
            return "DEC";
        }

        return "JAN";

    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }

    public boolean CheckedPassword (String Password, String ReEntry){

        if(Password.length() < 8)
        {
            ErrorMessage.setText("Password must be 8\n characters Length");
            return false;
        }

        for (int i = 0; i < Password.length()-1;i++)
        {
            if (Password.charAt(i) == ' ')
            {
                ErrorMessage.setText("Password shouldn't\n have White Spaces");
                return false;
            }
        }

        if(!Password.equals(ReEntry))
        {
            ErrorMessage.setText("Password and Re-Entry Password\n doesn't match");
            return false;
        }

        return true;
    }

    public boolean isUserNameAvailable (String UserName)
    {
        List<RegisterModel> UserNames = databaseHelper.getAllUserName();
        for(RegisterModel userNames : UserNames)
        {
            if(UserName.equals(userNames.getUserName()))
            {
                ErrorMessage.setText("UserName already exist");
                return false;
            }

        }
        return true;
    }



    public boolean CheckifEmpty (String [] ListOfFields){

        for(String field: ListOfFields)
        {
            if(field.isEmpty())
            {
                ErrorMessage.setText("Must complete the registration");
                return false;
            }
        }

        return true;
    }




}