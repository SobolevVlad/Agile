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
            <td>Order UID</td>
            <td>Item name</td>
            <td>Timestamp</td>
            <td>Quantity</td>
            <td>Payment</td>
            <td>Delivery address</td>
            <td>Customer UID</td>
            <td>Customer First Name</td>
            <td>Customer Last Name</td>
            <td>Customer Country</td>
            <td>Customer Address</td>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
<script>
    $(document).ready(function () {
        $('thead').on('click', function() {
            $.getJSON('api/orders?columnName', function (data) {
                $.each(data, function (k, arr) {
                    $('#orderTable tbody').append('<tr><td>' + arr[8] + '</td><td>' + arr[7] + '</td><td>' + arr[11] +
                            '</td><td>' + arr[10] + '</td><td>' + arr[9] + '</td><td>' + arr[1] + '</td><td>' + arr[5] +
                            '</td><td>' + arr[3] + '</td><td>' + arr[4] + '</td><td>' + arr[2] + '</td><td>' + arr[6] + '</td></tr>');
                });
            });
        });
        $.getJSON('/api/orders/', function (data) {
            $.each(data, function (k, arr) {
                $('#orderTable tbody').append('<tr><td>' + arr[8] + '</td><td>' + arr[7] + '</td><td>' + arr[11] +
                        '</td><td>' + arr[10] + '</td><td>' + arr[9] + '</td><td>' + arr[1] + '</td><td>' + arr[5] +
                        '</td><td>' + arr[3] + '</td><td>' + arr[4] + '</td><td>' + arr[2] + '</td><td>' + arr[6] + '</td></tr>');
            });
        });
    });
</script>

</body>
</html>