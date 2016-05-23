<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<html>
<%@ include file="/common/header.jsp"%>
<body>
  <div id="wrapper">
          <%@ include file="/common/usermenu.jsp"%>
  
  

  
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
            ${product.name }  
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>컬러</label>
          </div>
          <div class="col-md-5">
            ${product.color }
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>가격</label>
          </div>
          <div class="col-md-5">
            ${product.price }
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
          </div>

        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>설명</label>
          </div>
          <div class="col-md-5">
            ${product.description }
          </div>
        </div>
        
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>수량</label>
          </div>
          <div class="col-md-5">
            <input type="text" id="buyCount" cssClass="form-control input-sm" />
          </div>
        </div>
        
        <div class="row top-buffer">
          <div class="col-md-12">
            <div class="pull-left">
              <a href="list" class="btn btn-default btn-sm">List</a>
              <c:if test="${product.id ne null }">
                <a href="#" class="btn btn-danger btn-sm" id="delete-btn">장바구니에 담기</a>
                <a href="#" class="btn btn-danger btn-sm" id="order-btn">주문하기</a>
              </c:if>
             </div>
          </div>
        </div>
      </div>
  </div>
  


  
  <%@ include file="/common/scripts.jsp"%>

  <script>
  $('#delete-btn').on('click', function() {
	  var cnt = parseInt($('#buyCount').val());
	  
	  	  
      if (confirm('카트에 담으시겠어요?')) {
        $.ajax({
          url : '/user/cart/add',
          type : 'post',
          data : {
            id : '${product.id}',
            bcnt : cnt
          },
          dataType : 'json'
        }).done(function(data) {
          if (data.resultCode != '100') {
            alert(data.message);
            return false;
          }
          location.href = '/user/cart/list';
        });

      }
    });

  
  $('#order-btn').on('click', function() {
	  var cnt1 = parseInt($('#buyCount').val());
	  var orderPrice = parseFloat( '${product.price}' );
	  var productId = parseInt('${product.id}');

	  
      if (confirm('주문하시겠어요?')) {
    	  

    	  
    	  var totalObject = new Object();
    	  var orderArray = new Array();
    	  var orderObject = new Object();
    	  
    	  orderObject.productId = productId;
    	  orderObject.orderCount = cnt1;
    	  
    	  orderArray.push(orderObject);
    	  
    	  totalObject.recipientName = '${user.name}';
    	  totalObject.deliveryAddress =  '서울 경기도 강원도';
    	  totalObject.recipientTel = '01011111111';
    	  totalObject.orderPrice = orderPrice;
    	  totalObject.payMethod = 'CASH';
    	  totalObject.orderList = orderArray;
    	  
    	  
    	  $.ajax({
    		  			contentType:'application/json',
	 					type : "POST",
	 					url : "/user/order/add",
	 					cache : false,
	 					data : JSON.stringify(totalObject),
	 					dataType:"json",
	 					success : function(data) {
	 						alert("주문이 완료되었습니다.");
	 						location.href = '/user/order/list';
	 						
	 					},
	 					error : function(jqXHR, exception) {
	 						alert(jqXHR.status + " / " +exception);
	 					}
			});
    	  

    	  
    	  
    	  
        }
    });
  function onSuccess(json, status){alert($.trim(json));}
	
  </script>

</body>
</html>
