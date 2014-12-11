package com.aug.actions;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aug.actions.BaseAction;


import com.aug.entities.va.TestBeen;
import com.aug.entities.va.Va;
import com.aug.services.va.VaService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


@ResultPath(value = "/")
public class VaAction extends ActionSupport implements BaseAction {
  
	private static final long serialVersionUID = 1L;
	private Va vaobj;
	private Va vasearch;
	public List<Va> employees = new ArrayList<Va>();
	public Map session ;
	@Autowired
	VaService vaservice;
	
	public Integer id;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Va getVaobj() {
		return vaobj;
	}


	public void setVaobj(Va vaobj) {
		this.vaobj = vaobj;
	}

	

	public Va getVasearch() {
		return vasearch;
	}


	public void setVasearch(Va vasearch) {
		this.vasearch = vasearch;
	}


	public List<Va> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Va> employees) {
		this.employees = employees;
	}
	
	
	
	TestBeen beanTest;
	


	public TestBeen getBeanTest() {
		return beanTest;
	}


	public void setBeanTest(TestBeen beanTest) {
		this.beanTest = beanTest;
	}


	
	@Action(value = "initcreate", results = {
			@Result(name = "input", location = "pages/va/createemp.jsp")})
	@Override
    public String initCreate() {
        return INPUT;
    }
    
	
	
    @Override
    public String initList() {
        return INPUT;
    }

	@Action(value = "initupdate", results = {
			@Result(name = "input", location = "pages/va/updateemp.jsp") })
    @Override
    public String initUpdate() {

		System.out.println(id);
		session = ActionContext.getContext().getSession();
		session.put("id",id);
		setVaobj(vaservice.getId(id));
		System.out.println("id:"+ session.get("id"));
        return INPUT;
    }

	
	
   
    @Override
    public String initDelete() {
        return SUCCESS;
    }

    @Action(value = "createva", results = {
			@Result(name = "success",type="redirect",location = "listemp"),
			@Result(name = "failuer",type="redirect", location = "initcreate") })
    @Override
    public String create() {
    	if(vaservice.save(getVaobj())==true){ 
        return SUCCESS;
    	}else{
    	return "failuer";
    	}
    	
    }

    @Action(value = "listemp", results = {
			@Result(name = "success", location = "pages/va/showlist.jsp") })
    @Override
    public String list() {
    	employees = vaservice.findAll();
    	System.out.println(employees.size());
        return SUCCESS;
    	
    }

    @Action(value = "updateva", results = {
			@Result(name = "success",type="redirect", location = "listemp") })
    @Override
    public String update() { 
    	session = ActionContext.getContext().getSession();
    	System.out.println("session"+session.get("id"));
    	id = (Integer) session.get("id");
    	System.out.println(id);
    	Va va1 = vaservice.getId(id); 
    	System.out.println(this.vaobj.getAge());
    	va1.setAge(this.vaobj.getAge());
    	vaservice.update(va1);
        return SUCCESS;
    }

    
    @Action(value = "deleteemp", results = {
			@Result(name = "success",type="redirect", location = "listemp") })
    @Override
    public String delete() {
    	System.out.println("id delete: "+id);
    	Va va1 = vaservice.getId(id);
    	vaservice.delete(va1);
    	return SUCCESS;
       
    }
    
    
    @Action(value = "searchemp", results = {
			@Result(name = "success",location = "pages/va/showlist.jsp")})
   // @Override
    public String Search() {
    	setVaobj(vasearch);
    	System.out.println("name vaobj: "+vaobj.getName());
    	employees = vaservice.search(vaobj);
    	return SUCCESS;
    
       
    }


}
