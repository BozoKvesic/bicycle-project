<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
 href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
 <div class="container">
  <header>
   <h1>Bills from database</h1>
  </header>
  <div class="starter-template">
   <h1>Bills list</h1>
   <table
   style="border-collapse: collapse;"
    class="table table-striped table-hover table-condensed table-bordered">
    <thead style="border-bottom: 1px solid black;">
    <tr>
     <th>Id</th>
     <th>Date of purchase</th>
     <th>Total price</th>
    </tr>
    </thead>
    <c:forEach var="bill" items="${bills}">
     <tr>
      <td>${bill.id}</td>
      <td>${bill.dateOfPurchase}</td>
      <td>${bill.totalPrice}</td>
     </tr>
     <thead >
     <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Brand</th>
          <th>Price</th>
          <th>Color</th>
     </tr>
     <thead />
        <c:forEach var="bike" items="${bill.bikes}">
             <tr>
                   <td>${bike.id}</td>
                    <td>${bike.name}</td>
                    <td>${bike.brand}</td>
                    <td>${bike.price}</td>
                    <td>${bike.color}</td>
             </tr>
     </c:forEach>
     <tr style="border-top: 1px solid black;"></tr>
    </c:forEach>
   </table>
  </div>

 </div>

 <script type="text/javascript"
  src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>