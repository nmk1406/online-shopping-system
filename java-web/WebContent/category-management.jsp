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
						<strong class="text-black">Category Management</strong>
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
		                                <th>Action</th>
		                            </tr>
	                            </thead>
	                            <tbody>
		                            <c:forEach items="${categories}" var="category">
		                                <tr>
		                                    <td>
		                                        <input class="form-control-plaintext h5 text-black"
		                                        	value="${category.id}" style="text-align: center" disabled="disabled"> 
		                                    </td>
		                                    <td>
		                                    	<input class="form-control-plaintext h5 text-black"
		                                        	value="${category.name}" style="text-align: center" disabled="disabled">
		                                    </td>
		                                    <td>
		                                        <a href="update-category?id=${category.id}" class="btn btn-primary btn-sm">Edit</a>
		                                    </td>
		                                </tr>
		                            </c:forEach>
	                            </tbody>
	                        </table>
	                    </div>
	                </div>
	            </div>
	            <div class="row">
	                <div class="col-md-6">
	                    <div class="row mb-5">
	                        <div class="col-md-6 mb-3 mb-md-0">
	                            <a href="insert-category" class="btn btn-outline-primary btn-sm">Add category</a>
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