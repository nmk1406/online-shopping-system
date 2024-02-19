<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<header class="site-navbar" role="banner">
	<div class="site-navbar-top">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
					<form action="search" method="get" class="site-block-top-search">
						<span class="icon icon-search2"></span>
						<input name="txt" type="text" class="form-control border-0" placeholder="Search">
					</form>
				</div>
				<div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
					<div class="site-logo">
						<a href="shop" class="js-logo-clone">Nike</a>
					</div>
				</div>

				<div class="col-6 col-md-4 order-3 order-md-3 text-right">
					<div class="site-top-icons">
						<ul>
							<c:if test="${empty user}">
								<li><a href="login"><span class="icon icon-person"></span></a></li>
							</c:if>
							<c:if test="${not empty user}">
								<li><a href="logout"><span class="icon icon-sign-out"></span></a></li>
							</c:if>     
							<c:if test="${user.roleId != 1}">             
								<li>
									<a href="cart" class="site-cart">
										<span class="icon icon-shopping_cart"></span>
										<c:if test="${not empty size}">
											<span class="count">${size}</span>
										</c:if>
									</a>
								</li> 
								<li class="d-inline-block d-md-none ml-md-0">
									<a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu"></span></a>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<nav class="site-navigation text-right text-md-center" role="navigation">
		<div class="container">
			<ul class="site-menu js-clone-nav d-none d-md-block">
				<c:if test="${user == null}">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li class="active"><a href="shop">Shop</a></li>
				</c:if>
				<c:if test="${user != null}">
					<c:if test="${user.roleId != 1}">
						<li class="active"><a href="index.jsp">Home</a></li>
						<li class="active"><a href="shop">Shop</a></li>
					</c:if>
					<c:if test="${user.roleId == 1}">
						<li class="active"><a href="product-management">Product Management</a></li>
						<li class="active"><a href="user-management">User Management</a></li>
					</c:if>
					<li class="active"><a href="order-management">Order Management</a></li>
				</c:if>
			</ul>
		</div>
	</nav>
</header>