package com.example.androidepsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidepsi.utils.adapter.CategoriesAdapter;
import com.example.androidepsi.utils.adapter.ProductsAdapter;
import com.example.androidepsi.utils.entities.Categorie;
import com.example.androidepsi.utils.entities.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            getSupportActionBar().setTitle(bundle.getString("rayon"));
        }else{
            getSupportActionBar().setTitle("Erreur");
        }

        listView = findViewById(R.id.listProducts);
        getProducts(bundle.getString("products_url"));
    }

    private void getProducts(String url){
        RequestQueue queue = Volley.newRequestQueue(this);

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
                Toast.makeText(ProductsActivity.this, "Il semblerait qu'il y ait eu une erreur", Toast.LENGTH_LONG).show();
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

            ArrayList<Product> items = new ArrayList<Product>();

            for (int i=0;i<jArray.length();i++){
                items.add(new Product(jArray.getJSONObject(i).getString("name"), jArray.getJSONObject(i).getString("description"),jArray.getJSONObject(i).getString("picture_url")));
            }

            ListAdapter adapter = new ProductsAdapter(this, items);
            listView.setAdapter(adapter);
            listView.setDividerHeight(20);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    Intent intent = new Intent(ProductsActivity.this, ProductActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("name", items.get(position).getName());
                    bundle.putString("desc", items.get(position).getDescription());
                    bundle.putString("pic", items.get(position).getPicture_url());

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }catch (JSONException e){
            System.out.println("OUUUUUPS "+e);
        }
    }
}