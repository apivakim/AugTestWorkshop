package com.aug.daos.va;

import java.util.List;

import com.aug.daos.BaseHibernateDao;
import com.aug.entities.va.Va;

public interface VaDao extends BaseHibernateDao<Va> {

    public boolean deleteById(int id);
    
    public List<Va> findAll();
    
    public void save(Va v);
    
    public List<Va> search(Va vaobjserach);
    
  
  
}
