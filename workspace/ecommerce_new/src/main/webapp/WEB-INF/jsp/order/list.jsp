<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<html>
<%@ include file="/common/header.jsp"%>
<body>
  <div id="wrapper">
    <%@ include file="/common/menu.jsp"%>
    <div id="page-wrapper">
      <div class="row">
        <div class="col-lg-12">
          <h1 class="page-header">주문목록</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <i class="fa fa-dot-circle-o"> 검색결과 (${page.totalElements}건)</i>
        </div>
        <div class="col-md-12">
          <div class="table-responsive">
            <table class="table table-bordered table-hover table-condensed">
              <thead>
                <tr>
                  <th class="text-center">번호</th>
                  <th class="text-center">주문아이디</th>
                  <th class="text-center">상품</th>
                  <th class="text-center">상태</th>
                  <th class="text-center">결제수단</th>
                  <th class="text-center">가격</th>
                  <th class="text-center">주문자</th>
                  <th class="text-center">주문일</th>

                </tr>
              </thead>
              <tbody>
                <c:forEach var="order" items="${page.content }" varStatus="status">
                  <tr class="odd gradeX">
                    <td class="text-center">${page.totalElements - (page.number * page.size + status.count - 1)}</td>
                    <td class="text-center"><a href="view?id=${order.id }">${order.id }</a></td>
                    <td class="text-center">${order.orderProductNames }</td>
                    <td class="text-center">${order.orderStatus }</td>
                    <td class="text-center">${order.payMethod }</td>
                    <td class="text-center">${order.orderPrice}</td>
                    <td class="text-center">${order.user.username }</td>
                    <td class="text-center">${order.orderDate }</td>
                  </tr>
                </c:forEach>

              </tbody>
            </table>
          </div>

        </div>
        <div class="col-md-12">
          <ui:pagination page="${page}" />
        </div>
<!--         <div class="col-md-12"> -->
<!--           <div class="pull-right"> -->
<!--             <a href="/product/create" class="btn btn-primary btn-sm">Create</a> -->
<!--           </div> -->
<!--         </div> -->
      </div>
    </div>
  </div>
  <%@ include file="/common/scripts.jsp"%>
</body>
</html>
