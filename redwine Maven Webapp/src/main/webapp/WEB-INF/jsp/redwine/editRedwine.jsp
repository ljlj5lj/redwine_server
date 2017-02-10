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
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <title>修改红酒信息</title>
  
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
                           <span>修改${redwine.redwine_name }红酒信息</span>
                           <a href="${pageContext.request.contextPath}/redwine/listRedwine" class="label label-warning" style="float:right; margin:8px;">返回</a>
                           
                         </div>
                        <div class="well brown">
                         <form action="${pageContext.request.contextPath}/redwine/editRedwine" method="post">
                      		<div class="form_list"><label class="lable_title">红酒类型</label>
                         		<select style="width:150px;margin-left:15px;" name="redwine_type_id">
                              		<option value="${r.redwine_type.redwine_type_id}" selected="${r.redwine_type.redwine_type_id}">${r.redwine_type.type_name}</option>
                              		<c:forEach items="${redwineTypeList}" var="redwineType">
                              			<c:if test="${r.redwine_type.redwine_type_id != redwineType.redwine_type_id}">
                              				<option value="${redwineType.redwine_type_id}">${redwineType.type_name }</option>
                              			</c:if>
                              		</c:forEach>
                            	</select>
                         	</div>
                         	<input type="hidden" name="redwine_id" value="${redwine.redwine_id }"/>  
                            <div class="form_list"><label class="lable_title">红酒名称</label><input class="form_input" type="text" name="redwine_name" value="${redwine.redwine_name }"/></div>
                            <div class="form_list"><label class="lable_title">红酒价格</label><input class="form_input" type="number" name="price" min="0" value="${redwine.price }"/></div>
                            <div class="form_list"><label class="lable_title">红酒来源</label><input class="form_input" type="text" name="origin" value="${redwine.origin }"/></div>
                            <div class="form_list"><label class="lable_title">酿造年份</label><input class="form_input" type="number" name="vintage" value="${redwine.vintage }"/></div>
                            <div class="form_list"><label class="lable_title">酒精度数</label><input class="form_input" type="number" name="alcohol" min="0" step="0.5" value="${redwine.alcohol }"/></div>
                            <div class="form_list"><label class="lable_title">红酒容量</label><input class="form_input" type="number" name="capacity" min="0" value="${redwine.capacity }"/></div>
                            <div class="form_list"><label class="lable_title">红酒销量</label><input class="form_input" type="number" name="sales" min="0" value="${redwine.sales }"/></div>
                            <div class="form_list"><label class="lable_title">红酒描述</label><input class="form_input" type="text" name="description"  value="${redwine.description }"/></div>
                            <div class="form_list"><label class="lable_title">红酒简介</label><textarea rows="10" class="form_input" name="introduction" cols="50"><c:out value="${redwine.introduction }" /></textarea></div>
                            <div class="form_list"><input type="submit" class="submit" value="&nbsp;&nbsp;修&nbsp;&nbsp;改&nbsp;&nbsp;"></div>
                         </form>   
                           
                          
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

