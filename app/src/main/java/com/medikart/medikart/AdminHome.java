package com.medikart.medikart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AdminHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
    }
    public void loadMedicines(View view){
        MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);
        TextView txt = (TextView)findViewById(R.id.textView5);
        txt.setText(dbHandler.loadHandler());
        EditText id = (EditText)findViewById(R.id.editText);
        EditText id2 = (EditText)findViewById(R.id.editText2);
        id.setText("");
        id2.setText("");
    }
    public void addMedicine(View view){
        MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);
        EditText id = (EditText)findViewById(R.id.editText);
        EditText id2 = (EditText)findViewById(R.id.editText2);
        int med_id = Integer.parseInt(id.getText().toString());
        String name = id2.getText().toString();
        Medicine medicine = new Medicine(med_id,name);
        dbHandler.addHandler(medicine);
        id.setText("");
        id2.setText("");
    }
}
