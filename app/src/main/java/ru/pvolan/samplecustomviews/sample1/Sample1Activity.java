package ru.pvolan.samplecustomviews.sample1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.pvolan.samplecustomviews.R;
import ru.pvolan.samplecustomviews.uikit.ProfileItemView;

public class Sample1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_1);

        ProfileItemView profileItemName = findViewById(R.id.profileItemName);
        ProfileItemView profileItemPhone = findViewById(R.id.profileItemPhone);
        ProfileItemView profileItemEmail = findViewById(R.id.profileItemEmail);

        profileItemName.setValue("Vladimir");
        profileItemEmail.setValue("bzzzz@email.com");
        profileItemPhone.setValue("+71123123123123");
    }

}