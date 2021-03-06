<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
    String userID = null;
    if(session.getAttribute("userID") != null){
    	userID = (String) session.getAttribute("userID");// 겟 세션은 Object 를 리턴
    }
    
    pageContext.setAttribute("currentLoginID", userID);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="profile" href="https://gmpg.org/xfn/11">
<link rel="pingback" href="https://demo.colorlib.com/tyche/xmlrpc.php">
<meta name='robots' content='noindex, nofollow' />

<title>드로잉샵 상세</title>
<meta name="robots" content="noindex, follow, max-snippet:-1, max-image-preview:large, max-video-preview:-1" />
<meta property="og:locale" content="en_US" />
<meta property="og:type" content="article" />
<meta property="og:title" content="Black Top - Tyche Demo" />
<meta property="og:description" content="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." />
<meta property="og:url" content="https://demo.colorlib.com/tyche/product/black-top/" />
<meta property="og:site_name" content="Tyche Demo" />
<meta property="article:author" content="http://facebook.com" />
<meta property="article:modified_time" content="2021-03-29T13:59:24+00:00" />
<meta property="og:image" content="https://demo.colorlib.com/tyche/wp-content/uploads/sites/64/2017/06/woman-1477091_1920.jpg" />
<meta property="og:image:width" content="1920" />
<meta property="og:image:height" content="1281" />
<meta name="twitter:card" content="summary" />
<meta name="twitter:creator" content="@http://twitter.com" />
<script type="application/ld+json" class="yoast-schema-graph">{"@context":"https://schema.org","@graph":[{"@type":"WebSite","@id":"https://demo.colorlib.com/tyche/#website","url":"https://demo.colorlib.com/tyche/","name":"Tyche Demo","description":"Just another colorlib.com site","potentialAction":[{"@type":"SearchAction","target":"https://demo.colorlib.com/tyche/?s={search_term_string}","query-input":"required name=search_term_string"}],"inLanguage":"en-US"},{"@type":"ImageObject","@id":"https://demo.colorlib.com/tyche/product/black-top/#primaryimage","inLanguage":"en-US","url":"https://demo.colorlib.com/tyche/wp-content/uploads/sites/64/2017/06/woman-1477091_1920.jpg","width":1920,"height":1281},{"@type":"WebPage","@id":"https://demo.colorlib.com/tyche/product/black-top/#webpage","url":"https://demo.colorlib.com/tyche/product/black-top/","name":"Black Top - Tyche Demo","isPartOf":{"@id":"https://demo.colorlib.com/tyche/#website"},"primaryImageOfPage":{"@id":"https://demo.colorlib.com/tyche/product/black-top/#primaryimage"},"datePublished":"2017-06-12T06:59:33+00:00","dateModified":"2021-03-29T13:59:24+00:00","inLanguage":"en-US","potentialAction":[{"@type":"ReadAction","target":["https://demo.colorlib.com/tyche/product/black-top/"]}]}]}</script>

