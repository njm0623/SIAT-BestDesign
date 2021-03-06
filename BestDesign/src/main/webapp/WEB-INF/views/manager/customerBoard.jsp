<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="profile" href="https://gmpg.org/xfn/11">
<link rel="pingback" href="https://demo.colorlib.com/tyche/xmlrpc.php">
<meta name='robots' content='noindex, nofollow' />
<title>회원 관리 페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta name="robots"
	content="noindex, follow, max-snippet:-1, max-image-preview:large, max-video-preview:-1" />
<meta property="og:locale" content="en_US" />
<meta property="og:type" content="website" />
<meta property="og:title" content="Home - Tyche Demo" />
<meta property="og:url" content="https://demo.colorlib.com/tyche/" />
<meta property="og:site_name" content="Tyche Demo" />
<meta property="article:author" content="http://facebook.com/silkalns" />
<meta property="article:modified_time"
	content="2020-10-22T08:33:44+00:00" />
<meta name="twitter:card" content="summary" />
<meta name="twitter:creator" content="@https://twitter.com/ASilkalns" />
<!-- 추가한부분 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha384-vk5WoKIaW/vJyUAd9n/wmopsmNhiy+L2Z+SBxGYnUkunIxVxAv/UtMOhba/xskxh"
	crossorigin="anonymous"></script>
<!-- 메뉴css/js 파일 부분 -->
<script src="/BestDesign/resources/custom.css"></script>
<script src="/BestDesign/resources/custom.js"></script>
<script type="text/javascript"
	src="https://pagead2.googlesyndication.com/pagead/show_ads.js"></script>
<!-- 추가한부분 -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/custom.css">
<link href="https://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">	
<!-- 기존 소스 -->
<script type="application/ld+json" class="yoast-schema-graph">{"@context":"https://schema.org","@graph":[{"@type":"WebSite","@id":"https://demo.colorlib.com/tyche/#website","url":"https://demo.colorlib.com/tyche/","name":"Tyche Demo","description":"Just another colorlib.com site","potentialAction":[{"@type":"SearchAction","target":"https://demo.colorlib.com/tyche/?s={search_term_string}","query-input":"required name=search_term_string"}],"inLanguage":"en-US"},{"@type":"WebPage","@id":"https://demo.colorlib.com/tyche/#webpage","url":"https://demo.colorlib.com/tyche/","name":"Home - Tyche Demo","isPartOf":{"@id":"https://demo.colorlib.com/tyche/#website"},"datePublished":"2017-05-24T06:16:36+00:00","dateModified":"2020-10-22T08:33:44+00:00","inLanguage":"en-US","potentialAction":[{"@type":"ReadAction","target":["https://demo.colorlib.com/tyche/"]}]}]}</script>
<link rel='dns-prefetch' href='//fonts.googleapis.com' />
<link rel='dns-prefetch' href='//s.w.org' />
<link rel="alternate" type="application/rss+xml"
	title="Tyche Demo &raquo; Feed"
	href="https://demo.colorlib.com/tyche/feed/" />
<link rel="alternate" type="application/rss+xml"
	title="Tyche Demo &raquo; Comments Feed"
	href="https://demo.colorlib.com/tyche/comments/feed/" />
<link rel="alternate" type="application/rss+xml"
	title="Tyche Demo &raquo; Home Comments Feed"
	href="https://demo.colorlib.com/tyche/home/feed/" />
