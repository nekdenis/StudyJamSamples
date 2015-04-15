package com.studyjam.dbsamples.data.db.provider.company;

import android.net.Uri;
import android.provider.BaseColumns;

import com.studyjam.dbsamples.data.db.provider.GeneratedProvider;
import com.studyjam.dbsamples.data.db.provider.company.CompanyColumns;
import com.studyjam.dbsamples.data.db.provider.person.PersonColumns;

/**
 * A commercial business.
 */
public class CompanyColumns implements BaseColumns {
    public static final String TABLE_NAME = "company";
    public static final Uri CONTENT_URI = Uri.parse(GeneratedProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * The commercial name of this company.
     */
    public static final String NAME = "name";

    /**
     * The full address of this company.
     */
    public static final String ADDRESS = "address";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NAME,
            ADDRESS
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(ADDRESS) || c.contains("." + ADDRESS)) return true;
        }
        return false;
    }

}
