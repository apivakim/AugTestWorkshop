package com.aug.daos.may;

import com.aug.daos.BaseHibernateDao;
import com.aug.entities.may.May;

public interface MayDao extends BaseHibernateDao<May> {

    public boolean deleteById(int id);
}
