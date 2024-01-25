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
						<a href="home">Home</a>
						<span class="mx-2 mb-0">/</span>
						<strong class="text-black">Order History</strong>
					</div>
				</div>
			</div>
		</div>
		<div class="site-section">
	        <div class="container">
	            <div class="row mb-5">
	                <div class="col-md-12">
	                	<div>
	           				<label class="text-black h4">Order details</label>
	           			</div>
	                    <div class="site-blocks-table">
	                        <table class="table table-bordered">
	                            <thead>
		                            <tr>
		                                <th>Id</th>
		                                <th>Product</th>
		                                <th style="width: 300px">Image</th>
		                                <th>Price</th>
		                                <th>Quantity</th>
		                                <th>Total</th>
		                            </tr>
	                            </thead>
	                            <tbody>
		                            <c:forEach items="${orderDetails}" var="orderDetail">
		                                <tr>
		                                    <td>
		                                        <h2 class="h5 text-black">${orderDetail.product.id}</h2>
		                                    </td>
		                                    <td>
		                                        <h2 class="h5 text-black">${orderDetail.product.name}</h2>
		                                    </td>
		                                    <td>
		                                        <img src="${orderDetail.product.image}" alt="Image" class="img-fluid">
		                                    </td>
		                                    <td>
		                                        <h2 class="h5 text-black">$${orderDetail.price}</h2>
		                                    </td>
		                                    <td>
		                                        <h2 class="h5 text-black">${orderDetail.quantity}</h2>
		                                    </td>
		                                    <td>
		                                        <h2 class="h5 text-black">$${orderDetail.price * orderDetail.quantity}</h2>
		                                    </td>
		                                </tr>
		                            </c:forEach>
	                            </tbody>
	                        </table>
	                    </div>
	                </div>
	            </div>
	            
	            <div class="row mb-5">
	                <div class="col-md-12">
	                	<div>
	                		<label class="text-black h4">Shipping address</label>
	                	</div>
	                	<div class="site-blocks-table">
	                        <table class="table table-bordered">
	                            <thead>
		                            <tr>
		                                <th>Full name</th>
		                                <th>Address</th>
		                                <th>Email</th>
		                                <th>Phone</th>
		                            </tr>
	                            </thead>
	                            <tbody>
	                            	<tr>
	                            		<td>
	                            			<h2 class="h5 text-black">${orderDetails[0].order.fullname}</h2>
	                            		</td>
	                            		<td>
	                            			<h2 class="h5 text-black">${orderDetails[0].order.address}</h2>
	                            		</td>
	                            		<td>
	                            			<h2 class="h5 text-black">${orderDetails[0].order.email}</h2>
	                            		</td>
	                            		<td>
	                            			<h2 class="h5 text-black">${orderDetails[0].order.phone}</h2>
	                            		</td>
	                            	</tr>
	                            </tbody>
	                        </table>
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