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
	                    	<form action="update-order" method="post">
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
		                                <tr>
		                                    <td>
		                                        <input type="text" name="id" class="form-control-plaintext h5 text-black"
		                                        	value="${order.id}" style="text-align: center" readonly="readonly">
		                                    </td>
		                                    <td>
		                                        <h2 class="h5 text-black">${order.orderDate}</h2>
		                                    </td>
		                                    <td>
		                                        <h2 class="h5 text-black">$${order.totalMoney}</h2>
		                                    </td>
		                                    <td>
		                                    	<input type="number" min="0" max="3" name="status" class="form-control-plaintext h5 text-black"
		                                    		value="${order.status}" style="text-align: center" placeholder="Type here">
		                                    </td>
		                                    <td>
		                                    	<input type="submit" class="btn btn-primary btn-sm" value="save">
		                                    </td>
		                                </tr>
		                            </tbody>
		                        </table>
	                        </form>
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