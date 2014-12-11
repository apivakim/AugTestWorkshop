package com.aug.daos.va;

import java.util.List;

import javax.transaction.Transactional;

import com.aug.daos.BaseHibernateDaoImpl;
import com.aug.entities.va.Va;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class VaDaoImpl extends BaseHibernateDaoImpl<Va> implements VaDao{

    protected VaDaoImpl() {
        super(Va.class);
    }

    
  
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Va> findAll() {
    	 return getCurrentSession().createCriteria(Va.class).list();
	}
    
    
    public void save(Va v){
    	  getCurrentSession().persist(v);
    }
    
    
    @Override
    public Va getById(final Integer id) {
        if(id != null)
            return (Va) getCurrentSession().get(Va.class, id);
        else
            return null;
    }
    
   @Override
    public void update(final Va va) {
        getCurrentSession().merge(va);
    }
    


	
	@Override
	public boolean deleteById(int id) {
		return false;		
	}
	
	

	
	public void deleteId(Va vaa) {
		// TODO Auto-generated method stub
		
		getCurrentSession().delete(vaa);
		
	}
	
	
	public List<Va> search(Va vaobjserach){
		Criteria criteria = getCurrentSession().createCriteria(Va.class);
		criteria.add(Restrictions.eq("name", vaobjserach.getName()));
		List<Va> vaobj = criteria.list();
		return vaobj;
	}
   
  


}
