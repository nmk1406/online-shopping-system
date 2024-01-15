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
						<a href="index.html">Home</a>
						<span class="mx-2 mb-0">/</span>
						<strong class="text-black">Shop</strong>
					</div>
				</div>
			</div>
		</div>
	
		<div class="site-section">
			<div class="container">
				<div class="row mb-5">
					<div class="col-md-9 order-2">
						<div class="row mb-5">
							<c:forEach items="${products}" var="product">
								<div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
									<div class="block-4 text-center border" style="height: 100%">
										<figure class="block-4-image">
											<a href="product-detail?id=${product.id}">	
												<img src="${product.image}" alt="Image placeholder" class="img-fluid">
											</a>
										</figure>
										<div class="block-4-text p-4">
											<h3><a href="product-detail?id=${product.id}">${product.name} ${action}</a></h3>
											<p class="mb-0">$${product.price}</p>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="row" data-aos="fade-up">
							<div class="col-md-12 text-center">
								<div class="site-block-27">
									<ul>
										<c:forEach begin="${1}" end="${num}" var="i">
											<c:set var="url" value="${url}"/>
											<c:if test="${url == '/shop'}">
												<li><a href="shop?page=${i}">${i}</a></li>
											</c:if>
											<c:if test="${url == '/search'}">
												<li><a href="search?txt=${txt}&page=${i}">${i}</a></li>
											</c:if>
											<c:if test="${url == '/category'}">
												<li><a href="category?id=${categoryId}&page=${i}">${i}</a></li>
											</c:if>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-md-3 order-1 mb-5 mb-md-0">
						<div class="border p-4 rounded mb-4">
							<h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
							<ul class="list-unstyled mb-0">
								<c:forEach items="${categories}" var="category">
									<li class="mb-1 active">
				              			<a href="category?id=${category.id}" class="d-flex">
				              				<span>${category.name}</span>
				              			</a>
		              				</li>
		              			</c:forEach>
	              			</ul>
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