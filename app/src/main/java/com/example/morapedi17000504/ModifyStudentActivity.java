package com.example.morapedi17000504;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyStudentActivity extends AppCompatActivity implements View.OnClickListener {

//    Widgets:
    private EditText firstNameEditText, lastNameEditText, dateOfBirthEditText, genderEditText, postalAddressEditText,
            emaiLAddressEditText,
            contactNumberEditText, next_of_kin, nextOfKinEditText, contactNextOfKinEditText, facultyEditText,programmeEditText;

private Button updateBtn,deteteBtn;

private long id;
private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setTitle("Modify Record");

        setContentView(R.layout.activity_modify_student);


        dbManager = new DBManager(this);
        dbManager.open();

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

        updateBtn = findViewById(R.id.btn_update);
        deteteBtn = findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String first_name = intent.getStringExtra("first_name");
        String last_name = intent.getStringExtra("last_name");
        String date_of_birth = intent.getStringExtra("date_of_birth");
        String gender = intent.getStringExtra("gender");
        String postal_address = intent.getStringExtra("postal_address");
        String email_address = intent.getStringExtra("email_address");
        String contact_number = intent.getStringExtra("contact_number");
        String next_of_kin = intent.getStringExtra("next_of_kin");
        String next_of_kin_contact = intent.getStringExtra("next_of_kin_contact");
        String faculty = intent.getStringExtra("faculty");
        String programme = intent.getStringExtra("programme");

        id = String.valueOf(Long.parseLong(id));


        firstNameEditText.setText(first_name);
        lastNameEditText.setText(last_name);
        dateOfBirthEditText.setText(date_of_birth);
        genderEditText.setText(gender);
        postalAddressEditText.setText(postal_address);
        emaiLAddressEditText.setText(email_address);
        contactNumberEditText.setText(contact_number);
        nextOfKinEditText.setText(next_of_kin_contact);
        contactNextOfKinEditText.setText(next_of_kin);
        facultyEditText.setText(faculty);
        programmeEditText.setText(programme);

        updateBtn.setOnClickListener(this);
        deteteBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

     switch (v.getId()){
       case R.id.btn_update:
         String first_name = firstNameEditText.getText().toString();
         String last_name = lastNameEditText.getText().toString();
         String date_of_birth = dateOfBirthEditText.getText().toString();
         String gender = genderEditText.getText().toString();
         String postal_address = postalAddressEditText.getText().toString();
         String email_address = emaiLAddressEditText.getText().toString();
         String contact_number = contactNumberEditText.getText().toString();
         String next_of_kin = nextOfKinEditText.getText().toString();
         String next_of_kin_contact = contactNextOfKinEditText.getText().toString();
         String faculty = facultyEditText.getText().toString();
         String programme = programmeEditText.getText().toString();

         dbManager.update( id,  first_name,  last_name,  postal_address,
                email_address,  next_of_kin,  faculty,
                programme,  contact_number,  next_of_kin_contact );

         this.returnHome();
         break;


//      case R.id.btn_delete:
//        dbManager.delete(_id)
//                this.returnHome();
//        break;
     }
    }

 private void returnHome() {

     Intent home_intent = new Intent(getApplicationContext(),
             StudentListActivity.class)
             .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
     startActivity(home_intent);


 }
}