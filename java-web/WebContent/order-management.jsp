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
	                    <div class="site-blocks-table">
	                    	<c:if test="${not empty orders}">
	                        <table class="table table-bordered">
	                            <thead>
		                            <tr>
		                                <th>Id</th>
		                                <th>Date</th>
		                                <th>Total</th>
		                                <th>Status</th>
		                                <th>Action</th>
		                            </tr>
	                            </thead>
	                            <tbody>
		                            <c:forEach items="${orders}" var="order">
		                                <tr>
		                                    <td>
		                                        <h2 class="h5 text-black">${order.id}</h2>
		                                    </td>
		                                    <td>
		                                        <h2 class="h5 text-black">${order.orderDate}</h2>
		                                    </td>
		                                    <td>
		                                        <h2 class="h5 text-black">$${order.totalMoney}</h2>
		                                    </td>
		                                    <td>
		                                    	<c:if test="${order.status == 1}">
		                                    		<h2 class="h5 text-black">Processing</h2>
		                                    	</c:if>
		                                        <c:if test="${order.status == 2}">
		                                    		<h2 class="h5 text-black">Shipping</h2>
		                                    	</c:if>
		                                    	<c:if test="${order.status == 3}">
		                                    		<h2 class="h5 text-black">Delivered</h2>
		                                    	</c:if>
		                                    	<c:if test="${order.status == 0}">
		                                    		<h2 class="h5 text-black">Cancelled</h2>
		                                    	</c:if>
		                                    </td>
		                                    <td>
		                                    	<a href="order-detail?id=${order.id}" class="btn btn-primary btn-sm">Detail</a>
		                                    	<c:if test="${user.roleId == 1}">
		                                    		<a href="update-order?id=${order.id}" class="btn btn-primary btn-sm">Update</a>
		                                    	</c:if>
		                                    </td>
		                                </tr>
		                            </c:forEach>
	                            </tbody>
	                        </table>
	                        </c:if>
	                        <c:if test="${empty orders}">
	                        	<label class="text-black h4">Your order is empty.</label>
	                        </c:if>
	                    </div>
	                    <div class="row" data-aos="fade-up">
							<div class="col-md-12 text-center">
								<div class="site-block-27">
									<ul>
										<c:forEach begin="${1}" end="${num}" var="i">
											<li><a class="${i==page?'active':''}" href="order-management?page=${i}">${i}</a></li>
										</c:forEach>
									</ul>
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