<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: abao--%>
  <%--Date: 2019-05-24--%>
  <%--Time: 14:20--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
         <%--pageEncoding="UTF-8"%>--%>
<%--<%@ page trimDirectiveWhitespaces="true"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%@ taglib prefix="abao" uri="http://subjectsystem.ftthzj.team/common/"%>--%>
<%--<%--%>
    <%--String path = request.getContextPath();--%>
    <%--String basePath = request.getScheme() + "://" + request.getServerName()--%>
            <%--+ ":" + request.getServerPort() + path + "/";--%>
<%--%>--%>
<%--<!DOCTYPE HTML>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <%--<title>选课网</title>--%>
    <%--<!-- 引入css样式文件 -->--%>
    <%--<!-- Bootstrap Core CSS -->--%>
    <%--<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" />--%>
    <%--<!-- MetisMenu CSS -->--%>
    <%--<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet" />--%>
    <%--<!-- DataTables CSS -->--%>
    <%--<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet" />--%>
    <%--<!-- Custom CSS -->--%>
    <%--<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet" />--%>
    <%--<!-- Custom Fonts -->--%>
    <%--<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet" type="text/css" />--%>
    <%--<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet" type="text/css" />--%>
<%--</head>--%>
<%--<body>--%>
<%--<div id="wrapper">--%>
    <%--<!-- 导航栏部分 -->--%>
    <%--<nav class="navbar navbar-default navbar-static-top" role="navigation"--%>
         <%--style="margin-bottom: 0">--%>
        <%--<div class="navbar-header">--%>
            <%--<a class="navbar-brand" href="<%=basePath%>homepage/list.action">选课网</a>--%>
        <%--</div>--%>
        <%--<!-- 导航栏右侧图标部分 -->--%>
        <%--<ul class="nav navbar-top-links navbar-right">--%>
            <%--<!-- 邮件通知 start -->--%>
            <%--<li class="dropdown">--%>
                <%--<a class="dropdown-toggle" data-toggle="dropdown" href="#">--%>
                    <%--<i class="fa fa-envelope fa-fw"></i>--%>
                    <%--<i class="fa fa-caret-down"></i>--%>
                <%--</a>--%>
                <%--<ul class="dropdown-menu dropdown-messages">--%>
                    <%--<li>--%>
                        <%--<a href="#">--%>
                            <%--<div>--%>
                                <%--<strong>张经理</strong> <span class="pull-right text-muted">--%>
								<%--<em>昨天</em>--%>
							<%--</span>--%>
                            <%--</div>--%>
                            <%--<div>今天晚上开会，讨论一下下个月工作的事...</div>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="divider"></li>--%>
                    <%--<li>--%>
                        <%--<a class="text-center" href="#">--%>
                            <%--<strong>查看全部消息</strong>--%>
                            <%--<i class="fa fa-angle-right"></i>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<!-- 邮件通知 end -->--%>
            <%--<!-- 任务通知 start -->--%>
            <%--<li class="dropdown">--%>
                <%--<a class="dropdown-toggle" data-toggle="dropdown" href="#">--%>
                    <%--<i class="fa fa-tasks fa-fw"></i>--%>
                    <%--<i class="fa fa-caret-down"></i>--%>
                <%--</a>--%>
                <%--<ul class="dropdown-menu dropdown-tasks">--%>
                    <%--<li>--%>
                        <%--<a href="#">--%>
                            <%--<div>--%>
                                <%--<p>--%>
                                    <%--<strong>任务 1</strong>--%>
                                    <%--<span class="pull-right text-muted">完成40%</span>--%>
                                <%--</p>--%>
                                <%--<div class="progress progress-striped active">--%>
                                    <%--<div class="progress-bar progress-bar-success"--%>
                                         <%--role="progressbar" aria-valuenow="40" aria-valuemin="0"--%>
                                         <%--aria-valuemax="100" style="width: 40%">--%>
                                        <%--<span class="sr-only">完成40%</span>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="divider"></li>--%>
                    <%--<li>--%>
                        <%--<a href="#">--%>
                            <%--<div>--%>
                                <%--<p>--%>
                                    <%--<strong>任务 2</strong>--%>
                                    <%--<span class="pull-right text-muted">完成20%</span>--%>
                                <%--</p>--%>
                                <%--<div class="progress progress-striped active">--%>
                                    <%--<div class="progress-bar progress-bar-info" role="progressbar"--%>
                                         <%--aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"--%>
                                         <%--style="width: 20%">--%>
                                        <%--<span class="sr-only">完成20%</span>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="divider"></li>--%>
                    <%--<li>--%>
                        <%--<a class="text-center" href="#">--%>
                            <%--<strong>查看所有任务</strong>--%>
                            <%--<i class="fa fa-angle-right"></i>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<!-- 任务通知 end -->--%>
            <%--<!-- 消息通知 start -->--%>
            <%--<li class="dropdown">--%>
                <%--<a class="dropdown-toggle" data-toggle="dropdown" href="#">--%>
                    <%--<i class="fa fa-bell fa-fw"></i>--%>
                    <%--<i class="fa fa-caret-down"></i>--%>
                <%--</a>--%>
                <%--<ul class="dropdown-menu dropdown-alerts">--%>
                    <%--<li>--%>
                        <%--<a href="#">--%>
                            <%--<div>--%>
                                <%--<i class="fa fa-comment fa-fw"></i> 新回复--%>
                                <%--<span class="pull-right text-muted small">4分钟之前</span>--%>
                            <%--</div>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="divider"></li>--%>
                    <%--<li>--%>
                        <%--<a href="#">--%>
                            <%--<div>--%>
                                <%--<i class="fa fa-envelope fa-fw"></i> 新消息--%>
                                <%--<span class="pull-right text-muted small">4分钟之前</span>--%>
                            <%--</div>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="divider"></li>--%>
                    <%--<li>--%>
                        <%--<a href="#">--%>
                            <%--<div>--%>
                                <%--<i class="fa fa-tasks fa-fw"></i> 新任务--%>
                                <%--<span class="pull-right text-muted small">4分钟之前</span>--%>
                            <%--</div>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="divider"></li>--%>
                    <%--<li>--%>
                        <%--<a href="#">--%>
                            <%--<div>--%>
                                <%--<i class="fa fa-upload fa-fw"></i> 服务器重启--%>
                                <%--<span class="pull-right text-muted small">4分钟之前</span>--%>
                            <%--</div>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li class="divider"></li>--%>
                    <%--<li>--%>
                        <%--<a class="text-center" href="#">--%>
                            <%--<strong>查看所有提醒</strong>--%>
                            <%--<i class="fa fa-angle-right"></i>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<!-- 消息通知 end -->--%>
            <%--<!-- 用户信息和系统设置 start -->--%>
            <%--<li class="dropdown">--%>
                <%--<a class="dropdown-toggle" data-toggle="dropdown" href="#">--%>
                    <%--<i class="fa fa-user fa-fw"></i>--%>
                    <%--<i class="fa fa-caret-down"></i>--%>
                <%--</a>--%>
                <%--<ul class="dropdown-menu dropdown-user">--%>
                    <%--<li><a href="#"><i class="fa fa-user fa-fw"></i>--%>
                        <%--用户：${STU_SESSION.name}--%>
                    <%--</a>--%>
                    <%--</li>--%>
                    <%--<li><a href="#"><i class="fa fa-gear fa-fw"></i> 系统设置</a></li>--%>
                    <%--<li class="divider"></li>--%>
                    <%--<li>--%>
                        <%--<a href="${pageContext.request.contextPath }/logout.action">--%>
                            <%--<i class="fa fa-sign-out fa-fw"></i>退出登录--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<!-- 用户信息和系统设置结束 -->--%>
        <%--</ul>--%>
        <%--<!-- 左侧显示列表部分 start-->--%>
        <%--<div class="navbar-default sidebar" role="navigation">--%>
            <%--<div class="sidebar-nav navbar-collapse">--%>
                <%--<ul class="nav" id="side-menu">--%>
                    <%--<li class="sidebar-search">--%>
                        <%--<div class="input-group custom-search-form">--%>
                            <%--<input type="text" class="form-control" placeholder="查询内容...">--%>
                            <%--<span class="input-group-btn">--%>
							<%--<button class="btn btn-default" type="button">--%>
								<%--<i class="fa fa-search" style="padding: 3px 0 3px 0;"></i>--%>
							<%--</button>--%>
						<%--</span>--%>
                        <%--</div>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="${pageContext.request.contextPath }/homepage/list.action" class="active">--%>
                            <%--<i class="fa fa-edit fa-fw"></i> 课程管理--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="#">--%>
                            <%--<i class="fa fa-dashboard fa-fw" ></i> 查看课表--%>
                        <%--</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<!-- 左侧显示列表部分 end-->--%>
    <%--</nav>--%>
    <%--<!-- 课程列表查询部分  start-->--%>
    <%--<div id="page-wrapper">--%>
        <%--<div class="row">--%>
            <%--<div class="col-lg-12">--%>
                <%--<h1 class="page-header">公告栏</h1>--%>
            <%--</div>--%>
            <%--<!-- /.col-lg-12 -->--%>
        <%--</div>--%>
        <%--<!-- /.row -->--%>
        <%--<div class="panel panel-default">--%>
            <%--<div class="panel-body">、--%>
                <%--<form class="form-inline" method="get"--%>
                      <%--action="${pageContext.request.contextPath }/homepage/list.action">--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="homepageName">公告标题</label>--%>
                        <%--<input type="text" class="form-control" id="homepageName"--%>
                               <%--value="${custName }" name="custName" />--%>
                    <%--</div>--%>
                    <%--<button type="submit" class="btn btn-primary">查询</button>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<a href="#" class="btn btn-primary" data-toggle="modal"--%>
           <%--data-target="#newhomepageDialog" onclick="clearhomepage()">新建</a>--%>
        <%--<div class="row">--%>
            <%--<div class="col-lg-12">--%>
                <%--<div class="panel panel-default">--%>
                    <%--<div class="panel-heading">公告信息列表</div>--%>
                    <%--<!-- /.panel-heading -->--%>
                    <%--<table class="table table-bordered table-striped">--%>
                        <%--<thead>--%>
                        <%--<tr>--%>
                            <%--<th>编号</th>--%>
                            <%--<th>标题</th>--%>
                            <%--<th>发布时间</th>--%>
                        <%--</tr>--%>
                        <%--</thead>--%>
                        <%--<tbody>--%>
                        <%--<c:forEach items="${page.rows}" var="row">--%>
                            <%--<tr>--%>
                                <%--<td>${row.cust_id}</td>--%>
                                <%--<td>${row.cust_name}</td>--%>
                                <%--<td>${row.cust_source}</td>--%>
                                <%--<td>--%>
                                    <%--<a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#homepageEditDialog" onclick= "edithomepage(${row.cust_id})">修改</a>--%>
                                    <%--<a href="#" class="btn btn-danger btn-xs" onclick="deletehomepage(${row.cust_id})">删除</a>--%>
                                <%--</td>--%>
                            <%--</tr>--%>
                        <%--</c:forEach>--%>
                        <%--</tbody>--%>
                    <%--</table>--%>
                    <%--<div class="col-md-12 text-right">--%>
                        <%--<abao:page url="${pageContext.request.contextPath }/homepage/list.action" />--%>
                    <%--</div>--%>
                    <%--<!-- /.panel-body -->--%>
                <%--</div>--%>
                <%--<!-- /.panel -->--%>
            <%--</div>--%>
            <%--<!-- /.col-lg-12 -->--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<!-- 课程列表查询部分  end-->--%>
