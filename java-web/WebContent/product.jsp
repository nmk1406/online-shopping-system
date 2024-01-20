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
						<strong class="text-black">${product.name}</strong>
					</div>
				</div>
			</div>
		</div>
	    <div class="site-section">
	        <div class="container">
	        	<c:if test="${not empty product}">
	            <div class="row">
	                <div class="col-md-6">
	                    <img src="${product.image}" alt="Image" class="img-fluid">
	                </div>
	                <div class="col-md-6">
	                    <h2 class="text-black">${product.name}</h2>
						<h6 class="text-black">${product.category.name}</h6>
	                    <p>${product.description}</p>
	                    <p><strong class="text-primary h4">$${product.price}</strong></p>
	                    <form action="add-cart" method="post">
	                    	<div class="mb-3">
	                    		<input name="id" value="${product.id}" type="hidden">
	                        	<input name="quantity" value="1" type="hidden">
	                        	<label for="quantity" class="form-label text-black">
	                        		Products available: ${product.quantity}
	                        	</label>
	                        </div>
	                        <p><input type="submit" class="buy-now btn btn-sm btn-primary" value="Add To Cart"></p>
	                    </form>
	                </div>
	            </div>
	            </c:if>
	            <c:if test="${empty product}">
	            	<label class="text-black h4">This product isn't available.</label>
	            </c:if>
	        </div>
	    </div>
    	<jsp:include page="template/footer.jsp"/>
	</div>
	<jsp:include page="template/script.jsp"/>
</body>
</html>