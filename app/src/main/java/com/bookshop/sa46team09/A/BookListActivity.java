package com.bookshop.sa46team09.A;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ListView;

import com.bookshop.sa46team09.sa46team09a_bookshop.R;

import java.util.List;

public class BookListActivity extends ListActivity {

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_book_list);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);

        Bundle bundle = getIntent().getExtras();
        final String searchTitle = bundle.getString("Title");
        List<Books> bk = Books.bookSearch(searchTitle);

        BookAdapter adapter = new BookAdapter(this, R.layout.list, bk);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        Books bookobj = (Books) getListAdapter().getItem(position);
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.putExtra("BookID", bookobj.get("BookID"));
        startActivity(intent);
    }

}
