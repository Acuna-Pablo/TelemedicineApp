package com.example.bookofmormon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {
    private Button button;
    String _book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        // Get information

        Intent intent = getIntent();
        String _book= intent.getStringExtra(MainActivity.BOOK_APART);
        String _chapter= intent.getStringExtra(String.valueOf(MainActivity.BOOK_CHAPTER));
        String _verse= intent.getStringExtra(String.valueOf(MainActivity.BOOK_VERSE));
        System.out.printf("%1$s %2$s %3$s",_book, _chapter, _verse);
       // String formattedDisplay= String.format(myFormat);

        Log.d("Checking","About to create intent with John 3:16.");


        TextView textView = findViewById(R.id.b_display);
        //textView.setText(formattedDisplay);
    }
    public void onSaveScripture(View theButton) {

        SharedPreferences sharedPrefs = getSharedPreferences(MainActivity.APP_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();

        editor.putString(MainActivity.BOOK_APART, _book);
        editor.apply();

        Toast.makeText(this, "Scripture has been saved.", Toast.LENGTH_SHORT).show();
    }
}
