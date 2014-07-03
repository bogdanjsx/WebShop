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

public class Cart extends ListActivity{
    
	ListView lista;
	Button btn;
	ArrayList<String> nume;
	ArrayAdapter<String> adapter;
	
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
                Toast.makeText(Cart.this, "Ai apasat pe "+ adaptor.getItemAtPosition(position), Toast.LENGTH_SHORT).show()    ;
            }

        });
        
        lista.setOnItemLongClickListener(new OnItemLongClickListener() {


            public boolean onItemLongClick(AdapterView<?> adaptor, View arg1, int position,
                    long id) {
        		nume.remove(adaptor.getItemAtPosition(position));
				adapter.notifyDataSetChanged();
				return true;
            }

        });
        
        btn = (Button)findViewById(R.id.add_button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(Cart.this, ItemList.class);
            	startActivity(intent);
            }
        });
        

        
    }
}
