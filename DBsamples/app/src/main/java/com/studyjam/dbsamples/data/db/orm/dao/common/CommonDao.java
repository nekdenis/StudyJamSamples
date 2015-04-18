package com.studyjam.dbsamples.data.db.orm.dao.common;


import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.Collection;
import java.util.concurrent.Callable;

public class CommonDao<T, ID> extends BaseDaoImpl<T, ID> {

    public CommonDao(ConnectionSource connectionSource, Class<T> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public void createOrUpdate(final Collection<T> objects) throws SQLException {
        callBatchTasks(new Callable<Void>() {
            public Void call() throws Exception {
                for (T item : objects) {
                    createOrUpdate(item);
                }
                return null;
            }
        });
    }

    public int createBatch(final Collection<T> objects) throws SQLException {
        callBatchTasks(new Callable<Void>() {
            public Void call() throws Exception {
                for (T item : objects) {
                    create(item);
                }
                return null;
            }
        });
        return 0;
    }

    public int deleteAll() throws SQLException {
        DeleteBuilder<T, ID> deleteBuilder = this.deleteBuilder();
        return deleteBuilder.delete();
    }
}