<%--</div>--%>
<%--<!-- 创建课程模态框 -->--%>
<%--<div class="modal fade" id="newhomepageDialog" tabindex="-1" role="dialog"--%>
     <%--aria-labelledby="myModalLabel">--%>
    <%--<div class="modal-dialog" role="document">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                    <%--<span aria-hidden="true">&times;</span>--%>
                <%--</button>--%>
                <%--<h4 class="modal-title" id="myModalLabel">新建课程信息</h4>--%>
            <%--</div>--%>
            <%--<div class="modal-body">--%>
                <%--<form class="form-horizontal" id="new_homepage_form">--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="new_homepageName" class="col-sm-2 control-label">--%>
                            <%--课程名称--%>
                        <%--</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<input type="text" class="form-control" id="new_homepageName" placeholder="课程名称" name="cust_name" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="new_homepageFrom" style="float:left;padding:7px 15px 0 27px;">课程来源</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<select	class="form-control" id="new_homepageFrom" name="cust_source">--%>
                                <%--<option value="">--请选择--</option>--%>
                                <%--<c:forEach items="${fromType}" var="item">--%>
                                    <%--<option value="${item.dict_id}"<c:if test="${item.dict_id == custSource}">selected</c:if>>--%>
                                            <%--${item.dict_item_name }--%>
                                    <%--</option>--%>
                                <%--</c:forEach>--%>
                            <%--</select>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="new_custIndustry" style="float:left;padding:7px 15px 0 27px;">所属行业</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<select	class="form-control" id="new_custIndustry"  name="cust_industry">--%>
                                <%--<option value="">--请选择--</option>--%>
                                <%--<c:forEach items="${industryType}" var="item">--%>
                                    <%--<option value="${item.dict_id}"<c:if test="${item.dict_id == custIndustry}"> selected</c:if>>--%>
                                            <%--${item.dict_item_name }--%>
                                    <%--</option>--%>
                                <%--</c:forEach>--%>
                            <%--</select>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="new_custLevel" style="float:left;padding:7px 15px 0 27px;">课程级别</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<select	class="form-control" id="new_custLevel" name="cust_level">--%>
                                <%--<option value="">--请选择--</option>--%>
                                <%--<c:forEach items="${levelType}" var="item">--%>
                                    <%--<option value="${item.dict_id}"<c:if test="${item.dict_id == custLevel}"> selected</c:if>>${item.dict_item_name }</option>--%>
                                <%--</c:forEach>--%>
                            <%--</select>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="new_linkMan" class="col-sm-2 control-label">联系人</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<input type="text" class="form-control" id="new_linkMan" placeholder="联系人" name="cust_linkman" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="new_phone" class="col-sm-2 control-label">固定电话</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<input type="text" class="form-control" id="new_phone" placeholder="固定电话" name="cust_phone" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="new_mobile" class="col-sm-2 control-label">移动电话</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<input type="text" class="form-control" id="new_mobile" placeholder="移动电话" name="cust_mobile" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="new_zipcode" class="col-sm-2 control-label">邮政编码</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<input type="text" class="form-control" id="new_zipcode" placeholder="邮政编码" name="cust_zipcode" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="new_address" class="col-sm-2 control-label">联系地址</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<input type="text" class="form-control" id="new_address" placeholder="联系地址" name="cust_address" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
            <%--<div class="modal-footer">--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
                <%--<button type="button" class="btn btn-primary" onclick="createhomepage()">创建课程</button>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<!-- 修改课程模态框 -->--%>
