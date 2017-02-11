package com.example.csaper6.collegeapp.Presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.csaper6.collegeapp.Model.Person;
import com.example.csaper6.collegeapp.R;

public class AddFamilyMember extends AppCompatActivity {

    EditText fName,lName,info;
    NumberPicker age;
    Button cancel, submit;
    Switch toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_family_member);
        fName = (EditText)findViewById(R.id.first_name);
        lName = (EditText)findViewById(R.id.last_name);
        info = (EditText)findViewById(R.id.info);
        age = (NumberPicker)findViewById(R.id.age);
        cancel = (Button)findViewById(R.id.Cancel);
        submit = (Button)findViewById(R.id.submit);
        toggle = (Switch)findViewById(R.id.toggle);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    info.setHint("Relationship");
                else
                    info.setHint("Occupation");
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        age.setMaxValue(1);
        age.setMaxValue(150);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String appId = "E24429FD-156A-1BE0-FFD1-A379DAB79000",secretKey="9877E150-081C-240A-FF9F-1BAAB4457E00",version ="v1";

                Backendless.initApp(this, appId, secretKey, version );
                BackendlessUser user = Backendless.UserService.CurrentUser();


                Backendless.Persistence.of(Person.class).save(null, new AsyncCallback<Person>() {
                    @Override
                    public void handleResponse(Person response) {
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(AddFamilyMember.this, fault.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

                finish();
            }
        });
    }
}
