package com.bookshop.sa46team09.A;

//Author: Han Myint Tun A0180555A

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bookshop.sa46team09.sa46team09a_bookshop.R;

public class BookDetailActivity extends Activity implements View.OnClickListener {

    final static int[] ids = {R.id.BookID, R.id.Title, R.id.CategoryID,R.id.CategoryName, R.id.ISBN, R.id.Author, R.id.Stock, R.id.Price};
    final static String[] keys = {"BookID", "Title", "CategoryID","CategoryName", "ISBN", "Author", "Stock", "Price"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        Intent i = getIntent();
        String BookID = i.getStringExtra("BookID");
        Books books = Books.getbook(BookID);
        show(books);

    }



    void show(Books books) {
        for (int i = 0; i < keys.length; i++) {
            EditText e = (EditText) findViewById(ids[i]);
            e.setText(books.get(keys[i]));
        }
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageBitmap(Books.getPhoto(false, books.get("ISBN")));
    }

    @Override
    public void onClick(View v){
    try{
        EditText BookID,Title,CategoryID,CategoryName,ISBN,Author,Stock,Price;
        BookID = (EditText) findViewById(R.id.BookID);
        Title = (EditText) findViewById(R.id.Title);
        CategoryID = (EditText) findViewById(R.id.CategoryID);
        CategoryName = (EditText) findViewById(R.id.CategoryName);
        ISBN = (EditText) findViewById(R.id.ISBN);
        Author = (EditText) findViewById(R.id.Author);
        Stock = (EditText) findViewById(R.id.Stock);
        Price = (EditText) findViewById(R.id.Price);
        Books updatebooklist = new Books(BookID.getText().toString(),Title.getText().toString(),CategoryID.getText().toString(),CategoryName.getText().toString(),ISBN.getText().toString(),Author.getText().toString(),Stock.getText().toString(),Price.getText().toString());
        String result = Books.updateBook(updatebooklist);
        Toast t = Toast.makeText(this, "Successfully updated", Toast.LENGTH_SHORT);
        t.show();
    }
    catch (Exception e) {
            System.out.println("Error:" + e);
    }


    }

}