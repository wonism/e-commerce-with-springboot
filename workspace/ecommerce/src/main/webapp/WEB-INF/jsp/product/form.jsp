<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<html>
<%@ include file="/common/header.jsp"%>
<body>
  <div id="wrapper">
    <%@ include file="/common/menu.jsp"%>
    <form:form modelAttribute="product" method="post" id="product-form" enctype="multipart/form-data">
      <div id="page-wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h1 class="page-header">상품</h1>
          </div>
        </div>
        <div class="row">
          <div class="col-md-1">
            <label>상품명</label>
          </div>
          <div class="col-md-5">
            <form:input path="name" cssClass="form-control input-sm" />
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>컬러</label>
          </div>
          <div class="col-md-5">
            <form:input path="color" cssClass="form-control input-sm" />
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>가격</label>
          </div>
          <div class="col-md-5">
            <form:input path="price" cssClass="form-control input-sm" />
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>이미지</label>
          </div>
          <div class="col-md-5">
          <c:if test="${not empty product.imageUrl }">
            <img src="${product.imageUrl }" style="padding: 5px; width: 100px; margin-top: 10px; border: 1px solid #dddddd;"> <br>
          </c:if>
            <input type="file" name="imageFile" />
          </div>

        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>설명</label>
          </div>
          <div class="col-md-5">
            <form:textarea path="description" cssClass="form-control input-sm" rows="5" />
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-12">
            <div class="pull-left">
              <button type="submit" class="btn btn-primary btn-sm">Save</button>
              <a href="list" class="btn btn-default btn-sm">List</a>
              <c:if test="${product.id ne null }">
                <a href="#" class="btn btn-danger btn-sm" id="delete-btn">Delete</a>
              </c:if>
            </div>
          </div>
        </div>
      </div>
    </form:form>
  </div>
  <%@ include file="/common/scripts.jsp"%>

  <script>
      var options = {
        url : 'save',
        type : 'post',
        dataType : 'json',
        clearForm : false,
        success : function(data) {
          if (data.resultCode == '100') {
            alert('Saved');
            location.href = 'list';
          } else {
            alert('저장실패:' + data.message);
          }

        }
      };
      $('#product-form').ajaxForm(options);

      $('#delete-btn').on('click', function() {
        if (confirm('정말 삭제하시겠습니까?')) {
          $.ajax({
            url : 'delete',
            type : 'post',
            data : {
              id : '${product.id}'
            },
            dataType : 'json'
          }).done(function(data) {
            if (data.resultCode != '100') {
              alert(data.message);
              return false;
            }
            location.href = 'list';
          });

        }
      });
    </script>
</body>
</html>
