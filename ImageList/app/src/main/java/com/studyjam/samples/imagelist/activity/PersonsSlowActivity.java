package com.studyjam.samples.imagelist.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.studyjam.samples.imagelist.R;
import com.studyjam.samples.imagelist.adapter.PersonListAdapter;
import com.studyjam.samples.imagelist.adapter.PersonSlowListAdapter;
import com.studyjam.samples.imagelist.data.dao.PersonDao;
import com.studyjam.samples.imagelist.data.dto.Person;

import java.util.List;

public class PersonsSlowActivity extends Activity {

    private ListView personsListView;

    public static void startActivityAsTop(Context context){
        Intent intent = new Intent(context, PersonsSlowActivity.class);
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
        personsListView =
                (ListView) findViewById(R.id.persons_list_view);
    }

    private void initPersonList() {
        List<Person> persons = new PersonDao().getPersons();
        PersonSlowListAdapter personsListAdapter = new PersonSlowListAdapter(this);
        personsListAdapter.addAll(persons);
        personsListView.setAdapter(personsListAdapter);
    }
}
