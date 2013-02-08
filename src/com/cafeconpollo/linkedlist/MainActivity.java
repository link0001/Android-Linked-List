package com.cafeconpollo.linkedlist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements DoAction{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button addButton = (Button)findViewById(R.id.button1);
		final Button listButton = (Button)findViewById(R.id.button2);
		final Button searchButton = (Button)findViewById(R.id.button3);
		final EditText edttext = (EditText)findViewById(R.id.editText1);
		final TextView txtview1 = (TextView)findViewById(R.id.textView1);
		final TextView resulttxt = (TextView)findViewById(R.id.textView2);
		
		
		final LinkedList list = new LinkedList(this);	
		
		addButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {	
				list.addToFront(edttext.getText().toString());
				edttext.setText(""); //clear text field
				txtview1.setText("Elements in list: " + list.getCount());			
			}
		});
		listButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {	
				resulttxt.setText("");
				list.traverseList();		
			}
		});
		searchButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {	
				resulttxt.setText("");
				boolean isFound = list.searchList(edttext.getText().toString());
				if (isFound){
					resulttxt.setText("Entry was found in the List");
				}
				else{
					resulttxt.setText("Entry was NOT found in the List");					
				}
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void doAction(Object data, boolean isLastNode) {
		final TextView resulttxt = (TextView)findViewById(R.id.textView2);
		resulttxt.setText(resulttxt.getText().toString() + data.toString() + " ");
		if (isLastNode){
			resulttxt.setText(resulttxt.getText().toString() + "\\");
		}
		else{
			resulttxt.setText(resulttxt.getText().toString() + " -> ");
		}
	}

}
