package com.aug.services.va;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aug.daos.va.VaDao;
import com.aug.daos.va.VaDaoImpl;
import com.aug.entities.va.Va;

@Service
public class VaService  {

	   @Autowired
       VaDao vaDao;
	   public List<Va> valist;
	
	   
	   
	   public void setVaDao(VaDao vaDao) {
		
		   this.vaDao = vaDao;
	}



	public List<Va> findAll(){
		valist = vaDao.findAll();
		return valist;
    	
    }
	
	
	public boolean save(Va v){
		
		try{
				vaDao.save(v);
				return true;
		}catch(Exception except){
				return false;
		}				
    }
	
	
	public Va getId(int id){
		return vaDao.getById(id);
	}
	
	
	public void update(Va va){
			vaDao.update(va);
		}
	
	
	public void delete(Va vaa){
		  vaDao.delete(vaa);
	}
	
	public List<Va> search(Va vaobjsearch){
		return vaDao.search(vaobjsearch);
	}
	
	
}
