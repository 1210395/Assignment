package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button search;
    EditText edit;
    TableLayout table;
    Spinner spinner;
    ArrayList<Student> list;
    ArrayList<String> subjectNames;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        search=findViewById(R.id.button);
        edit=findViewById(R.id.text_field);
        table=findViewById(R.id.table);
        spinner=findViewById(R.id.spinner);
        add=findViewById(R.id.add);
        add.setOnClickListener(e->{
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);

        });
        list=new ArrayList<>();
        fillStudents();
        fillSpinner();
        fillTable();
        search.setOnClickListener(e->{
            String name=edit.getText().toString().trim();
            if(name.isEmpty())
                name=spinner.getSelectedItem().toString().trim();
            Student student=searchbyName(name);
            if(student!=null)
            Toast.makeText(this, "Student "+student.getName()+" Found!!!", Toast.LENGTH_SHORT).show();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void fillSpinner(){
        subjectNames=new ArrayList<>();
        for(Student i:list){
            subjectNames.add(i.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subjectNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }
    public Student searchbyName(String name){
        if(name.isEmpty()){
            Toast.makeText(this, "Add a Name", Toast.LENGTH_SHORT).show();
        }else{
            for(Student student:list){
                if(student.getName().equals(name))
                    return student;
            }
        }
        return null;
    }
    public void fillTable(){
            table.removeViews(1,table.getChildCount()-1);
            for(Student student:list){

                TableRow row=new TableRow(this);
                row.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                row.setGravity(Gravity.CENTER);
                TextView name = new TextView(this);
                name.setText(student.getName());
                name.setPadding(10, 10, 10, 10);
                name.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                TextView age = new TextView(this);
                age.setText(String.valueOf(student.getAge()));
                age.setPadding(10, 10, 10, 10);
                age.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                TextView id = new TextView(this);
                id.setText(student.getId());
                id.setPadding(10, 10, 10, 10);
                id.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                TextView mark = new TextView(this);
                mark.setText(String.valueOf(student.getMark()));
                mark.setPadding(10, 10, 10, 10);
                mark.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                row.addView(name);
                row.addView(age);
                row.addView(id);
                row.addView(mark);
                table.addView(row);
            }
    }
    public void fillStudents(){
        list.add(new Student("Jad", 20, "S001", 85.5));
        list.add(new Student("Adam", 22, "S002", 90.0));
        list.add(new Student("Hasoon", 21, "S003", 78.5));
        list.add(new Student("Ali", 23, "S004", 92.0));
        list.add(new Student("Oreo", 19, "S005", 88.5));
        list.add(new Student("PanCake", 20, "S006", 75.0));
        list.add(new Student("Pies", 22, "S007", 82.5));
        list.add(new Student("Cookies", 21, "S008", 91.0));
        list.add(new Student("Ahmad", 24, "S009", 89.5));
        list.add(new Student("Mansaf", 20, "S010", 94.0));
    }
}