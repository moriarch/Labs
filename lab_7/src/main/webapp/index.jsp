
<%
String header = "Coolshop";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp" />
        <h1><%= header %></h1>

        <c:forEach var="product" items="${products}">
             <div style="display:flex; gap:10px; align-items:center; border-bottom:1px solid black; padding:10px">
                 <a href="/item/${product.id}">${product.getName()}</a>
                 <span>${product.getPrice()}</span>
                 <a href="/remove/${product.id}">Remove Item</a>
             </div>
        </c:forEach>

<jsp:include page="layout/footer.jsp" />