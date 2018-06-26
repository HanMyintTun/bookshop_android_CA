package com.bookshop.sa46team09.A;

//Author: Han Myint Tun A0180555A


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bookshop.sa46team09.sa46team09a_bookshop.R;

public class BookSearchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_search);

        Button button =(Button) findViewById(R.id.button);
        final EditText editText=(EditText)findViewById(R.id.editText1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchTitle = editText.getText().toString();

                Intent intent = new Intent(getApplicationContext(), BookListActivity.class);
                intent.putExtra("Title", searchTitle);
                startActivity(intent);
            }
        });
    }
}
