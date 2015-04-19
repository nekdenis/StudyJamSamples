package com.studyjam.dbsamples.data.db.orm.dao;

import android.test.AndroidTestCase;

import com.j256.ormlite.support.ConnectionSource;
import com.studyjam.dbsamples.data.db.orm.OrmHelper;
import com.studyjam.dbsamples.data.db.orm.TestOrmHelper;

public class CommonDaoTest extends AndroidTestCase {

    protected ConnectionSource connectionSource;
    protected OrmHelper ormHelper;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        ormHelper = new TestOrmHelper(getContext());
        connectionSource = ormHelper.getConnectionSource();
        ormHelper.clearDatabase();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        if (connectionSource != null) {
            ormHelper.clearDatabase();
        }
        closeConnectionSource();
        if (ormHelper != null) {
            ormHelper.close();
        }
    }

    protected void closeConnectionSource() throws Exception {
        if (connectionSource != null) {
            connectionSource.close();
            connectionSource = null;
        }
    }

}
