package com.example.webshop;

import com.example.webshop.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.http.Header;


public class MainActivity extends Activity {

	Button btn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.start_button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	
            	Intent intent = new Intent(MainActivity.this, Cart.class);
            	startActivity(intent);
            }
        });
        
        
        RequestParams params = new RequestParams();
        params.put("api_auth", "VECeKU2puHatudreb7A3");
        params.put("trigger", "user_profile");
        params.put("id_user", "35");
        params.put("session", "61ff95571aa3db550df827f0cae10c938cd31fd2");

        AsyncHttpClient client = new AsyncHttpClient();
        client.post("https://10.0.2.2:5000/api/", params, new JsonHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            	System.out.println("SUCCESS");
                // called when response HTTP status is "200 OK"
                System.out.println(response.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, java.lang.Throwable throwable, JSONObject errorResponse) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                System.out.println("TEST");
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
            }
        });
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
 
    
}
