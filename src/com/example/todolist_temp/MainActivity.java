package com.example.todolist_temp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends ListActivity {
ArrayList<String> additem = new ArrayList<String>();
ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b1 = (Button)findViewById(R.id.b1);
		final EditText et1 = (EditText)findViewById(R.id.et1);
		lv = (ListView)findViewById(R.id.lv1);
		
		b1.setOnClickListener(new OnClickListener() {
		
			public void onClick(View v){
				String item = et1.getText().toString();
				
				if(TextUtils.isEmpty(item)){
					et1.setError("please enter item");
					et1.requestFocus();
					return;
				}
				
				else {
					additem.add(item);
					ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,additem);
					lv.setAdapter(adapter);
					((EditText)findViewById(R.id.lv1)).setText(" ");
					adapter.notifyDataSetChanged();
				}
			}
					
		}
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
