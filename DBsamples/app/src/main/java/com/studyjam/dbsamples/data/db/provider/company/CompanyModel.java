package com.studyjam.dbsamples.data.db.provider.company;

import com.studyjam.dbsamples.data.db.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * A commercial business.
 */
public interface CompanyModel extends BaseModel {

    /**
     * The commercial name of this company.
     * Cannot be {@code null}.
     */
    @NonNull
    String getName();

    /**
     * The full address of this company.
     * Can be {@code null}.
     */
    @Nullable
    String getAddress();
}
