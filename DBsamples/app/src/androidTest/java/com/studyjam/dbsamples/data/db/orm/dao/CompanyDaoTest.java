package com.studyjam.dbsamples.data.db.orm.dao;

import com.studyjam.dbsamples.data.db.orm.dao.common.CommonDao;
import com.studyjam.dbsamples.data.db.orm.dto.Company;
import com.studyjam.dbsamples.data.db.orm.dto.Person;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

public class CompanyDaoTest extends CommonDaoTest {


    public void testSearchByName() throws Exception {
        CompanyDao companyDao = (CompanyDao) ormHelper.getDaoByClass(Company.class);
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("first"));
        companies.add(new Company("second"));
        companies.add(new Company("third company"));
        companies.add(new Company("fourth"));
        companyDao.createBatch(companies);

        List<Company> foundCompanies = companyDao.searchByName("third");
        Assert.assertEquals(1, foundCompanies.size());
    }

    public void testCreate() throws Exception {
        CompanyDao companyDao = (CompanyDao) ormHelper.getDaoByClass(Company.class);
        CommonDao<Person, Long> personDao = ormHelper.getDaoByClass(Person.class);
        Company firstCompany = new Company("first");
        List<Person> firstCompanyPersons = new ArrayList<>();
        firstCompanyPersons.add(new Person("A", "AA", 10, firstCompany));
        firstCompanyPersons.add(new Person("B", "BB", 12, firstCompany));
        Company secondCompany = new Company("second");
        List<Person> secondCompanyPersons = new ArrayList<>();
        secondCompanyPersons.add(new Person("A1", "AA1", 10, secondCompany));
        secondCompanyPersons.add(new Person("B1", "BB1", 12, secondCompany));
        secondCompanyPersons.add(new Person("C1", "CC1", 14, secondCompany));

        companyDao.create(firstCompany, firstCompanyPersons, personDao);
        companyDao.create(secondCompany, secondCompanyPersons, personDao);

        List<Person> foundPersons = personDao.queryBuilder().where().eq(Person.COLUMN_NAME_NAME, "B").query();
        Assert.assertEquals(1, foundPersons.size());
        String firstPersonCompanyName = foundPersons.get(0).getCompany().getName();
        Assert.assertEquals("first", firstPersonCompanyName);

        Company secondComp = companyDao.searchByName("second").get(0);
        Assert.assertEquals(3, secondComp.getPersons().size());
    }
}