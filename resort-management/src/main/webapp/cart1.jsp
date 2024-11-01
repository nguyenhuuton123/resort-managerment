<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="theme-color" content="#33b5e5">


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">


    <link rel="stylesheet"
          href="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/css/dist/mdb5/standard/core.min.css">


    <link rel='stylesheet' id='roboto-subset.css-css'
          href='https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/css/mdb5/fonts/roboto-subset.css?ver=3.9.0-update.5'
          type='text/css' media='all'/>


    <meta charset="utf-8">
</head>

<body>
<section class="pb-4">
    <div class="bg-white border rounded-5">

        <section class="w-100 p-5 gradient-custom" style="border-radius: .5rem .5rem 0 0;">
            <style>
                .gradient-custom {
                    /* fallback for old browsers */
                    background: #6a11cb;

                    /* Chrome 10-25, Safari 5.1-6 */
                    background: -webkit-linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));

                    /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
                    background: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1))
                }
            </style>
            <div class="row">
                <div class="col-md-8">
                    <div class="card mb-4">
                        <div class="card-header py-3">
                            <h5 class="mb-0">Cart - <c:out value="${size}"/> items</h5>
                        </div>
                        <form action="/cart" method="post">
                            <c:forEach items="${cartItems}" var="item">
                                <div class="card-body">
                                    <!-- Single item -->
                                    <div class="row">
                                        <div class="col-lg-3 col-md-12 mb-4 mb-lg-0">
                                            <!-- Image -->
                                            <div class="bg-image hover-overlay hover-zoom ripple rounded"
                                                 data-mdb-ripple-color="light">
                                                <img src="${item.image}"
                                                     class="w-100" alt="Blue Jeans Jacket">
                                                <a href="#!">
                                                    <div class="mask"
                                                         style="background-color: rgba(251, 251, 251, 0.2)">
                                                    </div>
                                                </a>
                                            </div>
                                            <!-- Image -->
                                        </div>

                                        <div class="col-lg-5 col-md-6 mb-4 mb-lg-0">
                                            <!-- Data -->
                                            <input type="hidden" name="product_id" value="${item.product_id}">
                                            <p><strong>${item.productName}</strong></p>
                                            <p>Topping: ${item.topping}</p>
                                            <p>Size: ${item.size_name}</p>
                                            <button type="button" class="btn btn-primary btn-sm me-1 mb-2"
                                                    data-mdb-toggle="tooltip" aria-label="Remove item"
                                                    data-mdb-original-title="Remove item">
                                                <i class="fas fa-trash"></i>
                                            </button>

                                        </div>

                                        <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                                            <!-- Quantity -->
                                            <div class="d-flex mb-4" style="max-width: 300px">


                                                <div class="form-outline">
                                                    <input id="form1" min="0" name="quantity" value="${item.quantity}"
                                                           type="number"
                                                           class="form-control active">
                                                    <label class="form-label" for="form1"
                                                           style="margin-left: 0px;">Quantity</label>
                                                    <div class="form-notch">
                                                        <div class="form-notch-leading" style="width: 9px;"></div>
                                                        <div class="form-notch-middle" style="width: 32.8px;"></div>
                                                        <div class="form-notch-trailing"></div>
                                                    </div>
                                                </div>


                                            </div>
                                            <!-- Quantity -->

                                            <!-- Price -->
                                            <p class="text-start text-md-center">
                                                <strong>Price: ${item.price}.000</strong><br>
                                                <strong>Sub total: ${item.subToTal}.000</strong>
                                            </p>
                                            <!-- Price -->
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                    </div>


                </div>
                <div class="col-md-4">
                    <div class="card mb-4">
                        <div class="card-header py-3">
                            <h5 class="mb-0">Summary</h5>
                        </div>
                        <div class="card-body">


                            <button type="submit" class="btn btn-primary btn-lg btn-block">
                                Go to checkout
                            </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>


    </div>
</section>
</body>

</html>