<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
  	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>添加红酒信息</title>
  
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
                           <span>添加红酒</span>
                           <a href="${pageContext.request.contextPath}/redwine/listRedwine" class="label label-warning" style="float:right; margin:8px;">返回</a>
                           
                         </div>
                        <div class="well brown">
                        
                         <sf:form action="${pageContext.request.contextPath}/redwine/addRedwine" method="post" enctype="multipart/form-data" modelAttribute="redwine">
                         	<div class="form_list"><label class="lable_title">红酒类型</label>
                         		<select style="width:150px;margin-left:15px;" name="redwine_type_id">
                              		<option value="0">==请选择==</option>
                              		<c:forEach items="${redwineTypeList}" var="redwineType">
                              		<option value="${redwineType.redwine_type_id}">${redwineType.type_name }</option>
                              		</c:forEach>
                            	</select>
                         	</div>
                            <div class="form_list"><label class="lable_title">红酒名称</label><input class="form_input" type="text" name="redwine_name"/><sf:errors path="redwine_name" /></div>
                            <div class="form_list"><label class="lable_title">红酒图片</label><input class="form_input" type="file" name="file"/></div>
                            ${message}
                            <div class="form_list"><label class="lable_title">红酒价格</label><input class="form_input" type="number" name="price" min="0"/><sf:errors path="price" /></div>
                            <div class="form_list"><label class="lable_title">红酒来源</label><input class="form_input" type="text" name="origin"/><sf:errors path="origin" /></div>
                            <div class="form_list"><label class="lable_title">酿造年份</label><input class="form_input" type="number" name="vintage"/><sf:errors path="vintage" /></div>
                            <div class="form_list"><label class="lable_title">酒精度数</label><input class="form_input" type="number" name="alcohol" min="0" step="0.5"/><sf:errors path="alcohol" /></div>
                            <div class="form_list"><label class="lable_title">红酒容量</label><input class="form_input" type="number" name="capacity" min="0"/><sf:errors path="capacity" /></div>
                            <div class="form_list"><label class="lable_title">红酒销量</label><input class="form_input" type="number" name="sales" min="0"/><sf:errors path="sales" /></div>
                            <div class="form_list"><label class="lable_title">红酒描述</label><input class="form_input" type="text" name="description"/><sf:errors path="description" /></div>
                            <div class="form_list"><label class="lable_title">红酒简介</label><textarea rows="10" class="form_input" name="introduction" cols="50"></textarea><sf:errors path="introduction" /></div>
                            <div class="form_list"><input type="submit" class="submit" value="&nbsp;&nbsp;提&nbsp;&nbsp;交&nbsp;&nbsp;"></div>
                         </sf:form>   
                           
                          
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

