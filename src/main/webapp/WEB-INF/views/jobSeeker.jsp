<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<html>
<p> Name :  ${jobseeker.name}</p></br>
<p> Address:  ${jobseeker.address}</p></br>
<p> Gender :  ${jobseeker.gender}</p></br>
<p> Date Of Birth :  ${jobseeker.dob}</p></br>

<p>Technical Skills : </p></br>
 <core:forEach items="${jobseeker.technicalSkills}" var="element">

  <p>${element}</p></br>

  </core:forEach>

 <p>Work Expereince : ${jobseeker.wxp}</p></br>

<p>CV : </p></br>
  <p><iframe src=${jobseeker.cv.getAbsolutePath()} frameborder="0" height="400"
       width="95%"></iframe></p>





</html>