<link rel='dns-prefetch' href='//fonts.googleapis.com' />
<link rel='dns-prefetch' href='//s.w.org' />
<link rel="alternate" type="application/rss+xml" title="Tyche Demo &raquo; Feed" href="https://demo.colorlib.com/tyche/feed/" />
<link rel="alternate" type="application/rss+xml" title="Tyche Demo &raquo; Comments Feed" href="https://demo.colorlib.com/tyche/comments/feed/" />
<link rel="alternate" type="application/rss+xml" title="Tyche Demo &raquo; Black Top Comments Feed" href="https://demo.colorlib.com/tyche/product/black-top/feed/" />
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
<link rel='stylesheet' id='photoswipe-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/photoswipe/photoswipe.min.css?ver=5.2.2' type='text/css' media='all' />
<link rel='stylesheet' id='photoswipe-default-skin-css' href='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/css/photoswipe/default-skin/default-skin.min.css?ver=5.2.2' type='text/css' media='all' />
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
<link rel="https://api.w.org/" href="https://demo.colorlib.com/tyche/wp-json/" /><link rel="alternate" type="application/json" href="https://demo.colorlib.com/tyche/wp-json/wp/v2/product/19" /><link rel="EditURI" type="application/rsd+xml" title="RSD" href="https://demo.colorlib.com/tyche/xmlrpc.php?rsd" />
<link rel="wlwmanifest" type="application/wlwmanifest+xml" href="https://demo.colorlib.com/tyche/wp-includes/wlwmanifest.xml" />
<meta name="generator" content="WordPress 5.7.1" />
<meta name="generator" content="WooCommerce 5.2.2" />
<link rel='shortlink' href='https://demo.colorlib.com/tyche/?p=19' />
<link rel="alternate" type="application/json+oembed" href="https://demo.colorlib.com/tyche/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fdemo.colorlib.com%2Ftyche%2Fproduct%2Fblack-top%2F" />
<link rel="alternate" type="text/xml+oembed" href="https://demo.colorlib.com/tyche/wp-json/oembed/1.0/embed?url=https%3A%2F%2Fdemo.colorlib.com%2Ftyche%2Fproduct%2Fblack-top%2F&#038;format=xml" />
<meta name="jetpack-boost-config-id" content="" />
<meta name="jetpack-boost-ready" content="true" />
<!-- <noscript><style>.woocommerce-product-gallery{ opacity: 1 !important; }</style></noscript>
<script type="text/javascript">var ajaxurl = 'https://demo.colorlib.com/tyche/wp-admin/admin-ajax.php';</script> -->
<link rel="stylesheet" href="../resources/css/bootstrap.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
<script src="../resources/js/bootstrap.js"></script>
<style id="kirki-inline-styles"></style>

<link rel="stylesheet" href="../resources/css/bootstrap.css">
<link rel="stylesheet" href="../resources/css/custom.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
<script src="../resources/js/bootstrap.js"></script>

<style>
	@font-face {
    font-family: 'GyeonggiTitleM';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/GyeonggiTitleM.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}

	.form-submit {
		height: 41px;
	}
	
	.woocommerce #review_form #respond .form-submit input {
		margin: 1px 0;
	}
	
	.comment-list {
		padding-left: 0;
	}
	
	#comment {
		resize:none;
	}
	
	#replyBtn {
		float: right;
		margin-right: 12px;
	}
	
	#review {
		width: 95%;
		float: left;
	}
	
	.form-submit {
		float: left;
	}
	
	.woocommerce div.product .woocommerce-tabs {
		margin-bottom: 50px;
	}
	
	#designerProfile {
		height: 140px;
	}
	
	#profileMent {
		font-family:'GyeonggiTitleM';
		font-size: x-large;
	}
	
	#saleTitle {
		font-family:'GyeonggiTitleM';
	}
	
	.reviewRate {
		color:#FFAB1A;
		font-size: large;
	}
	
	.reviewContent {
		font-family:'GyeonggiTitleM';
	}
	
	article {
		height: 100px;
		margin-bottom: 10px;
	}
	
	.woocommerce #review_form #respond #modifyReply {
		width: 300px;
		resize: none;
	}
	
	#modifyRating {
		width: 50px;
	}
</style>