<%--<div class="modal fade" id="homepageEditDialog" tabindex="-1" role="dialog"--%>
     <%--aria-labelledby="myModalLabel">--%>
    <%--<div class="modal-dialog" role="document">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                    <%--<span aria-hidden="true">&times;</span>--%>
                <%--</button>--%>
                <%--<h4 class="modal-title" id="myModalLabel">修改课程信息</h4>--%>
            <%--</div>--%>
            <%--<div class="modal-body">--%>
                <%--<form class="form-horizontal" id="edit_homepage_form">--%>
                    <%--<input type="hidden" id="edit_cust_id" name="cust_id"/>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="edit_homepageName" class="col-sm-2 control-label">课程名称</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<input type="text" class="form-control" id="edit_homepageName" placeholder="课程名称" name="cust_name" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="edit_homepageFrom" style="float:left;padding:7px 15px 0 27px;">课程来源</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<select	class="form-control" id="edit_homepageFrom" name="cust_source">--%>
                                <%--<option value="">--请选择--</option>--%>
                                <%--<c:forEach items="${fromType}" var="item">--%>
                                    <%--<option value="${item.dict_id}"<c:if test="${item.dict_id == custSource}"> selected</c:if>>${item.dict_item_name }</option>--%>
                                <%--</c:forEach>--%>
                            <%--</select>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="edit_custIndustry" style="float:left;padding:7px 15px 0 27px;">所属行业</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<select	class="form-control" id="edit_custIndustry"  name="cust_industry">--%>
                                <%--<option value="">--请选择--</option>--%>
                                <%--<c:forEach items="${industryType}" var="item">--%>
                                    <%--<option value="${item.dict_id}"<c:if test="${item.dict_id == custIndustry}"> selected</c:if>>${item.dict_item_name }</option>--%>
                                <%--</c:forEach>--%>
                            <%--</select>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="edit_custLevel" style="float:left;padding:7px 15px 0 27px;">课程级别</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<select	class="form-control" id="edit_custLevel" name="cust_level">--%>
                                <%--<option value="">--请选择--</option>--%>
                                <%--<c:forEach items="${levelType}" var="item">--%>
                                    <%--<option value="${item.dict_id}"<c:if test="${item.dict_id == custLevel}"> selected</c:if>>${item.dict_item_name }</option>--%>
                                <%--</c:forEach>--%>
                            <%--</select>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="edit_linkMan" class="col-sm-2 control-label">联系人</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<input type="text" class="form-control" id="edit_linkMan" placeholder="联系人" name="cust_linkman" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="edit_phone" class="col-sm-2 control-label">固定电话</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<input type="text" class="form-control" id="edit_phone" placeholder="固定电话" name="cust_phone" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="edit_mobile" class="col-sm-2 control-label">移动电话</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<input type="text" class="form-control" id="edit_mobile" placeholder="移动电话" name="cust_mobile" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="edit_zipcode" class="col-sm-2 control-label">邮政编码</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<input type="text" class="form-control" id="edit_zipcode" placeholder="邮政编码" name="cust_zipcode" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="edit_address" class="col-sm-2 control-label">联系地址</label>--%>
                        <%--<div class="col-sm-10">--%>
                            <%--<input type="text" class="form-control" id="edit_address" placeholder="联系地址" name="cust_address" />--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
            <%--<div class="modal-footer">--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
                <%--<button type="button" class="btn btn-primary" onclick="updatehomepage()">保存修改</button>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<!-- 引入js文件 -->--%>
