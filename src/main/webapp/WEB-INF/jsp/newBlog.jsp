<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        <h2>Create a new blog</h2>
        <hr>
        <form:form class="form-horizontal" method="POST" action="/blogs/add" modelAttribute="blog">
            <div class="form-group">
                <div class="col-sm-2"></div>
                <form:label class="control-label col-sm-2" path="name">Name:</form:label>
                <div class="col-sm-6">
                    <form:input class="form-control" placeholder="Blog name" path="name"/>
                </div>
                <div class="col-sm-2"></div>
            </div>
            <div class="form-group">
                <div class="col-sm-2"></div>
                <form:label class="control-label col-sm-2" path="categories">Categories:</form:label>
                <div class="col-sm-6">
                    <form:select class="form-control" multiple="true" path="categories">
                        <form:options items="${categories}" itemValue="id" itemLabel="name"/>
                    </form:select>
                </div>
                <div class="col-sm-2"></div>
            </div>
            <div class="form-group">
                <div class="col-sm-4"></div>
                <div class="col-sm-6">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
                <div class="col-sm-2"></div>
            </div>
        </form:form>
    </div>

	<script type="text/javascript" src="../webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <footer>
        <div class="container">
            by Andrzej Goetzendorf-Grabowski, s13227
        </div>
    </footer>
</body>

</html>