<script>
	$(function() {		
		/* function comma(x) {
		    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		} */
		/* $("#pri").text(comma('${saleBoard.salePrice}')); */
		$("#pri").text('${saleBoard.salePrice}');

		$("#scart").val('${scart}')
		
		// 삭제 버튼 클릭
		$("#deleteBtn").click(function() {
			if (confirm("정말로 삭제하시겠습니까?")) {
				location.href = "deleteSaleBoard.do?saleNum="+${saleBoard.saleNum}
			}
		})
		
		// 구매하기 버튼 클릭
		$('#purchase').click(function() {
			if ('${currentLoginID}' == "") {
				alert("로그인 후 이용하실 수 있습니다.")
				return
			}
			
			if (confirm("정말로 구매하시겠습니까?")) {
				location.href="purchase.do?saleNum=${saleBoard.saleNum}&saleTitle=${saleBoard.saleTitle}&dealBuyerId=${currentLoginID}&dealSellerId=${saleBoard.designerId}&dealPrice=${saleBoard.salePrice}&dealImage=${saleBoard.saleImage}"
			}
		});
		
		$('#replyBtn').click(function(){				
				if ('${currentLoginID}' == "") {
					alert("로그인 후 이용하실 수 있습니다.")
					return
				}
			
				if ($("#comment").val() == "" || $("#rating option:selected").val() == "") {
					alert("평점과 리뷰를 모두 입력하세요")
					return
				}
			
				//serialize() jquery api 메소드를 이용해서 form 의 모든 element의 name과 value 값을 넘길수 있음!!         
		        // var params = $('#replyFrm').serialize();
			
				$.ajax({
	             	type :'post',	             	  
	             	data : {
	             		saleNum: ${saleBoard.saleNum},
						userId: '${currentLoginID}',
	             		reviewRate: $("#rating option:selected").val(),
	             		reviewComment: $("#comment").val()
	             	},
	             	contentType : "application/x-www-form-urlencoded; charset=UTF-8",
	             	url : 'reply/new.do',
	             	success : function(result){
	             		var replyList = $('#replyList');
	             		replyList.empty();
	             		replyListView();
	             		$("#reply").val("");
	             		$("#replyRate").val("");
	             		
	             	},
	            	error : function(err){
	            		alert('error');
	            		console.log(err);
	            	}
		       }); // end of ajax
		}); // end of click
		
		// 삭제 버튼 클릭
		$('#replyList').on("click", ".deleteReply", function() {
			if (confirm("정말로 삭제하시겠습니까?")) {
				console.log($(this).parent().parent().children().children('.saleNum').children().val())
				console.log($(this).parent().parent().children().children('.reviewNum').children().val())
				$.ajax({
		         	type :'get',            	  
		         	data : {
		         		saleNum:$(this).parent().parent().children().children('.saleNum').children().val(),
		         		reviewNum:$(this).parent().parent().children().children('.reviewNum').children().val()
		         	},
		         	url : 'reply/delete.do',
		         	success : function(result){
		         		var replyList = $('#replyList');
		         		replyList.empty();
		         		replyListView();
		         	},
		        	error : function(err){
		        		alert('error');
		        		console.log(err);
		        	}
				}); // end of ajax
			}
		});
		
		// 수정 버튼 클릭
		$('#replyList').on("click", ".modifyReply", function(){
			var reviewRate = $(this).parent().parent().children().children('.reviewRate').children().text()
			var reviewComment = $(this).parent().parent().children().children('.reviewComment').children().text()
			// $(this).parent().parent().children().children('.reviewRate').html('<span class="replyContent"></span><input type="number" name="auctionPrice" id="modifyAuctionPrice"/>')
			$(this).parent().parent().children().children('.reviewRate').html('<select name="reviewRate" id="modifyRating" required><option value="">평점</option>'+
					'<option value="5" id="5">5</option><option value="4" id="4">4</option><option value="3" id="3">3</option>'+
					'<option value="2" id="2">2</option><option value="1" id="1">1</option></select>')
			
			$(this).parent().parent().children().children('.reviewComment').html('<textarea type="text" id="modifyReply" name="auctionComment" placeholder="수정할 댓글을 입력하세요.">'+reviewComment+'</textarea>')
			$(this).val("등록")
			$(this).attr("class","modifyRegister")
			$(this).next().next().val("취소")
			$(this).next().next().attr("class", "cancel")
		});
		
		// 수정하기
		$('#replyList').on("click", ".modifyRegister", function(){
			var reviewRate = $(this).parent().parent().children().children('.reviewRate').children().val()
			var reviewComment = $(this).parent().parent().children().children('.reviewComment').children().val()
			
			if(reviewRate == "" || reviewComment == "") {
				alert("평점과 리뷰를 모두 입력하세요")
				return
			}
			
			console.log($(this).parent().parent().children().children('.saleNum').children().val())
        		console.log($(this).parent().parent().children().children('.reviewNum').children().val())
        		console.log($(this).parent().parent().children().children('.reviewRate').children().val())
        		console.log($(this).parent().parent().children().children('.reviewComment').children().val())
        		
			$.ajax({
				type :'post',
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
             	data : {
             		saleNum:$(this).parent().parent().children().children('.saleNum').children().val(),
             		reviewNum:$(this).parent().parent().children().children('.reviewNum').children().val(),
             		reviewRate:$(this).parent().parent().children().children('.reviewRate').children().val(),
             		reviewComment:$(this).parent().parent().children().children('.reviewComment').children().val()
             	},
             	url : 'reply/modify.do',
             	success : function(result){
             		var replyList = $('#replyList');
             		replyList.empty();
             		replyListView();
             	},
            	error : function(err){
            		alert('error');
            		console.log(err);
            	}
			}); // end of ajax
		});
		
		$('#replyList').on("click", ".cancel", function(){
			var replyList = $('#replyList');
        		replyList.empty();
        		replyListView();
		});
		
		replyListView();
		function replyListView(){
			$.ajax({
	     	type :'get',
	     	url : 'reply.do?saleNum=${saleBoard.saleNum}',
	     	dataType : 'json',
	     	success : function(result){
	     		// alert(result);
	     		console.log(result);
	     		// 화면에 출력
	     		var replyList = $('#replyList');
	     		for(row of result){
	     			var article = $('<article/>');
	     				var reviewDiv = $('<div id="review"/>');
	     				
	     					var saleNumDiv = $('<div class="saleNum"/>');
		     				var reviewNumDiv = $('<div class="reviewNum"/>');
		     				var reviewerDiv = $('<div class="reviewer"/>');
		     				var reviewRateDiv = $('<div class="reviewRate"/>');
		     				var reviewRateNumDiv = $('<div class="reviewRateNum"/>');
		     				var reviewCommentDiv = $('<div class="reviewComment"/>');
		     				var reviewDateDiv = $('<div class="replyDate"/>');			     				
		     				
		     					var saleNum = $('<input type="hidden">').attr('value', '${saleBoard.saleNum}');
		     					var reviewNum = $('<input type="hidden">').attr('value', row["reviewNum"]);
			     				var reviewer = $('<span class="reviewContent"/>').html('작성자: ' + row["userId"]);
			     								     				
			     				var starRate = ""
			     				for(var i = 0; i < row["reviewRate"]; i++) {
			     					starRate += '★'
			     				}
			     				for(var i = 0; i < 5 - row["reviewRate"]; i++) {
			     					starRate += '☆'
			     				}
			     					
			     				var reviewRate = $('<span class="reviewContent"/>').html(starRate);
			     				var reviewRateNum = $('<input type="hidden">').html(row["reviewRate"]);
			     				var reviewComment = $('<span class="reviewContent"/>').html(row["reviewComment"]);
			     				var reviewDate = $('<span class="reviewContent"/>').html(row["reviewDate"]);
			     				
			     				saleNumDiv.append(saleNum);
			     				reviewDiv.append(saleNumDiv);
			     				
			     				reviewNumDiv.append(reviewNum);
			     				reviewDiv.append(reviewNumDiv);
			     				
			     				reviewerDiv.append(reviewer);
			     				reviewDiv.append(reviewerDiv);
			     				
			     				reviewRateDiv.append(reviewRate);
			     				reviewDiv.append(reviewRateDiv);
			     				
			     				reviewRateNumDiv.append(reviewRateNum);
			     				reviewDiv.append(reviewRateNumDiv);
			     				
			     				reviewCommentDiv.append(reviewComment);
			     				reviewDiv.append(reviewCommentDiv);
			     				
			     				reviewDateDiv.append(reviewDate);	
			     				reviewDiv.append(reviewDateDiv);
			     				
			     				article.append(reviewDiv);
	     			
			     		if(row["userId"] == '${currentLoginID}') {
		     				var commentBtn = $('<div class="form-submit"/>');
		     					commentBtn.append('<input type="button" class="modifyReply" value="수정"/><br>');
		     					commentBtn.append('<input type="button" class="deleteReply" value="삭제"/>');
		     				article.append(commentBtn);
			     		}
	     				
	     			replyList.append(article);
	     		}
	     	},
	    	error : function(request, status, err){
	    		alert('error');
	    		console.log(err);
	    	}
	       }); // end of ajax 
		}
		
		$("#scart").click(function(){
			if ('${currentLoginID}' == "") {
				alert("로그인 후 이용하실 수 있습니다.")
				return
			}
			
			let userID = "${sessionScope.userID}";
			let saleNum = "${saleBoard.saleNum}";
			$.ajax({
				data:{userId: userID,
					saleNum:saleNum},
				type:"post",
				dataType:"text",
				url:"checkCart.do",
				success:Check,
				error:function(error){
					alert("에러");
					console.log(error);
				}
			})
			function Check(star){
				$("#scart").val(star);
				if(star=="찜하기"){
					$("#checkMessage").html("찜에서 해제되었습니다.");
					$("checkType").attr("class","modal-content panel-warning");
				}else{
					flag=true;
					$("#checkMessage").html("찜에 등록되었습니다.");
					$("#checkType").attr("class","modal-content panel-success");
				}
				$("#checkModal").modal("show");
			}
		})
	})
