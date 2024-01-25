<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<jsp:include page="template/head.jsp"/>
<body>
	<div class="site-wrap">
		<jsp:include page="template/header.jsp"/>
		<div class="site-blocks-cover" style="background-image: url(static/images/background.jpg);" data-aos="fade">
	        <div class="container">
	            <div class="row align-items-start align-items-md-center justify-content-end">
	                <div class="col-md-5 text-center text-md-left pt-5 pt-md-0">
	                    <h1 class="mb-2">Finding Your Perfect Shoes</h1>
	
	                    <div class="intro-text text-center text-md-left">
	                        <p class="mb-4">HIIT the gym with locked-in support and next-level confidence.
		                        Enjoy your rest day or simply chill in the softest flexibility imaginable.
		                        From working out to pressing pause, Nike bras and leggings are the essential
		                        foundation for your day- no matter what life throws your way.
	                        </p>
	                        <p>
	                            <a href="shop" class="btn btn-sm btn-primary">Shop Now</a>
	                        </p>
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