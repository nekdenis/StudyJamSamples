package com.studyjam.dbsamples.ui.fragment;


import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.studyjam.dbsamples.R;
import com.studyjam.dbsamples.data.db.provider.company.CompanyColumns;
import com.studyjam.dbsamples.data.db.provider.company.CompanyContentValues;
import com.studyjam.dbsamples.data.db.provider.company.CompanyCursor;
import com.studyjam.dbsamples.data.db.provider.company.CompanySelection;
import com.studyjam.dbsamples.data.db.provider.person.Gender;
import com.studyjam.dbsamples.data.db.provider.person.PersonColumns;
import com.studyjam.dbsamples.data.db.provider.person.PersonContentValues;
import com.studyjam.dbsamples.ui.adapter.PersonAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Fragment for showing ContentProvider usage.
 * * insert
 * * insert
 * * clear whole table
 * * ListView with cursor
 * * delete
 * * loading using loaders
 * <p/>
 * WARNING all DB-related operations work in UI !!!
 */
public class GeneratedProviderFragment extends Fragment {

    public static final String TAG = GeneratedProviderFragment.class.getSimpleName();

    public static final int CURSOR_LOADER_ID = 4;

    private AbsListView listView;

    private CursorAdapter adapter;

    public GeneratedProviderFragment() {
    }

    public static GeneratedProviderFragment newInstance() {
        GeneratedProviderFragment fragment = new GeneratedProviderFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDB();
        setHasOptionsMenu(true);
    }

    private void initDB() {
        getActivity().getContentResolver().delete(CompanyColumns.CONTENT_URI, null, null);
        getActivity().getContentResolver().delete(PersonColumns.CONTENT_URI, null, null);

        getActivity().getSupportLoaderManager().initLoader(CURSOR_LOADER_ID, null, new PersonLoaderCallback());
        fillSampleData();
    }

    private void fillSampleData() {
        CompanyContentValues company = new CompanyContentValues();
        company.putName("company 1");
        Uri uri = company.insert(getActivity().getContentResolver());
        long companyId = ContentUris.parseId(uri);

        List<ContentValues> personList = new ArrayList<ContentValues>();

        personList.add(new PersonContentValues().putAge(30).putFirstName("Арсений").putLastName("Петров").putCountryCode("").putGender(Gender.MALE).putCompanyId(companyId).values());
        personList.add(new PersonContentValues().putAge(20).putFirstName("Евлампий").putLastName("Петров").putCountryCode("").putGender(Gender.MALE).putCompanyId(companyId).values());
        personList.add(new PersonContentValues().putAge(40).putFirstName("Зольден").putLastName("Петров").putCountryCode("").putGender(Gender.MALE).putCompanyId(companyId).values());
        personList.add(new PersonContentValues().putAge(60).putFirstName("Марк").putLastName("Петров").putCountryCode("").putGender(Gender.MALE).putCompanyId(companyId).values());
        personList.add(new PersonContentValues().putAge(18).putFirstName("Саша").putLastName("Петров").putCountryCode("").putGender(Gender.FEMALE).putCompanyId(companyId).values());

        getActivity().getContentResolver().bulkInsert(PersonColumns.CONTENT_URI, personList.toArray(new ContentValues[personList.size()]));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basiclistfragment, container, false);


        listView = (AbsListView) view.findViewById(android.R.id.list);
        adapter = new PersonAdapter(getActivity(), null);
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
        CompanySelection companySelection = new CompanySelection();
        CompanyCursor companyCursor = companySelection.query(getActivity().getContentResolver());
        companyCursor.moveToFirst();

        PersonContentValues personContentValues = new PersonContentValues().putAge(8).putFirstName("Новый парень").putLastName("Петров").putCountryCode("").putGender(Gender.MALE).putCompanyId(companyCursor.getId());
        getActivity().getContentResolver().insert(PersonColumns.CONTENT_URI, personContentValues.values());
        getActivity().getSupportLoaderManager().getLoader(CURSOR_LOADER_ID).forceLoad();
    }

    private class PersonLoaderCallback implements LoaderManager.LoaderCallbacks<Cursor> {

        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            return new CursorLoader(getActivity(), PersonColumns.CONTENT_URI, null, null, null, null);
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            if (adapter != null) {
                adapter.swapCursor(data);
            }
        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {

        }
    }
}
