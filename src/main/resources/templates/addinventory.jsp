<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head th:replace="fragments :: html_head"/>
<body>
<div th:replace="fragments :: header_menu"/>  
<div class="container">
  <h2>Inline form</h2>
  <p>Make the viewport larger than 768px wide to see that all of the form elements are inline, left aligned, and the labels are alongside.</p>
  
  <form class="form-horizontal" action="/action_page.php">
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Category Type:</label>
    <div class="col-sm-3">
      <input type="email" class="form-control" id="email" placeholder="Enter email">
    </div>
    <label class="control-label col-sm-2" for="pwd">Category :</label>
    <div class="col-sm-3">
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Product :</label>
    <div class="col-sm-3">
      <input type="email" class="form-control" id="email" placeholder="Enter email">
    </div>
    <label class="control-label col-sm-2" for="pwd">Product Desc :</label>
    <div class="col-sm-3">
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Barcode :</label>
    <div class="col-sm-3">
      <input type="email" class="form-control" id="email" placeholder="Enter email">
    </div>
    <label class="control-label col-sm-2" for="pwd">Batch No:</label>
    <div class="col-sm-3">
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">MRP:</label>
    <div class="col-sm-3">
      <input type="email" class="form-control" id="email" placeholder="Enter email">
    </div>
    <label class="control-label col-sm-2" for="pwd">MFG Date:</label>
    <div class="col-sm-3">
      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
  </div>
  
  
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form>
</div>


  
  
  
  
</div>
<div th:replace="fragments :: footer"/> 
</body>
</html>