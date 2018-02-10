<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<c:url value="/css/app.css" var="appCss" />
	<link href="${appCss}" rel="stylesheet" />

</head>
<body>

    <header>
        <div class="container">
            <h1 class="title">BLOG ENGINE</h1>
        </div>
        <div class="container">
            <ul class="menu-right">
                <a href="/blogs"><li>All blogs</li></a>
                <a href="/blogs/new"><li>New blog</li></a>
                <a href="/categories"><li>New category</li></a>
            </ul>
        </div>
    </header>

    <div class="container">
        <div class="row">
            <c:forEach items="${blogs}" var="blog">
                <div class="col-xs-4">
                    <a href="#">
                        <div class="blog-tile">
                            <h3>${blog.name}</h3>
                            <p>
                                <h5><strong>Categories:</strong></h5>
                                <ul>
                                    <c:forEach items="${blog.categories}" var="category"><li>${category.name}</li></c:forEach>
                                </ul>
                            </p>
                            <p>${blog.description}</p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>

	<script type="text/javascript" src="../webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <footer>
        <div class="container">
            by Andrzej Goetzendorf-Grabowski, s13227
        </div>
    </footer>
</body>

</html>