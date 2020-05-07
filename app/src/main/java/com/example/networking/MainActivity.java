package com.example.networking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity<RequestQueue> extends AppCompatActivity {
    private TextView bTextViewrerult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bTextViewrerult = findViewById(R.id.text_viewer);
        final Button buttonparse = findViewById(R.id.button_parse);
        buttonparse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JsonTask().execute("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=brom");
            }
        });



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

                String finaljson = builder.toString();
                JSONObject parentobject = new JSONObject(finaljson);
                JSONArray parentArray = parentobject.getJSONArray("Mountain");

                StringBuilder finalBuilderbTextViewrerult = new StringBuilder();
                for (int i=0; i<parentArray.length(); i++){
                    JSONObject finalobject = parentArray.getJSONObject(i);

                   String Mountain =finalobject.getString("Mountain");
                    String ID =finalobject.getString("ID");
                   String name = finalobject.getString("name");
                   String type = finalobject.getString("type");
                   String company = finalobject.getString("company");
                   String location = finalobject.getString("location");
                   String category = finalobject.getString("category");
                   int  size = finalobject.getInt("size");
                   int  cost = finalobject.getInt("cost");

                   finalBuilderbTextViewrerult.append(Mountain +"_" + ID + "_" + name + "_" + type +"_" + company +"_"
                   +location+ "_" + category + "_" + size + "_" + cost + "\n");

                }
                return finalBuilderbTextViewrerult.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
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
            super.onPostExecute(json);
           bTextViewrerult.setText(json);

        }

    }
    private class JSNONTASK extends AsyncTask<URL,String,String>{
        @Override
        protected String doInBackground(URL... urls) {
            return null;
        }
    }


}


