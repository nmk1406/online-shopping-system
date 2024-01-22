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
						<strong class="text-black">Product Management</strong>
					</div>
				</div>
			</div>
		</div>
		<div class="site-section">
	        <div class="container">
	            <div class="row mb-5">
	                <div class="col-md-12">
	                    <div class="site-blocks-table">
	                        <table class="table table-bordered">
	                            <thead>
		                            <tr>
		                                <th>Id</th>
		                                <th>Name</th>
		                                <th>Image</th>
		                                <th>Quantity</th>
		                                <th>Price</th>
		                                <th>Description</th>
		                                <th>Status</th>
		                                <th>Category</th>
		                                <th>Action</th>
		                            </tr>
	                            </thead>
	                            <tbody>
		                            <c:forEach items="${products}" var="product">
		                                <tr>
		                                    <td>
		                                        <h2 class="h5 text-black">${product.id}</h2>
		                                    </td>
		                                    <td>
		                                    	<h2 class="h5 text-black">${product.name}</h2>
		                                    </td>
		                                    <td>
		                                    	<img src="${product.image}" alt="Image" class="img-fluid">
		                                    </td>
		                                    <td>
		                                    	<h2 class="h5 text-black">${product.quantity}</h2>
		                                    </td>
		                                    <td>
		                                    	<h2 class="h5 text-black">${product.price}</h2>
		                                    </td>
		                                    <td>
		                                    	<h2 class="h5 text-black">${product.description}</h2>
		                                    </td>
		                                    <td>
		                                    	<h2 class="h5 text-black">${product.status}</h2>
		                                    </td>
		                                    <td>
		                                    	<h2 class="h5 text-black">${product.category.name}</h2>
		                                    </td>
		                                    <td>
		                                        <a href="update-product?id=${product.id}" class="btn btn-primary btn-sm">Edit</a>
		                                    </td>
		                                </tr>
		                            </c:forEach>
	                            </tbody>
	                        </table>
	                    </div>
	                    <div class="row" data-aos="fade-up">
							<div class="col-md-12 text-center">
								<div class="site-block-27">
									<ul>
										<c:forEach begin="${1}" end="${num}" var="i">
											<li><a class="${i==page?'active':''}" href="product-management?page=${i}">${i}</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
	                </div>
	            </div>
	            <div class="row">
	                <div class="col-md-6">
	                    <div class="row mb-5">
	                        <div class="col-md-6 mb-3 mb-md-0">
	                            <a href="insert-product" class="btn btn-outline-primary btn-sm">Add product</a>
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