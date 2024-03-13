<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head th:replace="fragments :: html_head"/>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css">
<body>
<div th:replace="fragments :: header_menu"/>  
<div class="container bg-light">
  <h3>Category Master</h3>
  <p>Use this form to Create, Modify or Delete Category Master.</p>
  <div class="rounded">
  <div th:if="${param.success}">
     <div class="alert alert-info">
        Data save successfully!
     </div>
  </div>
  <form method="post" role="form" th:action="@{/master/savecategorymaster}" th:object="${categorybean}" class="was-validated">
  <input type="hidden" th:field="*{categoryId}" name="categoryId" id="categoryId"/>
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Category Type:<span style="color: red">*</span></label>
    <div class="col-sm-3">
    
        <select class="form-control" th:field="*{categoryTypeId}" name="categoryTypeId" id="categoryTypeId">
		    <option value="0">- Select -</option>
            <option th:each="option : ${categotytypebeanlist}"
                    th:text="${option.categoryTypeName}"
                    th:value="${option.categotyTypeId}"></option>
        </select>		
      	<p th:if="${#fields.hasErrors('categoryTypeId')}" th:errors="*{categoryTypeId}" class="text-danger"></p>
    </div>
    <label class="control-label col-sm-3" for="email">Category Name:<span style="color: red">*</span></label>
    <div class="col-sm-3">
      	<input type="text" class="form-control" th:field="*{categoryName}" name="categoryName" id="categoryName" placeholder="Enter Category Name">
      	<p th:if="${#fields.hasErrors('categoryName')}" th:errors="*{categoryName}" class="text-danger"></p>
    </div>
  </div>

  <div class="form-group"> <label class="col">&nbsp;</label></div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Description :</label>
    <div class="col-sm-3">
      	<input type="text" class="form-control" th:field="*{categoryDesc}" name="categoryDesc" id="categoryDesc" placeholder="Enter Description">
    </div>
    <label class="control-label col-sm-3" for="pwd"></label>
    <div class="col-sm-3">
   
   </div>
  </div>
   
  <br/>
  <br/>
  <div class="col-md-12 text-center">
      <button type="submit" class="btn btn-primary">Submit</button>&nbsp;&nbsp;
      <button type="reset" class="btn btn-warning">Cancel</button>
  </div>
  <br/>
  <br/>
</form>
</div>
<br/>
	<div th:if="${param.delete}">
     <div class="alert alert-info">
        Data Deleted successfully!
     </div>
 	</div>
	<table id="example" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">

	    <thead>
	      <tr>
	      	<th width="10%">SL No.</th>
	      	<th>Category Type</th>
	        <th>Category Name</th>
	        <th>Description</th>
	        <th width="10%">Edit</th>
	        <th width="10%">Delete</th>
	      </tr>
	    </thead>
	    <tbody>
            <tr th:each = "categotybean, iterationStatus  : ${categotybeanlist}">
            	<td th:text="${iterationStatus.count}"></td>
            	<td th:text = "${categotybean.categoryTypeName}"></td>
                <td th:text = "${categotybean.categoryName}"></td>
                <td th:text = "${categotybean.categoryDesc}"></td>
                <td><a th:href="@{/master/editcategorymaster/{id}(id=${categotybean.categoryId})}" class="btn btn-info"><i class="glyphicon glyphicon-edit"></i></a></td>
	        	<td><a th:href="@{/master/deletecategorymaster/{id}(id=${categotybean.categoryId})}" class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></a></td>
			</tr>
        </tbody>
	  </table>

</div>
<br/>
<br/>
<div th:replace="fragments :: footer"/> 
</body>
 <script src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js"></script>
 <script src="https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js"></script>
 <script type="text/javascript">
	$(document).ready(function () {
	  $('#example').DataTable();
	  $('.dataTables_length').addClass('bs-select');
	});
</script>
</html>