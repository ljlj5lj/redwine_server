<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
  	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>显示红酒信息</title>
  
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/stylesheet.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <link href="icon/font-awesome.css" rel="stylesheet">
    

    <!-- Le fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.html">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.html">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.html">
                    <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.html">
                                  

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->
    
  </head>

  <body>  
    <div id="content"> <!-- Content start -->
      <div class="inner_content">
          <div class="widgets_area">
                <div class="row-fluid">
                    <div class="span12">
                         <div  class="daohanglink" style="">
                           <span class="daohang"></span>
                           <span>首页</span><span>></span>
                           <span>进口红酒管理</span><span>></span>
                           <span><c:out value="${redwine.redwine_name}"/>红酒信息</span>
                           <a href="${pageContext.request.contextPath}/redwine/listRedwine" class="label label-warning" style="float:right; margin:8px;">返回</a>
                         </div>
                         <img src='<%=path%>${realpath}/${redwine.picture}'>
                        <div class="well brown">                          
                          <div class="form_list"><label class="lable_title">红酒名称 :&nbsp;</label><c:out value="${redwine.redwine_name}"/></div>
                          <div class="form_list"><label class="lable_title">红酒类型 :&nbsp;</label><c:out value="${redwine.redwine_type.type_name }"/></div>
                          <div class="form_list"><label class="lable_title">红酒价格 :&nbsp;</label>￥<c:out value="${redwine.price}"/></div>
                       	  <div class="form_list"><label class="lable_title">红酒来源 :&nbsp;</label><c:out value="${redwine.origin}"/></div>
                          <div class="form_list"><label class="lable_title">酿造年份 :&nbsp;</label><c:out value="${redwine.vintage}"/>年</div>
                          <div class="form_list"><label class="lable_title">酒精度数 :&nbsp;</label><c:out value="${redwine.alcohol}"/>%</div>
                          <div class="form_list"><label class="lable_title">红酒容量 :&nbsp;</label><c:out value="${redwine.capacity}"/>ml</div>
                          <div class="form_list"><label class="lable_title">红酒销量 :&nbsp;</label><c:out value="${redwine.sales}"/>支</div>
                          <div class="form_list"><label class="lable_title">红酒描述 :&nbsp;</label><c:out value="${redwine.description}"/></div>
                          <div class="form_list"><label class="lable_title">红酒简介 :&nbsp;</label><c:out value="${redwine.introduction}"/></div>
                        </div>
                    </div>
                </div>

            
            </div>
        </div>
    </div>

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
   <script src="js/jquery-1.10.2.js"></script>
    <script src="js/jquery-ui-1.10.3.js"></script>
    <script src="js/bootstrap.js"></script>

    <script src="js/flatpoint_core.js"></script>

  </body>
</html>

