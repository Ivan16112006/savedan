package com.example.savedan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editSave;
    private Button save, get;

    private SharedPreferences pref;
    private final String save_key = "save_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = findViewById(R.id.save);
        get = findViewById(R.id.get);

        init();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor edit = pref.edit();
              edit.putString(save_key, editSave.getText().toString());
                edit.apply();
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editSave.setText(pref.getString(save_key, "ooo"));
            }
        });
    }
    private void init(){
        pref = getSharedPreferences("Test", MODE_PRIVATE);
        editSave = findViewById(R.id.editTextTextPersonName);
        editSave.setText(pref.getString(save_key, "ooo"));

    }

}