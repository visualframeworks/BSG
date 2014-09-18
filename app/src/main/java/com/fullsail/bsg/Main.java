//Chad Gibson
package com.fullsail.bsg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;


public class Main extends Activity {

    private List<ListItem> items;
    private ListData listData;
    private ListView list;
    private Button button;
    private TextView inputText;
    private TextView medText;
    private TextView avgText;
    private ArrayAdapter<ListItem> adapter;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listData = new ListData();
        items = listData.getItems();


        //find the Views in the UI
        list = (ListView) findViewById(R.id.listView);
        inputText = (TextView) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        medText = (TextView) findViewById(R.id.textView);
        avgText = (TextView) findViewById(R.id.avg);

        //create an adapter to interface with the listView
        adapter = new ArrayAdapter<ListItem>(this, android.R.layout.simple_list_item_1, items);

         //set the adapter to the listView (applies the data to the listView)
        list.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListItem newItem = new ListItem(inputText.getText().toString());
                //listData.addItem(newItem);
                if(listData.addItem(newItem)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid Entry. Try again.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                //items.add(newItem);
                adapter.notifyDataSetChanged();
                medText.setText(listData.getSizeMessage());
                avgText.setText(listData.getAverageEntryLength(inputText.getText().toString().length()));
                inputText.setText("");
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("CLICK", "List item clicked.");
                TextView listText = (TextView) view;
                String text = listText.getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("You clicked ".concat(text))
                        .setCancelable(true)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int id){
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });



    }


}