</script>

</head>
<body class="product-template-default single single-product postid-19 wp-custom-logo theme-tyche woocommerce woocommerce-page woocommerce-no-js elementor-default elementor-kit-1236">
<div id="page" class="site">

<jsp:include page="../main/header.jsp"></jsp:include>
<br>
<div class="site-content">
<div class="container">
<div class="row">
<div class="col-md-12">
<div class="woocommerce-notices-wrapper"></div><div id="product-19" class="product type-product post-19 status-publish first instock product_cat-tops product_cat-trends has-post-thumbnail taxable shipping-taxable purchasable product-type-simple">
<div class="woocommerce-product-gallery woocommerce-product-gallery--with-images woocommerce-product-gallery--columns-4 images" data-columns="4" style="opacity: 0; transition: opacity .25s ease-in-out;">
<figure class="woocommerce-product-gallery__wrapper">
<div data-thumb="${saleBoard.saleImage}" class="woocommerce-product-gallery__image">
<img width="540" height="360" src="${saleBoard.saleImage}" class="wp-post-image" data-src="${saleBoard.saleImage}" data-large_image="${saleBoard.saleImage}" data-large_image_width="1920" data-large_image_height="1281" srcset="${saleBoard.saleImage} 1920w, ${saleBoard.saleImage} 300w, ${saleBoard.saleImage} 768w, ${saleBoard.saleImage} 1024w" sizes="(max-width: 540px) 100vw, 540px" />
</div>
</figure>
</div>
<div class="summary entry-summary">
<h1 class="product_title entry-title" id="saleTitle">${saleBoard.saleTitle}</h1>
<div class="meta">
<ul class="meta-list"><li class="post-author"><icon class="fa fa-user"></icon> By <a href="../designer/profile.do?designerId=${saleBoard.designerId}">
<c:choose>
	<c:when test="${empty saleBoard.designerNickname}">${saleBoard.designerId}</c:when>
	<c:otherwise>${saleBoard.designerNickname}</c:otherwise>
