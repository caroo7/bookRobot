<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <spring:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/core/css/reset.css" var="coreCss" />
    <spring:url value="http://getbootstrap.com/examples/jumbotron/jumbotron.css" var="jumbotronCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Latest compiled Bootstrap -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Robot library checker</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="https://github.com/caroo7/Caro-robot">Github Repository</a>
        </div>
      </div>
    </nav>
<div class"container text-center">
 <div class="jumbotron">
      <div class="container">
        <h1>Robot library application</h1>
      </div>
    </div>
<div class="container">
    <div id="libraries" class="list-group">
        <a href="#" class="list-group-item active">Empik</a>
        <a href="#" class="list-group-item active">Library2</a>
        <a href="#" class="list-group-item active">Library3</a>
        <a href="#" class="list-group-item active">Library4</a>

</div>
    <div id="books">

             <table class="table table-bordered">
             <thead >
             <tr id="heads">
             <th>Title</th>
             <th>Author</th>
             </tr>
                <c:forEach var="b" items="${books}">
                <tr>
                    <td>${b.getTitle()}</td>
                    <td>${b.getAuthors()}</td>
                </tr>
                </c:forEach>
             </table>
             </thead>


    </div>
   </div>
   <div class="container text-center" align="center">
     <footer >
            <p>&copy; 2016 Yggdrasil Inc.</p>
     </footer>
     </div>
</div>
</body>
</html>