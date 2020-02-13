<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
    uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
   href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Customers</title>
</head>
<body>
	<section>
		<div class="jumbot run">
			<div class="container">
				<h1>customers</h1>
				<p>All the available Customers in our store</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${customers}" var="customer">
                  <div class="col-sm-6 col-md-3">
                     <div class="thumbnail">
                        <div class="caption">
                           <h3>${customer.customerId}</h3>
                           <p>${customer.name}</p>
                           <p>${customer.address}</p>
      <p>${customer.noOfOrdersMade} units made</p>
                        </div>
                     </div>
                  </div>
               </c:forEach>
		</div>
	</section>
</body>
</html>