package com.studyjam.dbsamples.data.db.provider.company;

import java.util.Date;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.studyjam.dbsamples.data.db.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code company} table.
 */
public class CompanyContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return CompanyColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable CompanySelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * The commercial name of this company.
     */
    public CompanyContentValues putName(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("name must not be null");
        mContentValues.put(CompanyColumns.NAME, value);
        return this;
    }


    /**
     * The full address of this company.
     */
    public CompanyContentValues putAddress(@Nullable String value) {
        mContentValues.put(CompanyColumns.ADDRESS, value);
        return this;
    }

    public CompanyContentValues putAddressNull() {
        mContentValues.putNull(CompanyColumns.ADDRESS);
        return this;
    }
}
