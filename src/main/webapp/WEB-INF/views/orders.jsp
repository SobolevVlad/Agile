<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title><spring:message code="order.head.message"/></title>
</head>
<body>
<div>
    <spring:message code="order.head.message"/>
    <table id="orderTable">
        <thead>
        <tr>
            <td>Name</td>
            <td>Group</td>
            <td>Balance</td>
            <td>Description</td>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    <table>
        <c:forEach items="${requestScope.orders}" var="order">
            <tr>
                <td>${order.orderUid}</td>
                <td>${order.deliveryAddress}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
<script>
    $(document).ready(function () {
        $.getJSON('api/orders/all', function (data) {
            console.log(data);
            $.each(data, function (k, arr) {
                console.log(data);
                console.log(k);
                console.log(arr);
                $('#orderTable tbody').append('<tr><td>' + k + '</td><td>' + arr[1] + '</td><td>' + arr.itemName +
                        '</td><td>' + arr.timestamp + '</td><td>' + arr.quantity + '</td><td>' + arr.payment +
                        '</td><td>' + arr.deliveryAddress + '</td><td>' + arr.customerUid + '</td><td>' + arr.customerFirstName +
                        '</td><td>' + arr.customerLastName + '</td><td>' + arr.customerCountry +
                        '</td><td>' + arr.customerCountry + '</td><td>' + arr.customerAddress + '</td></tr>');
            });
        });
    });
</script>

</body>
</html>
