package com.bookshop.sa46team09.A;

//Author: Han Myint Tun A0180555A

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bookshop.sa46team09.sa46team09a_bookshop.R;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Books> {

    private List<Books> books;
    int resource;

    public BookAdapter(Context context, int resource, List<Books> books) {
        super(context, resource, books);
        this.resource = resource;
        this.books = books;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        Books bookobj = books.get(position);
        if (bookobj != null) {
            TextView txtbookId = (TextView) v.findViewById(R.id.BookID);
            txtbookId.setText(bookobj.get("BookID"));
            TextView txttitle = (TextView) v.findViewById(R.id.Title);
            txttitle.setText(bookobj.get("Title"));
            TextView txtcategoryname = (TextView) v.findViewById(R.id.Author);
            txtcategoryname.setText(bookobj.get("Author"));
            ImageView image = (ImageView) v.findViewById(R.id.imageView2);
            image.setImageBitmap(Books.getPhoto(true, bookobj.get("ISBN")));
        }
        return v;
    }
}