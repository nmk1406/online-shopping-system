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
						<strong class="text-black">Categories Management</strong>
					</div>
				</div>
			</div>
		</div>
		<div class="site-section">
	        <div class="container">
	            <div class="row mb-5">
	                <div class="col-md-12">
	                    <div class="site-blocks-table">
	                    <c:if test="${product != null}">
	                    	<form action="update-product" method="post">
	                    </c:if>
	                    <c:if test="${product == null}">
	                    	<form action="insert-product" method="post">
	                    </c:if>
		                        <table class="table table-bordered">
		                            <thead>
			                            <tr>
			                            	<c:if test="${product != null}">
			                            		<th>Id</th>
			                            	</c:if>
			                                <th>Name</th>
			                                <th>Image</th>
			                                <th>Quantity</th>
			                                <th>Price</th>
			                                <th>Description</th>
			                                <th>Status</th>
			                                <th>Category Id</th>
			                                <th>Action</th>
			                            </tr>
		                            </thead>
		                            <tbody>
			                                <tr>
			                                	<c:if test="${product != null}">
				                                	<td>
				                                		<input type="text" name="id" class="form-control-plaintext h5 text-black"
				                                			value="${product.id}" style="text-align: center" readonly="readonly">
				                                    </td>
			                                    </c:if>
			                                    <td>
			                                    	<input type="text" name="name" class="form-control-plaintext h5 text-black"
			                                        	value="${product.name}" style="text-align: center" placeholder="Type here">
			                                    </td>
			                                    <td>
			                                    	<input type="text" name="image" class="form-control-plaintext h5 text-black"
			                                        	value="${product.image}" style="text-align: center" placeholder="Type here">
			                                    </td>
			                                    <td>
			                                    	<input type="text" name="quantity" class="form-control-plaintext h5 text-black"
			                                        	value="${product.quantity}" style="text-align: center" placeholder="Type here">
			                                    </td>
			                                    <td>
			                                    	<input type="text" name="price" class="form-control-plaintext h5 text-black"
			                                        	value="${product.price}" style="text-align: center" placeholder="Type here">
			                                    </td>
			                                    <td>
			                                    	<input type="text" name="description" class="form-control-plaintext h5 text-black"
			                                        	value="${product.description}" style="text-align: center" placeholder="Type here">
			                                    </td>
			                                    <td>
			                                    	<input type="number" name="status" min="0" max="1" class="form-control-plaintext h5 text-black"
			                                        	value="${product.status}" style="text-align: center" placeholder="Type here">
			                                    </td>
			                                    <td>
			                                    	<input type="number" name="categoryId" min="1" class="form-control-plaintext h5 text-black"
			                                        	value="${product.category.id}" style="text-align: center" placeholder="Type here">
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