package com.example.csaper6.collegeapp.Presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.csaper6.collegeapp.Model.Guardian;
import com.example.csaper6.collegeapp.Model.Person;
import com.example.csaper6.collegeapp.Model.Sibling;
import com.example.csaper6.collegeapp.R;

import java.util.ArrayList;


public class StoreData extends AppCompatActivity {
    private TextView display;
    private Button saveButton;
    private ArrayList<Person> people;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_data);

        people = new ArrayList<>();

        saveButton = (Button) findViewById(R.id.button1);
        display = (TextView) findViewById(R.id.txt1);

        Guardian mom = new Guardian("Rami", "Jin", "Pharmacist", 43);
        Sibling sister = new Sibling("Chloe", "Kim", "Sister", 15);

        Backendless.initApp(this, "E24429FD-156A-1BE0-FFD1-A379DAB79000", "9877E150-081C-240A-FF9F-1BAAB4457E00", "v1");

        Backendless.Persistence.of(Person.class).save(mom, new BackendlessCallback<Person>() {
            @Override
            public void handleResponse(Person response) {
                Toast.makeText(StoreData.this, "SUCCESS!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                super.handleFault(fault);
                Toast.makeText(StoreData.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Backendless.Persistence.of(Person.class).save(sister, new BackendlessCallback<Person>() {
            @Override
            public void handleResponse(Person response) {
                Toast.makeText(StoreData.this, "SUCCESS!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                super.handleFault(fault);
                Toast.makeText(StoreData.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Backendless.Persistence.of(Guardian.class).find(new BackendlessCallback<BackendlessCollection<Guardian>>() {
            @Override
            public void handleResponse(BackendlessCollection<Guardian> response) {
                people.addAll(response.getData());
                Log.d("sdlkfsda;f", people.toString());
            }
        });
    }
}
