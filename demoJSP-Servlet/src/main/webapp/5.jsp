<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Tutorial</title>
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500" rel="stylesheet">
    <!-- CSS -->
    <meta name="robots" content="noindex,follow"/>
    <style>
        * {
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif;
        }

        /* Basic Styling */
        html,
        body {
            display: grid;
            height: 100%;
            place-items: center;
            font-family: 'Roboto', sans-serif;
            background: #333;
            margin: 0;
            padding: 0;
            width: 100vw;
            height: 100vh;
            overflow: hidden;
        }

        .container {
            max-width: 1200px;
            border: 1px solid black;
            margin: 0 auto;
            padding: 15px;
            display: flex;
        }

        /* Columns */
        .left-column {
            width: 50%;
            position: relative;
        }

        .right-column {
            width: 35%;
        }

        /* Right Column */

        /* Product Description */
        .product-description {
            margin-bottom: 10px;
        }

        .product-description span {
            font-size: 24px;
            color: aqua;
            letter-spacing: 1px;
            text-transform: uppercase;
            display: inline-block;
            position: absolute;
            top: 2%;
            right: 30%;
        }

        .product-description h1 {
            color: aqua;
        }

        .product-description p {
            font-size: 16px;
            font-weight: 300;
            color: white;
            line-height: 24px;
        }


        /* Product Price */
        .product-price {
            display: flex;
            align-items: center;
        }

        .cart-btn {
            margin: 20px;
            display: inline-block;
            background-color: #53b81d;
            border-radius: 6px;
            font-size: 16px;
            color: #FFFFFF;
            text-decoration: none;
            padding: 12px 30px;
            transition: all .5s;
        }

        .cart-btn:hover {
            background-color: #59ff00;
        }

        /* Responsive */
        @media (max-width: 940px) {
            .container {
                flex-direction: column;
                margin-top: 60px;
            }

            .left-column,
            .right-column {
                width: 100%;
            }

            .left-column img.active {
                width: 300px;
                right: 0;
                top: -65px;
                left: initial;
            }
        }

        .counter {
            width: 150px;
            margin: auto;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .counter input {
            width: 50px;
            border: 0;
            line-height: 30px;
            font-size: 20px;
            text-align: center;
            background: #0052cc;
            color: #fff;
            appearance: none;
            outline: 0;
        }

        .counter span {
            display: block;
            font-size: 25px;
            padding: 0 10px;
            cursor: pointer;
            color: #0052cc;
            user-select: none;
        }

        @media (max-width: 535px) {
            .left-column img.active {
                width: 220px;
                top: -85px;
            }
        }

        /* Left Column */
        .left-column img.active {
            opacity: 1;
            width: 80%;
            height: 98%;
        }

        .left-column img {
            width: 100%;
            position: absolute;
            left: -10px;
            top: 0;
            opacity: 0;
            transition: all 0.3s ease;
        }

        user agent stylesheet img {
            overflow-clip-margin: content-box;
            overflow: clip;
        }

        .wrapper {
            margin-bottom: 10px;
            display: inline-flex;
            background: #000000;
            height: 100px;
            width: 400px;
            align-items: center;
            justify-content: space-evenly;
            border-radius: 5px;
            padding: 20px 15px;
            box-shadow: 5px 5px 30px rgba(0, 0, 0, 0.2);
        }

        .wrapper .option {
            background: #fff;
            height: 100%;
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: space-evenly;
            margin: 0 10px;
            border-radius: 5px;
            cursor: pointer;
            padding: 0 10px;
            border: 2px solid lightgrey;
            transition: all 0.3s ease;
            box-sizing: border-box;
        }

        .wrapper .option .dot {
            height: 20px;
            width: 20px;
            background: #d9d9d9;
            border-radius: 50%;
            position: relative;
        }

        .wrapper .option .dot::before {
            position: absolute;
            content: "";
            top: 4px;
            left: 1px;
            width: 12px;
            height: 12px;
            background: #0069d9;
            border-radius: 50%;
            opacity: 0;
            transform: scale(1.5);
            transition: all 0.3s ease;
        }

        input[type="radio"] {
            display: none;
        }

        input[type="checkbox"] {
            display: none;
        }

        #option-1:checked:checked ~ .option-1,
        #option-2:checked:checked ~ .option-2,
        #option-3:checked:checked ~ .option-3 {
            border-color: #0069d9;
            background: #0069d9;
        }

        #option-1:checked:checked ~ .option-1 .dot,
        #option-2:checked:checked ~ .option-2 .dot,
        #option-3:checked:checked ~ .option-3 .dot {
            background: #fff;
        }

        #option-1:checked:checked ~ .option-1 .dot::before,
        #option-2:checked:checked ~ .option-2 .dot::before,
        #option-3:checked:checked ~ .option-3 .dot::before {
            opacity: 1;
            transform: scale(1);
        }

        #option-1:checked:checked ~ .option-1 span,
        #option-2:checked:checked ~ .option-2 span,
        #option-3:checked:checked ~ .option-3 span {
            color: #fff;
        }

        #option-4:checked:checked ~ .option-4,
        #option-5:checked:checked ~ .option-5,
        #option-6:checked:checked ~ .option-6 {
            border-color: #0069d9;
            background: #0069d9;
        }

        #option-4:checked:checked ~ .option-4 .dot,
        #option-5:checked:checked ~ .option-5 .dot,
        #option-6:checked:checked ~ .option-6 .dot {
            background: #fff;
        }

        #option-4:checked:checked ~ .option-4 .dot::before,
        #option-5:checked:checked ~ .option-5 .dot::before,
        #option-6:checked:checked ~ .option-6 .dot::before {
            opacity: 1;
            transform: scale(1);
        }

        .wrapper .option span {
            font-size: 15px;
            font-weight: bold;
            color: black;
        }

        #option-4:checked:checked ~ .option-4 span,
        #option-5:checked:checked ~ .option-5 span,
        #option-6:checked:checked ~ .option-6 span {
            color: #fff;
        }
    </style>
