package com.example.webshop;

import java.util.ArrayList;

import com.example.webshop.R;

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
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.item_list);
	    	
	        lista = (ListView) findViewById(android.R.id.list);

	        nume = new ArrayList<String>();
	        nume.add("Salut"); nume.add("Buna"); nume.add("Bonjour"); nume.add("Guten Morgen");
	        nume.add("Sayonara"); nume.add("Hello"); nume.add("Hiya"); nume.add("Hey");
	        nume.add("Manowar");
	        nume.add("Salut"); nume.add("Buna"); nume.add("Bonjour"); nume.add("Guten Morgen");
	        nume.add("Sayonara"); nume.add("Hello"); nume.add("Hiya"); nume.add("Hey");
	        nume.add("Manowar");
	        nume.add("Salut"); nume.add("Buna"); nume.add("Bonjour"); nume.add("Guten Morgen");
	        nume.add("Sayonara"); nume.add("Hello"); nume.add("Hiya"); nume.add("Hey");
	        nume.add("Manowar");

	        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nume);
	        setListAdapter(adapter);

	        
	        lista.setOnItemClickListener(new OnItemClickListener() {

	            @Override
	            public void onItemClick(AdapterView<?> adaptor, View arg1, int position,
	                    long id) {
	                Toast.makeText(ItemList.this, "Ati selectat "+ adaptor.getItemAtPosition(position), Toast.LENGTH_SHORT).show()    ;
					ItemList.this.finish();
	            }

	        });
	 }
	 
}
