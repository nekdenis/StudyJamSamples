package com.studyjam.dbsamples.data.db.provider.person;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.studyjam.dbsamples.data.db.provider.base.AbstractCursor;
import com.studyjam.dbsamples.data.db.provider.company.*;

/**
 * Cursor wrapper for the {@code person} table.
 */
public class PersonCursor extends AbstractCursor implements PersonModel {
    public PersonCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PersonColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * First name of this person. For instance, John.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getFirstName() {
        String res = getStringOrNull(PersonColumns.FIRST_NAME);
        if (res == null)
            throw new NullPointerException("The value of 'first_name' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Last name (a.k.a. Given name) of this person. For instance, Smith.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getLastName() {
        String res = getStringOrNull(PersonColumns.LAST_NAME);
        if (res == null)
            throw new NullPointerException("The value of 'last_name' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code age} value.
     */
    public int getAge() {
        Integer res = getIntegerOrNull(PersonColumns.AGE);
        if (res == null)
            throw new NullPointerException("The value of 'age' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code birth_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public Date getBirthDate() {
        Date res = getDateOrNull(PersonColumns.BIRTH_DATE);
        return res;
    }

    /**
     * If {@code true}, this person has blue eyes. Otherwise, this person doesn't have blue eyes.
     */
    public boolean getHasBlueEyes() {
        Boolean res = getBooleanOrNull(PersonColumns.HAS_BLUE_EYES);
        if (res == null)
            throw new NullPointerException("The value of 'has_blue_eyes' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code height} value.
     * Can be {@code null}.
     */
    @Nullable
    public Float getHeight() {
        Float res = getFloatOrNull(PersonColumns.HEIGHT);
        return res;
    }

    /**
     * Get the {@code gender} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public Gender getGender() {
        Integer intValue = getIntegerOrNull(PersonColumns.GENDER);
        if (intValue == null)
            throw new NullPointerException("The value of 'gender' in the database was null, which is not allowed according to the model definition");
        return Gender.values()[intValue];
    }

    /**
     * Get the {@code country_code} value.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getCountryCode() {
        String res = getStringOrNull(PersonColumns.COUNTRY_CODE);
        if (res == null)
            throw new NullPointerException("The value of 'country_code' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code company_id} value.
     */
    public long getCompanyId() {
        Long res = getLongOrNull(PersonColumns.COMPANY_ID);
        if (res == null)
            throw new NullPointerException("The value of 'company_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * The commercial name of this company.
     * Cannot be {@code null}.
     */
    @NonNull
    public String getCompanyName() {
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
    public String getCompanyAddress() {
        String res = getStringOrNull(CompanyColumns.ADDRESS);
        return res;
    }
}
