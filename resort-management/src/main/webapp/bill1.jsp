<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');

        body {
            background-color: #ffe8d2;
            font-family: 'Montserrat', sans-serif
        }

        .card {
            border: none
        }

        .logo {
            background-color: #eeeeeea8
        }

        .totals tr td {
            font-size: 13px
        }

        .footer {
            background-color: #eeeeeea8
        }

        .footer span {
            font-size: 12px
        }

        .product-qty span {
            font-size: 12px;
            color: black;
        }
    </style>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form action="/bill" method="post">
    <input type="hidden" name="user_id" value="${user.id}">
    <div class="container mt-5 mb-5">

        <div class="row d-flex justify-content-center">

            <div class="col-md-8">

                <div class="card">


                    <div class="text-left logo p-2 px-5">

                        <img src="https://i.imgur.com/2zDU056.png" width="50">


                    </div>

                    <div class="invoice p-5">

                        <h5>Your order Confirmed!</h5>

                        <span class="font-weight-bold d-block mt-4">Hello, <c:out value="${user.username}"/></span>
                        <span>You order has been confirmed and will be shipped in next two days!</span>

                        <div class="payment border-top mt-3 mb-3 border-bottom table-responsive">

                            <table class="table table-borderless">

                                <tbody>
                                <tr>
                                    <td>
                                        <div class="py-2">

                                            <span class="d-block text-muted">Order Date</span>
                                            <span id="demo"></span>

                                        </div>
                                    </td>

                                    <td>
                                        <div class="py-2">

                                            <span class="d-block text-muted">Order No</span>
                                            <span>MT12332345</span>

                                        </div>
                                    </td>

                                    <td>
                                        <div class="py-2">

                                            <span class="d-block text-muted">Payment</span>
                                            <span><img src="https://img.icons8.com/color/48/000000/mastercard.png"
                                                       width="20"/></span>

                                        </div>
                                    </td>

                                    <td>
                                        <div class="py-2">

                                            <span class="d-block text-muted">Shiping Address</span>
                                            <span>414 Advert Avenue, NY,USA</span>

                                        </div>
                                    </td>
                                </tr>
                                </tbody>

                            </table>


                        </div>


                        <div class="product border-bottom table-responsive">

                            <table class="table table-borderless">

                                <tbody>
                                <c:forEach items="${cartItems}" var="item">
                                    <tr>
                                        <td width="20%">

                                            <img src="${item.image}" width="90">

                                        </td>

                                        <td width="60%">
                                            <span class="font-weight-bold">${item.productName}</span>
                                            <div class="product-qty">
                                                <span class="d-block">Quantity:${item.quantity}</span>
                                                <span class="d-block">Topping:${item.topping}</span>
                                                <span>Size: ${item.size_name}</span>

                                            </div>
                                        </td>
                                        <td width="20%">
                                            <div class="text-right">
                                                <span class="font-weight-bold">Unit price: ${item.price}.000</span>
                                                <span class="font-weight-bold">Sub total${item.subToTal}.000</span>
                                            </div>
                                        </td>
                                    </tr>


                                </c:forEach>
                                </tbody>

                            </table>


                        </div>


                        <div class="row d-flex justify-content-end">

                            <div class="col-md-5">

                                <table class="table table-borderless">

                                    <tbody class="totals">

                                    <tr>
                                        <td>
                                            <div class="text-left">

                                                <span class="text-muted">Total</span>

                                            </div>
                                        </td>
                                        <td>
                                            <div class="text-right">
                                                <span><c:out value="${totalPrice}.000"/></span>
                                            </div>
                                        </td>
                                    </tr>


                                    <tr>
                                        <td>
                                            <div class="text-left">

                                                <span class="text-muted">Shipping Fee</span>

                                            </div>
                                        </td>
                                        <td>
                                            <div class="text-right">
                                                <span>gratis</span>
                                            </div>
                                        </td>
                                    </tr>


                                    <tr class="border-top border-bottom">
                                        <td>
                                            <div class="text-left">

                                                <span class="font-weight-bold">Subtotal</span>

                                            </div>
                                        </td>
                                        <td>
                                            <div class="text-right">
                                                <span class="font-weight-bold"><c:out value="${totalPrice}.000"/></span>
                                            </div>
                                        </td>
                                    </tr>

                                    </tbody>

                                </table>

                            </div>


                        </div>


                        <p>We will be sending shipping confirmation email when the item shipped successfully!</p>

                    </div>
                </div>

                <input type="submit" value="Submit">
            </div>


            <div class="d-flex justify-content-between footer p-3">

                <span>Need Help? visit our <a href="#"> help center</a></span>
                <span>12 June, 2020</span>

            </div>


        </div>

    </div>

    </div>

    </div>
</form>
<script>
    document.getElementById("demo").innerHTML = new Date().toString().slice(0, 25);
</script>
</body>
</html>
