package com.example.todo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener
{
    private EditText editText;
    private Button btn_add_items;
    private ListView item_list;
    private ArrayList<String> values = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.text_edit);
        btn_add_items = findViewById(R.id.btn_add_text);
        item_list = findViewById(R.id.listview);
        Intent intent = new Intent(this, MainActivity2.class);

        btn_add_items.setOnClickListener(this);
        item_list.setOnItemLongClickListener(this);

        item_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(intent);
            }
        });


    }




    @Override
    public void onClick(View view) {
        String add_item = editText.getText().toString();

        if (values.contains(add_item))
        {
            Toast.makeText(getBaseContext(),"Item already exist",Toast.LENGTH_LONG).show();
        }
            else
                {
                    values.add(add_item);
                    adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,values);
                    item_list.setAdapter(adapter);
                    editText.setText("");

                }


    }




    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        final int removing_item=i;
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to delete").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                values.remove(removing_item);
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), "Item deleted", Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("Cancel",null).show();
        return true;
    }


    public String loadJSONFromAsset(Context context){
        String json = null;
        InputStream jsonFile;
        try {
            InputStream is  = getAssets().open("Todo.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");






        }
        catch (IOException ex){
            ex.printStackTrace();
            return null;
        }



        return json;
    }

    public  String Method(){
        String json = loadJSONFromAsset(this);

        return json;
    }




}
