package com.studyjam.dbsamples.data.db.provider.company;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.studyjam.dbsamples.data.db.provider.base.AbstractSelection;

/**
 * Selection for the {@code company} table.
 */
public class CompanySelection extends AbstractSelection<CompanySelection> {
    @Override
    protected Uri baseUri() {
        return CompanyColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code CompanyCursor} object, which is positioned before the first entry, or null.
     */
    public CompanyCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new CompanyCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null)}.
     */
    public CompanyCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null)}.
     */
    public CompanyCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public CompanySelection id(long... value) {
        addEquals("company." + CompanyColumns._ID, toObjectArray(value));
        return this;
    }

    public CompanySelection name(String... value) {
        addEquals(CompanyColumns.NAME, value);
        return this;
    }

    public CompanySelection nameNot(String... value) {
        addNotEquals(CompanyColumns.NAME, value);
        return this;
    }

    public CompanySelection nameLike(String... value) {
        addLike(CompanyColumns.NAME, value);
        return this;
    }

    public CompanySelection nameContains(String... value) {
        addContains(CompanyColumns.NAME, value);
        return this;
    }

    public CompanySelection nameStartsWith(String... value) {
        addStartsWith(CompanyColumns.NAME, value);
        return this;
    }

    public CompanySelection nameEndsWith(String... value) {
        addEndsWith(CompanyColumns.NAME, value);
        return this;
    }

    public CompanySelection address(String... value) {
        addEquals(CompanyColumns.ADDRESS, value);
        return this;
    }

    public CompanySelection addressNot(String... value) {
        addNotEquals(CompanyColumns.ADDRESS, value);
        return this;
    }

    public CompanySelection addressLike(String... value) {
        addLike(CompanyColumns.ADDRESS, value);
        return this;
    }

    public CompanySelection addressContains(String... value) {
        addContains(CompanyColumns.ADDRESS, value);
        return this;
    }

    public CompanySelection addressStartsWith(String... value) {
        addStartsWith(CompanyColumns.ADDRESS, value);
        return this;
    }

    public CompanySelection addressEndsWith(String... value) {
        addEndsWith(CompanyColumns.ADDRESS, value);
        return this;
    }
}
