<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
 <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "springform"%>


  <html>
 <springform:form  action="/SpringWebAssignnment/register" commandName="js" method="post" >
    Name:
    <springform:input type="text" path="name"/><br/>
    <springform:errors type="text" path="name"/><br/>

    Address:
     <springform:input type="text" path="address"/><br/>
        <springform:errors type="text" path="address"/><br/>

    Gender:
<springform:radiobutton path="gender" value="M"/>Male
<springform:radiobutton path="gender" value="F"/>Female
<br/>
 <springform:errors type="text" path="gender"/><br/>


Date of birth (dd/mm/yyyy):
 <springform:input type="text" path="dob"/><br/>
  <springform:errors type="text" path="dob"/><br/>


     Technical SKills:
    <springform:checkbox path="technicalSkills" value="Java"/>Java
    <springform:checkbox path="technicalSkills" value="C++"/>C++
    <springform:checkbox path="technicalSkills" value=".Net"/>.Net
        </br>
      <springform:errors type="text" path="technicalSkills"/><br/>

    Work Expereince:
      <springform:input type="number" path="wxp"/><br/>
        <springform:errors type="text" path="wxp"/><br/>


        Upload CV:
        <springform:input type="file" path="cv"/><br/>
         <springform:errors type="text" path="cv"/><br/>

     <input  type="submit" value="save"/><br/>

   </springform:form>
  </html>