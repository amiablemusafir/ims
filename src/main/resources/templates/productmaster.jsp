<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head th:replace="fragments :: html_head"/>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css">
<body>
<div th:replace="fragments :: header_menu"/>  
<div class="container bg-light">
  <h3>Product Master</h3>
  <p>Use this form to Create, Modify or Delete Product Master.</p>
  <div class="rounded">
  <div th:if="${param.success}">
     <div class="alert alert-info">
        Data save successfully!
     </div>
  </div>
  <form method="post" role="form" th:action="@{/master/saveproductmaster}" th:object="${productmasterbean}" class="was-validated">
  <input type="hidden" th:field="*{productId}" name="productId" id="productId"/>
  <div class="form-group">
    <label class="control-label col-sm-2" for="categorytype">Category Type:<span style="color: red">*</span></label>
    <div class="col-sm-3">
    
        <select class="form-control" th:field="*{categoryTypeId}" name="categoryTypeId" id="categoryTypeId">
		    <option value="">- Select -</option>
            <option th:each="option : ${categotytypebeanlist}"
                    th:text="${option.categoryTypeName}"
                    th:value="${option.categotyTypeId}"></option>
        </select>		
      	<p th:if="${#fields.hasErrors('categoryTypeId')}" th:errors="*{categoryTypeId}" class="text-danger"></p>
    </div>
    <label class="control-label col-sm-3" for="categoryname">Category Name:<span style="color: red">*</span></label>
    <div class="col-sm-3">
      	 <select class="form-control" th:field="*{categoryId}" name="categoryId" id="categoryId">
		    <option value="0">- Select -</option>
            <option th:each="option : ${categotybeanlist}"
                    th:text="${option.categoryName}"
                    th:value="${option.categoryId}"></option>
        </select>		
      	<p th:if="${#fields.hasErrors('categoryId')}" th:errors="*{categoryId}" class="text-danger"></p>
    </div>
  </div>

  <div class="form-group"> <label class="col">&nbsp;</label></div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="productname">Product Name :</label>
    <div class="col-sm-3">
      	<input type="text" class="form-control" th:field="*{productName}" name="productName" id="productName" placeholder="Enter Product Name">
    </div>
    <label class="control-label col-sm-3" for="barcode">Barcode :</label>
    <div class="col-sm-3">
   		<input type="text" class="form-control" th:field="*{barcode}" name="barcode" id="barcode" placeholder="Enter Barcode">
   </div>
   <button type="button" class="btn btn-info btn-sm mb-2">Generate</button>
  </div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="batchno">Batch No :</label>
    <div class="col-sm-3">
      	<input type="text" class="form-control" th:field="*{batchNo}" name="batchNo" id="batchNo" placeholder="Enter Batch No">
    </div>
    <label class="control-label col-sm-3" for="price">MRP :</label>
    <div class="col-sm-3">
   		<input type="number" class="form-control" th:field="*{price}" name="price" id="price" placeholder="Enter Price">
   </div>
  </div> 
  <div class="form-group"> <label class="col">&nbsp;</label></div>
   <div class="form-group">
   	 <label class="control-label col-sm-2" for="mfgdate">MFG Date :</label>
    
     <div class="col-sm-3">
  	 <div id="mfgdatediv" class="input-group date" data-date-format="mm-dd-yyyy">
         <input type="text" class="form-control" th:field="*{mfgDate}" name="mfgDate" id="mfgDate" placeholder="Enter MFG Date" readonly="readonly">
         <span class="input-group-addon">
            <i class="glyphicon glyphicon-calendar"></i>
         </span>
     </div>     	
    </div>
    <label class="control-label col-sm-3" for="expdate">EXP Date :</label>
    <div class="col-sm-3">
     <div id="expdatediv" class="input-group date" data-date-format="mm-dd-yyyy">
         <input type="text" class="form-control" th:field="*{expDate}" name="expDate" id="expDate" placeholder="Enter EXP Date" readonly="readonly">
         <span class="input-group-addon">
            <i class="glyphicon glyphicon-calendar"></i>
         </span>
     </div>   		
   </div>
  </div> 
  <div class="form-group"> <label class="col">&nbsp;</label></div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="stock">Stock :</label>
    <div class="col-sm-3">
      	<input type="number" class="form-control" th:field="*{stock}" name="stock" id="stock" placeholder="Enter Stock Quantity">
    </div>
    <label class="control-label col-sm-3" for="desc">Description :</label>
    <div class="col-sm-3">
   		<input type="text" class="form-control" th:field="*{productDesc}" name="productDesc" id="productDesc" placeholder="Enter Description">
   </div>
  </div> 
         
  <div class="form-group"> <label class="col">&nbsp;</label></div>
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
	        <th>Product Name</th>
	        <th>Description</th>
	        <th width="10%">Edit</th>
	        <th width="10%">Delete</th>
	      </tr>
	    </thead>
	    <tbody>
            <tr th:each = "productbean, iterationStatus  : ${productmasterbeanlist}">
            	<td th:text="${iterationStatus.count}"></td>
            	<td th:text = "${productbean.categoryTypeName}"></td>
                <td th:text = "${productbean.categoryName}"></td>
                <td th:text = "${productbean.productName}"></td>
                <td th:text = "${productbean.productDesc}"></td>
                <td><a th:href="@{/master/editproductmaster/{id}(id=${productbean.productId})}" class="btn btn-info"><i class="glyphicon glyphicon-edit"></i></a></td>
	        	<td><a th:href="@{/master/deleteproductmaster/{id}(id=${productbean.productId})}" class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></a></td>
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
	  $("#mfgdate").datepicker({ 
	      autoclose: true, 
	      todayHighlight: true,
	  }).datepicker('update', new Date());
	  $("#expdate").datepicker({ 
	      autoclose: true, 
	      todayHighlight: true,
	  }).datepicker('update', new Date());
	  $('#example').DataTable();
	  $('.dataTables_length').addClass('bs-select');
	});
	
</script>
</html>