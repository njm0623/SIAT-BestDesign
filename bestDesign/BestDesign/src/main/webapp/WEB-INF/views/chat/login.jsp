 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="../resources/css/bootstrap.css">
	<link rel="stylesheet" href="../resources/css/custom.css">
    <title>아약스 실시간 회원제 회원가입</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
    <script src="../resources/js/bootstrap.js"></script>
    <script src="../resources/js/custom.js"></script>
    <style>
    	.container{
			width:500px;
		}
    </style>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
    <%
        String userID = null;
        if(session.getAttribute("userID") != null){
        	userID = (String) session.getAttribute("userID");// 겟 세션은 Object 를 리턴
        }
        if(userID != null){
        	session.setAttribute("messageType", "오류");
        	session.setAttribute("messageContent", "현재 로그인이 되어있는 상태입니다.");
        	response.sendRedirect("index.jsp");
        	return;
        }
    %>
    <div class="container">
    	<form method="post" action="../user/login.do">
    		<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
    			<thead>
    				<tr>
    					<th colspan="2"><h4>로그인 양식</h4></th>
    				</tr>
    			</thead>
    			<tbody>
    				<tr>
    					<td style="width: 110px;"><h5>아이디</h5></td>
    					<td><input type="text" class="form-control" name="userID" id="userID" maxlength="20" placeholder="아이디를 입력하세요."></td>
    				</tr>
    				<tr>
    					<td style="width: 110px;"><h5>비밀번호</h5></td>
    					<td><input type="password" class="form-control" name="userPassword" id="userPassword" maxlength="20" placeholder="아이디를 입력하세요."></td>
    				</tr>
    				<tr>
    					<td style="width: 110px;"><h5>유형</h5></td>
    					<td colspan="2">
    						<div class="form-group" style="text-align: center; margin: 0 auto;">
    							<div class="btn-group" data-toggle="buttons">
    								<label class="btn  btn-primary active">
    									<input type="radio" name="userType" autocomplete="off" value="고객" checked>고객
    								</label>
    								<label class="btn  btn-primary">
    									<input type="radio" name="userType" autocomplete="off" value="디자이너">디자이너
    								</label>
    							</div>
    						</div>
    					</td>
    				</tr>
    				<tr>
    					<td style="text-align: left" colspan="2"><input type="submit" class="btn btn-primary pull-right"  value="로그인"></td>
    				</tr>
    			</tbody>
    		</table>
    	</form>
    </div>
    <%
    	String messageContent = null;
    	if(session.getAttribute("messageContent")!=null){
    		messageContent = (String)session.getAttribute("messageContent");
    	}
    	String messageType = null;
    	if(session.getAttribute("messageType")!=null){
    		messageType = (String)session.getAttribute("messageType");
    	}
    	if(messageContent != null){
    %>
    <div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-hidden="true">
    	<div class="vertical-alignment-helper">
    		<div class="modal-dialog vertical-align-center">
    			<div class="modal-content <%if(messageType.equals("오류")) out.println("panel-warning"); else out.println("panel-success"); %>">
    				<div class="modal-header panel-heading">
    					<button type="button" class="close" data-dismiss="modal">
    						<span aria-hidden="true">&times</span>
    						<span class="sr-only">Close</span>
    					</button>
    					<h4 class="modal-title">
    						<%=messageType %>
    					</h4>
    				</div>
    				<div class="modal-body">
    					<%=messageContent %>
    				</div>
    				<div class="modal-footer">
    					<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <script type="text/javascript">
    	$("#messageModal").modal("show");
    </script>
    <%
    	session.removeAttribute("messageContent");
    	session.removeAttribute("messageType");
    }
    %>
    <div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-hidden="true">
    	<div class="vertical-alignment-helper">
    		<div class="modal-dialog vertical-align-center">
    			<div id="checkType" class="modal-content panel-info">
    				<div class="modal-header panel-heading">
    					<button type="button" class="close" data-dismiss="modal">
    						<span aria-hidden="true">&times</span>
    						<span class="sr-only">Close</span>
    					</button>
    					<h4 class="modal-title">
    						확인 메시지
    					</h4>
    				</div>
    				<div id="checkMessage" class="modal-body"></div>
    				<div class="modal-footer">
    					<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
  <jsp:include page="../main/footer.jsp"/>
</body>
</html>--%>

<!DOCTYPE html>
<html lang="ko">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>My account - Tyche Demo</title>


