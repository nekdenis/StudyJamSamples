package com.studyjam.dbsamples.data.db.orm.dao;

import com.j256.ormlite.support.ConnectionSource;
import com.studyjam.dbsamples.data.db.orm.dao.common.CommonDao;
import com.studyjam.dbsamples.data.db.orm.dto.Company;
import com.studyjam.dbsamples.data.db.orm.dto.Person;

import java.sql.SQLException;
import java.util.List;

public class CompanyDao extends CommonDao<Company, Long> {

    public static final String TAG = CompanyDao.class.getSimpleName();

    public CompanyDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Company.class);
    }

    public List<Company> searchByName(String name) throws SQLException {
        return queryBuilder().where().like(Company.COLUMN_NAME_NAME, name + "%").query();
    }

    public void create(Company company, List<Person> persons, CommonDao<Person, Long> personDao) throws SQLException {
        create(company);
        savePersons(persons, personDao);
    }

    public void createOrUpdate(Company company, List<Person> persons, CommonDao<Person, Long> personDao) throws SQLException {
        createOrUpdate(company);
        savePersons(persons, personDao);
    }

    private void savePersons(List<Person> persons, CommonDao<Person, Long> personDao) throws SQLException {
        for (Person person : persons) {
            personDao.createOrUpdate(person);
        }
    }
}
