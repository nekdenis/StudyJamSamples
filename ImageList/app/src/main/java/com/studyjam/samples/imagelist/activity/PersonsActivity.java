package com.studyjam.samples.imagelist.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.studyjam.samples.imagelist.R;
import com.studyjam.samples.imagelist.adapter.PersonListAdapter;
import com.studyjam.samples.imagelist.data.dao.PersonDao;
import com.studyjam.samples.imagelist.data.dto.Person;

import java.util.List;

public class PersonsActivity extends Activity {

    private ListView personsListView;
    private EditText queryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);
        initView();
        initPersonList();
    }

    private void initView() {
        personsListView = (ListView) findViewById(R.id.persons_list_view);
        queryEditText = (EditText) findViewById(R.id.images_query_edittext);
    }

    private void initPersonList() {
        PersonListAdapter personsListAdapter = new PersonListAdapter(this);
        List<Person> persons = new PersonDao().getPersons();
        personsListAdapter.addAll(persons);
        personsListView.setAdapter(personsListAdapter);
    }
}
