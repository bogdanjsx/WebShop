package com.example.webshop;

import java.util.ArrayList;

import com.example.webshop.R;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
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

public class Cart extends ListActivity{
    
	ListView lista;
	Button addbtn, buybtn;
	ArrayList<String> nume;
	ArrayAdapter<String> adapter;
	final Context context = this;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
    	
        lista = (ListView) findViewById(android.R.id.list);

        nume = new ArrayList<String>();
        nume.add("Maria"); nume.add("Diana");
        

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nume);
        setListAdapter(adapter);

        lista.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adaptor, View arg1, int position,
                    long id) {
                Toast.makeText(Cart.this, "Apasati lung pentru a sterge produsul", Toast.LENGTH_SHORT).show()    ;
            }

        });
        
        lista.setOnItemLongClickListener(new OnItemLongClickListener() {


            public boolean onItemLongClick(AdapterView<?> adaptor, View arg1, int position,
                    long id) {
            	Toast.makeText(Cart.this, "Ati sters produsul "+ adaptor.getItemAtPosition(position), Toast.LENGTH_SHORT).show()    ;
        		nume.remove(adaptor.getItemAtPosition(position));
				adapter.notifyDataSetChanged();
				return true;
            }

        });
        
        addbtn = (Button)findViewById(R.id.add_button);
        addbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	//Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
            	nume.add("CATA");
            	adapter.notifyDataSetChanged();
            }
        });
        
        buybtn = (Button)findViewById(R.id.buy_button);
        buybtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
    	 
    				// set title
    				alertDialogBuilder.setTitle("Buy notice");
    	 
    				// set dialog message
    				alertDialogBuilder
    					.setMessage("Are you sure you want to buy these items?")
    					.setCancelable(false)
    					.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
    						public void onClick(DialogInterface dialog,int id) {
    							// if this button is clicked, close
    							// current activity
    							Cart.this.finish();
    						}
    					  })
    					.setNegativeButton("No",new DialogInterface.OnClickListener() {
    						public void onClick(DialogInterface dialog,int id) {
    							// if this button is clicked, just close
    							// the dialog box and do nothing
    							dialog.cancel();
    						}
    					});
    	 
    					// create alert dialog
    					AlertDialog alertDialog = alertDialogBuilder.create();
    	 
    					// show it
    					alertDialog.show();
            }
        });
    }
}
