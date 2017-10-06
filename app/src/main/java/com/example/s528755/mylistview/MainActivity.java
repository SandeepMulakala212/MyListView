package com.example.s528755.mylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.example.s528755.mylistview.R.id.editText;
import static com.example.s528755.mylistview.R.id.parent;


public class MainActivity extends AppCompatActivity {

    ArrayList<NameCount> mylist = new ArrayList<NameCount>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);
        final ArrayAdapter arrayAdapter = new EventAdapClass(this, R.layout.namecount, R.id.textV1, mylist);

        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                NameCount NmCnt=mylist.get(i);
                int count= NmCnt.getcount();
                ListView listView=(ListView) findViewById(R.id.listview);
                mylist.set(i,new NameCount(NmCnt.getName(),count+1));
                listView.setAdapter(arrayAdapter);
            }
        });

    }
    public void NewEvent(View v) {
        ListView listview = (ListView) findViewById(R.id.listview);
        EditText editText = (EditText) findViewById(R.id.editText);
        String vl = editText.getText().toString();
        final ArrayAdapter arrayAdapter = new EventAdapClass(this, R.layout.namecount, R.id.textV1,mylist);
          if(vl.trim().length() == 0){
            Toast.makeText(getApplicationContext(), "Enter text to add an event", Toast.LENGTH_SHORT).show();
        }else {
              mylist.add(new NameCount(editText.getText().toString(), 0));
              listview.setAdapter(arrayAdapter);
              Toast.makeText(MainActivity.this, editText.getText() + " Created", Toast.LENGTH_LONG).show();
              editText.setText("");
          }
    }

    public void sn(View v){

        Collections.sort(mylist, new Comparator<NameCount>() {
            public int compare(NameCount name1, NameCount name2) {
                return name1.getName().compareToIgnoreCase(name2.getName());
            }
        });
        ListView lv = (ListView) findViewById(R.id.listview);
        ArrayAdapter server = new EventAdapClass(this,R.layout.namecount,R.id.textV1,mylist);
        lv.setAdapter(server);

    }


    //SORTING BY COUNT
    public void sc(View v){

        Collections.sort(mylist, new Comparator<NameCount>() {
            public int compare(NameCount name1, NameCount name2) {
                return name1.getcount().compareTo(name2.getcount());
            }
        });
        ListView lv = (ListView) findViewById(R.id.listview);
        ArrayAdapter server = new EventAdapClass(this,R.layout.namecount,R.id.textV1,mylist);
        lv.setAdapter(server);


    }


}