</c:choose>
</a></li><span class="sep">평점:&nbsp${saleBoard.saleRate} &nbsp/&nbsp 조회수: ${saleBoard.saleView}</span></ul>
</div>
<div class="woocommerce-product-details__short-description">
<div id="designerProfile">
<span id="profileMent">디자이너를 소개합니다.</span><br>
${saleBoard.designerProfile}
</div>
</div>
<p class="price"><span class="woocommerce-Price-amount amount"><bdi><span class="woocommerce-Price-currencySymbol"></span><span id="pri"></span>원</bdi></span></p>

<c:choose>
	<c:when test="${saleBoard.designerId == currentLoginID}">
		<input type="button" value="수정" id="modifyBtn" onClick="location.href='modifySaleBoard.do?saleNum=${saleBoard.saleNum}'"></input>
		<input type="button" value="삭제" id="deleteBtn"></input>
	</c:when>
	<c:otherwise>
		<input type="button" value="찜하기" id="scart"></input>
		<input type="button" value="구매하기" id="purchase"></input>
	</c:otherwise>
</c:choose>


</div>
<div class="woocommerce-tabs wc-tabs-wrapper">
<ul class="tabs wc-tabs tyche-wc-tabs" role="tablist">
<li class="description_tab" id="tab-title-description" role="tab" aria-controls="tab-description">
<a href="#tab-description">상세 설명</a>
</li>
<li class="reviews_tab" id="tab-title-reviews" role="tab" aria-controls="tab-reviews">
<a href="#tab-reviews">리뷰</a>
</li>
</ul>

