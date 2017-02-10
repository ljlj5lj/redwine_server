<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
    <title>导航页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

    

    <script>
    function getclassname(obj){
		if(document.getElementsByClassName('link_onclick').length==0){
			obj.className='link_onclick';
			obj.id='link_onclick';
			}else{
				var obj1=document.getElementById('link_onclick');
				obj1.className='111';
				obj1.id='1';
				obj.className='link_onclick';
			   obj.id='link_onclick';
			}
		}
	function logout() {
        if(window.confirm('您确定要退出吗？')) {
            top.location = 'login.jsp';
        }
    }  
    </script>
  </head>

  <body>

    <header class="dark_grey">
     <!-- Header start -->
       <div class="top">
    <div class="logo">
    <img src="image/logo.png" />
    </div>
     <div class="login">
    <img src="image/login.png"  onclick="logout();"/>
    </div>
    
    <div class="username">
      	欢迎您,${sessionScope.admin_name }
    </div>
    <div class="user">
    <img src="image/user.png" />
    </div>
   

</div>
       
    </header>

    <div id="main_navigation" class="dark_navigation"> <!-- Main navigation start -->
        <div class="inner_navigation" >
            <ul class="main" >
                <li ><a class="expand"  href="dashboard.html"><i class="icon-signal"></i>&nbsp;&nbsp;进口红酒管理</a>
                    <ul class="sub_main" style="background-color: #20477C;">
                          <li><a href="${pageContext.request.contextPath}/redwine/listRedwine.action" target="right" onClick="getclassname(this)">所有红酒信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></a></li>
                          <li><a href="${pageContext.request.contextPath}/redwineType/listRedwineType.action" target="right" onClick="getclassname(this)">红酒类型管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></a></li>
                    </ul>
                </li>
                
                <li>
                	<a href="${pageContext.request.contextPath}/user/listUser.action" target="right" onClick="getclassname(this)"><i class="icon-reorder"></i>&nbsp;&nbsp;用户管理</a>
                </li>
                
                <li ><a class="expand"  href="dashboard.html"><i class="icon-tasks"></i>&nbsp;&nbsp;订单管理</a>
                    <ul class="sub_main" style="background-color: #20477C;">
                          <li><a href="${pageContext.request.contextPath}/orders/listOrders.action" target="right" onClick="getclassname(this)">所有订单信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;></a></li>
                    </ul>
                </li>
                
                <li>
                	<a href="${pageContext.request.contextPath}/evaluation/listEvaluation.action" target="right" onClick="getclassname(this)"><i class="icon-calendar"></i>&nbsp;&nbsp;评价管理</a>
                </li>
                
                <li>
                	<a href="${pageContext.request.contextPath}/address/listAddress.action" target="right" onClick="getclassname(this)"><i class="icon-home"></i>&nbsp;&nbsp;地址管理</a>
                </li>
                
                <li>
                	<a href="${pageContext.request.contextPath}/favorites/listFavorites.action" target="right" onClick="getclassname(this)"><i class="icon-table"></i>&nbsp;&nbsp;收藏管理</a>
                </li>
                
                <li>
                	<a href="${pageContext.request.contextPath}/user/chatting.action" target="right" onClick="getclassname(this)"><i class="icon-tasks"></i>&nbsp;&nbsp;在线咨询模块</a>
                </li>
                
            </ul>
        </div>
    </div>

    <div id="content" class="no-sidebar">
   		<iframe  class="inner_navigation1" name="right" src="" frameborder="0" width="100%"  height="100%"></iframe>    
    </div>

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/jquery-ui-1.10.3.js"></script>
    <script src="js/bootstrap.js"></script>

    <script src="js/library/jquery.collapsible.min.js"></script>
    <script src="js/library/jquery.mCustomScrollbar.min.js"></script>
    <script src="js/library/jquery.mousewheel.min.js"></script>
    <script src="js/library/jquery.uniform.min.js"></script>

    
    <script src="js/library/jquery.sparkline.min.js"></script>
    <script src="js/library/chosen.jquery.min.js"></script>
    <script src="js/library/jquery.easytabs.js"></script>
    <script src="js/library/flot/excanvas.min.js"></script>
    <script src="js/library/flot/jquery.flot.js"></script>
    <script src="js/library/flot/jquery.flot.pie.js"></script>
    <script src="js/library/flot/jquery.flot.selection.js"></script>
    <script src="js/library/flot/jquery.flot.resize.js"></script>
    <script src="js/library/flot/jquery.flot.orderBars.js"></script>
    <script src="js/library/maps/jquery.vmap.js"></script>
    <script src="js/library/maps/maps/jquery.vmap.world.js"></script>
    <script src="js/library/maps/data/jquery.vmap.sampledata.js"></script>
    <script src="js/library/jquery.autosize-min.js"></script>
    <script src="js/library/charCount.js"></script>
    <script src="js/library/jquery.minicolors.js"></script>
    <script src="js/library/jquery.tagsinput.js"></script>
    <script src="js/library/fullcalendar.min.js"></script>
    <script src="js/library/footable/footable.js"></script>
    <script src="js/library/footable/data-generator.js"></script>

    <script src="js/library/bootstrap-datetimepicker.js"></script>
    <script src="js/library/bootstrap-timepicker.js"></script>
    <script src="js/library/bootstrap-datepicker.js"></script>
    <script src="js/library/bootstrap-fileupload.js"></script>
    <script src="js/library/jquery.inputmask.bundle.js"></script>

    <script src="js/flatpoint_core.js"></script>

    <script>
        jQuery('#vmap').vectorMap({
            map:"world_en",
            backgroundColor:null,
            color:"#ffffff",
            hoverOpacity:.7,
            selectedColor:"#2d91ef",
            enableZoom:0,
            showTooltip:1,
            values:sample_data,
            scaleColors:["#8cc3f6","#5c86ac"],
            normalizeFunction:"polynomial",
            onRegionClick:function(){alert("This Region has "+(Math.floor(Math.random()*10)+1)+" users!"
            )}
        });

        jQuery(document).ready(function($) {
            $('.footable').footable();
            $('.responsive_table_container').mCustomScrollbar({
                set_height: 400,
                advanced:{
                  updateOnContentResize: true,
                  updateOnBrowserResize: true
                }
            });

            $('.responsive_table_container_2').mCustomScrollbar({
                set_height: 520,
                advanced:{
                  updateOnContentResize: true,
                  updateOnBrowserResize: true
                }
            });
        });
    </script>

    <script src="js/calendar.js"></script>
    <script src="js/forms.js"></script>
    <script src="js/dashboard.js"></script>
    
  </body>
</html>