<%--<!-- jQuery -->--%>
<%--<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>--%>
<%--<!-- Bootstrap Core JavaScript -->--%>
<%--<script src="<%=basePath%>js/bootstrap.min.js"></script>--%>
<%--<!-- Metis Menu Plugin JavaScript -->--%>
<%--<script src="<%=basePath%>js/metisMenu.min.js"></script>--%>
<%--<!-- DataTables JavaScript -->--%>
<%--<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>--%>
<%--<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>--%>
<%--<!-- Custom Theme JavaScript -->--%>
<%--<script src="<%=basePath%>js/sb-admin-2.js"></script>--%>
<%--<!-- 编写js代码 -->--%>
<%--<script type="text/javascript">--%>
    <%--//清空新建课程窗口中的数据--%>
    <%--function clearhomepage() {--%>
        <%--$("#new_homepageName").val("");--%>
        <%--$("#new_homepageFrom").val("")--%>
        <%--$("#new_custIndustry").val("")--%>
        <%--$("#new_custLevel").val("")--%>
        <%--$("#new_linkMan").val("");--%>
        <%--$("#new_phone").val("");--%>
        <%--$("#new_mobile").val("");--%>
        <%--$("#new_zipcode").val("");--%>
        <%--$("#new_address").val("");--%>
    <%--}--%>
    <%--// 创建课程--%>
    <%--function createhomepage() {--%>
        <%--$.post("<%=basePath%>homepage/create.action",--%>
            <%--$("#new_homepage_form").serialize(),function(data){--%>
                <%--if(data =="OK"){--%>
                    <%--alert("课程创建成功！");--%>
                    <%--window.location.reload();--%>
                <%--}else{--%>
                    <%--alert("课程创建失败！");--%>
                    <%--window.location.reload();--%>
                <%--}--%>
            <%--});--%>
    <%--}--%>
    <%--// 通过id获取修改的课程信息--%>
    <%--function edithomepage(id) {--%>
        <%--$.ajax({--%>
            <%--type:"get",--%>
            <%--url:"<%=basePath%>homepage/gethomepageById.action",--%>
            <%--data:{"id":id},--%>
            <%--success:function(data) {--%>
                <%--$("#edit_cust_id").val(data.cust_id);--%>
                <%--$("#edit_homepageName").val(data.cust_name);--%>
                <%--$("#edit_homepageFrom").val(data.cust_source)--%>
                <%--$("#edit_custIndustry").val(data.cust_industry)--%>
                <%--$("#edit_custLevel").val(data.cust_level)--%>
                <%--$("#edit_linkMan").val(data.cust_linkman);--%>
                <%--$("#edit_phone").val(data.cust_phone);--%>
                <%--$("#edit_mobile").val(data.cust_mobile);--%>
                <%--$("#edit_zipcode").val(data.cust_zipcode);--%>
                <%--$("#edit_address").val(data.cust_address);--%>

            <%--}--%>
        <%--});--%>
    <%--}--%>
    <%--// 执行修改课程操作--%>
    <%--function updatehomepage() {--%>
        <%--$.post("<%=basePath%>homepage/update.action",$("#edit_homepage_form").serialize(),function(data){--%>
            <%--if(data =="OK"){--%>
                <%--alert("课程信息更新成功！");--%>
                <%--window.location.reload();--%>
            <%--}else{--%>
                <%--alert("课程信息更新失败！");--%>
                <%--window.location.reload();--%>
            <%--}--%>
        <%--});--%>
    <%--}--%>
    <%--// 删除课程--%>
    <%--function deletehomepage(id) {--%>
        <%--if(confirm('确实要删除该课程吗?')) {--%>
            <%--$.post("<%=basePath%>homepage/delete.action",{"id":id},--%>
                <%--function(data){--%>
                    <%--if(data =="OK"){--%>
                        <%--alert("课程删除成功！");--%>
                        <%--window.location.reload();--%>
                    <%--}else{--%>
                        <%--alert("删除课程失败！");--%>
                        <%--window.location.reload();--%>
                    <%--}--%>
                <%--});--%>
        <%--}--%>
    <%--}--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>
