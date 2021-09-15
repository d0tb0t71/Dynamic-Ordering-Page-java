package com.shieldsoft.project_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox whipped_cream,chocolate;
    ImageButton minus_btn,plus_btn;
    Button order_now;
    EditText name_ET;
    TextView name_TV,quantity_TV,total_quantity_tv,total_TV,whipped_cream_TV,chocolate_TV,order_summary;
    Integer quan=0,raw_total=0,wc_total=0,ch_total=0;
    Boolean wc=false;
    Boolean ch=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //checkbox
        whipped_cream=findViewById(R.id.whipped_cream_id);
        chocolate=findViewById(R.id.chocolate_id);

        //plus_minus_btn
        minus_btn=findViewById(R.id.minus_id);
        plus_btn=findViewById(R.id.plus_btn);

        //button
        order_now=findViewById(R.id.order_btn);

        //edittext
        name_ET=findViewById(R.id.name_ET);

        //textview
        name_TV=findViewById(R.id.name_TV);
        quantity_TV=findViewById(R.id.quantity_TV);
        total_quantity_tv=findViewById(R.id.total_quantity_TV);
        total_TV=findViewById(R.id.total_TV);
        whipped_cream_TV=findViewById(R.id.whipped_cream_TV);
        chocolate_TV=findViewById(R.id.chocolate_TV);
        order_summary=findViewById(R.id.order_summary);



        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quan==0){
                    raw_total=0;
                    wc_total=0;
                    ch_total=0;
                    total_TV.setVisibility(TextView.VISIBLE);
                    whipped_cream_TV.setVisibility(TextView.VISIBLE);
                    chocolate_TV.setVisibility(TextView.VISIBLE);

                    total_TV.setText("Total : "+Integer.toString(raw_total+wc_total+ch_total));
                    total_quantity_tv.setVisibility(TextView.VISIBLE);
                    total_quantity_tv.setText("Quantity : "+Integer.toString(quan));
                    quantity_TV.setText(Integer.toString(quan));
                    quantity_TV.setTextColor(Color.RED);
                }
                else
                {
                    quan--;
                    raw_total=quan*5;
                    wc_total=quan*5;
                    ch_total= quan;
                    if(quan==0){
                        wc_total=0;
                        whipped_cream.setChecked(false);
                        ch_total=0;
                        chocolate.setChecked(false);

                    }
                    chocolate_TV.setVisibility(TextView.VISIBLE);
                    whipped_cream_TV.setVisibility(TextView.VISIBLE);
                    total_TV.setVisibility(TextView.VISIBLE);
                    total_TV.setText("Total : "+Integer.toString(raw_total+wc_total+ch_total));
                    total_quantity_tv.setVisibility(TextView.VISIBLE);
                    total_quantity_tv.setText("Quantity : "+Integer.toString(quan));
                    quantity_TV.setText(Integer.toString(quan));

                }
            }
        });

        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quan++;
                raw_total=quan*5;
                if(whipped_cream.isChecked()){
                    wc_total=quan*5;
                }
                if(chocolate.isChecked()){
                    ch_total= quan;
                }
                chocolate_TV.setVisibility(TextView.VISIBLE);
                whipped_cream_TV.setVisibility(TextView.VISIBLE);
                total_TV.setVisibility(TextView.VISIBLE);
                total_TV.setText("Total : "+Integer.toString(raw_total+wc_total+ch_total));
                total_quantity_tv.setVisibility(TextView.VISIBLE);
                total_quantity_tv.setText("Quantity : "+Integer.toString(quan));
                quantity_TV.setText(Integer.toString(quan));
                quantity_TV.setTextColor(Color.BLACK);

            }
        });

        name_ET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name_TV.setVisibility(TextView.VISIBLE);
                name_TV.setText("Name : "+ s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        whipped_cream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(whipped_cream.isChecked()){

                    wc=true;
                    wc_total+=quan*5;
                    total_TV.setVisibility(TextView.VISIBLE);
                    total_TV.setText("Total : "+Integer.toString(raw_total+wc_total+ch_total));
                    whipped_cream_TV.setVisibility(TextView.VISIBLE);
                    whipped_cream_TV.setText("Add whipped cream?true");


                }
                else{
                    wc_total=0;
                    total_TV.setVisibility(TextView.VISIBLE);
                    total_TV.setText("Total : "+Integer.toString(raw_total+wc_total+ch_total));
                    whipped_cream_TV.setVisibility(TextView.VISIBLE);
                    whipped_cream_TV.setText("Add whipped cream?false");
                }

            }
        });

        chocolate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(whipped_cream.isChecked()){

                    ch=true;
                    ch_total= quan;
                    total_TV.setVisibility(TextView.VISIBLE);
                    total_TV.setText("Total : "+Integer.toString(raw_total+wc_total+ch_total));
                    chocolate_TV.setVisibility(TextView.VISIBLE);
                    chocolate_TV.setText("Add chocolate cream?true");


                }
                else{
                    ch_total=0;
                    total_TV.setVisibility(TextView.VISIBLE);
                    total_TV.setText("Total : "+Integer.toString(raw_total+wc_total+ch_total));
                    chocolate_TV.setVisibility(TextView.VISIBLE);
                    chocolate_TV.setText("Add chocolate cream?false");
                }


            }
        });


        order_now.setOnClickListener(v->{


            /*String name=name_ET.getText().toString();

            if(name.equals("")){
                name_ET.setError("Enter Name");
            }
            else
            {
                name_TV.setText("Name : "+name);
                name_TV.setVisibility(TextView.VISIBLE);
            }*/







        });



    }
}