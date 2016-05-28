package com.example.izabela.dojoteste.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.izabela.dojoteste.R;
import com.example.izabela.dojoteste.exception.UserException;
import com.example.izabela.dojoteste.model.User;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.submitButton){
            saveUser();
        }
    }

    private void saveUser(){
        //Gets the name typed in the view by the user
        EditText nameEditText= (EditText) findViewById(R.id.nameEditText);
        String userName = nameEditText.getText().toString();

        //Gets the age typed in the view by the user
        EditText ageEditText =  ageEditText = (EditText) findViewById(R.id.ageEditText);
        String userAge = ageEditText.getText().toString();

        try{
            User user = new User(userName, userAge);

            TextView welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
            welcomeTextView.setVisibility(View.VISIBLE);
        }
        catch(UserException userException){
            String errorMessage = userException.getMessage();

            if(errorMessage.equals(getString(R.string.emptyAgeErrorMessage))){
                ageEditText.requestFocus();
                ageEditText.setError(getString(R.string.emptyAgeErrorMessage));
            }

            if(errorMessage.equals(getString(R.string.emptyNameErrorMessage))){
                nameEditText.requestFocus();
                nameEditText.setError(getString(R.string.emptyNameErrorMessage));
            }

            if(errorMessage.equals(getString(R.string.maxNameErrorMessage))){
                nameEditText.requestFocus();
                nameEditText.setError(getString(R.string.maxNameErrorMessage));
            }
        }
    }
}
