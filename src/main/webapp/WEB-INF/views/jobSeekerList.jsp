<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>



  <html>
  job seekers

  <core:forEach items="${jobseekers}" var="element">

  <a  href="/SpringWebAssignnment/jobseeker/${element}">${element}</a>

  </core:forEach>



  </html>


