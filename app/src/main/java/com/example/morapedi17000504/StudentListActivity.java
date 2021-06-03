package com.example.morapedi17000504;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class StudentListActivity extends AppCompatActivity {

    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper._ID, DatabaseHelper.FIRST_NAME,
            DatabaseHelper.LAST_NAME, DatabaseHelper.POSTAL_ADDRESS,
            DatabaseHelper.EMAIL_ADDRESS, DatabaseHelper.NEXT_OF_KIN, DatabaseHelper.FACULTY,
            DatabaseHelper.PROGRAMME, String.valueOf(DatabaseHelper.CONTACT_NUMBER),
            String.valueOf(DatabaseHelper.CONTACT_KIN)};

    final int[] to = new int[] {R.id.id, R.id.title, R.id.first_name};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_emp_list);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);

        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);


//        OnclickListener for List items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewid) {

                TextView idTextView = view.findViewById(R.id.id);
                TextView titleTextView = view.findViewById(R.id.title);
                TextView first_name_TextView = view.findViewById(R.id.first_name);


                String id = idTextView.getText().toString();
                String title = titleTextView.getText().toString();
                String first_name = first_name_TextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(),
                        ModifyStudentActivity.class);

                modify_intent.putExtra("title", title);
                modify_intent.putExtra("first_name", first_name);
                modify_intent.putExtra("id", id);

                startActivity(modify_intent);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();
        if(id ==R.id.add_record){

            Intent add_mem = new Intent(this,AddStudentActivity.class);
            startActivity(add_mem);
        }

        return super.onOptionsItemSelected(item);
    }

    }
