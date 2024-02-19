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
	                    <a href="home"> Home </a>
	                    <span class="mx-2 mb-0">/</span>
	
	                    <a href="cart">Cart</a>
	                    <span class="mx-2 mb-0">/</span>
	
	                    <strong class="text-black">Checkout</strong>
	                </div>
	            </div>
	        </div>
	    </div>
	
	    <div class="site-section">
	    	<div class="container">
				<form class="row" action="checkout" method="post">
					<div class="col-md-6 mb-5 mb-md-0">
						<h2 class="h3 mb-3 text-black">Billing Details</h2>
	                    <div class="p-3 p-lg-5 border">
	                        <div class="form-group row">
	                            <div class="col-md-12">
	                                <label for="fullname" class="text-black">
	                                    Full Name <span class="text-danger">*</span>
	                                </label>
	
	                                <input type="text" class="form-control" id="fullname" name="fullname" required>
	                            </div>
	                        </div>
	
	                        <div class="form-group row">
	                            <div class="col-md-12">
	                                <label for="address" class="text-black">
	                                    Address <span class="text-danger">*</span>
	                                </label>
	
	                                <input type="text" class="form-control" id="address" name="address" required>
	                            </div>
	                        </div>
	
	                        <div class="form-group row mb-5">
	                            <div class="col-md-6">
	                                <label for="email" class="text-black">
	                                    Email Address <span class="text-danger">*</span>
	                                </label>
	
	                                <input type="text" class="form-control" id="email" name="email" required>
	                            </div>
	                            <div class="col-md-6">
	                                <label for="phone" class="text-black">
	                                    Phone <span class="text-danger">*</span>
	                                </label>
	
	                                <input type="text" class="form-control" id="phone" name="phone" required>
	                            </div>
	                        </div>
	                    </div>
	                </div>
					<div class="col-md-6">
	          
						<div class="row mb-5">
							<div class="col-md-12">
							<h2 class="h3 mb-3 text-black">Your Order</h2>
								<div class="p-3 p-lg-5 border">
									<table class="table site-block-order-table mb-5">
										<thead>
											<tr>
												<th>Product</th>
												<th>Total</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${cart.items}" var="item">
												<tr>
													<td>${item.product.name}<strong class="mx-2"> x </strong>${item.quantity}</td>
													<td>$${item.price * item.quantity}</td>
												</tr>
											</c:forEach>
											<tr>
												<td class="text-black font-weight-bold"><strong>Order Total</strong></td>
												<td class="text-black font-weight-bold"><strong>$${cart.totalMoney}</strong></td>
											</tr>
										</tbody>
									</table>
									<button class="btn btn-primary btn-lg py-3 btn-block" type="submit">Place Order</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<jsp:include page="template/footer.jsp"/>
	</div>
	<jsp:include page="template/script.jsp"/>
</body>
</html>