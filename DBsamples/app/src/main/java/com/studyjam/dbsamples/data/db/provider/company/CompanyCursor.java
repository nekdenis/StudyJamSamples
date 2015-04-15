package com.studyjam.dbsamples.data.db.provider.company;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.studyjam.dbsamples.data.db.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code company} table.
 */
public class CompanyCursor extends AbstractCursor implements CompanyModel {
    public CompanyCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(CompanyColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * The commercial name of this company.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getName() {
        String res = getStringOrNull(CompanyColumns.NAME);
        if (res == null)
            throw new NullPointerException("The value of 'name' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * The full address of this company.
     * Can be {@code null}.
     */
    @Nullable
    public String getAddress() {
        String res = getStringOrNull(CompanyColumns.ADDRESS);
        return res;
    }
}
