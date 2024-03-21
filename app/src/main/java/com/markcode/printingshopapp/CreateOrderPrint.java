package com.markcode.printingshopapp;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderPrint extends AppCompatActivity {


    RadioButton selectedPrintType;
    RadioButton colored ;
    RadioButton monocrome;

    RadioGroup printType;

    RadioButton LowQuality;
    RadioButton NormalQuality;
    RadioButton HighQuality;

    RadioGroup printQuality;

    Spinner paperSizeSpinner;
    EditText et_numberPages;


    Button addPagesButton;
    Button subtractPagesButton;

    Button addCopy;
    Button subtractCopy;

    EditText et_numberCopy;


    Integer NumberOfPages;
    Integer NumberOfCopy;

    TextView txt_priceColor;
    TextView txt_priceQuality;
    TextView txt_priceSize;
    TextView txt_PricerPerPage;

    TextView txt_NumerbofPages;
    TextView txt_NumerbofCopies;
    TextView txt_totalNumberofPages;
    TextView txt_pircerPerPage2;
    TextView txt_totalBill;

    Double PricePerPage;

    Double printColorPrice;
    Double  printSizePrice;
    Double printQualityPrice;

    Integer totalNumberOfPapers;

    Double  TotalPrice;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_print);
        monocrome = findViewById(R.id.monocrome);
        colored = findViewById(R.id.colored);
        paperSizeSpinner = findViewById(R.id.paperSizeSpinner);
        et_numberPages = findViewById(R.id.et_numberOfPages);
        txt_priceColor = findViewById(R.id.txt_printColorPrice);
        txt_priceSize = findViewById(R.id.txt_printSizePrice);
        txt_priceQuality = findViewById(R.id.txt_paperQualityPrice);
        txt_PricerPerPage = findViewById(R.id.txt_totalPricePerPage);

        txt_NumerbofPages = findViewById(R.id.txt_NoPages);
        txt_NumerbofCopies = findViewById(R.id.txt_NoCopy);
        txt_totalNumberofPages = findViewById(R.id.txt_totalQuantityOfPages);
        txt_pircerPerPage2 = findViewById(R.id.txt_pricePerPage2);

        txt_totalBill = findViewById(R.id.txt_totalBill);


        addPagesButton = findViewById(R.id.btn_addPages);
        subtractPagesButton = findViewById(R.id.btn_subtractPages);

        addCopy = findViewById(R.id.btn_addCopy);
        subtractCopy = findViewById(R.id.btn_subtractCopy);

        et_numberCopy = findViewById(R.id.et_numberOfCopy);

        printQuality = findViewById(R.id.rg_quality);
        LowQuality = findViewById(R.id.lowQuality);
        NormalQuality = findViewById(R.id.NormalQuality);
        HighQuality = findViewById(R.id.HighQuality);

        printColorPrice=0.0;
        printSizePrice=0.0;
        printQualityPrice=0.0;

        TotalPrice=0.0;

        totalNumberOfPapers = 0;
        PricePerPage = 0.0;

        NumberOfPages = 1;
        NumberOfCopy = 1;

        txt_totalBill.setText(setTotalBill().toString());

        txt_NumerbofPages.setText(NumberOfPages.toString());

        et_numberPages.setText(NumberOfPages.toString());
        addPagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberOfPages+=1;
                et_numberPages.setText(NumberOfPages.toString());
                txt_NumerbofPages.setText(NumberOfPages.toString());
                txt_totalNumberofPages.setText(setTotalPage().toString());
                txt_totalBill.setText(setTotalBill().toString());

            }
        });

        subtractPagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberOfPages-=1;
                et_numberPages.setText(NumberOfPages.toString());

                txt_NumerbofPages.setText(NumberOfPages.toString());
                txt_totalNumberofPages.setText(setTotalPage().toString());


                if( NumberOfPages <= 1)
                {
                    NumberOfPages=1;
                    et_numberPages.setText(NumberOfPages.toString());

                    txt_NumerbofPages.setText(NumberOfPages.toString());
                    txt_totalNumberofPages.setText(setTotalPage().toString());
                    txt_totalBill.setText(setTotalBill().toString());
                }
                txt_totalBill.setText(setTotalBill().toString());

            }
        });

        et_numberPages.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txt_NumerbofPages.setText(et_numberPages.getText());

                if(!et_numberPages.getText().toString().isEmpty())
                {
                    NumberOfPages = Integer.parseInt(et_numberPages.getText().toString());

                }
                else
                {
                    NumberOfPages = 0;
                }
                txt_totalNumberofPages.setText(setTotalPage().toString());
                txt_totalBill.setText(setTotalBill().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        et_numberCopy.setText(NumberOfPages.toString());
        txt_NumerbofCopies.setText(NumberOfPages.toString());

        addCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NumberOfCopy +=1;
                et_numberCopy.setText(NumberOfCopy.toString());
                txt_NumerbofCopies.setText(NumberOfCopy.toString());
                txt_totalNumberofPages.setText(setTotalPage().toString());
                txt_totalBill.setText(setTotalBill().toString());

            }
        });




        subtractCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberOfCopy -=1;
                et_numberCopy.setText(NumberOfCopy.toString());
                txt_NumerbofCopies.setText( NumberOfCopy.toString());
                txt_totalNumberofPages.setText(setTotalPage().toString());

                if(NumberOfCopy <= 1)
                {
                    NumberOfCopy =1;
                    et_numberCopy.setText(NumberOfCopy.toString());
                    txt_NumerbofCopies.setText( NumberOfCopy.toString());
                    txt_totalNumberofPages.setText(setTotalPage().toString());
                }
                txt_totalBill.setText(setTotalBill().toString());
            }
        });

        et_numberCopy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txt_NumerbofCopies.setText( et_numberCopy.getText());

                if(!et_numberCopy.getText().toString().isEmpty())
                {
                    NumberOfCopy = Integer.parseInt(et_numberCopy.getText().toString());
                }
                else
                {
                    NumberOfCopy = 0;
                }


                txt_totalNumberofPages.setText(setTotalPage().toString());
                txt_totalBill.setText(setTotalBill().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        LowQuality.setButtonDrawable(R.drawable.ic_radio_button);
        NormalQuality.setButtonDrawable(R.drawable.ic_radio_button);
        HighQuality.setButtonDrawable(R.drawable.ic_radio_button);

        printQuality.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId!= -1) {
                    if (checkedId == LowQuality.getId()) {
                        printQualityPrice = -1.0;
                        txt_priceQuality.setText(printQualityPrice.toString());
                        txt_PricerPerPage.setText(setPricePerPage().toString());
                        txt_pircerPerPage2.setText(setPricePerPage().toString());

                    } else if (checkedId== NormalQuality.getId()) {
                        printQualityPrice = 0.0;
                        txt_priceQuality.setText(printQualityPrice.toString());
                        txt_PricerPerPage.setText(setPricePerPage().toString());
                        txt_pircerPerPage2.setText(setPricePerPage().toString());
                    } else {
                        printQualityPrice = 2.0;
                        txt_priceQuality.setText(printQualityPrice.toString());
                        txt_PricerPerPage.setText(setPricePerPage().toString());
                        txt_pircerPerPage2.setText(setPricePerPage().toString());

                    }
                    txt_totalBill.setText(setTotalBill().toString());
                }

            }
        });






        monocrome.setButtonDrawable(R.drawable.ic_radio_button);
        colored.setButtonDrawable(R.drawable.ic_radio_button);


        printType = findViewById(R.id.rg_print_type);
        printType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == monocrome.getId()){
                    printColorPrice = 4.0;
                    txt_priceColor.setText(printColorPrice.toString());
                    txt_PricerPerPage.setText(setPricePerPage().toString());
                    txt_pircerPerPage2.setText(setPricePerPage().toString());
                }
                else
                {
                    printColorPrice = 6.0;
                    txt_priceColor.setText(printColorPrice.toString());
                    txt_PricerPerPage.setText(setPricePerPage().toString());
                    txt_pircerPerPage2.setText(setPricePerPage().toString());
                }
                txt_totalBill.setText(setTotalBill().toString());
            }
        });




        List<String> PaperSizeList = new ArrayList<>();
        PaperSizeList.add("A4 (210 x 297 mm)");
        PaperSizeList.add("short (215.9 x 279.4 mm)");
        PaperSizeList.add("Long (215.9 x 355.6 mm)");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.customer_spiner_textstyle,PaperSizeList);
        adapter.setDropDownViewResource(R.layout.customer_spiner_textstyle);
        paperSizeSpinner.setAdapter(adapter);

        paperSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                if(selectedItem.equals("short (215.9 x 279.4 mm)"))
                {
                    printSizePrice = 1.0;
                    txt_priceSize.setText(printSizePrice.toString());
                    txt_PricerPerPage.setText(setPricePerPage().toString());
                    txt_pircerPerPage2.setText(setPricePerPage().toString());
                }
                else if(selectedItem.equals("A4 (210 x 297 mm)"))
                {
                    printSizePrice = 1.5;
                    txt_priceSize.setText(printSizePrice.toString());
                    txt_PricerPerPage.setText(setPricePerPage().toString());
                    txt_pircerPerPage2.setText(setPricePerPage().toString());
                }
                else
                {
                    printSizePrice = 2.0;
                    txt_priceSize.setText(printSizePrice.toString());
                    txt_PricerPerPage.setText(setPricePerPage().toString());
                    txt_pircerPerPage2.setText(setPricePerPage().toString());
                }
                txt_totalBill.setText(setTotalBill().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    public Double setPricePerPage(){
        PricePerPage = printColorPrice + printSizePrice + (printQualityPrice);
        return PricePerPage;
    }

    public Integer setTotalPage(){
        totalNumberOfPapers = NumberOfCopy * NumberOfPages ;
        return totalNumberOfPapers;
    }

    public Double setTotalBill()
    {
        TotalPrice = totalNumberOfPapers * PricePerPage;
        return TotalPrice;
    }




    }
