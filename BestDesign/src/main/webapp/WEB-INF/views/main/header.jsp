<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%
   String userID = null;
   if(session.getAttribute("userID") != null){
   	userID = (String)session.getAttribute("userID");// 겟 세션은 Object 를 리턴
   }
   String type = null;
   if(session.getAttribute("type") != null){
   	type = (String)session.getAttribute("type");//
   	//type = type.trim();
   }
   System.out.println("내 타입 바뀌지마 " + type);
%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Home - Tyche Demo</title>

<!-- ************************************************************************************************************* -->


<style>
	#masthead {
		background:#fff;
	}

	.sf-menu>li>a {
		color: black;
	}
	.search-top-bar-submit{
		top: 5px;
	}
	html body .top-header-bar-container .top-header-bar .top-account{
		float: right;
	}
	html body .top-header-bar-container .top-header-bar .top-search{
		float: left;
	}
</style>

	<script>
			function getUnread(){
				$.ajax({
					type:"post",
					url:"../chat/unReadChat.do",
					data:{userID : '<%=userID%>'},
					success:function(result){
						let data = result.trim();
						console.log(data);
						if(data>=1){
							console.log("존재")
							showUnread(data);
						}else{							
							console.log("없음")
							showUnread("");
						}
					}
				})
			}
			function getInfiniteUnread(){
				console.log("인피니트");
				setInterval(function(){
					getUnread();
				}, 4000);
			}
			function showUnread(result){
				$("#unread").html(result);
			}
	</script>
<!-- ************************************************************************************************************* -->
</head>
<body class="home page-template-default page page-id-2 wp-custom-logo theme-tyche woocommerce-no-js elementor-default elementor-kit-1236">

<header class="top-header-bar-container">
<div class="container">
<div class="row">
<div class="col-md-12">
<ul class="top-header-bar">



<%
	if(userID == null){
%>
<li class="top-account">
<a href="../chat/login.do"><i class="fa fa-user"></i> 로그인 </a>
</li>
<%
	}else{
%>
<li class="top-account">
<a href="../chat/logout.do"><i class="fa fa-user"></i> 로그아웃 </a>
</li>

<% if(type=="관리자"){%>

<li class="top-account">
<a href="../manager/manager.do"><i class="fa fa-user"></i> 관리자 </a>
</li>

<%} else{%>
<li class="top-search">

<form role="search" method="post" class="pull-right" id="searchform_topbar" action="../chat/find.do">
<label>
<span class="screen-reader-text"></span>
<input class="search-field-top-bar" id="search-field-top-bar" placeholder="대화할 유저 검색.." value="" id="toId" name="toId" type="search">
</label>
<button id="search-top-bar-submit" type="submit" class="search-top-bar-submit">
<span class="fa fa-search"></span>
</button>
</form>
</li>
<li class="top-account">
<a href="../chat/box.do"><i class="fa fa-envelope"></i> 메시지 함 <span id="unread" class="label label-info"></span></a>
</li>
<% if(type=="디자이너"){%>

<li class="top-account">
<a href="../designer/profile.do?designerId=<%=userID %>"><i class="fa fa-user"></i> 프로필 </a>
</li>

<%}else if(type=="고객"){ %>

<li class="top-cart">
<a href="C:\00.siat\test\home\my cart 페이지.html"><i class="fa fa-shopping-cart"></i> 나의 찜 - <span class="price">0</span> </a>
</li> 

<%}}}%>



<!-- 
<li class="top-search">
<form role="search" method="get" class="pull-right" id="searchform_topbar" action="https://demo.colorlib.com/tyche/">
<label>
<span class="screen-reader-text"></span>
<input class="search-field-top-bar" id="search-field-top-bar" placeholder="Search ..." value="" name="s" type="search">
</label>
<button id="search-top-bar-submit" type="submit" class="search-top-bar-submit">
<span class="fa fa-search"></span>
</button>
</form> 
</li>-->
</ul>
</div>
</div>
</div>
</header> 

<header id="masthead" class="site-header" role="banner">
<div class="site-branding container">
<div class="row">
<div class="col-sm-4 header-logo">
<a href="../main/index.do" class="custom-logo-link" rel="home" aria-current="page"><img width="150" height="70" src="../resources/BestDesign_Logo.png" class="custom-logo" alt="Tyche Demo" /></a> </div>
</div>
</div>
<nav id="site-navigation" class="main-navigation" role="navigation">
<div class="container">
<div class="row">
<div class="col-md-12">
<ul id="desktop-menu" class="sf-menu"><li itemscope="itemscope" itemtype="https://www.schema.org/SiteNavigationElement" id="menu-item-83" class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-83 active"><a title="Home" href="C:\00.siat\test\home\main.html">홈</a></li>
<li itemscope="itemscope" itemtype="https://www.schema.org/SiteNavigationElement" id="menu-item-86" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-86"><a title="Shop" href="C:\00.siat\test\home\shop메인.html">그려주세요</a></li>
<li itemscope="itemscope" itemtype="https://www.schema.org/SiteNavigationElement" id="menu-item-84" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-84"><a title="Blog" href="C:\00.siat\test\home\blog 메인.html">드로잉 샵</a></li>
<li itemscope="itemscope" itemtype="https://www.schema.org/SiteNavigationElement" id="menu-item-84" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-84"><a title="Blog" href="C:\00.siat\test\home\blog 메인.html">디자이너</a></li>
<li itemscope="itemscope" itemtype="https://www.schema.org/SiteNavigationElement" id="menu-item-85" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-85"><a title="Contact" href="../contactboard/boardList.do">문의 게시판</a></li>
</ul> 
<button href="#" id="mobile-menu-trigger"> <i class="fa fa-bars"></i> </button>

</div>
</div>
</div>
</nav>
</header>
<script type="text/javascript" src="../resources/js/chat.js"></script>
    <%
    	if(userID != null){
    %>
    	<script type="text/javascript">
    		$(function(){
    			getUnread();
    			getInfiniteUnread();
    		});
    	</script>
    <%
    	}
    %>
</body>
</html>