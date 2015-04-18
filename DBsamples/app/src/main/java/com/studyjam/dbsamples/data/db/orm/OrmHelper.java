package com.studyjam.dbsamples.data.db.orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.studyjam.dbsamples.data.db.orm.dao.CompanyDao;
import com.studyjam.dbsamples.data.db.orm.dao.common.CommonDao;
import com.studyjam.dbsamples.data.db.orm.dto.Company;
import com.studyjam.dbsamples.data.db.orm.dto.Person;
import com.studyjam.dbsamples.util.Constants;
import com.studyjam.dbsamples.util.DLog;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class OrmHelper extends OrmLiteSqliteOpenHelper {

    public static final String TAG = OrmHelper.class.getSimpleName();

    public static final int COMPANY_DAO_NUM = 0;
    public static final int PERSON_DAO_NUM = COMPANY_DAO_NUM + 1;

    private Class[] classes = {
            Company.class,
            Person.class
    };

    private SparseArray<CommonDao> daos;

    public OrmHelper(Context context) {
        super(context, getDBName(), null, Constants.DATABASE_VERSION);
        daos = new SparseArray<>();
    }

    public static String getDBName() {
        return Constants.DATABASE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            DLog.i(TAG, "onCreate");
            createAllTables(connectionSource);
        } catch (SQLException e) {
            DLog.e(TAG, "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    public void createAllTables(ConnectionSource connectionSource) throws SQLException {
        for (Class className : classes) {
            TableUtils.createTable(connectionSource, className);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            DLog.i(TAG, "onUpgrade");
            dropAllTables(connectionSource);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            DLog.e(TAG, "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    private void dropAllTables(ConnectionSource connectionSource) throws SQLException {
        for (Class className : classes) {
            TableUtils.dropTable(connectionSource, className, true);
        }
    }

    public void clearDatabase() {
        try {
            DLog.i(TAG, "onClear");
            dropAllTables(connectionSource);
            createAllTables(connectionSource);
        } catch (SQLException e) {
            DLog.e(TAG, "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    public CommonDao getDaoByClass(Class<?> classInstance) throws SQLException {
        if (classInstance.equals(Company.class)) {
            return getCustomDaoByNum(CompanyDao.class, COMPANY_DAO_NUM);
        } else if (classInstance.equals(Person.class)) {
            return getDaoByNum(Person.class, PERSON_DAO_NUM);
        }
        return null;
    }

    private CommonDao getCustomDaoByNum(Class<? extends CommonDao> className, int daoNum) throws SQLException {
        CommonDao dao = daos.get(daoNum);
        if (dao == null) {
            try {
                dao = className.getDeclaredConstructor(ConnectionSource.class).newInstance(getConnectionSource());
                daos.put(daoNum, dao);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return dao;
    }

    private CommonDao getDaoByNum(Class<?> className, int daoNum) throws SQLException {
        CommonDao dao = daos.get(daoNum);
        if (dao == null) {
            dao = new CommonDao(getConnectionSource(), className);
            daos.put(daoNum, dao);
        }
        return dao;
    }

    @Override
    public void close() {
        super.close();
        daos = null;
    }
}