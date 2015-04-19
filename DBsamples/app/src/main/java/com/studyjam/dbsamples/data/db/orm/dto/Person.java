package com.studyjam.dbsamples.data.db.orm.dto;

import com.j256.ormlite.field.DatabaseField;
import com.studyjam.dbsamples.data.db.orm.dto.common.Indexed;

public class Person implements Indexed {

    public static final String COLUMN_NAME_NAME = "name";
    public static final String COLUMN_NAME_REGISTERED_DATE = "registered";

    @DatabaseField(generatedId = true, columnName = COLUMN_NAME_ID)
    private long id;

    @DatabaseField(columnName = COLUMN_NAME_NAME, uniqueCombo = true)
    private String name;

    @DatabaseField(uniqueCombo = true)
    private String lastName;

    @DatabaseField(columnName = COLUMN_NAME_REGISTERED_DATE)
    private long createdTime;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Company company;

    @DatabaseField
    private int age;

    //Empty construcotor is necessary for ORM
    public Person() {
    }

    public Person(String name, String lastName, int age, Company company) {
        this.name = name;
        this.lastName = lastName;
        this.createdTime = System.currentTimeMillis();
        this.company = company;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }
}