<script type="text/javascript">
			window._wpemojiSettings = {"baseUrl":"https:\/\/s.w.org\/images\/core\/emoji\/13.0.1\/72x72\/","ext":".png","svgUrl":"https:\/\/s.w.org\/images\/core\/emoji\/13.0.1\/svg\/","svgExt":".svg","source":{"concatemoji":"https:\/\/demo.colorlib.com\/tyche\/wp-includes\/js\/wp-emoji-release.min.js?ver=5.7.1"}};
			!function(e,a,t){var n,r,o,i=a.createElement("canvas"),p=i.getContext&&i.getContext("2d");function s(e,t){var a=String.fromCharCode;p.clearRect(0,0,i.width,i.height),p.fillText(a.apply(this,e),0,0);e=i.toDataURL();return p.clearRect(0,0,i.width,i.height),p.fillText(a.apply(this,t),0,0),e===i.toDataURL()}function c(e){var t=a.createElement("script");t.src=e,t.defer=t.type="text/javascript",a.getElementsByTagName("head")[0].appendChild(t)}for(o=Array("flag","emoji"),t.supports={everything:!0,everythingExceptFlag:!0},r=0;r<o.length;r++)t.supports[o[r]]=function(e){if(!p||!p.fillText)return!1;switch(p.textBaseline="top",p.font="600 32px Arial",e){case"flag":return s([127987,65039,8205,9895,65039],[127987,65039,8203,9895,65039])?!1:!s([55356,56826,55356,56819],[55356,56826,8203,55356,56819])&&!s([55356,57332,56128,56423,56128,56418,56128,56421,56128,56430,56128,56423,56128,56447],[55356,57332,8203,56128,56423,8203,56128,56418,8203,56128,56421,8203,56128,56430,8203,56128,56423,8203,56128,56447]);case"emoji":return!s([55357,56424,8205,55356,57212],[55357,56424,8203,55356,57212])}return!1}(o[r]),t.supports.everything=t.supports.everything&&t.supports[o[r]],"flag"!==o[r]&&(t.supports.everythingExceptFlag=t.supports.everythingExceptFlag&&t.supports[o[r]]);t.supports.everythingExceptFlag=t.supports.everythingExceptFlag&&!t.supports.flag,t.DOMReady=!1,t.readyCallback=function(){t.DOMReady=!0},t.supports.everything||(n=function(){t.readyCallback()},a.addEventListener?(a.addEventListener("DOMContentLoaded",n,!1),e.addEventListener("load",n,!1)):(e.attachEvent("onload",n),a.attachEvent("onreadystatechange",function(){"complete"===a.readyState&&t.readyCallback()})),(n=t.source||{}).concatemoji?c(n.concatemoji):n.wpemoji&&n.twemoji&&(c(n.twemoji),c(n.wpemoji)))}(window,document,window._wpemojiSettings);
		</script>
<style type="text/css">
img.wp-smiley, img.emoji {
	display: inline !important;
	border: none !important;
	box-shadow: none !important;
	height: 1em !important;
	width: 1em !important;
	margin: 0 .07em !important;
	vertical-align: -0.1em !important;
	background: none !important;
	padding: 0 !important;
}
</style>
<link rel='stylesheet' id='wp-block-library-css'
	href='https://demo.colorlib.com/tyche/wp-includes/css/dist/block-library/style.min.css?ver=5.7.1'
	type='text/css' media='all' />
<link rel='stylesheet' id='wc-block-vendors-style-css'
	href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/packages/woocommerce-blocks/build/vendors-style.css?ver=4.7.2'
	type='text/css' media='all' />
<link rel='stylesheet' id='wc-block-style-css'
	href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/packages/woocommerce-blocks/build/style.css?ver=4.7.2'
	type='text/css' media='all' />
<link rel='stylesheet' id='contact-form-7-css'
	href='https://demo.colorlib.com/tyche/wp-content/plugins/contact-form-7/includes/css/styles.css?ver=5.4'
	type='text/css' media='all' />
<link rel='stylesheet' id='prisna-social-counter-css'
	href='https://demo.colorlib.com/tyche/wp-content/plugins/social-counter/styles/prisna-social-counter.css?ver=5.7.1'
	type='text/css' media='all' />
<link rel='stylesheet' id='woocommerce-layout-css'
	href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/woocommerce-layout.css?ver=5.2.2'
	type='text/css' media='all' />
<link rel='stylesheet' id='woocommerce-smallscreen-css'
	href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/woocommerce-smallscreen.css?ver=5.2.2'
	type='text/css' media='only screen and (max-width: 768px)' />
<link rel='stylesheet' id='woocommerce-general-css'
	href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/woocommerce.css?ver=5.2.2'
	type='text/css' media='all' />
<style id='woocommerce-inline-inline-css' type='text/css'>
.woocommerce form .form-row .required {
	visibility: visible;
}
</style>
<link crossorigin="anonymous" rel='stylesheet' id='google-fonts-css'
	href='//fonts.googleapis.com/css?family=Karla%3A400%2C700&#038;ver=5.7.1'
	type='text/css' media='all' />
