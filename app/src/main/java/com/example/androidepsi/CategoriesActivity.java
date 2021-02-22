package com.example.androidepsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidepsi.utils.adapter.CategoriesAdapter;
import com.example.androidepsi.utils.entities.Categorie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class CategoriesActivity extends AppCompatActivity {

    private TextView res;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.listCateg);
        getCategories();
    }

    private void getCategories(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://djemam.com/epsi/categories";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        createList(response);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                res.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    private void createList(String response){

        try {
            JSONObject jObject = new JSONObject(response);
            String sItems = jObject.get("items").toString();
            JSONArray jArray = new JSONArray(sItems);

            ArrayList<Categorie> items = new ArrayList<Categorie>();

            for (int i=0;i<jArray.length();i++){
                items.add(new Categorie(jArray.getJSONObject(i).getString("title"), jArray.getJSONObject(i).getString("products_url")));
            }

            ListAdapter adapter = new CategoriesAdapter(this, items);
            listView.setAdapter(adapter);
            listView.setDividerHeight(20);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String url = items.get(position).getProducts_url();
                    String rayon = items.get(position).getName();
                    Intent intent = new Intent(CategoriesActivity.this, ProductsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("rayon", rayon);
                    bundle.putString("products_url", url);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }catch (JSONException e){
            System.out.println("OUUUUUPS "+e);
        }
    }
}