</head>

<body>
<main class="container">
    <div class="left-column">
        <img data-image="red" class="active"
             src="https://i.pinimg.com/564x/7d/3a/1b/7d3a1b0801edd4098104175c4825ddbf.jpg" alt="">
    </div>
    <div class="right-column">
        <form action="/home" method="post">
            <input type="hidden" name="user_id" value="${user.id}">
            <!-- Product Description -->
            <div class="product-description">
                <input type="hidden" name="product_id" value="5">
                <h1>Trà vải</h1>
                <span>
                        <h3>19.000</h3>
                    </span>
                <p>The preferred choice of a vast range of acclaimed DJs. Punchy, bass-focused sound and high
                    isolation.
                    Sturdy headband and on-ear cushions suitable for live performance</p>
            </div>
            <h3 style="color:aqua">Size</h3>
            <div class="wrapper">
                <input type="radio" id="option-1" name="size_id" value="1">
                <input type="radio" id="option-2" name="size_id" value="2">
                <input type="radio" id="option-3" name="size_id" value="3">
                <label for="option-1" class="option option-1">
                    <div class="dot"></div>
                    <span>Nhỏ</span>
                </label>
                <label for="option-2" class="option option-2">
                    <div class="dot"></div>
                    <span>Vừa</span>
                </label>
                <label for="option-3" class="option option-3">
                    <div class="dot"></div>
                    <span>Lớn</span>
                </label>
            </div>
            <h3 style="color:aqua">Topping</h3>
            <div class="wrapper">
                <input type="checkbox" id="option-4" name="topping_ids" value="1">
                <input type="checkbox" id="option-5" name="topping_ids" value="2">
                <input type="checkbox" id="option-6" name="topping_ids" value="3">
                <label for="option-4" class="option option-4">
                    <div class="dot"></div>
                    <span>kem phô mai</span>
                </label>
                <label for="option-5" class="option option-5">
                    <div class="dot"></div>
                    <span>trân châu trắng</span>
                </label>
                <label for="option-6" class="option option-6">
                    <div class="dot"></div>
                    <span>thạch cà phê</span>
                </label>
            </div>
            <div class="product-price">
                <h3 style="color:aqua">Quantity:</h3>
                <div class="counter">
                    <span class="down" onClick='decreaseCount(event, this)'>-</span>
                    <input type="text" name="quantity" value="1">
                    <span class="up" onClick='increaseCount(event, this)'>+</span>
                </div>
                <input class="cart-btn" type="submit" value="Add to cart" onclick="myFunction()">
            </div>
        </form>
    </div>

</main>

<script>
    function myFunction() {
        alert("Trà vải của bạn đã được thêm vào giỏ hàng");
    }
    function increaseCount(a, b) {
        var input = b.previousElementSibling;
        var value = parseInt(input.value, 10);
        value = isNaN(value) ? 0 : value;
        value++;
        input.value = value;
    }

    function decreaseCount(a, b) {
        var input = b.nextElementSibling;
        var value = parseInt(input.value, 10);
        if (value > 1) {
            value = isNaN(value) ? 0 : value;
            value--;
            input.value = value;
        }
    }
</script>
</body>

</html>