<link rel='stylesheet' id='font-awesome-css'
	href='https://demo.colorlib.com/tyche/wp-content/plugins/elementor/assets/lib/font-awesome/css/font-awesome.min.css?ver=4.7.0'
	type='text/css' media='all' />
<link rel='stylesheet' id='owlCarousel-css'
	href='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/owl-carousel/owl.carousel.min.css?ver=5.7.1'
	type='text/css' media='all' />
<link rel='stylesheet' id='owlCarousel-theme-css'
	href='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/owl-carousel/owl.theme.default.css?ver=5.7.1'
	type='text/css' media='all' />
<link rel='stylesheet' id='dashicons-css'
	href='https://demo.colorlib.com/tyche/wp-includes/css/dashicons.min.css?ver=5.7.1'
	type='text/css' media='all' />
<link rel='stylesheet' id='tyche-css'
	href='https://demo.colorlib.com/tyche/wp-content/themes/tyche/style.css?ver=5.7.1'
	type='text/css' media='all' />
<link rel='stylesheet' id='tyche-style-css'
	href='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/css/style.css?ver=5.7.1'
	type='text/css' media='all' />
<script type='text/javascript'
	src='https://demo.colorlib.com/tyche/wp-includes/js/jquery/jquery.min.js?ver=3.5.1'
	id='jquery-core-js'></script>
<script type='text/javascript'
	src='https://demo.colorlib.com/tyche/wp-includes/js/jquery/jquery-migrate.min.js?ver=3.3.2'
	id='jquery-migrate-js'></script>
<script type='text/javascript'
	src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/owl-carousel/owl.carousel.min.js?ver=1.3.3'
	id='owlCarousel-js'></script>
<script type='text/javascript'
	src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/jquery-zoom/jquery.zoom.min.js?ver=1.3.3'
	id='jquery-zoom-js'></script>
<script type='text/javascript' id='tyche-scripts-js-extra'>
/* <![CDATA[ */
var tycheHelper = {"initZoom":"1","ajaxURL":"https:\/\/demo.colorlib.com\/tyche\/wp-admin\/admin-ajax.php"};
/* ]]> */
</script>
<script type='text/javascript'
	src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/js/functions.js?ver=5.7.1'
	id='tyche-scripts-js'></script>
<link rel="https://api.w.org/"
	href="https://demo.colorlib.com/tyche/wp-json/" />
<link rel="alternate" type="application/json"
	href="https://demo.colorlib.com/tyche/wp-json/wp/v2/pages/2" />
<link rel="EditURI" type="application/rsd+xml" title="RSD"
	href="https://demo.colorlib.com/tyche/xmlrpc.php?rsd" />
<link rel="wlwmanifest" type="application/wlwmanifest+xml"
	href="https://demo.colorlib.com/tyche/wp-includes/wlwmanifest.xml" />

<meta name="generator" content="WordPress 5.7.1" />
<meta name="generator" content="WooCommerce 5.2.2" />
<link rel='shortlink' href='https://demo.colorlib.com/tyche/' />
<link rel="alternate" type="application/json+oembed"
	href="https://demo.colorlib.com/tyche/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fdemo.colorlib.com%2Ftyche%2F" />
<link rel="alternate" type="text/xml+oembed"
	href="https://demo.colorlib.com/tyche/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fdemo.colorlib.com%2Ftyche%2F&#038;format=xml" />
<meta name="jetpack-boost-config-id" content="" />
<meta name="jetpack-boost-ready" content="true" />
<noscript>
	<style>
.woocommerce-product-gallery {
	opacity: 1 !important;
}
</style>
</noscript>
<script type="text/javascript">var ajaxurl = 'https://demo.colorlib.com/tyche/wp-admin/admin-ajax.php';</script>
<style id="kirki-inline-styles"></style>
<!-- ************************************************************************************************************* -->

<script>
		$(function() {
			$(".custom-logo").prop("src", "main/webapp/resources/BestDesign_Logo.png")
		})
	</script>

<style>
#masthead {
	background: #fff;
}

