<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Technology Services</title>
  <meta name="description" content="Technology Services">
  <meta name="keywords" content="Technology Services" />
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/resources/sites/css/page.css"/>
</head>
<body style="background-color: #f5f5f5;">
 <jsp:include page="../include/header.jsp"></jsp:include>
 <section class="banner">
  <div class="banner-overlay"></div>
  <div class="banner-content">
    <h2>Technology Services for ${categoryRequest.name}</h2>
  </div>
</section>
<div class="container py-5">
    <h2 class="text-center">Our Technology</h2>
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
      <c:forEach var="data" items="${requestDetail}"> 
      <div class="col">
        <div class="card">
          <%-- <img src="${data.imgUrl}" class="card-img-top" alt="Service 1"> --%>
          <div class="card-body">
            <h5 class="card-title"><a class="heading" href="/${data.categoryUrl}/${data.pageUrl}">${data.categoryType}</a></h5>
          </div>
        </div>
      </div>
	</c:forEach>
       
    </div>
  </div>
     
 
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>
