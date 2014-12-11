<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sb:head />
</head>
<body>


	  <s:actionerror theme="bootstrap"/>
	  <s:actionmessage theme="bootstrap"/>
	  <s:fielderror theme="bootstrap"/>
	
	
  	<s:if test="%{employees.size() <= 0}">
                Data Not Found
    </s:if>
  	
  		<br>
  		<s:form action="searchemp" method="get" theme="bootstrap" cssClass="form-vertical">
		  		<s:textfield
				     label="Name"
				     name="vasearch.name"
				     id="name" 
				     tooltip="Search by name"/>	
				     <div align="center">
					 <s:submit cssClass="btn" value="Search"/>
					 </div>
		</s:form>
		
		
		<br>
  		<a href="initcreate">Add New</a>
	
	 	<s:form action="listemp" method="get" theme="bootstrap" cssClass="well form-horizontal">
		
		  <div align="center">
	       	   			   <div class="row" align="center">  		
	       	   			        <div class="col-xs-1"><s:label>no</s:label></div>
	       	   			      	<div class="col-xs-1"><s:label>name</s:label></div>
	       	   			      	<div class="col-xs-1"><s:label>age</s:label></div>
	       	   			      	<div class="col-xs-2"><s:label>email</s:label></div>
	       	   			      	<div class="col-xs-1"><s:label>owner</s:label></div>
	       	   			   
	       	   			   </div>
 		  <s:iterator value="employees" status="employeesStatus">
	       	   			    
	       	   			 	<div class="row" align="center"> 	
			        	    	<div class="col-xs-1"><s:property value="#employeesStatus.index+1"/></div>	   		
			        	   		<div class="col-xs-1"><s:property value="name"/></div>
								<div class="col-xs-1"><s:property value="age"/></div>				    	
							  	<div class="col-xs-2"><s:property value="email"/></div>	  
								<div class="col-xs-1"><s:property value="va"/></div>
								
								<s:bean name="com.aug.entities.va.TestBeen" var="hello" >
  								<s:param name="id"><s:property value="id"/></s:param>
								</s:bean>
													
							
								<div class="col-xs-1"><a href="initupdate?id=<s:property value="id"/>">edit</a></div>
								<div class="col-xs-1"><a href="deleteemp?id=<s:property value="id"/>">delete</a></div>
						 </div>	
	     	</s:iterator>  
			
				
			
			</div>
	
		
		
    </s:form>


</body>
</html>