<%--<meta name="robots" content="noindex, follow, max-snippet:-1, max-image-preview:large, max-video-preview:-1" />
<meta property="og:locale" content="en_US" />
<meta property="og:type" content="article" />
<meta property="og:title" content="My account - Tyche Demo" />
<meta property="og:url" content="https://demo.colorlib.com/tyche/my-account/" />
<meta property="og:site_name" content="Tyche Demo" />
<meta name="twitter:card" content="summary" />
<script type="application/ld+json" class="yoast-schema-graph">{"@context":"https://schema.org","@graph":[{"@type":"WebSite","@id":"https://demo.colorlib.com/tyche/#website","url":"https://demo.colorlib.com/tyche/","name":"Tyche Demo","description":"Just another colorlib.com site","potentialAction":[{"@type":"SearchAction","target":"https://demo.colorlib.com/tyche/?s={search_term_string}","query-input":"required name=search_term_string"}],"inLanguage":"en-US"},{"@type":"WebPage","@id":"https://demo.colorlib.com/tyche/my-account/#webpage","url":"https://demo.colorlib.com/tyche/my-account/","name":"My account - Tyche Demo","isPartOf":{"@id":"https://demo.colorlib.com/tyche/#website"},"datePublished":"2017-05-24T06:27:07+00:00","dateModified":"2017-05-24T06:27:07+00:00","inLanguage":"en-US","potentialAction":[{"@type":"ReadAction","target":["https://demo.colorlib.com/tyche/my-account/"]}]}]}</script>

<link rel='dns-prefetch' href='//fonts.googleapis.com' />
<link rel='dns-prefetch' href='//s.w.org' />
<link rel="alternate" type="application/rss+xml" title="Tyche Demo &raquo; Feed" href="https://demo.colorlib.com/tyche/feed/" />
<link rel="alternate" type="application/rss+xml" title="Tyche Demo &raquo; Comments Feed" href="https://demo.colorlib.com/tyche/comments/feed/" />
<script type="text/javascript">
			window._wpemojiSettings = {"baseUrl":"https:\/\/s.w.org\/images\/core\/emoji\/13.0.1\/72x72\/","ext":".png","svgUrl":"https:\/\/s.w.org\/images\/core\/emoji\/13.0.1\/svg\/","svgExt":".svg","source":{"concatemoji":"https:\/\/demo.colorlib.com\/tyche\/wp-includes\/js\/wp-emoji-release.min.js?ver=5.7.1"}};
			!function(e,a,t){var n,r,o,i=a.createElement("canvas"),p=i.getContext&&i.getContext("2d");function s(e,t){var a=String.fromCharCode;p.clearRect(0,0,i.width,i.height),p.fillText(a.apply(this,e),0,0);e=i.toDataURL();return p.clearRect(0,0,i.width,i.height),p.fillText(a.apply(this,t),0,0),e===i.toDataURL()}function c(e){var t=a.createElement("script");t.src=e,t.defer=t.type="text/javascript",a.getElementsByTagName("head")[0].appendChild(t)}for(o=Array("flag","emoji"),t.supports={everything:!0,everythingExceptFlag:!0},r=0;r<o.length;r++)t.supports[o[r]]=function(e){if(!p||!p.fillText)return!1;switch(p.textBaseline="top",p.font="600 32px Arial",e){case"flag":return s([127987,65039,8205,9895,65039],[127987,65039,8203,9895,65039])?!1:!s([55356,56826,55356,56819],[55356,56826,8203,55356,56819])&&!s([55356,57332,56128,56423,56128,56418,56128,56421,56128,56430,56128,56423,56128,56447],[55356,57332,8203,56128,56423,8203,56128,56418,8203,56128,56421,8203,56128,56430,8203,56128,56423,8203,56128,56447]);case"emoji":return!s([55357,56424,8205,55356,57212],[55357,56424,8203,55356,57212])}return!1}(o[r]),t.supports.everything=t.supports.everything&&t.supports[o[r]],"flag"!==o[r]&&(t.supports.everythingExceptFlag=t.supports.everythingExceptFlag&&t.supports[o[r]]);t.supports.everythingExceptFlag=t.supports.everythingExceptFlag&&!t.supports.flag,t.DOMReady=!1,t.readyCallback=function(){t.DOMReady=!0},t.supports.everything||(n=function(){t.readyCallback()},a.addEventListener?(a.addEventListener("DOMContentLoaded",n,!1),e.addEventListener("load",n,!1)):(e.attachEvent("onload",n),a.attachEvent("onreadystatechange",function(){"complete"===a.readyState&&t.readyCallback()})),(n=t.source||{}).concatemoji?c(n.concatemoji):n.wpemoji&&n.twemoji&&(c(n.twemoji),c(n.wpemoji)))}(window,document,window._wpemojiSettings);
		</script>