<div class="woocommerce-Tabs-panel woocommerce-Tabs-panel--description panel entry-content wc-tab" id="tab-description" role="tabpanel" aria-labelledby="tab-title-description">
<h2>작품 소개</h2>
<div>${saleBoard.saleContent}</div>
</div>

<div class="woocommerce-Tabs-panel woocommerce-Tabs-panel--reviews panel entry-content wc-tab" id="tab-reviews" role="tabpanel" aria-labelledby="tab-title-reviews">
<div id="reviews" class="woocommerce-Reviews">

<div id="comments">
<h2 class="woocommerce-Reviews-title">
리뷰 등록</h2>
</div>

<div id="review_form_wrapper">
<div id="review_form">
<div id="respond" class="comment-respond">
<form method="post" id="replyFrm" class="comment-form" novalidate>
<div class="comment-form-rating"><label for="rating">* 평점</label>
<input type="hidden" name="saleNum" value="${saleBoard.saleNum}"/>
<input type="hidden" name="userId" value="${currentLoginID}">
<select name="reviewRate" id="rating" required>
<option value="">평점</option>
<option value="5">5</option>
<option value="4">4</option>
<option value="3">3</option>
<option value="2">2</option>
<option value="1">1</option>
</select></div>
<p class="comment-form-comment"><label for="comment">* 리뷰 작성</label><textarea id="comment" name="reviewComment" cols="45" rows="8" required></textarea></p>
<input id="replyBtn" type="button" value="등록"></input>
</form>
<hr>
<ol class="comment-list">
	<li id="replyList" class="comment even thread-even depth-1">
		
	</li>
