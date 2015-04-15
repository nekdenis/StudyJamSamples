package com.studyjam.dbsamples.data.db.provider.person;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.studyjam.dbsamples.data.db.provider.base.AbstractSelection;
import com.studyjam.dbsamples.data.db.provider.company.*;

/**
 * Selection for the {@code person} table.
 */
public class PersonSelection extends AbstractSelection<PersonSelection> {
    @Override
    protected Uri baseUri() {
        return PersonColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code PersonCursor} object, which is positioned before the first entry, or null.
     */
    public PersonCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new PersonCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null)}.
     */
    public PersonCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null)}.
     */
    public PersonCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public PersonSelection id(long... value) {
        addEquals("person." + PersonColumns._ID, toObjectArray(value));
        return this;
    }

    public PersonSelection firstName(String... value) {
        addEquals(PersonColumns.FIRST_NAME, value);
        return this;
    }

    public PersonSelection firstNameNot(String... value) {
        addNotEquals(PersonColumns.FIRST_NAME, value);
        return this;
    }

    public PersonSelection firstNameLike(String... value) {
        addLike(PersonColumns.FIRST_NAME, value);
        return this;
    }

    public PersonSelection firstNameContains(String... value) {
        addContains(PersonColumns.FIRST_NAME, value);
        return this;
    }

    public PersonSelection firstNameStartsWith(String... value) {
        addStartsWith(PersonColumns.FIRST_NAME, value);
        return this;
    }

    public PersonSelection firstNameEndsWith(String... value) {
        addEndsWith(PersonColumns.FIRST_NAME, value);
        return this;
    }

    public PersonSelection lastName(String... value) {
        addEquals(PersonColumns.LAST_NAME, value);
        return this;
    }

    public PersonSelection lastNameNot(String... value) {
        addNotEquals(PersonColumns.LAST_NAME, value);
        return this;
    }

    public PersonSelection lastNameLike(String... value) {
        addLike(PersonColumns.LAST_NAME, value);
        return this;
    }

    public PersonSelection lastNameContains(String... value) {
        addContains(PersonColumns.LAST_NAME, value);
        return this;
    }

    public PersonSelection lastNameStartsWith(String... value) {
        addStartsWith(PersonColumns.LAST_NAME, value);
        return this;
    }

    public PersonSelection lastNameEndsWith(String... value) {
        addEndsWith(PersonColumns.LAST_NAME, value);
        return this;
    }

    public PersonSelection age(int... value) {
        addEquals(PersonColumns.AGE, toObjectArray(value));
        return this;
    }

    public PersonSelection ageNot(int... value) {
        addNotEquals(PersonColumns.AGE, toObjectArray(value));
        return this;
    }

    public PersonSelection ageGt(int value) {
        addGreaterThan(PersonColumns.AGE, value);
        return this;
    }

    public PersonSelection ageGtEq(int value) {
        addGreaterThanOrEquals(PersonColumns.AGE, value);
        return this;
    }

    public PersonSelection ageLt(int value) {
        addLessThan(PersonColumns.AGE, value);
        return this;
    }

    public PersonSelection ageLtEq(int value) {
        addLessThanOrEquals(PersonColumns.AGE, value);
        return this;
    }

    public PersonSelection birthDate(Date... value) {
        addEquals(PersonColumns.BIRTH_DATE, value);
        return this;
    }

    public PersonSelection birthDateNot(Date... value) {
        addNotEquals(PersonColumns.BIRTH_DATE, value);
        return this;
    }

    public PersonSelection birthDate(Long... value) {
        addEquals(PersonColumns.BIRTH_DATE, value);
        return this;
    }

    public PersonSelection birthDateAfter(Date value) {
        addGreaterThan(PersonColumns.BIRTH_DATE, value);
        return this;
    }

    public PersonSelection birthDateAfterEq(Date value) {
        addGreaterThanOrEquals(PersonColumns.BIRTH_DATE, value);
        return this;
    }

    public PersonSelection birthDateBefore(Date value) {
        addLessThan(PersonColumns.BIRTH_DATE, value);
        return this;
    }

    public PersonSelection birthDateBeforeEq(Date value) {
        addLessThanOrEquals(PersonColumns.BIRTH_DATE, value);
        return this;
    }

    public PersonSelection hasBlueEyes(boolean value) {
        addEquals(PersonColumns.HAS_BLUE_EYES, toObjectArray(value));
        return this;
    }

    public PersonSelection height(Float... value) {
        addEquals(PersonColumns.HEIGHT, value);
        return this;
    }

    public PersonSelection heightNot(Float... value) {
        addNotEquals(PersonColumns.HEIGHT, value);
        return this;
    }

    public PersonSelection heightGt(float value) {
        addGreaterThan(PersonColumns.HEIGHT, value);
        return this;
    }

    public PersonSelection heightGtEq(float value) {
        addGreaterThanOrEquals(PersonColumns.HEIGHT, value);
        return this;
    }

    public PersonSelection heightLt(float value) {
        addLessThan(PersonColumns.HEIGHT, value);
        return this;
    }

    public PersonSelection heightLtEq(float value) {
        addLessThanOrEquals(PersonColumns.HEIGHT, value);
        return this;
    }

    public PersonSelection gender(Gender... value) {
        addEquals(PersonColumns.GENDER, value);
        return this;
    }

    public PersonSelection genderNot(Gender... value) {
        addNotEquals(PersonColumns.GENDER, value);
        return this;
    }


    public PersonSelection countryCode(String... value) {
        addEquals(PersonColumns.COUNTRY_CODE, value);
        return this;
    }

    public PersonSelection countryCodeNot(String... value) {
        addNotEquals(PersonColumns.COUNTRY_CODE, value);
        return this;
    }

    public PersonSelection countryCodeLike(String... value) {
        addLike(PersonColumns.COUNTRY_CODE, value);
        return this;
    }

    public PersonSelection countryCodeContains(String... value) {
        addContains(PersonColumns.COUNTRY_CODE, value);
        return this;
    }

    public PersonSelection countryCodeStartsWith(String... value) {
        addStartsWith(PersonColumns.COUNTRY_CODE, value);
        return this;
    }

    public PersonSelection countryCodeEndsWith(String... value) {
        addEndsWith(PersonColumns.COUNTRY_CODE, value);
        return this;
    }

    public PersonSelection companyId(long... value) {
        addEquals(PersonColumns.COMPANY_ID, toObjectArray(value));
        return this;
    }

    public PersonSelection companyIdNot(long... value) {
        addNotEquals(PersonColumns.COMPANY_ID, toObjectArray(value));
        return this;
    }

    public PersonSelection companyIdGt(long value) {
        addGreaterThan(PersonColumns.COMPANY_ID, value);
        return this;
    }

    public PersonSelection companyIdGtEq(long value) {
        addGreaterThanOrEquals(PersonColumns.COMPANY_ID, value);
        return this;
    }

    public PersonSelection companyIdLt(long value) {
        addLessThan(PersonColumns.COMPANY_ID, value);
        return this;
    }

    public PersonSelection companyIdLtEq(long value) {
        addLessThanOrEquals(PersonColumns.COMPANY_ID, value);
        return this;
    }

    public PersonSelection companyName(String... value) {
        addEquals(CompanyColumns.NAME, value);
        return this;
    }

    public PersonSelection companyNameNot(String... value) {
        addNotEquals(CompanyColumns.NAME, value);
        return this;
    }

    public PersonSelection companyNameLike(String... value) {
        addLike(CompanyColumns.NAME, value);
        return this;
    }

    public PersonSelection companyNameContains(String... value) {
        addContains(CompanyColumns.NAME, value);
        return this;
    }

    public PersonSelection companyNameStartsWith(String... value) {
        addStartsWith(CompanyColumns.NAME, value);
        return this;
    }

    public PersonSelection companyNameEndsWith(String... value) {
        addEndsWith(CompanyColumns.NAME, value);
        return this;
    }

    public PersonSelection companyAddress(String... value) {
        addEquals(CompanyColumns.ADDRESS, value);
        return this;
    }

    public PersonSelection companyAddressNot(String... value) {
        addNotEquals(CompanyColumns.ADDRESS, value);
        return this;
    }

    public PersonSelection companyAddressLike(String... value) {
        addLike(CompanyColumns.ADDRESS, value);
        return this;
    }

    public PersonSelection companyAddressContains(String... value) {
        addContains(CompanyColumns.ADDRESS, value);
        return this;
    }

    public PersonSelection companyAddressStartsWith(String... value) {
        addStartsWith(CompanyColumns.ADDRESS, value);
        return this;
    }

    public PersonSelection companyAddressEndsWith(String... value) {
        addEndsWith(CompanyColumns.ADDRESS, value);
        return this;
    }
}
