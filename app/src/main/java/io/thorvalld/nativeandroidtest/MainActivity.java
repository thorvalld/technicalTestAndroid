package io.thorvalld.nativeandroidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button instance and xml binding
        Button wizardButton = findViewById(R.id.wizard_btn);

        //button click event
        wizardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToDashboard();
            }
        });
    }

    //navigation function
    void navigateToDashboard(){
        Intent intent = new Intent(MainActivity.this, Home.class);
        startActivity(intent);
    }
}