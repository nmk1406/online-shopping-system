<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="template/head.jsp"/>
<body>
	<div class="site-wrap">
		<jsp:include page="template/header.jsp"/>
		<div class="bg-light py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="shop">Home</a>
						<span class="mx-2 mb-0">/</span>
						<strong class="text-black">Cart</strong>
					</div>
				</div>
			</div>
		</div>
		<div class="site-section">
	        <div class="container">
	            <div class="row mb-5">
	                <div class="col-md-12">
	                    <div class="site-blocks-table">
	                    	<c:if test="${not empty cart}">
	                        <table class="table table-bordered">
	                            <thead>
		                            <tr>
		                                <th class="product-thumbnail">Image</th>
		                                <th class="product-name">Product</th>
		                                <th class="product-price">Price</th>
		                                <th class="product-quantity">Quantity</th>
		                                <th class="product-total">Total</th>
		                                <th class="product-remove">Action</th>
		                            </tr>
	                            </thead>
	                            <tbody>
		                            <c:forEach items="${cart.items}" var="item">
		                                <tr>
		                                    <td style="min-width: 240px">
		                                        <img src="${item.product.image}" alt="Image" class="img-fluid">
		                                    </td>
		                                    <td style="min-width: 240px">
		                                        <h2 class="h5 text-black">${item.product.name}</h2>
		                                    </td>
		                                    <td style="min-width: 160px">
		                                        <h2 class="h5 text-black">$${item.price}</h2>
		                                    </td>
		                                    <td style="min-width: 160px">
		                                        <div class="input-group" >
		                                            <div class="input-group-prepend">
		                                            	<a href="edit-cart?id=${item.product.id}&quantity=-1">
			                                                <button class="btn btn-outline-primary" type="button">
			                                                	&minus;
			                                                </button>
		                                                </a>
		                                            </div>
		                                            <input name="product-quantity" type="text" class="form-control text-center"
			                                            	value="${item.quantity}" aria-label="Example text with button addon" aria-describedby="button-addon1">
		                                            <div class="input-group-append">
		                                            	<a href="edit-cart?id=${item.product.id}&quantity=1">
			                                                <button class="btn btn-outline-primary" type="button">
			                                                	&plus;
			                                                </button>
			                                            </a>
		                                            </div>
		                                        </div>
		                                    </td>
		                                    <td style="min-width: 160px">
		                                    	<h2 class="h5 text-black">$${item.price * item.quantity}</h2>
		                                    </td>
		                                    <td style="min-width: 140px">
												<a href="remove-cart?id=${item.product.id}" class="btn btn-primary btn-sm">Remove</a>
		                                    </td>
		                                </tr>
		                            </c:forEach>
	                            </tbody>
	                        </table>
	                        </c:if>
	                        <c:if test="${empty cart}">
	                        	<label class="text-black h4">Your cart is empty.</label>
	                        </c:if>
	                    </div>
	                </div>
	            </div>
	            <div class="row">
	                <div class="col-md-6">
	                    <div class="row mb-5">
	                        <div class="col-md-6 mb-3 mb-md-0">
	                            <a href="shop" class="btn btn-outline-primary btn-sm">Continue shopping</a>
	                        </div>
	                    </div>
	                    <div class="row">
	                        <div class="col-md-12">
	                            <label class="text-black h4" for="coupon">Coupon</label>
	                            <p>Enter your coupon code if you have one.</p>
	                        </div>
	                        <div class="col-md-8 mb-3 mb-md-0">
	                            <input type="text" class="form-control py-3" id="coupon" placeholder="Coupon Code">
	                        </div>
	                        <div class="col-md-4">
	                            <button class="btn btn-primary btn-sm">Apply Coupon</button>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-md-6 pl-5">
	                    <div class="row justify-content-end">
	                        <div class="col-md-7">
	                            <div class="row">
	                                <div class="col-md-12 text-right border-bottom mb-5">
	                                    <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
	                                </div>
	                            </div>
	                            <div class="row mb-5">
	                                <div class="col-md-6">
	                                    <span class="text-black" style="font-size: 1.5em">Total</span>
	                                </div>
	
	                                <div class="col-md-6 text-right">
	                                	<span class="text-black" style="font-size: 1.5em">$${cart.totalMoney}</span>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-md-12">
	                                    <a href="checkout" class="btn btn-primary btn-lg py-3 btn-block">
	                                        Checkout
	                                    </a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	    	</div>
    	</div>
    	<jsp:include page="template/footer.jsp"/>
	</div>
	<jsp:include page="template/script.jsp"/>
</body>
</html>