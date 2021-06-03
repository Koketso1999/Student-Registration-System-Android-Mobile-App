package com.example.morapedi17000504;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//allow users to data into database
public class AddStudentActivity extends Activity implements View.OnClickListener {


//    Widgets
    private Button addTodoBtn;
    private EditText firstNameEditText, lastNameEditText, dateOfBirthEditText, genderEditText, postalAddressEditText,
            emaiLAddressEditText,
            contactNumberEditText, nextOfKinEditText, contactNextOfKinEditText, facultyEditText,programmeEditText;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        setTitle("Add Student");
        setContentView(R.layout.activity_add_student);

//        Instantiation of widgets
        firstNameEditText = findViewById(R.id.firstname_edittext);
        lastNameEditText = findViewById(R.id.last_name_edittext);
        dateOfBirthEditText = findViewById(R.id.date_of_birth_edittext);
        genderEditText = findViewById(R.id.gender_edittext);
        postalAddressEditText = findViewById(R.id.postal_address_edittext);
        emaiLAddressEditText = findViewById(R.id.email_address_edittext);
        contactNumberEditText = findViewById(R.id.contact_number_edittext);
        nextOfKinEditText = findViewById(R.id.next_of_kin_edittext);
        contactNextOfKinEditText = findViewById(R.id.contact_next_of_kin_edittext);
        facultyEditText = findViewById(R.id.faculty_edittext);
        programmeEditText = findViewById(R.id.programme);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);

    }

//
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.add_record:
                final String fname = firstNameEditText.getText().toString();
                final String lname = lastNameEditText.getText().toString();
//                final String dob= dateOfBirthEditText.getText().toString();
//                final String genderm = genderEditText.getText().toString();
                final String paddress = postalAddressEditText.getText().toString();
                final String eaddress = emaiLAddressEditText.getText().toString();
                final String contact = contactNumberEditText.getText().toString();
                final String next_kin = nextOfKinEditText.getText().toString();
                final String contact_kin = contactNextOfKinEditText.getText().toString();
                final String fac = facultyEditText.getText().toString();
                final String programmes = programmeEditText.getText().toString();

                dbManager.insert(fname, lname, paddress, eaddress, contact, next_kin, contact_kin, fac, programmes );

                Intent main = new Intent(AddStudentActivity.this, StudentListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        startActivity(main);
                break;
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}