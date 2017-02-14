package com.example.csaper6.collegeapp.Presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.csaper6.collegeapp.Model.Guardian;
import com.example.csaper6.collegeapp.Model.Person;
import com.example.csaper6.collegeapp.Model.Sibling;
import com.example.csaper6.collegeapp.R;

public class DataTestActivity extends AppCompatActivity {
    private TextView display;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_test);

        saveButton = (Button) findViewById(R.id.button_save);
        display = (TextView) findViewById(R.id.text_display);

        Guardian mom = new Guardian("Rami", "Jin", "Pharmacist", 43);
        Sibling sister = new Sibling("Chloe", "Kim", "Sister", 15);

        Backendless.initApp(this, "E24429FD-156A-1BE0-FFD1-A379DAB79000", "9877E150-081C-240A-FF9F-1BAAB4457E00", "v1");

        Backendless.Persistence.of(Person.class).save(mom, new BackendlessCallback<Person>() {
            @Override
            public void handleResponse(Person response) {
                Toast.makeText(DataTestActivity.this, "SUCCESS!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void handleFault(BackendlessFault fault) {
                super.handleFault(fault);
                Toast.makeText(DataTestActivity.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Backendless.Persistence.of(Person.class).save(sister, new BackendlessCallback<Person>() {
            @Override
            public void handleResponse(Person response) {
                Toast.makeText(DataTestActivity.this, "SUCCESS!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                super.handleFault(fault);
                Toast.makeText(DataTestActivity.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