</ol>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</main></div> </div>
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
<script type="application/ld+json">{"@context":"https:\/\/schema.org\/","@graph":[{"@context":"https:\/\/schema.org\/","@type":"BreadcrumbList","itemListElement":[{"@type":"ListItem","position":1,"item":{"name":"Home","@id":"https:\/\/demo.colorlib.com\/tyche"}},{"@type":"ListItem","position":2,"item":{"name":"Tops","@id":"https:\/\/demo.colorlib.com\/tyche\/product-category\/tops\/"}},{"@type":"ListItem","position":3,"item":{"name":"Black Top","@id":"https:\/\/demo.colorlib.com\/tyche\/product\/black-top\/"}}]},{"@context":"https:\/\/schema.org\/","@type":"Product","@id":"https:\/\/demo.colorlib.com\/tyche\/product\/black-top\/#product","name":"Black Top","url":"https:\/\/demo.colorlib.com\/tyche\/product\/black-top\/","description":"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.","image":"https:\/\/demo.colorlib.com\/tyche\/wp-content\/uploads\/sites\/64\/2017\/06\/woman-1477091_1920.jpg","sku":19,"offers":[{"@type":"Offer","price":"35.00","priceValidUntil":"2022-12-31","priceSpecification":{"price":"35.00","priceCurrency":"USD","valueAddedTaxIncluded":"false"},"priceCurrency":"USD","availability":"http:\/\/schema.org\/InStock","url":"https:\/\/demo.colorlib.com\/tyche\/product\/black-top\/","seller":{"@type":"Organization","name":"Tyche Demo","url":"https:\/\/demo.colorlib.com\/tyche"}}]}]}</script>
<div class="pswp" tabindex="-1" role="dialog" aria-hidden="true">
<div class="pswp__bg"></div>
<div class="pswp__scroll-wrap">
<div class="pswp__container">
<div class="pswp__item"></div>
<div class="pswp__item"></div>
<div class="pswp__item"></div>
</div>
<div class="pswp__ui pswp__ui--hidden">
<div class="pswp__top-bar">
<div class="pswp__counter"></div>
<button class="pswp__button pswp__button--close" aria-label="Close (Esc)"></button>
<button class="pswp__button pswp__button--share" aria-label="Share"></button>
<button class="pswp__button pswp__button--fs" aria-label="Toggle fullscreen"></button>
<button class="pswp__button pswp__button--zoom" aria-label="Zoom in/out"></button>
<div class="pswp__preloader">
<div class="pswp__preloader__icn">
<div class="pswp__preloader__cut">
<div class="pswp__preloader__donut"></div>
</div>
</div>
</div>
</div>
<div class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
<div class="pswp__share-tooltip"></div>
</div>
<button class="pswp__button pswp__button--arrow--left" aria-label="Previous (arrow left)"></button>
<button class="pswp__button pswp__button--arrow--right" aria-label="Next (arrow right)"></button>
<div class="pswp__caption">
<div class="pswp__caption__center"></div>
</div>
</div>
</div>
</div>
<script type="text/javascript">
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
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/zoom/jquery.zoom.min.js?ver=1.7.21' id='zoom-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/flexslider/jquery.flexslider.min.js?ver=2.7.2' id='flexslider-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/photoswipe/photoswipe.min.js?ver=4.1.1' id='photoswipe-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/photoswipe/photoswipe-ui-default.min.js?ver=4.1.1' id='photoswipe-ui-default-js'></script>
<script type='text/javascript' id='wc-single-product-js-extra'>
/* <![CDATA[ */
var wc_single_product_params = {"i18n_required_rating_text":"Please select a rating","review_rating_required":"yes","flexslider":{"rtl":false,"animation":"slide","smoothHeight":true,"directionNav":false,"controlNav":"thumbnails","slideshow":false,"animationSpeed":500,"animationLoop":false,"allowOneSlide":false},"zoom_enabled":"1","zoom_options":[],"photoswipe_enabled":"1","photoswipe_options":{"shareEl":false,"closeOnScroll":false,"history":false,"hideAnimationDuration":0,"showAnimationDuration":0},"flexslider_enabled":"1"};
/* ]]> */
</script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-content/plugins/woocommerce/assets/js/frontend/single-product.min.js?ver=5.2.2' id='wc-single-product-js'></script>
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
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/comment-reply.min.js?ver=5.7.1' id='comment-reply-js'></script>
<script type='text/javascript' src='https://demo.colorlib.com/tyche/wp-includes/js/wp-embed.min.js?ver=5.7.1' id='wp-embed-js'></script>
<script>window.GA_ID='';</script><script src='https://demo.colorlib.com/tyche/wp-content/plugins/flying-analytics/js/minimal-analytics.js' defer></script>
</body></html>
