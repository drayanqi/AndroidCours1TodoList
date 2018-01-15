package com.example.venancih.tp1;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by venancih on 15/01/2018.
 */
public class TodoActivity extends Activity implements View.OnClickListener {
    private Button buttonValider;
    private Button buttonEmpty;
    private TextView textView;
    private EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout);
        ListView lv = (ListView)findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, ListItem.getList()));
        buttonValider = (Button)findViewById(R.id.validateList);
        buttonEmpty = (Button)findViewById(R.id.emptyList);
        buttonValider.setOnClickListener(this);
        buttonEmpty.setOnClickListener(this);
        //lv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v instanceof Button)
        {
            Button btn = (Button)v;
            if(btn == buttonValider)
            {
                AddElementToList();
            }
            else if(btn == buttonEmpty)
            {
                ClearText();
            }
        }
    }

    public void AddElementToList()
    {
        String text = editText.getText().toString();
        if(text.length() > 0) {
            ListItem.getList().add(text);
            editText.setText("");
        }
    }

    public void ClearText()
    {
        ListItem.getList().clear();
    }
}
