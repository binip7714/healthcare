package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {
            {"Doctor Name : Binod Poudel", "Hospital Address : New Baneshwor", "Exp : 15yrs", "Mobile No : 9843257643", "500"},
            {"Doctor Name : Sunil Sharma", "Hospital Address : Biratnagar", "Exp : 20yrs", "Mobile No : 9843257000", "600"},
            {"Doctor Name : Alsan Poudel", "Hospital Address : Itahari", "Exp : 10yrs", "Mobile No : 9845233970", "700"},
            {"Doctor Name : Binip Ghimire", "Hospital Address : Urlabari", "Exp : 20yrs", "Mobile No : 9816307714", "650"},
            {"Doctor Name : Bedh Nidhi Khatiwada", "Hospital Address : Damak", "Exp : 35yrs", "Mobile No : 9842140780", "1000"}
    };
    private String[][] doctor_details2 = {
            {"Doctor Name : Sunil Mahara", "Hospital Address : Gatthaghar", "Exp : 5yrs", "Mobile No : 9800000000", "745"},
            {"Doctor Name : Sandeep Khadka", "Hospital Address : Koteshwor", "Exp : 9yrs", "Mobile No : 9834789823", "600"},
            {"Doctor Name : Bickey Karki", "Hospital Address : Imadol", "Exp : 7yrs", "Mobile No : 9812134500", "400"},
            {"Doctor Name : Sunil Shrestha", "Hospital Address : Chyasal", "Exp : 6yrs", "Mobile No : 9823435363", "650"},
            {"Doctor Name : Ashish Prasad Bhatt", "Hospital Address : Kailali", "Exp : 9.5yrs", "Mobile No : 9845233670", "1000"}
    };
    private String[][] doctor_details3 = {
            {"Doctor Name : Pooja Tiwari", "Hospital Address : New Baneshwor", "Exp : 10yrs", "Mobile No : 9843253680", "500"},
            {"Doctor Name : Sneha Dhusuzu", "Hospital Address : Gwarko", "Exp : 11yrs", "Mobile No : 9843200567", "600"},
            {"Doctor Name : Metisha Shrestha", "Hospital Address : Patan", "Exp : 10yrs", "Mobile No : 9842156345", "700"},
            {"Doctor Name : Saugat Dhakal", "Hospital Address : Godawari", "Exp : 20yrs", "Mobile No : 9814237654", "650"},
            {"Doctor Name : Dipesh Kumar Thapa", "Hospital Address : Rolpa", "Exp : 3.5yrs", "Mobile No : 9834627361", "1000"}
    };
    private String[][] doctor_details4 = {
            {"Doctor Name : Himal Chand Thapa", "Hospital Address : Chyasal", "Exp : 15yrs", "Mobile No : 9845673876", "500"},
            {"Doctor Name : Dhurba Lamichhane", "Hospital Address : Gothatar", "Exp : 20yrs", "Mobile No : 9840976345", "600"},
            {"Doctor Name : Rubash Mali", "Hospital Address : Lalitpur", "Exp : 13yrs", "Mobile No : 9823456345", "700"},
            {"Doctor Name : Diwash KC", "Hospital Address : Gauradaha", "Exp : 10yrs", "Mobile No : 9812453756", "650"},
            {"Doctor Name : Nawaraj Singh Thakuri", "Hospital Address : Chabahil", "Exp : 15yrs", "Mobile No : 9842135678", "1000"}
    };
    private String[][] doctor_details5 = {
            {"Doctor Name : Pratik Rouniyar", "Hospital Address : New Baneshwor", "Exp : 10yrs", "Mobile No : 9845367456", "500"},
            {"Doctor Name : Kritika Sharma", "Hospital Address : Gaushala", "Exp : 14yrs", "Mobile No : 9842345674", "600"},
            {"Doctor Name : Dristi Gurung", "Hospital Address : Boudhanagar", "Exp : 10yrs", "Mobile No : 9842345678", "700"},
            {"Doctor Name : Rose Rawal", "Hospital Address : Sankhamul", "Exp : 20yrs", "Mobile No : 9843678254", "650"},
            {"Doctor Name : Riya Kattel", "Hospital Address : Chyasal", "Exp : 10yrs", "Mobile No : 9843456789", "1000"}
    };
    TextView tv;
    Button btn;

    String[][] doctor_details = {};
    HashMap <String, String> item;
    ArrayList list;

    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewLDTitle);
        btn = findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
        doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
        doctor_details = doctor_details2;
        else
        if (title.compareTo("Surgeon")==0)
        doctor_details = doctor_details3;
        else
        if (title.compareTo("Dentist")==0)
        doctor_details = doctor_details4;
        else
        doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0; i<doctor_details.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+doctor_details[i][4]+"Rs.");
            list.add(item);


        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines, new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
                );
        ListView lst = findViewById(R.id.editTextTextBMDMultiLines);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });



    }
}