<style type="text/css">
img.wp-smiley,
img.emoji {
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
<link rel='stylesheet' id='wp-block-library-css' href='https://demo.colorlib.com/tyche/wp-includes/css/dist/block-library/style.min.css?ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='wc-block-vendors-style-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/packages/woocommerce-blocks/build/vendors-style.css?ver=4.7.2' type='text/css' media='all' />
<link rel='stylesheet' id='wc-block-style-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/packages/woocommerce-blocks/build/style.css?ver=4.7.2' type='text/css' media='all' />
<link rel='stylesheet' id='contact-form-7-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/contact-form-7/includes/css/styles.css?ver=5.4' type='text/css' media='all' />
<link rel='stylesheet' id='prisna-social-counter-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/social-counter/styles/prisna-social-counter.css?ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='select2-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/select2.css?ver=5.2.2' type='text/css' media='all' />
<link rel='stylesheet' id='woocommerce-layout-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/woocommerce-layout.css?ver=5.2.2' type='text/css' media='all' />
<link rel='stylesheet' id='woocommerce-smallscreen-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/woocommerce-smallscreen.css?ver=5.2.2' type='text/css' media='only screen and (max-width: 768px)' />
<link rel='stylesheet' id='woocommerce-general-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/woocommerce.css?ver=5.2.2' type='text/css' media='all' />
<style id='woocommerce-inline-inline-css' type='text/css'>
.woocommerce form .form-row .required { visibility: visible; }
</style>
<link crossorigin="anonymous" rel='stylesheet' id='google-fonts-css' href='//fonts.googleapis.com/css?family=Karla%3A400%2C700&#038;ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='font-awesome-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/elementor/assets/lib/font-awesome/css/font-awesome.min.css?ver=4.7.0' type='text/css' media='all' />
<link rel='stylesheet' id='owlCarousel-css' href='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/owl-carousel/owl.carousel.min.css?ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='owlCarousel-theme-css' href='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/owl-carousel/owl.theme.default.css?ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='dashicons-css' href='https://demo.colorlib.com/tyche/wp-includes/css/dashicons.min.css?ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='tyche-css' href='https://demo.colorlib.com/tyche/wp-content/themes/tyche/style.css?ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='tyche-style-css' href='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/css/style.css?ver=5.7.1' type='text/css' media='all' />
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/jquery/jquery.min.js?ver=3.5.1' id='jquery-core-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/jquery/jquery-migrate.min.js?ver=3.3.2' id='jquery-migrate-js'></script>
<script type='text/javascript' id='zxcvbn-async-js-extra'>
/* <![CDATA[ */
var _zxcvbnSettings = {"src":"https:\/\/demo.colorlib.com\/tyche\/wp-includes\/js\/zxcvbn.min.js"};
/* ]]> */
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/zxcvbn-async.min.js?ver=1.0' id='zxcvbn-async-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/owl-carousel/owl.carousel.min.js?ver=1.3.3' id='owlCarousel-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/jquery-zoom/jquery.zoom.min.js?ver=1.3.3' id='jquery-zoom-js'></script>
<script type='text/javascript' id='tyche-scripts-js-extra'>
/* <![CDATA[ */
var tycheHelper = {"initZoom":"1","ajaxURL":"https:\/\/demo.colorlib.com\/tyche\/wp-admin\/admin-ajax.php"};
/* ]]> */
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/js/functions.js?ver=5.7.1' id='tyche-scripts-js'></script>
<link rel="https://api.w.org/" href="https://demo.colorlib.com/tyche/wp-json/" /><link rel="alternate" type="application/json" href="https://demo.colorlib.com/tyche/wp-json/wp/v2/pages/7" /><link rel="EditURI" type="application/rsd+xml" title="RSD" href="https://demo.colorlib.com/tyche/xmlrpc.php?rsd" />
<link rel="wlwmanifest" type="application/wlwmanifest+xml" href="https://demo.colorlib.com/tyche/wp-includes/wlwmanifest.xml" />
<meta name="generator" content="WordPress 5.7.1" />
<meta name="generator" content="WooCommerce 5.2.2" />
<link rel='shortlink' href='https://demo.colorlib.com/tyche/?p=7' />
<link rel="alternate" type="application/json+oembed" href="https://demo.colorlib.com/tyche/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fdemo.colorlib.com%2Ftyche%2Fmy-account%2F" />
<link rel="alternate" type="text/xml+oembed" href="https://demo.colorlib.com/tyche/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fdemo.colorlib.com%2Ftyche%2Fmy-account%2F&#038;format=xml" />
<meta name="jetpack-boost-config-id" content="" />
<meta name="jetpack-boost-ready" content="true" />
<noscript><style>.woocommerce-product-gallery{ opacity: 1 !important; }</style></noscript>
<script type="text/javascript">var ajaxurl = 'https://demo.colorlib.com/tyche/wp-admin/admin-ajax.php';</script>
<style id="kirki-inline-styles"></style>
--%>
<script type="application/ld+json" class="yoast-schema-graph">{"@context":"https://schema.org","@graph":[{"@type":"WebSite","@id":"https://demo.colorlib.com/tyche/#website","url":"https://demo.colorlib.com/tyche/","name":"Tyche Demo","description":"Just another colorlib.com site","potentialAction":[{"@type":"SearchAction","target":"https://demo.colorlib.com/tyche/?s={search_term_string}","query-input":"required name=search_term_string"}],"inLanguage":"en-US"},{"@type":"WebPage","@id":"https://demo.colorlib.com/tyche/my-account/#webpage","url":"https://demo.colorlib.com/tyche/my-account/","name":"My account - Tyche Demo","isPartOf":{"@id":"https://demo.colorlib.com/tyche/#website"},"datePublished":"2017-05-24T06:27:07+00:00","dateModified":"2017-05-24T06:27:07+00:00","inLanguage":"en-US","potentialAction":[{"@type":"ReadAction","target":["https://demo.colorlib.com/tyche/my-account/"]}]}]}</script>

<link rel='dns-prefetch' href='//fonts.googleapis.com' />
<link rel='dns-prefetch' href='//s.w.org' />
<link rel="alternate" type="application/rss+xml" title="Tyche Demo &raquo; Feed" href="https://demo.colorlib.com/tyche/feed/" />
<link rel="alternate" type="application/rss+xml" title="Tyche Demo &raquo; Comments Feed" href="https://demo.colorlib.com/tyche/comments/feed/" />


<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/jquery/jquery.min.js?ver=3.5.1' id='jquery-core-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/jquery/jquery-migrate.min.js?ver=3.3.2' id='jquery-migrate-js'></script>

<script type="text/javascript">
			window._wpemojiSettings = {"baseUrl":"https:\/\/s.w.org\/images\/core\/emoji\/13.0.1\/72x72\/","ext":".png","svgUrl":"https:\/\/s.w.org\/images\/core\/emoji\/13.0.1\/svg\/","svgExt":".svg","source":{"concatemoji":"https:\/\/demo.colorlib.com\/tyche\/wp-includes\/js\/wp-emoji-release.min.js?ver=5.7.1"}};
			!function(e,a,t){var n,r,o,i=a.createElement("canvas"),p=i.getContext&&i.getContext("2d");function s(e,t){var a=String.fromCharCode;p.clearRect(0,0,i.width,i.height),p.fillText(a.apply(this,e),0,0);e=i.toDataURL();return p.clearRect(0,0,i.width,i.height),p.fillText(a.apply(this,t),0,0),e===i.toDataURL()}function c(e){var t=a.createElement("script");t.src=e,t.defer=t.type="text/javascript",a.getElementsByTagName("head")[0].appendChild(t)}for(o=Array("flag","emoji"),t.supports={everything:!0,everythingExceptFlag:!0},r=0;r<o.length;r++)t.supports[o[r]]=function(e){if(!p||!p.fillText)return!1;switch(p.textBaseline="top",p.font="600 32px Arial",e){case"flag":return s([127987,65039,8205,9895,65039],[127987,65039,8203,9895,65039])?!1:!s([55356,56826,55356,56819],[55356,56826,8203,55356,56819])&&!s([55356,57332,56128,56423,56128,56418,56128,56421,56128,56430,56128,56423,56128,56447],[55356,57332,8203,56128,56423,8203,56128,56418,8203,56128,56421,8203,56128,56430,8203,56128,56423,8203,56128,56447]);case"emoji":return!s([55357,56424,8205,55356,57212],[55357,56424,8203,55356,57212])}return!1}(o[r]),t.supports.everything=t.supports.everything&&t.supports[o[r]],"flag"!==o[r]&&(t.supports.everythingExceptFlag=t.supports.everythingExceptFlag&&t.supports[o[r]]);t.supports.everythingExceptFlag=t.supports.everythingExceptFlag&&!t.supports.flag,t.DOMReady=!1,t.readyCallback=function(){t.DOMReady=!0},t.supports.everything||(n=function(){t.readyCallback()},a.addEventListener?(a.addEventListener("DOMContentLoaded",n,!1),e.addEventListener("load",n,!1)):(e.attachEvent("onload",n),a.attachEvent("onreadystatechange",function(){"complete"===a.readyState&&t.readyCallback()})),(n=t.source||{}).concatemoji?c(n.concatemoji):n.wpemoji&&n.twemoji&&(c(n.twemoji),c(n.wpemoji)))}(window,document,window._wpemojiSettings);
		</script>

<style type="text/css">
img.wp-smiley,
img.emoji {
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
<link rel='stylesheet' id='wp-block-library-css' href='https://demo.colorlib.com/tyche/wp-includes/css/dist/block-library/style.min.css?ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='wc-block-vendors-style-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/packages/woocommerce-blocks/build/vendors-style.css?ver=4.7.2' type='text/css' media='all' />
<link rel='stylesheet' id='wc-block-style-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/packages/woocommerce-blocks/build/style.css?ver=4.7.2' type='text/css' media='all' />
<link rel='stylesheet' id='contact-form-7-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/contact-form-7/includes/css/styles.css?ver=5.4' type='text/css' media='all' />
<link rel='stylesheet' id='prisna-social-counter-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/social-counter/styles/prisna-social-counter.css?ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='select2-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/select2.css?ver=5.2.2' type='text/css' media='all' />
<link rel='stylesheet' id='woocommerce-layout-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/woocommerce-layout.css?ver=5.2.2' type='text/css' media='all' />
<link rel='stylesheet' id='woocommerce-smallscreen-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/woocommerce-smallscreen.css?ver=5.2.2' type='text/css' media='only screen and (max-width: 768px)' />
<link rel='stylesheet' id='woocommerce-general-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/woocommerce.css?ver=5.2.2' type='text/css' media='all' />



<link crossorigin="anonymous" rel='stylesheet' id='google-fonts-css' href='//fonts.googleapis.com/css?family=Karla%3A400%2C700&#038;ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='font-awesome-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/elementor/assets/lib/font-awesome/css/font-awesome.min.css?ver=4.7.0' type='text/css' media='all' />
<link rel='stylesheet' id='owlCarousel-css' href='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/owl-carousel/owl.carousel.min.css?ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='owlCarousel-theme-css' href='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/owl-carousel/owl.theme.default.css?ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='dashicons-css' href='https://demo.colorlib.com/tyche/wp-includes/css/dashicons.min.css?ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='tyche-css' href='https://demo.colorlib.com/tyche/wp-content/themes/tyche/style.css?ver=5.7.1' type='text/css' media='all' />
<link rel='stylesheet' id='tyche-style-css' href='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/css/style.css?ver=5.7.1' type='text/css' media='all' />

<!-- <script type='text/javascript' id='zxcvbn-async-js-extra'>
/* <![CDATA[ */
var _zxcvbnSettings = {"src":"https:\/\/demo.colorlib.com\/tyche\/wp-includes\/js\/zxcvbn.min.js"};
/* ]]> */
</script>

<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/zxcvbn-async.min.js?ver=1.0' id='zxcvbn-async-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/owl-carousel/owl.carousel.min.js?ver=1.3.3' id='owlCarousel-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/jquery-zoom/jquery.zoom.min.js?ver=1.3.3' id='jquery-zoom-js'></script>
 -->
<!-- <script type='text/javascript' id='tyche-scripts-js-extra'>
/* <![CDATA[ */
var tycheHelper = {"initZoom":"1","ajaxURL":"https:\/\/demo.colorlib.com\/tyche\/wp-admin\/admin-ajax.php"};
/* ]]> */
</script>

<link rel="https://api.w.org/" href="https://demo.colorlib.com/tyche/wp-json/" /><link rel="alternate" type="application/json" href="https://demo.colorlib.com/tyche/wp-json/wp/v2/pages/7" /><link rel="EditURI" type="application/rsd+xml" title="RSD" href="https://demo.colorlib.com/tyche/xmlrpc.php?rsd" />
<link rel="wlwmanifest" type="application/wlwmanifest+xml" href="https://demo.colorlib.com/tyche/wp-includes/wlwmanifest.xml" />
<meta name="generator" content="WordPress 5.7.1" />
<meta name="generator" content="WooCommerce 5.2.2" />
<link rel='shortlink' href='https://demo.colorlib.com/tyche/?p=7' />
<link rel="alternate" type="application/json+oembed" href="https://demo.colorlib.com/tyche/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fdemo.colorlib.com%2Ftyche%2Fmy-account%2F" />
<link rel="alternate" type="text/xml+oembed" href="https://demo.colorlib.com/tyche/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fdemo.colorlib.com%2Ftyche%2Fmy-account%2F&#038;format=xml" />


<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/js/functions.js?ver=5.7.1' id='tyche-scripts-js'></script> -->

<link rel="stylesheet" href="../resources/css/bootstrap.css">
	<link rel="stylesheet" href="../resources/css/custom.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
    <script src="../resources/js/bootstrap.js"></script>
    <script src="../resources/js/custom.js"></script>

<style>

	body .btn-primary{
		background-color: #f66249;
    	border-color: red;
	}
	body .btn-primary:hover{
		background-color: #f2a154;
	}
	body .btn-primary.active{
		background-color: #f2a154;
		border-color: red;
	}
	body .btn-primary.active.focus{
		background-color: #f2a154;
		border-color: red;
	}
	body .btn-primary.active:hover{
		background-color: #f66249;
    	border-color: #f2a154;
	}
	body .btn-primary:active:hover{
		background-color: #f66249;
    	border-color: #f2a154;
	}
</style>

</head>

<%
        String userID = null;
        if(session.getAttribute("userID") != null){
        	userID = (String) session.getAttribute("userID");// 겟 세션은 Object 를 리턴
        }
        if(userID != null){
        	session.setAttribute("messageType", "오류");
        	session.setAttribute("messageContent", "현재 로그인이 되어있는 상태입니다.");
        	response.sendRedirect("index.jsp");
        	return;
        }
    %>



<body class="page-template-default page page-id-7 wp-custom-logo theme-tyche woocommerce-account woocommerce-page woocommerce-no-js elementor-default elementor-kit-1236">
<div id="page" class="site">
<jsp:include page="../main/header.jsp"></jsp:include>
<div class="site-content">
<div class="container">
<div class="row">
<div class="col-xs-12">
<div class="tyche-breadcrumbs"><span itemscope itemtype="http://data-vocabulary.org/Breadcrumb"><a itemprop="url" href="https://demo.colorlib.com/tyche"><span itemprop="title">Home </span></a></span><span class="tyche-breadcrumb-sep">/</span><span itemscope itemtype="http://data-vocabulary.org/Breadcrumb"><a itemprop="url" href="https://demo.colorlib.com/tyche/shop/"><span itemprop="title">Shop</span></a></span><span class="tyche-breadcrumb-sep">/</span><span class="breadcrumb-leaf">My account</span></div> </div>
</div>
</div>
<div class="container">
<div class="row">
<div id="primary" class="content-area col-md-12">
<main id="main" class="site-main" role="main">
<article id="post-7" class="post-7 page type-page status-publish hentry">
<div class="row">
<div class="col-md-12">
<header>
<h1 class="page-title margin-top">My account</h1>
</header>
</div>
</div>
<div class="woocommerce"><div class="woocommerce-notices-wrapper"></div>
<h2>Login</h2>
<form class="woocommerce-form woocommerce-form-login login" method="post"action="../user/login.do" >
<p class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide">
<label for="username">아이디&nbsp;<span class="required">*</span></label>
<input type="text" class="woocommerce-Input woocommerce-Input--text input-text" name="userID" id="userID" maxlength="20" /> </p>
<p class="woocommerce-form-row woocommerce-form-row--wide form-row form-row-wide">
<label for="password">비밀번호&nbsp;<span class="required">*</span></label>
<input class="woocommerce-Input woocommerce-Input--text input-text" type="password"name="userPassword" id="userPassword" maxlength="20" />
</p>


<div class="form-group">
	<div class="btn-group" data-toggle="buttons">
		<label class="btn  btn-primary active">
			<input type="radio" name="userType" autocomplete="off" value="고객" checked>고객
		</label>
		<label class="btn  btn-primary">
			<input type="radio" name="userType" autocomplete="off" value="디자이너">디자이너
		</label>
	</div>
</div>


<p class="form-row">
<input type="hidden" id="woocommerce-login-nonce" name="woocommerce-login-nonce" value="8cb402852a" /><input type="hidden" name="_wp_http_referer" value="/tyche/my-account/" /> <button type="submit" class="woocommerce-button button woocommerce-form-login__submit" name="login" value="Log in">Log in</button>
</p>
<p class="woocommerce-LostPassword lost_password">
<a href="../chat/join.do">회원가입</a>
</p>
</form>
</div>
</article>
</main>
</div>
</div>
</div>
</div>
<%
    	String messageContent = null;
    	if(session.getAttribute("messageContent")!=null){
    		messageContent = (String)session.getAttribute("messageContent");
    	}
    	String messageType = null;
    	if(session.getAttribute("messageType")!=null){
    		messageType = (String)session.getAttribute("messageType");
    	}
    	System.out.println("login 에서 : " + messageContent);
    	if(messageContent != null){
    %>
    <div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-hidden="true">
    	<div class="vertical-alignment-helper">
    		<div class="modal-dialog vertical-align-center">
    			<div class="modal-content <%if(messageType.equals("오류")) out.println("panel-warning"); else out.println("panel-success"); %>">
    				<div class="modal-header panel-heading">
    					<button type="button" class="close" data-dismiss="modal">
    						<span aria-hidden="true">&times</span>
    						<span class="sr-only">Close</span>
    					</button>
    					<h4 class="modal-title">
    						<%=messageType %>
    					</h4>
    				</div>
    				<div class="modal-body">
    					<%=messageContent %>
    				</div>
    				<div class="modal-footer">
    					<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <script type="text/javascript">
    	$("#messageModal").modal("show");
    	console.log("쇼!");
    </script>
    <%
    	session.removeAttribute("messageContent");
    	session.removeAttribute("messageType");
    }
    %>
    <div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-hidden="true">
    	<div class="vertical-alignment-helper">
    		<div class="modal-dialog vertical-align-center">
    			<div id="checkType" class="modal-content panel-info">
    				<div class="modal-header panel-heading">
    					<button type="button" class="close" data-dismiss="modal">
    						<span aria-hidden="true">&times</span>
    						<span class="sr-only">Close</span>
    					</button>
    					<h4 class="modal-title">
    						확인 메시지
    					</h4>
    				</div>
    				<div id="checkMessage" class="modal-body"></div>
    				<div class="modal-footer">
    					<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
<jsp:include page="../main/footer.jsp"></jsp:include>
</div>

<!-- <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script> -->
<script type="text/javascript">
		(function () {
			var c = document.body.className;
			c = c.replace(/woocommerce-no-js/, 'woocommerce-js');
			document.body.className = c;
		})();
	</script>
	
<!-- <script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill.min.js?ver=7.4.4' id='wp-polyfill-js'></script>
<script type='text/javascript' id='wp-polyfill-js-after'>
( 'fetch' in window ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-fetch.min.js?ver=3.0.0"></scr' + 'ipt>' );( document.contains ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-node-contains.min.js?ver=3.42.0"></scr' + 'ipt>' );( window.DOMRect ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-dom-rect.min.js?ver=3.42.0"></scr' + 'ipt>' );( window.URL && window.URL.prototype && window.URLSearchParams ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-url.min.js?ver=3.6.4"></scr' + 'ipt>' );( window.FormData && window.FormData.prototype.keys ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-formdata.min.js?ver=3.0.12"></scr' + 'ipt>' );( Element.prototype.matches && Element.prototype.closest ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-element-closest.min.js?ver=2.0.2"></scr' + 'ipt>' );( 'objectFit' in document.documentElement.style ) || document.write( '<script src="https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill-object-fit.min.js?ver=2.3.4"></scr' + 'ipt>' );
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/dist/hooks.min.js?ver=50e23bed88bcb9e6e14023e9961698c1' id='wp-hooks-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/dist/i18n.min.js?ver=db9a9a37da262883343e941c3731bc67' id='wp-i18n-js'></script>
<script type='text/javascript' id='wp-i18n-js-after'>
wp.i18n.setLocaleData( { 'text direction\u0004ltr': [ 'ltr' ] } );
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/lodash.min.js?ver=4.17.19' id='lodash-js'></script>
<script type='text/javascript' id='lodash-js-after'>
window.lodash = _.noConflict();
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/dist/url.min.js?ver=0ac7e0472c46121366e7ce07244be1ac' id='wp-url-js'></script>
<script type='text/javascript' id='wp-api-fetch-js-translations'>
( function( domain, translations ) {
	var localeData = translations.locale_data[ domain ] || translations.locale_data.messages;
	localeData[""].domain = domain;
	wp.i18n.setLocaleData( localeData, domain );
} )( "default", { "locale_data": { "messages": { "": {} } } } );
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/dist/api-fetch.min.js?ver=a783d1f442d2abefc7d6dbd156a44561' id='wp-api-fetch-js'></script>
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
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/contact-form-7/includes/js/index.js?ver=5.4' id='contact-form-7-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/jquery-blockui/jquery.blockUI.min.js?ver=2.70' id='jquery-blockui-js'></script>
<script type='text/javascript' id='wc-add-to-cart-js-extra'>
/* <![CDATA[ */
var wc_add_to_cart_params = {"ajax_url":"\/tyche\/wp-admin\/admin-ajax.php","wc_ajax_url":"\/tyche\/?wc-ajax=%%endpoint%%","i18n_view_cart":"View cart","cart_url":"https:\/\/demo.colorlib.com\/tyche\/cart\/","is_cart":"","cart_redirect_after_add":"no"};
/* ]]> */
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/frontend/add-to-cart.min.js?ver=5.2.2' id='wc-add-to-cart-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/selectWoo/selectWoo.full.min.js?ver=1.0.6' id='selectWoo-js'></script>
<script type='text/javascript' id='password-strength-meter-js-extra'>
/* <![CDATA[ */
var pwsL10n = {"unknown":"Password strength unknown","short":"Very weak","bad":"Weak","good":"Medium","strong":"Strong","mismatch":"Mismatch"};
/* ]]> */
</script>
<script type='text/javascript' id='password-strength-meter-js-translations'>
( function( domain, translations ) {
	var localeData = translations.locale_data[ domain ] || translations.locale_data.messages;
	localeData[""].domain = domain;
	wp.i18n.setLocaleData( localeData, domain );
} )( "default", { "locale_data": { "messages": { "": {} } } } );
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-admin/js/password-strength-meter.min.js?ver=5.7.1' id='password-strength-meter-js'></script>
<script type='text/javascript' id='wc-password-strength-meter-js-extra'>
/* <![CDATA[ */
var wc_password_strength_meter_params = {"min_password_strength":"3","stop_checkout":"","i18n_password_error":"Please enter a stronger password.","i18n_password_hint":"Hint: The password should be at least twelve characters long. To make it stronger, use upper and lower case letters, numbers, and symbols like ! \" ? $ % ^ & )."};
/* ]]> */
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/frontend/password-strength-meter.min.js?ver=5.2.2' id='wc-password-strength-meter-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/js-cookie/js.cookie.min.js?ver=2.1.4' id='js-cookie-js'></script>
<script type='text/javascript' id='woocommerce-js-extra'>
/* <![CDATA[ */
var woocommerce_params = {"ajax_url":"\/tyche\/wp-admin\/admin-ajax.php","wc_ajax_url":"\/tyche\/?wc-ajax=%%endpoint%%"};
/* ]]> */
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/frontend/woocommerce.min.js?ver=5.2.2' id='woocommerce-js'></script>
<script type='text/javascript' id='wc-cart-fragments-js-extra'>
/* <![CDATA[ */
var wc_cart_fragments_params = {"ajax_url":"\/tyche\/wp-admin\/admin-ajax.php","wc_ajax_url":"\/tyche\/?wc-ajax=%%endpoint%%","cart_hash_key":"wc_cart_hash_c7ba160b83b4cf4fe4c311fa6b89b05c","fragment_name":"wc_fragments_c7ba160b83b4cf4fe4c311fa6b89b05c","request_timeout":"5000"};
/* ]]> */
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/frontend/cart-fragments.min.js?ver=5.2.2' id='wc-cart-fragments-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/js/skip-link-focus-fix.js?ver=5.7.1' id='tyche-skip-link-focus-fix-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/menu/menu.min.js?ver=5.7.1' id='tyche-multilang-menu-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/wp-embed.min.js?ver=5.7.1' id='wp-embed-js'></script>
<script>window.GA_ID='';</script><script src='https://demo.colorlib.com/tyche/wp-content/plugins/flying-analytics/js/minimal-analytics.js' defer></script> -->
</body></html>
