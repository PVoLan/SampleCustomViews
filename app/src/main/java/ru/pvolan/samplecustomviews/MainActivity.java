package ru.pvolan.samplecustomviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.pvolan.samplecustomviews.uikit.ProfileItemView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ProfileItemView profileItemName = findViewById(R.id.profileItemName);
        ProfileItemView profileItemPhone = findViewById(R.id.profileItemPhone);
        ProfileItemView profileItemEmail = findViewById(R.id.profileItemEmail);

        profileItemName.setValue("Vladimir");
        profileItemEmail.setValue("bzzzz@email.com");
        profileItemPhone.setValue("+71123123123123");
    }


}