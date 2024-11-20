package com.example.apicallingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    JSONObject jsonObject;
    Button btn;
    ArrayList<User> users;
    ArrayList<Posts> data;
    RecyclerView recyclerView;
    SqlData sqlData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        users = new ArrayList<>();
        data = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        // Fetch data from the API and save it to SQLite
        fetch_data();

        // Set up RecyclerView with horizontal layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        sqlData = new SqlData(this);

        // Set up adapter
        UserAdapter userAdapter = new UserAdapter(MainActivity.this, data);
        recyclerView.setAdapter(userAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {


                // Fetch users from SQLite database
                users = sqlData.ReadData();

                // Add user data to posts
                // Populate the data for the RecyclerView
                for (User user : users) {
                    Posts p = new Posts(user.id, user.name, user.username, user.email, user.phone, user.website,
                            user.street, user.suite, user.city, user.zipcode, user.lat, user.lng,
                            user.company_name, user.catchPhrase, user.bs);

                    data.add(p);
                }

                // Notify adapter of data changes
                userAdapter.notifyDataSetChanged();

            }
        });


    }
    void init() {
        recyclerView = findViewById(R.id.recycle);
        btn = findViewById(R.id.btnprint);
    }
    private void fetch_data() {
        String url = "https://jsonplaceholder.typicode.com/users";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                jsonObject = response.getJSONObject(i);

                                int id = jsonObject.optInt("id", 0); // use optInt to prevent crashes
                                String name = jsonObject.optString("name", "N/A");
                                String userName = jsonObject.optString("username", "N/A");
                                String email = jsonObject.optString("email", "N/A");

                                // Fetch address fields
                                JSONObject address = jsonObject.optJSONObject("address");
                                String street = address != null ? address.optString("street", "N/A") : "N/A";
                                String suite = address != null ? address.optString("suite", "N/A") : "N/A";
                                String city = address != null ? address.optString("city", "N/A") : "N/A";
                                String zipcode = address != null ? address.optString("zipcode", "N/A") : "N/A";

                                // Fetch geo fields inside address
                                JSONObject geo = address != null ? address.optJSONObject("geo") : null;
                                String lat = geo != null ? geo.optString("lat", "0.0") : "0.0";
                                String lng = geo != null ? geo.optString("lng", "0.0") : "0.0";

                                // Fetch other user fields
                                String phone = jsonObject.optString("phone", "N/A");
                                String website = jsonObject.optString("website", "N/A");

                                // Fetch company details
                                JSONObject company = jsonObject.optJSONObject("company");
                                String company_name = company != null ? company.optString("name", "Unknown") : "Unknown";
                                String catchphrase = company != null ? company.optString("catchPhrase", "Unknown") : "Unknown";
                                String bs = company != null ? company.optString("bs", "Unknown") : "Unknown";

                                // Log user details for debugging
                                Log.d("User", "ID: " + id + ", Name: " + name);
                                Log.d("Address", street + " " + suite + " " + city + " " + zipcode);
                                Log.d("Geo", lat + ", " + lng);
                                Log.d("Company", company_name + " " + catchphrase + " " + bs);

                                // Create a User object and add it to the list
                                User u = new User(id, name, userName, email, phone, website, street, suite, city, zipcode, lat, lng, company_name, catchphrase);
                                users.add(u);

                            } catch (JSONException e) {
                                Log.e("JSONError", "Error parsing JSON response", e);
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VolleyError", "Error fetching data: " + error.getMessage());
            }
        });

        // Add request to the queue
        requestQueue.add(jsonArrayRequest);
    }




//    private void fetch_data() {
//        String url = "https://jsonplaceholder.typicode.com/users";
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                jsonObject = response.getJSONObject(i);
//
//                                int id = jsonObject.getInt("id");
//                                String name = jsonObject.getString("name");
//                                String userName = jsonObject.getString("username");
//                                String email = jsonObject.getString("email");
//
//                                // Fetch address fields
//                                JSONObject address = jsonObject.getJSONObject("address");
//                                String street = address.getString("street");
//                                String suite = address.getString("suite");
//                                String city = address.getString("city");
//                                String zipcode = address.getString("zipcode");
//
//                                // Fetch geo fields inside address
//                                JSONObject geo = address.getJSONObject("geo");
//                                String lat = geo.getString("lat");
//                                String lng = geo.getString("lng");
//
//                                // Fetch other user fields
//                                String phone = jsonObject.getString("phone");
//                                String website = jsonObject.getString("website");
//
//                                // Fetch company details
//                                JSONObject company = jsonObject.getJSONObject("company");
//                                String company_name = company.getString("name");
//                                String catchphrase = company.getString("catchPhrase");
//                                String bs = company.getString("bs");
//
//                                // Log user details for debugging
//                                Log.d("User", "ID: " + id + ", Name: " + name);
//                                Log.d("Address", street + " " + suite + " " + city + " " + zipcode);
//                                Log.d("Geo", lat + ", " + lng);
//                                Log.d("Company", company_name + " " + catchphrase + " " + bs);
//
//                                // Create a User object and add it to the list
//                                User u = new User(id, name, userName, email, phone, website, street, suite, city, zipcode, lat, lng, company_name, catchphrase);
//                                users.add(u);
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                                Log.e("JSONError", "Error parsing JSON response", e);
//                            }
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("VolleyError", "Error fetching data: " + error.getMessage());
//            }
//        });
//
//        // Add request to the queue
//        requestQueue.add(jsonArrayRequest);
//    }
}
