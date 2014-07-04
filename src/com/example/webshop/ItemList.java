package com.example.webshop;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.webshop.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ItemList extends ListActivity {

	ListView lista;
	ArrayList<String> nume;
	ArrayAdapter<String> adapter;
	ArrayList<Integer> preturi;
	ArrayList<Integer> iduri;
	
    public static String text = new String();
    public static int ok = 0;
	
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.item_list);
	    	
	        lista = (ListView) findViewById(android.R.id.list);

	        nume = new ArrayList<String>();
	        preturi = new ArrayList<Integer>();
	        iduri = new ArrayList<Integer>();
	        
	        for(int i=1; i<11; i++)
	        	nume.add("New product "+ i);
	        
	        RequestParams params = new RequestParams();
	        params.put("api_auth", "VECeKU2puHatudreb7A3");
	        params.put("trigger", "user_profile");
	        params.put("id_user", "35");
	        params.put("session", "61ff95571aa3db550df827f0cae10c938cd31fd2");

	        AsyncHttpClient client = new AsyncHttpClient();
	        client.get("http://10.0.2.2:5000/api/list", new JsonHttpResponseHandler() {

	            @Override
	            public void onStart() {
	                // called before request is started
	            }

	            @Override
	            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
	                // called when response HTTP status is "200 OK"
	            	System.out.println(response);
/*	            	if (response != null) { 
	            		   for (int i=0; i<response.length(); i++){ 
	            		    try {
								nume.add(response.get(i).toString());
								System.out.println(nume[-1]);
							} catch (JSONException e) {
								e.printStackTrace();
							}
	            		   } 
	            		}
	            	*/
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
	    
	    

	        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nume);
	        setListAdapter(adapter);

	        
	        lista.setOnItemClickListener(new OnItemClickListener() {

	            @Override
	            public void onItemClick(AdapterView<?> adaptor, View arg1, int position,
	                    long id) {
	                Toast.makeText(ItemList.this, "You added "+ adaptor.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
	                text = adaptor.getItemAtPosition(position).toString();
	                ok = 1;
	                Intent returnIntent = new Intent();
	                returnIntent.putExtra("result",text);
	                setResult(RESULT_OK,returnIntent);
	                finish();
					ItemList.this.finish();
	            }

	        });
	 }
	 
}
