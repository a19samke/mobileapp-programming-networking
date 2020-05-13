package com.example.networking;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Mainactivity";
    ArrayList<Mountainname> items;
    ArrayAdapter<Mountainname> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,R.layout.row,items);
        ListView view = findViewById(R.id.list_view);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Mountainname mountainname = items.get(i);
                String Messeg ="get" + mountainname.getID()+
                        "get" + mountainname.getType()+
                        "The name of the mountion" + mountainname.getName() +
                        "The mountion is locatied" + mountainname.getLocation() +
                        "The mountions saize is " +mountainname.getSize() +
                        "."+ mountainname.getCost();
                Toast.makeText(MainActivity.this, Messeg, Toast.LENGTH_SHORT).show();
            }

        });
        new JsonTask().execute("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=brom");
    }

    @SuppressLint("StaticFieldLeak")
    private class JsonTask extends AsyncTask<String, String, String> {

        private HttpURLConnection connection = null;
        private BufferedReader reader = null;

        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && !isCancelled()) {
                    builder.append(line).append("\n");
                }
                return builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String json) {

            try {
                items.clear();
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0;i <jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String ID = jsonObject.getString("ID");
                    String type = jsonObject.getString("type");
                    String name = jsonObject.getString("name");
                    String location = jsonObject.getString("location");
                    int size = jsonObject.getInt("size");
                    int cost = jsonObject.getInt("cost");
                    Mountainname mountainname = new Mountainname(ID, type, name, location, size,cost);
                    items.add(mountainname);
                }
                adapter.notifyDataSetChanged();

            } catch (JSONException e) {
                Log.d(TAG, "KUNDE inte parsa" + json + "\n do to caption" + e);
            }


        }

    }

}


