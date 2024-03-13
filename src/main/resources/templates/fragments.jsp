<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head th:fragment="html_head">
  <title>Inventory Management System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js">
    </script>
  <style>
  
  .footer {
	   position: fixed;
	   bottom:0;
	   width:100%;
	   height:50px;   /* Height of the footer */
	   background:#222222;
	   color: white;
	   text-align: center;
	}
	
	div.rounded {
	    padding: 10px;
	    border: 2px solid #a59e9e;
	    border-radius: 15px;
	    -moz-border-radius: 15px;
	}
	</style>
</head>
<body>
<div th:fragment="header_menu">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><i class="glyphicon glyphicon-book"></i> <span th:text="${appName}"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a th:href="@{/dashboard}"><i class="glyphicon glyphicon-home"></i> Dashboard</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-th-list"></i> Inventory<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a th:href="@{/inventory/addInventory}"><i class="glyphicon glyphicon-plus"></i> Add Inventory</a></li>
          <li><a href="#"><i class="glyphicon glyphicon-minus"></i> Remove Inventory</a></li>
          <li><a href="#"><i class="glyphicon glyphicon-retweet"></i> Move Inventory</a></li>
          <li><a href="#"><i class="glyphicon glyphicon-edit"></i> Adjust Inventory</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-user"></i> User Management<span class="caret"></span></a>
        <ul class="dropdown-menu">         
          <li><a href="#"><i class="glyphicon glyphicon-plus"></i> Add User</a></li>
          <li><a href="#"><i class="glyphicon glyphicon-pencil"></i> Active/Inactive User</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-save"></i> Master<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a th:href="@{/master/addcategorytypemaster}"><i class="glyphicon glyphicon-plus"></i> Category Type Master</a></li>
          <li><a th:href="@{/master/addcategorymaster}"><i class="glyphicon glyphicon-plus"></i> Category Master</a></li>
          <li><a th:href="@{/master/addproductmaster}"><i class="glyphicon glyphicon-plus"></i> Product Master</a></li>
        </ul>
      </li>
      <li><a href="#"><i class="glyphicon glyphicon-usd"></i> Billing</a></li>
      <li><a href="#"><i class="glyphicon glyphicon-list-alt"></i> Reports</a></li>
      <li><a href="#"><i class="glyphicon glyphicon-cog"></i> Settings</a></li>
    </ul>
    <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
    <a th:href="@{/logout}" type="button" class="btn btn-danger navbar-btn pull-right">
      <span class="glyphicon glyphicon-off"></span> Logout
    </a>
  </div>
</nav>
</div>

<div th:fragment="footer">
<div class="footer">
  <p><span th:text="${appName}"></span></p>
  2023
</div>
</div>
</body>
</html>