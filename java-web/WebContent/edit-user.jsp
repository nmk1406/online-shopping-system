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
						<strong class="text-black">Edit User</strong>
					</div>
				</div>
			</div>
		</div>
		<div class="site-section">
	        <div class="container">
	            <div class="row mb-5">
	                <div class="col-md-12">
	                    <div class="site-blocks-table">
	                    	<form action="update-user" method="post">
		                        <table class="table table-bordered">
		                            <thead>
			                            <tr>
			                                <th>Id</th>
			                                <th>Email</th>
			                                <th>Password</th>
			                                <th>Phone</th>
			                                <th>Status</th>
			                                <th>Role Id</th>
			                                <th>Action</th>
			                            </tr>
		                            </thead>
		                            <tbody>
		                                <tr>
		                                    <td>
		                                        <input type="text" name="id" class="form-control-plaintext h5 text-black"
		                                        	value="${user.id}" style="text-align: center" readonly="readonly">
		                                    </td>
		                                    <td>
		                                        <h2 class="h5 text-black">${user.email}</h2>
		                                    </td>
		                                    <td>
		                                        <h2 class="h5 text-black">${user.password}</h2>
		                                    </td>
		                                    <td>
		                                        <h2 class="h5 text-black">${user.phone}</h2>
		                                    </td>
		                                    <td>
		                                    	<input type="number" min="0" max="1" name="status" class="form-control-plaintext h5 text-black"
		                                    		value="${user.status}" style="text-align: center" placeholder="Type here">
		                                    </td>
		                                    <td>
		                                    	<input type="number" min="1" max="2" name="roleId" class="form-control-plaintext h5 text-black"
		                                    		value="${user.roleId}" style="text-align: center" placeholder="Type here">
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