.sf-menu>li>a {
	color: black;
}
</style>		
</head>
<body
	class="home page-template-default page page-id-2 wp-custom-logo theme-tyche woocommerce-no-js elementor-default elementor-kit-1236">
	<div id="page" class="site">

		<header class="top-header-bar-container">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<ul class="top-header-bar">

							<li class="top-email">
							<li class="top-cart"><a
								href="C:\00.siat\test\home\my cart 페이지.html"><i
									class="fa fa-shopping-cart"></i> 나의 찜 - <span class="price">0</span>
							</a></li>

							<li class="top-account"><a href="chat/header.do"><i
									class="fa fa-user"></i> 로그인 </a></li>

							<li class="top-search">

								<form role="search" method="get" class="pull-right"
									id="searchform_topbar"
									action="https://demo.colorlib.com/tyche/">
									<label> <span class="screen-reader-text"></span> <input
										class="search-field-top-bar" id="search-field-top-bar"
										placeholder="Search ..." value="" name="s" type="search">
									</label>
									<button id="search-top-bar-submit" type="submit"
										class="search-top-bar-submit">
										<span class="fa fa-search"></span>
									</button>
								</form>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<header id="masthead" class="site-header" role="banner">
			<div class="site-branding container">
				<div class="row">
					<div class="col-sm-4 header-logo">
						<a href="C:\00.siat\test\home\main.html" class="custom-logo-link"
							rel="home" aria-current="page"><img width="150" height="70"
							src="https://demo.colorlib.com/tyche/wp-content/uploads/sites/64/2017/06/logo.png"
							class="custom-logo" alt="Tyche Demo" /></a>
					</div>
				</div>
			</div>
			<nav id="site-navigation" class="main-navigation" role="navigation">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<ul id="desktop-menu" class="sf-menu">
								<li itemscope="itemscope"
									itemtype="https://www.schema.org/SiteNavigationElement"
									id="menu-item-83"
									class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-83 active"><a
									title="Home" href="C:\00.siat\test\home\main.html">홈</a></li>
								<li itemscope="itemscope"
									itemtype="https://www.schema.org/SiteNavigationElement"
									id="menu-item-86"
									class="menu-item menu-item-type-post_type menu-item-object-page menu-item-86"><a
									title="Shop" href="C:\00.siat\test\home\shop메인.html">그려주세요</a></li>
								<li itemscope="itemscope"
									itemtype="https://www.schema.org/SiteNavigationElement"
									id="menu-item-84"
									class="menu-item menu-item-type-post_type menu-item-object-page menu-item-84"><a
									title="Blog" href="C:\00.siat\test\home\blog 메인.html">드로잉 샵</a></li>
								<li itemscope="itemscope"
									itemtype="https://www.schema.org/SiteNavigationElement"
									id="menu-item-84"
									class="menu-item menu-item-type-post_type menu-item-object-page menu-item-84"><a
									title="Blog" href="C:\00.siat\test\home\blog 메인.html">디자이너</a></li>
								<li itemscope="itemscope"
									itemtype="https://www.schema.org/SiteNavigationElement"
									id="menu-item-85"
									class="menu-item menu-item-type-post_type menu-item-object-page menu-item-85"><a
									title="Contact" href="C:\00.siat\test\home\Contact 메인페이지.html">문의
										게시판</a></li>
							</ul>
							<button href="#" id="mobile-menu-trigger">
								<i class="fa fa-bars"></i>
							</button>

						</div>
					</div>
				</div>
			</nav>
		</header>
		<!--탑부분 삭제: 185 라인 main-slider부터 site-content 위에 section 끝나는부분까지(239라인)-->
		<div class="site-content">
			<div class="container">
				<!-- 썸네일 페이지  188라인 col-xs-12부터 467 colophon footer전까지 삭제-->
				<div class="row">
					<div class="col-md-12">
						<nav class="woocommerce-breadcrumb">
							<a href="https://demo.colorlib.com/tyche">Home</a>&nbsp;&#47;&nbsp;Administrator
						</nav>
					</div>
				</div>
				<!-- 본문 -->
				<div class="row">
					<!-- 왼쪽 side메뉴 -->
					<div class="col-md-4 hidden-xs">
						<div class="left-menu">
						<div class="accordion-menu">
							<ul class="menu">
								<li><a href="#">회원관리<i class="fa fa-chevron-down"></i></a>
									<ul>
										<li><a href="userBoardList.do">회원</a></li>
										<li><a href="designBoardList.do">디자이너</a></li>
									</ul>
								</li>
								<li><a href="#"> 게시물 관리 <i class="fa fa-chevron-down"></i></a>
									<ul>
										<li><a href="requestBoardList.do">그려주세요 목록</a></li>
										<li><a href="saleBoardList.do">드로잉샵 목록</a></li>
										<li><a href="#">문의게시판 목록</a></li>
									</ul>
								</li>
								<li><a href="saleConfirm.do">매출 확인<i class="fa fa-chevron-down"></i></a>
									<ul>
										<li><a href="#">Sub-Element #1</a></li>
										<li><a href="#">Sub-Element #2</a></li>
										<li><a href="#">Sub-Element #3</a></li>
										<li><a href="#">Sub-Element #4</a></li>
									</ul>
								</li>
							</ul>
						</div>
						</div>
					</div>
					<div class="col-md-8 tyche-has-sidebar">
							<h4>고객 등록 목록</h4>
					<form action='customerBoard.do' method='post'>
					</form>	
					<table border="1">
					<tr>
						<th bgcolor="gray" width="100">ID</th>
						<th bgcolor="gray" width="100">PWD</th>
						<th bgcolor="gray" width="100">이름</th>
						<th bgcolor="gray" width="150">이메일</th>
						<th bgcolor="gray" width="100">생일</th>
						<th bgcolor="gray" width="150">핸드폰번호</th>
					</tr>
									<!-- DB값 호출 -->			
						<c:forEach items="${userList}" var="users">
							<tr>
								<td>${users.userId}</td><!--위에 VAR명이랑 일치  --><!--컬럼명은 UserVO랑 일치시켜야한다.  -->
								<td>${users.userPwd}</td>
								<td>${users.userName}</td>
								<td>${users.userEmail}</td>
								<td>${users.userBirth}</td>
								<td>${users.userPhone}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>		
	</div>
	<footer id="colophon" class="site-footer" role="contentinfo">
		<div class="widgets-area">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-6">
						<div id="meta-4" class="widget widget_meta">
							<h5 class="widget-title">
								<span>Meta</span>
							</h5>
							<ul>
								<li><a rel="nofollow"
									href="https://demo.colorlib.com/tyche/wp-login.php">Log in</a></li>
								<li><a href="https://demo.colorlib.com/tyche/feed/">Entries
										feed</a></li>
								<li><a
									href="https://demo.colorlib.com/tyche/comments/feed/">Comments
										feed</a></li>
								<li><a href="https://wordpress.org/">WordPress.org</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-3 col-sm-6">

						<div id="tyche_recent-5"
							class="tyche-recent-posts widget widget_tyche_recent">
							<h5 class="widget-title">
								<span>Recent Posts</span>
							</h5>
							<div class="tyche-recent-post-widget">
								<div class="tyche-image">
									<a
										href="https://demo.colorlib.com/tyche/2017/06/12/jackets-soul-color/">
										<img width="65" height="65"
										src="https://demo.colorlib.com/tyche/wp-content/uploads/sites/64/2017/06/down-jackets-1281699_1920-65x65.jpg"
										class="attachment-tyche-recent-post-list-image size-tyche-recent-post-list-image wp-post-image"
										alt="" loading="lazy" />
									</a>
								</div>
								<div class="tyche-post-content">
									<div class="tyche-title">
										<p>
											<a
												href="https://demo.colorlib.com/tyche/2017/06/12/jackets-soul-color/">Jackets
												For The Soul. What Color Is Yours?</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6">


						<div id="text-3" class="widget widget_text">
							<h5 class="widget-title">
								<span>About</span>
							</h5>
							<div class="textwidget">
								<p>Pri quas audiam virtute ut, case utamur fuisset eam ut,
									iisque accommodare an eam.</p>
							</div>
						</div>
					</div>


					<div class="col-md-3 col-sm-6">
						<div id="tag_cloud-3" class="widget widget_tag_cloud">
							<h5 class="widget-title">
								<span>Tags</span>
							</h5>
							<div class="tagcloud">
								<a href="C:\00.siat\test\home\메인페이지 하단 tags를 클릭한화면.html"
									class="tag-cloud-link tag-link-52 tag-link-position-1"
									style="font-size: 8pt;" aria-label="Autumn (1 item)">Autumn</a>
								<a href="https://demo.colorlib.com/tyche/tag/dress/"
									class="tag-cloud-link tag-link-56 tag-link-position-2"
									style="font-size: 8pt;" aria-label="dress (1 item)">dress</a> <a
									href="https://demo.colorlib.com/tyche/tag/fashion/"
									class="tag-cloud-link tag-link-54 tag-link-position-3"
									style="font-size: 18.5pt;" aria-label="fashion (3 items)">fashion</a>
								<a href="https://demo.colorlib.com/tyche/tag/jackets/"
									class="tag-cloud-link tag-link-57 tag-link-position-4"
									style="font-size: 8pt;" aria-label="jackets (1 item)">jackets</a>
								<a href="https://demo.colorlib.com/tyche/tag/stockings/"
									class="tag-cloud-link tag-link-55 tag-link-position-5"
									style="font-size: 8pt;" aria-label="stockings (1 item)">stockings</a>
								<a href="https://demo.colorlib.com/tyche/tag/trends/"
									class="tag-cloud-link tag-link-53 tag-link-position-6"
									style="font-size: 22pt;" aria-label="trends (4 items)">trends</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<footer class="site-copyright">
		<div class="site-info ">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div id="menu-social" class="menu pull-left">
							<ul id="menu-social-items" class="menu-items">
								<li id="menu-item-88"
									class="menu-item menu-item-type-custom menu-item-object-custom menu-item-88"><a
									href="https://facebook.com"><span
										class="screen-reader-text">Facebook</span></a></li>
								<li id="menu-item-89"
									class="menu-item menu-item-type-custom menu-item-object-custom menu-item-89"><a
									href="https://twitter.com"><span class="screen-reader-text">Twitter</span></a></li>
								<li id="menu-item-90"
									class="menu-item menu-item-type-custom menu-item-object-custom menu-item-90"><a
									href="https://dribbble.com"><span
										class="screen-reader-text">Dribbble</span></a></li>
								<li id="menu-item-91"
									class="menu-item menu-item-type-custom menu-item-object-custom menu-item-91"><a
									href="https://vimeo.com"><span class="screen-reader-text">Vimeo</span></a></li>
								<li id="menu-item-92"
									class="menu-item menu-item-type-custom menu-item-object-custom menu-item-92"><a
									href="https://youtube.com"><span class="screen-reader-text">YouTube</span></a></li>
							</ul>
						</div>
						<div class="copyright-text pull-right">Copyright © 2021 |
							Theme: Tyche | Powered by WordPress.</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	</div>
	<script data-cfasync="false"
		src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
	<script type="text/javascript">
		(function () {
			var c = document.body.className;
			c = c.replace(/woocommerce-no-js/, 'woocommerce-js');
			document.body.className = c;
		})();
	</script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill.min.js?ver=7.4.4'
		id='wp-polyfill-js'></script>
	<script type='text/javascript' id='wp-polyfill-js-after'>
