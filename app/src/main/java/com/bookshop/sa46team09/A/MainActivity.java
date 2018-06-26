package com.bookshop.sa46team09.A;

//Author: Han Myint Tun A0180555A


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.bookshop.sa46team09.sa46team09a_bookshop.R;

import java.util.List;

public class MainActivity extends Activity {
    private  GridView gridView;
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        List<Books> books = Books.list();
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new BookAdapter(this, R.layout.row, books));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object bookobject = gridView.getItemAtPosition(position);
                Books booksitem = (Books) bookobject;
                Intent intent = new Intent(getApplicationContext(), BookDetailActivity.class);
                intent.putExtra("BookID", booksitem.get("BookID"));
                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                startActivity(new Intent(this, BookSearchActivity.class));
                return true;
            case R.id.item2:
                startActivity(new Intent(this, MainActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
