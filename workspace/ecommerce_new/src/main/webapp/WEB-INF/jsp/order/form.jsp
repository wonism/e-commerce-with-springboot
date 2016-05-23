<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<html>
<%@ include file="/common/header.jsp"%>
<style>
.top-buffer {
	margin-top: 20px;
}
</style>
<body>
  <div id="wrapper">
    <%@ include file="/common/menu.jsp"%>
    <form:form modelAttribute="order" method="post" id="order-form">
      <div id="page-wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h1 class="page-header">주문상세</h1>
          </div>
        </div>
        <div class="row">
          <div class="col-md-1">
            <label>주문자</label>
          </div>
          <div class="col-md-5">${order.user.username }</div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>상품</label>
          </div>
          <div class="col-md-5">
            <ul class="list-inline">
              <c:forEach var="orderProduct" items="${order.orderProducts }" varStatus="status">
                <li>
                  <div class="col-sm-12">
                    <img src="${orderProduct.product.imageUrl}" width="100" height="100" />
                  </div>
                  <div class="col-sm-12 top-buffer">
                    <label>${orderProduct.product.name }</label>
                  </div>
                </li>
              </c:forEach>
            </ul>
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>주문상태</label>
          </div>
          <div class="col-md-5">
            <form:select path="orderStatus" cssClass="form-control input-sm" style="width:150px;">
              <form:options items="${orderStatuses }" />
            </form:select>
          </div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>결제수단</label>
          </div>
          <div class="col-md-5">${order.payMethod }</div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>주문금액</label>
          </div>
          <div class="col-md-5">${order.orderPrice }원</div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>배송받을사람</label>
          </div>
          <div class="col-md-5">${order.recipientName }</div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>배송지전화</label>
          </div>
          <div class="col-md-5">${order.recipientTel }</div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>배송주소</label>
          </div>
          <div class="col-md-5">${order.deliveryAddress }</div>
        </div>
        <div class="row top-buffer">
          <div class="col-md-1">
            <label>주문일자</label>
          </div>
          <div class="col-md-5">${order.orderDate }</div>
        </div>

        <div class="row top-buffer">
          <div class="col-md-12">
            <div class="pull-left">
              <button type="submit" class="btn btn-primary btn-sm">Save</button>
              <a href="/admin/order/list" class="btn btn-default btn-sm">List</a>
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
            document.location.reload();
          } else {
            alert('저장실패:' + data.message);
          }

        }
      };
      $('#order-form').ajaxForm(options);
    </script>
</body>
</html>
