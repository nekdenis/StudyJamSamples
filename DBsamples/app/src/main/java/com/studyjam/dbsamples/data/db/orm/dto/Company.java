package com.studyjam.dbsamples.data.db.orm.dto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.studyjam.dbsamples.data.db.orm.dto.common.Indexed;

import java.util.Collection;

public class Company implements Indexed {

    public static final String COLUMN_NAME_NAME = "name";

    @DatabaseField(generatedId = true, columnName = COLUMN_NAME_ID)
    private long id;

    @DatabaseField(columnName = COLUMN_NAME_NAME)
    private String name;

    @ForeignCollectionField(eager = true)
    private Collection<Person> persons;

    //Empty construcotor is necessary for ORM
    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Collection<Person> getPersons() {
        return persons;
    }

    public void setName(String name) {
        this.name = name;
    }
}
