<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
        String userID = null;
        if(session.getAttribute("userID") != null){
        	userID = (String) session.getAttribute("userID");// 겟 세션은 Object 를 리턴
        }
        
        if(userID == null){
        	response.sendRedirect("../chat/login.do");
        	return;
        }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="profile" href="https://gmpg.org/xfn/11">
<link rel="pingback" href="https://demo.colorlib.com/tyche/xmlrpc.php">
<meta name='robots' content='noindex, nofollow' />

<title>그려주세요 등록</title>
<script src="{{asset("/ckeditor5_custom/build/ckeditor.js")}}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="../resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<meta name="robots" content="noindex, follow, max-snippet:-1, max-image-preview:large, max-video-preview:-1" />
<meta property="og:locale" content="en_US" />
<meta property="og:type" content="website" />
<meta property="og:title" content="Home - Tyche Demo" />
<meta property="og:url" content="https://demo.colorlib.com/tyche/" />
<meta property="og:site_name" content="Tyche Demo" />
<meta property="article:author" content="http://facebook.com/silkalns" />
<meta property="article:modified_time" content="2020-10-22T08:33:44+00:00" />
<meta name="twitter:card" content="summary" />
<meta name="twitter:creator" content="@https://twitter.com/ASilkalns" />
<script type="application/ld+json" class="yoast-schema-graph">{"@context":"https://schema.org","@graph":[{"@type":"WebSite","@id":"https://demo.colorlib.com/tyche/#website","url":"https://demo.colorlib.com/tyche/","name":"Tyche Demo","description":"Just another colorlib.com site","potentialAction":[{"@type":"SearchAction","target":"https://demo.colorlib.com/tyche/?s={search_term_string}","query-input":"required name=search_term_string"}],"inLanguage":"en-US"},{"@type":"WebPage","@id":"https://demo.colorlib.com/tyche/#webpage","url":"https://demo.colorlib.com/tyche/","name":"Home - Tyche Demo","isPartOf":{"@id":"https://demo.colorlib.com/tyche/#website"},"datePublished":"2017-05-24T06:16:36+00:00","dateModified":"2020-10-22T08:33:44+00:00","inLanguage":"en-US","potentialAction":[{"@type":"ReadAction","target":["https://demo.colorlib.com/tyche/"]}]}]}</script>

<link rel='dns-prefetch' href='//fonts.googleapis.com' />
<link rel='dns-prefetch' href='//s.w.org' />
<link rel="alternate" type="application/rss+xml" title="Tyche Demo &raquo; Feed" href="https://demo.colorlib.com/tyche/feed/" />
<link rel="alternate" type="application/rss+xml" title="Tyche Demo &raquo; Comments Feed" href="https://demo.colorlib.com/tyche/comments/feed/" />
<link rel="alternate" type="application/rss+xml" title="Tyche Demo &raquo; Home Comments Feed" href="https://demo.colorlib.com/tyche/home/feed/" />
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
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/owl-carousel/owl.carousel.min.js?ver=1.3.3' id='owlCarousel-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/vendors/jquery-zoom/jquery.zoom.min.js?ver=1.3.3' id='jquery-zoom-js'></script>
<script type='text/javascript' id='tyche-scripts-js-extra'>
/* <![CDATA[ */
var tycheHelper = {"initZoom":"1","ajaxURL":"https:\/\/demo.colorlib.com\/tyche\/wp-admin\/admin-ajax.php"};
/* ]]> */
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/themes/tyche/assets/js/functions.js?ver=5.7.1' id='tyche-scripts-js'></script>
<link rel="https://api.w.org/" href="https://demo.colorlib.com/tyche/wp-json/" /><link rel="alternate" type="application/json" href="https://demo.colorlib.com/tyche/wp-json/wp/v2/pages/2" /><link rel="EditURI" type="application/rsd+xml" title="RSD" href="https://demo.colorlib.com/tyche/xmlrpc.php?rsd" />
<link rel="wlwmanifest" type="application/wlwmanifest+xml" href="https://demo.colorlib.com/tyche/wp-includes/wlwmanifest.xml" />
<meta name="generator" content="WordPress 5.7.1" />
<meta name="generator" content="WooCommerce 5.2.2" />
<link rel='shortlink' href='https://demo.colorlib.com/tyche/' />
<link rel="alternate" type="application/json+oembed" href="https://demo.colorlib.com/tyche/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fdemo.colorlib.com%2Ftyche%2F" />
<link rel="alternate" type="text/xml+oembed" href="https://demo.colorlib.com/tyche/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fdemo.colorlib.com%2Ftyche%2F&#038;format=xml" />
<meta name="jetpack-boost-config-id" content="" />
<meta name="jetpack-boost-ready" content="true" />
<noscript><style>.woocommerce-product-gallery{ opacity: 1 !important; }</style></noscript>
<script type="text/javascript">var ajaxurl = 'https://demo.colorlib.com/tyche/wp-admin/admin-ajax.php';</script>
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
<script src="../resources/js/bootstrap.js"></script>
<style id="kirki-inline-styles"></style>
<!-- ************************************************************************************************************* -->


<script>
	$(function() {
		$("#save").click(function() {
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
			$("#frm").submit();
		})
	})
</script>
	
<style>
	#title {
		width: 99%;
		height: 40px;
		margin-bottom: 5px;
	}

	#frm {
		margin: 20px 0;
	}
	
	#ir1 {
		width: 99%;
		height: 500px;		
	}
	
	.btn {
		margin: 10px 10px;
	}
	
	#save {
		margin-left: 494px;
	}
</style>

<!-- ************************************************************************************************************* -->
</head>
<body class="home page-template-default page page-id-2 wp-custom-logo theme-tyche woocommerce-no-js elementor-default elementor-kit-1236">
<div id="page" class="site">
<jsp:include page="../main/header.jsp"></jsp:include>

<div id="smarteditor" class="container">
	<form id="frm" action="registerboard" method="post" >
		<input type="text" id="title" placeholder="제목을 입력해 주세요."/>
		<textarea id="ir1" name="content"></textarea>
		<input type="file" id="file"/>
		<input type="button" id="save" value="저장" class="btn"/><input type="button" id ="cancel" value="취소" class="btn" onclick="location.href='requestList.do'"/>
	</form>
</div>

<jsp:include page="../main/footer.jsp"></jsp:include>

</div>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script type="text/javascript">
		(function () {
			var c = document.body.className;
			c = c.replace(/woocommerce-no-js/, 'woocommerce-js');
			document.body.className = c;
		})();
	</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/dist/vendor/wp-polyfill.min.js?ver=7.4.4' id='wp-polyfill-js'></script>
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
<script>window.GA_ID='';</script><script src='https://demo.colorlib.com/tyche/wp-content/plugins/flying-analytics/js/minimal-analytics.js' defer></script>
</body>
<script>
	var oEditors = [];
	
	nhn.husky.EZCreator.createInIFrame({
	  oAppRef : oEditors,
	  elPlaceHolder : "ir1",
	  sSkinURI : "../resources/editor/SmartEditor2Skin.html",
	  fCreator : "createSEditor2",
	  htParams : {
		  // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		  bUseToolbar : true,
		  // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		  bUseVerticalResizer : false,
		  // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		  bUseModeChanger : false,
		  fOnBeforeUnload : function(){
			  
		  }
		},
		fOnAppLoad : function(){
			//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
			oEditors.getById["ir1"].exec("PASTE_HTML", [""]);
		}
	});
</script>
</html>