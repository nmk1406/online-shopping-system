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
						<strong class="text-black">Categories Management</strong>
					</div>
				</div>
			</div>
		</div>
		<div class="site-section">
	        <div class="container">
	            <div class="row mb-5">
	                <div class="col-md-12">
	                	<div>
	           				<label class="text-black h4">Add Categories</label>
	           			</div>
	                    <div class="site-blocks-table">
	                    <c:if test="${category != null}">
	                    	<form action="update-category" method="post">
	                    </c:if>
	                    <c:if test="${category == null}">
	                    	<form action="insert-category" method="post">
	                    </c:if>
		                        <table class="table table-bordered">
		                            <thead>
			                            <tr>
			                            	<c:if test="${category != null}">
			                            		<th>Id</th>
			                            	</c:if>
			                                <th>Name</th>
			                                <th>Action</th>
			                            </tr>
		                            </thead>
		                            <tbody>
			                                <tr>
			                                	<c:if test="${category != null}">
				                                	<td>
				                                		<input type="text" name="id" class="form-control-plaintext h5 text-black"
				                                			value="${category.id}" style="text-align: center" readonly="readonly">
				                                    </td>
			                                    </c:if>
			                                    <td>
			                                    	<input type="text" name="name" class="form-control-plaintext h5 text-black"
			                                        	value="${category.name}" style="text-align: center" placeholder="Type here">
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