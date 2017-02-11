package com.example.csaper6.collegeapp.Presenter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.csaper6.collegeapp.R;

public class Login extends AppCompatActivity {

    TextInputEditText name,password;
    Button login;
    TextView newA;
    public String nameT,passwordT;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (TextInputEditText)findViewById(R.id.login_name);
        password = (TextInputEditText)findViewById(R.id.login_password);
        login = (Button)findViewById(R.id.submit);
        newA = (TextView)findViewById(R.id.newA);

        String appId = "E24429FD-156A-1BE0-FFD1-A379DAB79000",secretKey="9877E150-081C-240A-FF9F-1BAAB4457E00",version ="v1";
        Backendless.initApp(this, appId, secretKey, version );


        pd = new ProgressDialog(this,ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("Loging in...");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameT=name.getText().toString();
                passwordT=password.getText().toString();
                pd.show();
                Backendless.UserService.login(nameT, passwordT, new AsyncCallback<BackendlessUser>() {
                    public void handleResponse(BackendlessUser user) {
                        pd.cancel();
                        Toast.makeText(Login.this, "User:" + user.getUserId(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, MainActivity.class));
                    }

                    public void handleFault(BackendlessFault fault) {
                        pd.cancel();
                        Toast.makeText(Login.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        newA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Login.this, CreateAccount.class),1);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            Log.e("asdf","o");
            // Make sure the request was successful
            Log.e("asdf","k");
            name.setText(data.getStringExtra("name"));
            password.setText(data.getStringExtra("pass"));

        }
    }
}
