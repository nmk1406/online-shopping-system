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
						<strong class="text-black">Thank you</strong>
					</div>
				</div>
			</div>
		</div>

    	<div class="site-section">
        	<div class="container">
            	<div class="row">
                	<div class="col-md-12 text-center">
                    	<span class="icon-check_circle display-3 text-success"></span>
                    	<h2 class="display-3 text-black">Thank you!</h2>
                    	<p class="lead mb-5">You order was successfuly completed.</p>
                    	<p><a href="shop" class="btn btn-sm btn-primary">Back to shop</a></p>
                	</div>
            	</div>
        	</div>
    	</div>
		<jsp:include page="template/footer.jsp"/>
	</div>
	<jsp:include page="template/script.jsp"/>
</body>
</html>