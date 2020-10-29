package com.example.bookofmormon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    public static final String BOOK_APART = "BOOK_PART";
    public static final String BOOK_CHAPTER = "BOOK_CHAPTER";
    public static final String BOOK_VERSE = "BOOK_VERSE";
    public static final String APP_PREFS = "APPLICATION_PREFERENCE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.b_display);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               // Intent i = new Intent(getApplicationContext(),DisplayActivity.class);
              //  startActivity(i);
                openActivity2();

            }

            {

            }
        });

    }

    public void openActivity2() {

        //Name of the Book
        EditText _book = (EditText) findViewById(R.id.txtBook);
        String b_name = _book.getText().toString();


        //Chapter of the book.
        EditText _chapter = (EditText) findViewById(R.id.txtChapter);
        String b_chapter = _chapter.getText().toString();


        //Verse of the chapter.
        EditText _verse = (EditText) findViewById(R.id.txtVerse);
        String b_verse = _verse.getText().toString();


        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(BOOK_APART, b_name);
        intent.putExtra(String.valueOf(BOOK_CHAPTER), b_chapter);
        intent.putExtra(String.valueOf(BOOK_VERSE), b_verse);

        startActivity(intent);
    }

    public void onLoadScripture(View theButton) {

        SharedPreferences sharedPref = getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);

        String book = sharedPref.getString(BOOK_APART, null);

        EditText txtBook = (EditText) findViewById(R.id.txtBook);

        txtBook.setText(book);

    }
}
