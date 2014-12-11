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
		  <br>
		  <br>
		  
		  
		  
		  
		  <s:form action="updateva" method="post" theme="bootstrap" cssClass="well form-vertical"
		  label="Update">
				 
				 
				 
				   <s:hidden name="#hello.id" id="id"></s:hidden>
				   <s:textfield
	                        label="Name"
	                        name="vaobj.name"
	                        id="name" />
   
			       <s:textfield
		                        label="Age"
		                        name="vaobj.age"
		                        id="age"
		                        tooltip="Enter your Age for update here"/>
		                        
		           <s:textfield
		                        label="E-mail"
		                        name="vaobj.email"
		                        id="email" />
		                        
		        
		           <s:textfield
		                        label="Owner"
		                        name="vaobj.va"
		                        id="va" />
		                       
								
		       
			        <div align="center"> 
				        <s:submit cssClass="btn" value="Update"/> 
				        <s:reset cssClass="btn" value="Cancle"/>
			        </div>
			  </s:form>

</body>
</html>