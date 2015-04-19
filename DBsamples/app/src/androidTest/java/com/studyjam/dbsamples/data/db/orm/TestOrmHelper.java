package com.studyjam.dbsamples.data.db.orm;

import android.content.Context;

public class TestOrmHelper extends OrmHelper {

    public static final String TEST_DB_NAME = "test_orm.db";

    public TestOrmHelper(Context context) {
        super(context);
    }

    @Override
    public String getDatabaseName() {
        return TEST_DB_NAME;
    }
}