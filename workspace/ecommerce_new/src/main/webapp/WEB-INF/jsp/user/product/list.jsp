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
          <h1 class="page-header">상품 리스트</h1>
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
                  <th class="text-center">상품ID</th>
                  <th class="text-center">이미지</th>
                  <th class="text-center">상품명</th>
                  <th class="text-center">컬러</th>
                  <th class="text-center">가격</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="product" items="${page.content }" varStatus="status">
                  <tr class="odd gradeX">
                    <td class="text-center" style="vertical-align: middle;">${page.totalElements - (page.number * page.size + status.count - 1)}</td>
                    <td class="text-center" style="vertical-align: middle;"><a href="view?id=${product.id }">${product.id }</a></td>
                    <td class="text-center" style="vertical-align: middle;"><a href="view?id=${product.id }"><img src="${product.imageUrl }"
                      style="padding: 5px; width: 100px; margin-top: 10px; border: 1px solid #dddddd;" /></a></td>
                    <td class="text-center" style="vertical-align: middle;"><a href="view?id=${product.id }">${product.name }</a></td>
                    <td class="text-center" style="vertical-align: middle;">${product.color}</td>
                    <td class="text-center" style="vertical-align: middle;">${product.price }</td>
                  </tr>
                </c:forEach>

              </tbody>
            </table>
          </div>

        </div>
        <div class="col-md-12">
          <ui:pagination page="${page}" />
        </div>
        <div class="col-md-12">
          <div class="pull-right">
          </div>
        </div>
      </div>
    </div>
  </div>
  <%@ include file="/common/scripts.jsp"%>
</body>
</html>
