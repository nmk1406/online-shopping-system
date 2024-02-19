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
		                                <th>Email</th>
		                                <th>Password</th>
		                                <th>Phone</th>
		                                <th>Status</th>
		                                <th>Role</th>
		                                <th>Action</th>
		                            </tr>
	                            </thead>
	                            <tbody>
		                            <c:forEach items="${users}" var="user">
		                                <tr>
		                                    <td>
		                                        <h2 class="h5 text-black">${user.id}</h2>
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
		                                    <c:if test="${user.status == 1}">
			                                    <td>
			                                    	<h2 class="h5 text-black">Open</h2>
			                                    </td>
		                                    </c:if>
		                                    <c:if test="${user.status == 0}">
			                                    <td>
			                                    	<h2 class="h5 text-black">Terminated</h2>
			                                    </td>
		                                    </c:if>
		                                    <c:if test="${user.roleId == 1}">
			                                    <td>
			                                    	<h2 class="h5 text-black">Admin</h2>
			                                    </td>
		                                    </c:if>
		                                    <c:if test="${user.roleId == 2}">
			                                    <td>
			                                    	<h2 class="h5 text-black">User</h2>
			                                    </td>
		                                    </c:if>
		                                    <td>
		                                        <a href="update-user?id=${user.id}" class="btn btn-primary btn-sm">Update</a>
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
											<li><a class="${i==page?'active':''}" href="user-management?page=${i}">${i}</a></li>
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