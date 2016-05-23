<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0; background-color: black; min-height: 80px">
  <!-- 브랜드 -->
  <div class="row">
    <div class="col-md-4">
      <a href="/product/list" style="color: white;"><h3 style="margin-left: 30px;">커머스서비스</h3></a>
    </div>
    <div class="col-md-7" style="margin-top:20px;">
      <a href="/admin/logout" style="color: white;" class="pull-right" >로그아웃</a>
    </div>
    <div class="col-md-1">
    </div>
  </div>

  <!-- 좌측메뉴 -->
  <div class="navbar-default sidebar" role="navigation" >
    <div class="sidebar-nav navbar-collapse">
      <ul class="nav" id="side-menu">
        <li><a href="/admin/product/list"><i class="fa fa-dashboard fa-fw"></i> 상품관리</a></li>
        <li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 주문관리<span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li><a href="/admin/order/list">주문목록</a></li>
            <li><a href="/admin/order/cancel_list">주문취소목록</a></li>
          </ul></li>
      </ul>
    </div>
  </div>
</nav>