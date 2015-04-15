package com.studyjam.dbsamples.data.db.provider.person;

import com.studyjam.dbsamples.data.db.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * A human being which is part of a team.
 */
public interface PersonModel extends BaseModel {

    /**
     * First name of this person. For instance, John.
     * Cannot be {@code null}.
     */
    @NonNull
    String getFirstName();

    /**
     * Last name (a.k.a. Given name) of this person. For instance, Smith.
     * Cannot be {@code null}.
     */
    @NonNull
    String getLastName();

    /**
     * Get the {@code age} value.
     */
    int getAge();

    /**
     * Get the {@code birth_date} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getBirthDate();

    /**
     * If {@code true}, this person has blue eyes. Otherwise, this person doesn't have blue eyes.
     */
    boolean getHasBlueEyes();

    /**
     * Get the {@code height} value.
     * Can be {@code null}.
     */
    @Nullable
    Float getHeight();

    /**
     * Get the {@code gender} value.
     * Cannot be {@code null}.
     */
    @NonNull
    Gender getGender();

    /**
     * Get the {@code country_code} value.
     * Cannot be {@code null}.
     */
    @NonNull
    String getCountryCode();

    /**
     * Get the {@code company_id} value.
     */
    long getCompanyId();
}
