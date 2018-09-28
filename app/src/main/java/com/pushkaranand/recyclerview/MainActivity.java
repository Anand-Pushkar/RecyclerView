package com.pushkaranand.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Data> dataList = generateData();
    RecyclerView recyclerView;
    EditText inputName;
    EditText inputCourse;
    Button Add;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = (EditText)findViewById(R.id.et_name);
        inputCourse = (EditText)findViewById(R.id.et_course);
        Add = (Button) findViewById(R.id.btn_add);

        recyclerView = (RecyclerView)findViewById((R.id.rv_data));
        adapter = new Adapter(dataList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(adapter);

        Add.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                addData();
            }
        });

    }

    public void addData(){
        String name = inputName.getText().toString();
        String course = inputCourse.getText().toString();

        dataList.add(new Data(name,course));
        adapter.notifyDataSetChanged();
        inputName.setText(null);
        inputCourse.setText(null);

    }


    static ArrayList<Data>generateData(){

        ArrayList<Data> data = new ArrayList<>();

        data.add(new Data("Pushkar","Pandora"));
        data.add(new Data("Naman","Elixir"));
        data.add(new Data("Aman","Pandora"));
        data.add(new Data("Harsh","Crux"));
        data.add(new Data("Garima","Pandora"));
        data.add(new Data("Sahib","elixir"));
        data.add(new Data("Dave","Pandora"));
        data.add(new Data("Jon","Crux"));
        data.add(new Data("Ned","Pandora"));
        data.add(new Data("Stalin","Crux"));
        data.add(new Data("Jeff","Elixir"));
        data.add(new Data("Sansa","Pandora"));
        data.add(new Data("Bob","Pandora"));
        data.add(new Data("Logan","Elixir"));
        data.add(new Data("Shaquanda","Pandora"));
        data.add(new Data("Jamal","Crux"));

        return data;
    }
}
