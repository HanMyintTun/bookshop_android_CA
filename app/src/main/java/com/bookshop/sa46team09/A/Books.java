package com.bookshop.sa46team09.A;


//Author: Han Myint Tun A0180555A

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Books extends HashMap<String, String> {

    final static String host = "http://webapi20180622104433.azurewebsites.net/api";

    public Books(String id, String title, String categoryId, String categoryName, String isbn,String author, String stock, String price) {
        put("BookID", id);
        put("Title", title);
        put("CategoryID", categoryId);
        put("CategoryName", categoryName);
        put("ISBN", isbn);

        put("Author", author);
        put("Stock", stock);
        put("Price", price);
    }

    public static List<Books> list() {
        List<Books> list = new ArrayList<Books>();
        JSONArray a = JSONParser.getJSONArrayFromUrl(host + "/book/");
        try {

            for (int i =0; i<a.length(); i++){
                JSONObject b = a.getJSONObject(i);
                list.add(new Books(b.getString("BookID"), b.getString("Title"),b.getString("CategoryID"),b.getString("CategoryName"),b.getString("ISBN"),b.getString("Author"),
                        b.getString("Price"), b.getString("Stock")));
            }

        } catch (Exception e) {
            Log.e("Books.list()", "JSONArray error");
        }
        return(list);
    }

    public static Books getbook(String BookID){
        JSONArray a = JSONParser.getJSONArrayFromUrl(host + "/book/" + BookID);

        try {

            for (int i =0; i<a.length(); i++) {
                JSONObject b = a.getJSONObject(i);
                return new Books(b.getString("BookID"), b.getString("Title"),b.getString("CategoryID"),b.getString("CategoryName"),b.getString("ISBN"),b.getString("Author"),
                        b.getString("Stock"), b.getString("Price"));
            }
        } catch (Exception e){
            Log.e("Books.getbook()", "JSONArray error");
        }
        return(null);
    }


    final static String imageURL = "http://webapi20180622104433.azurewebsites.net/api/book/";
    public static Bitmap getPhoto(boolean thumbnail, String isbn) {
        try {
            URL url = (new URL(String.format(imageURL + isbn + "/image")));
            URLConnection conn = url.openConnection();
            InputStream ins = conn.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(ins);
            ins.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("Employee.getPhoto()", "Bitmap error");
        }
        return(null);
    }
        public static List<Books> searchBook(String url)
        {
            List<Books> booklist = new ArrayList<Books>();
            //JSONObject a = JSONParser.getJSONFromUrl(host + "/book/search/" + title);
            try {
                JSONArray a = JSONParser.getJSONArrayFromUrl(url);
                for (int i =0; i<a.length(); i++){
                    JSONObject b = a.getJSONObject(i);
                    booklist.add(new Books(b.getString("BookID"), b.getString("Title"),b.getString("CategoryID"),b.getString("CategoryName"),b.getString("ISBN"),b.getString("Author"),
                            b.getString("Stock"), b.getString("Price")));
                }
            } catch (Exception e){
                Log.e("Book.blist()", "JSONArray error");
            }
            return booklist;

        }

        public  static  List<Books> bookSearch(String title)
        {
            return  searchBook(host+"/book/search/"+title);
        }

    public static String updateBook(Books b) {
        JSONObject jbook = new JSONObject();
        try {
            jbook.put("BookID", b.get("BookID"));
            jbook.put("Title", b.get("Title"));

            jbook.put("CategoryID", b.get("CategoryID"));
            jbook.put("ISBN", b.get("ISBN"));
            jbook.put("Author", b.get("Author"));
            jbook.put("Stock", b.get("Stock"));
            jbook.put("Price", b.get("Price"));
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
        System.out.print(jbook.toString());
        String result = JSONParser.postStream(host + "/book/update", jbook.toString());

        return result;
    }



}