( 'fetch' in window ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-fetch.min.js?ver=3.0.0"></scr' + 'ipt>' );( document.contains ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-node-contains.min.js?ver=3.42.0"></scr' + 'ipt>' );( window.DOMRect ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-dom-rect.min.js?ver=3.42.0"></scr' + 'ipt>' );( window.URL && window.URL.prototype && window.URLSearchParams ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-url.min.js?ver=3.6.4"></scr' + 'ipt>' );( window.FormData && window.FormData.prototype.keys ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-formdata.min.js?ver=3.0.12"></scr' + 'ipt>' );( Element.prototype.matches && Element.prototype.closest ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-element-closest.min.js?ver=2.0.2"></scr' + 'ipt>' );( 'objectFit' in document.documentElement.style ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-object-fit.min.js?ver=2.3.4"></scr' + 'ipt>' );
</script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-includes/js/dist/hooks.min.js?ver=50e23bed88bcb9e6e14023e9961698c1'
		id='wp-hooks-js'></script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-includes/js/dist/i18n.min.js?ver=db9a9a37da262883343e941c3731bc67'
		id='wp-i18n-js'></script>
	<script type='text/javascript' id='wp-i18n-js-after'>
wp.i18n.setLocaleData( { 'text direction\u0004ltr': [ 'ltr' ] } );
</script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/lodash.min.js?ver=4.17.19'
		id='lodash-js'></script>
	<script type='text/javascript' id='lodash-js-after'>
window.lodash = _.noConflict();
</script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-includes/js/dist/url.min.js?ver=0ac7e0472c46121366e7ce07244be1ac'
		id='wp-url-js'></script>
	<script type='text/javascript' id='wp-api-fetch-js-translations'>
( function( domain, translations ) {
	var localeData = translations.locale_data[ domain ] || translations.locale_data.messages;
	localeData[""].domain = domain;
	wp.i18n.setLocaleData( localeData, domain );
} )( "default", { "locale_data": { "messages": { "": {} } } } );
</script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-includes/js/dist/api-fetch.min.js?ver=a783d1f442d2abefc7d6dbd156a44561'
		id='wp-api-fetch-js'></script>
	<script type='text/javascript' id='wp-api-fetch-js-after'>
wp.apiFetch.use( wp.apiFetch.createRootURLMiddleware( "https://demo.colorlib.com/tyche/wp-json/" ) );
wp.apiFetch.nonceMiddleware = wp.apiFetch.createNonceMiddleware( "3aa5e0bf44" );
wp.apiFetch.use( wp.apiFetch.nonceMiddleware );
wp.apiFetch.use( wp.apiFetch.mediaUploadMiddleware );
wp.apiFetch.nonceEndpoint = "https://demo.colorlib.com/tyche/wp-admin/admin-ajax.php?action=rest-nonce";
</script>
	<script type='text/javascript' id='contact-form-7-js-extra'>
/* <![CDATA[ */
var wpcf7 = [];
/* ]]> */
</script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-content/plugins/contact-form-7/includes/js/index.js?ver=5.4'
		id='contact-form-7-js'></script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/jquery-blockui/jquery.blockUI.min.js?ver=2.70'
		id='jquery-blockui-js'></script>
	<script type='text/javascript' id='wc-add-to-cart-js-extra'>
/* <![CDATA[ */
var wc_add_to_cart_params = {"ajax_url":"\/tyche\/wp-admin\/admin-ajax.php","wc_ajax_url":"\/tyche\/?wc-ajax=%%endpoint%%","i18n_view_cart":"View cart","cart_url":"https:\/\/demo.colorlib.com\/tyche\/cart\/","is_cart":"","cart_redirect_after_add":"no"};
/* ]]> */
</script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/frontend/add-to-cart.min.js?ver=5.2.2'
		id='wc-add-to-cart-js'></script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/js-cookie/js.cookie.min.js?ver=2.1.4'
		id='js-cookie-js'></script>
	<script type='text/javascript' id='woocommerce-js-extra'>
/* <![CDATA[ */
var woocommerce_params = {"ajax_url":"\/tyche\/wp-admin\/admin-ajax.php","wc_ajax_url":"\/tyche\/?wc-ajax=%%endpoint%%"};
/* ]]> */
</script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/frontend/woocommerce.min.js?ver=5.2.2'
		id='woocommerce-js'></script>
	<script type='text/javascript' id='wc-cart-fragments-js-extra'>
/* <![CDATA[ */
var wc_cart_fragments_params = {"ajax_url":"\/tyche\/wp-admin\/admin-ajax.php","wc_ajax_url":"\/tyche\/?wc-ajax=%%endpoint%%","cart_hash_key":"wc_cart_hash_c7ba160b83b4cf4fe4c311fa6b89b05c","fragment_name":"wc_fragments_c7ba160b83b4cf4fe4c311fa6b89b05c","request_timeout":"5000"};
/* ]]> */
</script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/frontend/cart-fragments.min.js?ver=5.2.2'
		id='wc-cart-fragments-js'></script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/js/skip-link-focus-fix.js?ver=5.7.1'
		id='tyche-skip-link-focus-fix-js'></script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/menu/menu.min.js?ver=5.7.1'
		id='tyche-multilang-menu-js'></script>
	<script type='text/javascript'
		src='https://demo.colorlib.com/tyche/wp-includes/js/wp-embed.min.js?ver=5.7.1'
		id='wp-embed-js'></script>
	<script>window.GA_ID='';</script>
	<script
		src='https://demo.colorlib.com/tyche/wp-content/plugins/flying-analytics/js/minimal-analytics.js'
		defer></script>
</body>
</html>