package databases.samples.studyjam.com.dbsamples.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import java.util.ArrayList;
import java.util.List;

import databases.samples.studyjam.com.dbsamples.R;
import databases.samples.studyjam.com.dbsamples.data.db.simplecursor.dao.CoreObjectsDataSource;
import databases.samples.studyjam.com.dbsamples.data.db.simplecursor.dto.CoreObject;
import databases.samples.studyjam.com.dbsamples.ui.adapter.CoreObjectCursorAdapter;


/**
 * Fragment for showing simple cursor usage.
 * * basic insert
 * * batch insert
 * * clear whole table
 * * ListView with cursor
 * * basic delete
 *
 * WARNING all DB-related operations work in UI !!!
 */
public class CursorListFragment extends Fragment {

    private AbsListView listView;

    private CursorAdapter adapter;

    private CoreObjectsDataSource coreObjectsDataSource;

    public static CursorListFragment newInstance() {
        CursorListFragment fragment = new CursorListFragment();
        return fragment;
    }

    public CursorListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDB();
        setHasOptionsMenu(true);
    }

    @Override
    public void onDestroy() {
        if(coreObjectsDataSource!=null){
            coreObjectsDataSource.close();
        }
        super.onDestroy();
    }

    private void initDB() {
        //use it as DAO
        coreObjectsDataSource = new CoreObjectsDataSource(getActivity());
        coreObjectsDataSource.open();

        //Delete table
        coreObjectsDataSource.deleteAllCoreObjects();

        List<CoreObject> coreObjectList = new ArrayList<CoreObject>();
        coreObjectList.add(new CoreObject("First", "http://cs607121.vk.me/v607121966/134a/9pxVTMKVP78.jpg"));
        coreObjectList.add(new CoreObject("Second", "http://cs14111.vk.me/c620122/v620122214/24ff/gqL3k1NGZ0U.jpg"));
        coreObjectList.add(new CoreObject("Third", "http://cs606525.vk.me/v606525662/3f8b/11NVcg3VGQM.jpg"));
        coreObjectList.add(new CoreObject("Forth", "https://b-a.d-cd.net/6580468s-240.jpg"));

        //Batch insert of objects in list
        coreObjectsDataSource.insertCoreObjects(coreObjectList);

        //Cursor adapter with all data that contains in CoreObject table
        adapter = new CoreObjectCursorAdapter(getActivity(), coreObjectsDataSource.getCursorForAll());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basiclistfragment, container, false);

        listView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) listView).setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onDeleteClick(id);
            }
        });

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

    /**
     *
     * @param id of item in table
     */
    private void onDeleteClick(long id) {
        coreObjectsDataSource.deleteCoreObject(id);
        updateList();
    }

    private void onAddClick() {
        coreObjectsDataSource.createCoreObject("new obj", "http://ru.droidcon.com/2014/wp-content/uploads/droid1.png");
        updateList();
    }

    /**
     * update data in list
     */
    private void updateList() {
        adapter.swapCursor(coreObjectsDataSource.getCursorForAll());
    }
}
