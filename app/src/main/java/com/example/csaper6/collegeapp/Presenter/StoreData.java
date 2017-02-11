package com.example.csaper6.collegeapp.Presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.csaper6.collegeapp.Model.Guardian;
import com.example.csaper6.collegeapp.Model.Person;
import com.example.csaper6.collegeapp.Model.Sibling;
import com.example.csaper6.collegeapp.R;


public class StoreData extends AppCompatActivity {

    private Button b;
    public TextView t;
    private Guardian g;
    private Sibling s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_data);
        b = (Button)findViewById(R.id.button1);
        t = (TextView)findViewById(R.id.txt1);

        g = new Guardian();
        s = new Sibling();

        String appId = "E24429FD-156A-1BE0-FFD1-A379DAB79000",secretKey="9877E150-081C-240A-FF9F-1BAAB4457E00",version ="v1";
        Backendless.initApp(this, appId, secretKey, version );


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Backendless.Persistence.of(Person.class).save(g, new AsyncCallback<Person>() {
                    @Override
                    public void handleResponse(Person response) {
                        Toast.makeText(StoreData.this, "saved", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(StoreData.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
