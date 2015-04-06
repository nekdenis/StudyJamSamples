package com.studyjam.samples.imagelist.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

    public static void startActivityAsTop(Context context){
        Intent intent = new Intent(context, PersonsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);
        initView();
        initPersonList();
    }

    private void initView() {
        personsListView = (ListView) findViewById(R.id.persons_list_view);
    }

    private void initPersonList() {
        PersonListAdapter personsListAdapter = new PersonListAdapter(this);
        List<Person> persons = new PersonDao().getPersons();
        personsListAdapter.addAll(persons);
        personsListView.setAdapter(personsListAdapter);
    }
}
