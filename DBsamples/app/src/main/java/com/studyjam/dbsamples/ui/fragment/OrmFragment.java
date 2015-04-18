package com.studyjam.dbsamples.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.loadercallback.OrmCursorLoaderCallback;
import com.j256.ormlite.stmt.PreparedQuery;
import com.studyjam.dbsamples.R;
import com.studyjam.dbsamples.data.db.orm.OrmHelper;
import com.studyjam.dbsamples.data.db.orm.dao.CompanyDao;
import com.studyjam.dbsamples.data.db.orm.dao.common.CommonDao;
import com.studyjam.dbsamples.data.db.orm.dto.Company;
import com.studyjam.dbsamples.data.db.orm.dto.Person;
import com.studyjam.dbsamples.ui.adapter.PersonObjAdapter;
import com.studyjam.dbsamples.util.DLog;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Fragment for showing ORMLite usage.
 * * insert
 * * clear whole table
 * * ListView with cursor
 * * delete
 * * loading using loaders
 * <p/>
 * WARNING all DB-related operations work in UI !!!
 */
public class OrmFragment extends Fragment {

    public static final String TAG = OrmFragment.class.getSimpleName();

    public static final int ORM_LOADER_ID = 4;

    private AbsListView listView;

    private PersonObjAdapter adapter;

    private OrmHelper ormHelper;

    public static OrmFragment newInstance() {
        OrmFragment fragment = new OrmFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDB();
        setHasOptionsMenu(true);
    }

    private void initDB() {
        ormHelper = OpenHelperManager.getHelper(getActivity().getApplicationContext(), OrmHelper.class);
        ormHelper.clearDatabase();

        fillSampleData();
        try {
            CommonDao personDao = ormHelper.getDaoByClass(Person.class);
            PreparedQuery query = personDao.queryBuilder().prepare();
            OrmCursorLoaderCallback<Person, Long> personLoaderCallback = new OrmCursorLoaderCallback<Person, Long>(getActivity(), personDao, query, adapter);
            getActivity().getLoaderManager().initLoader(ORM_LOADER_ID, null, personLoaderCallback);
        } catch (SQLException e) {
            DLog.e(TAG, e.getMessage());
        }
    }

    private void fillSampleData() {
        Company company = new Company();
        company.setName("company 1");
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Арсений", "Вартанов", 30, company));
        personList.add(new Person("Евлампий", "Петров", 20, company));
        personList.add(new Person("Зольден", "Москвин", 40, company));
        personList.add(new Person("Марк", "Шульценберг", 60, company));
        personList.add(new Person("Саша", "Фитч", 18, company));

        try {
            CompanyDao companyDao = (CompanyDao) ormHelper.getDaoByClass(Company.class);
            CommonDao personDao = ormHelper.getDaoByClass(Person.class);
            companyDao.create(company, personList, personDao);
        } catch (SQLException e) {
            DLog.e(TAG, e.getMessage());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basiclistfragment, container, false);


        listView = (AbsListView) view.findViewById(android.R.id.list);
        adapter = new PersonObjAdapter(getActivity());
        ((AdapterView<ListAdapter>) listView).setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.basic_listfragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            onAddClick();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onAddClick() {
        try {
            CompanyDao companyDao = (CompanyDao) ormHelper.getDaoByClass(Company.class);
            CommonDao personDao = ormHelper.getDaoByClass(Person.class);
            List<Company> companies = companyDao.queryForAll();
            Company company = companies.get(0);
            Person person = new Person("Новый парень", String.valueOf(System.currentTimeMillis()), 8, company);
            personDao.create(person);
        } catch (SQLException e) {
            DLog.e(TAG, e.getMessage());
        }
    }
}
