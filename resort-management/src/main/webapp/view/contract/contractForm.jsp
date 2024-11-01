<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Form</title>
</head>
<body>
<h2>Customer Information Form</h2>

<form action="processFormData.jsp" method="post">
    <!-- Customer Information -->
    <label name="fullname">Full Name:</label>
    <input type="text" name="fullname" required><br>

    <label name="phone">Phone Number:</label>
    <input type="text" name="phone" required><br>

    <label name="email">Email:</label>
    <input type="text" name="email" required><br>

    <label name="address">Address:</label>
    <input type="text" name="address" required><br>

    <label name="gender">Gender:</label>
    <select name="gender">
        <option value="male">Male</option>
        <option value="female">Female</option>
    </select><br>

    <label name="idCard">ID Card:</label>
    <input type="text" name="idCard" required><br>

    <label name="dob">Date of Birth:</label>
    <input type="date" name="dob" required><br>

    <!-- Contract Information -->
    <h3>Contract Information</h3>

    <label name="startDate">Start Date:</label>
    <input type="date" name="startDate" required><br>

    <label name="endDate">End Date:</label>
    <input type="date" name="endDate" required><br>

    <label name="deposit">Deposit:</label>
    <input type="text" name="deposit" required><br>

    <!-- Contract Detail Information -->
    <h3>Contract Detail Information</h3>

    <label name="facilityName">Facility Name:</label>
    <input type="text" name="facilityName" required><br>

    <label name="quantity">Quantity:</label>
    <input type="text" name="quantity" required><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>