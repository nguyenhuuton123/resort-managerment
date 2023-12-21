<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Registration</title>
    <style>
        html{
            background-image: url("4882066.jpg");
            background-size: cover;
            background-repeat: no-repeat;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            max-height: 80vh;
            overflow-y: auto;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<form action="/employee-register" method="post">

    <label for="name">Full Name:</label>
    <input type="text" id="name" name="name" required>

    <label for="dateOfBirth">Date of Birth:</label>
    <input type="date" id="dateOfBirth" name="dateOfBirth" required>

    <label for="idCard">ID Card:</label>
    <input type="text" id="idCard" name="idCard" required>

    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" required>

    <label for="phoneNumber">Phone Number:</label>
    <input type="tel" id="phoneNumber" name="phoneNumber" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required>

    <label for="positionId">Position ID:</label>
    <input type="text" id="positionId" name="positionId" required>

    <label for="educationId">Education ID:</label>
    <input type="text" id="educationId" name="educationId" required>

    <label for="divisionId">Division ID:</label>
    <input type="text" id="divisionId" name="divisionId" required>

    <label for="user_id">User Name:</label>
    <input type="text" id="user_id" name="username" value="${username}">

    <button type="submit">Register</button>
</form>

</body>
</html>