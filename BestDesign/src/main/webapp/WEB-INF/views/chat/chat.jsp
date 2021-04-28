<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
        String userID = null;
        if(session.getAttribute("userID") != null){
        	userID = (String) session.getAttribute("userID");// 겟 세션은 Object 를 리턴
        }
        String toID = null;
        if(request.getParameter("toID") != null){
        	toID = (String) request.getParameter("toID");
        }
        if(userID == null){
        	session.setAttribute("messageType", "오류");
        	session.setAttribute("messageContent", "현재 로그인이 되어있지 않습니다.");
        	response.sendRedirect("index.jsp");
        	return;
        }
        if(toID == null){
        	session.setAttribute("messageType", "오류");
        	session.setAttribute("messageContent", "상대방이 지정되지 않았습니다.");
        	response.sendRedirect("index.jsp");
        	return;
        }
    %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<link rel="profile" href="https://gmpg.org/xfn/11">
<link rel="pingback" href="https://demo.colorlib.com/tyche/xmlrpc.php">
<meta name='robots' content='noindex, nofollow' />

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
<style id="kirki-inline-styles"></style>
<style type="text/css">
	body .container{
		width:800px;
	}
</style>
		<link rel="stylesheet" href="../resources/css/custom.css">
	<link rel="stylesheet" href="../resources/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
    <script src="../resources/js/bootstrap.js"></script>
    <script src="../resources/js/custom.js"></script>
	<script type="text/javascript">
	
    function autoClosingAlert(selector, delay){
    	let alert = $(selector).alert();
    	alert.show();
    	window.setTimeout(function(){alert.hide()}, delay);
    }
	$(function(){
	    $("#sub").click(function(){
	    	send();
	    })
	    $("#chatContent").keypress(function(e) { 
	    	if (e.keyCode === 13) { 
	    		console.log("H");
	    		send();
	    	} 
	    });
	})
    function send(){
    	let fromID = '<%=userID%>';
    	let toID = '<%=toID%>';
    	let chatContent = $("#chatContent").val();
    	$.ajax({
    		type:"post",
    		url:"chatting.do",
    		data:{
    			fromID : fromID,
    			toID : toID,
    			chatContent : chatContent
    		},
    		success:function(data){
    			let d = data.trim()
    			if(d == 0){
    				autoClosingAlert("#dangerMessage", 2000);
    			}
    		},
    		error:function(e){
    			alert(e);
    			console.log(e);
    		}
    	})
    	$("#chatContent").val("");
    }
    let lastID = 0;
    function chatListFunction(type){
    	let fromID = '<%=userID%>';
    	let toID = '<%=toID%>';
    	$.ajax({
    		type:"post",
    		url:"chatList.do",
    		data:{
    			fromID : fromID,
    			toID : toID,
    			listType : type
    		},
    		success:function(data){
    			if(data.trim() == ""){
    				return;
    			}
    			console.log(data)
    			let parsed = JSON.parse(data);
    			console.log(parsed)
    			let result = parsed.result;
    			for(let i = 0; i < result.length; i++){
    				addChat(result[i][0].value, result[i][2].value, result[i][3].value);
    			}
    			lastID = Number(parsed.last);
    		}
    	})
    }
    function addChat(chatName, chatContent, chatTime){
    /*  let c = (userID == chatName) ? "sent" : "received";
    	$("#chatList").append('<ul class="chatting-list"><li class='+c+'><span class="profile"><span class="user">chatName</span><img class="image" src="https://placeimg.com/50/50/any" alt="any"></span><span class="message">chatContent</span><span class="time">chatTime</span>')
        let div = document.createElement("div");
        div.classList.add("clear_div");
        $("#chatList").appendChild(div);
    	$("#chatList").scrollTo(0, $("#chatList").scrollHeight) */
    	let c = ('<%=userID%>' == chatName) ? "sent" : "received";
      	$("#chatList").append('<li class='+c+'><span class="profile"><span class="user">'+chatName+'</span><img class="image" src="https://placeimg.com/50/50/any" alt="any"/></span><span class="message">'+chatContent+'</span><span class="time">'+chatTime+'</span></li><li class="clear_div"></li>')
      	//$(".chatting-list").append('<li>hihihihihih</li>')
      	//$("#chatList").append('<li>hihihihihih</li>')
        
    	//$("#chatList").append('<div class="row"><div class="col-lg-12"><div class="media"><a class="pull-left" href="#"><img class="media-object img-circle" src="https://placeimg.com/50/50/any" alt="any"></a><div class="media-body"><h4 class="media-heading">'+chatName+'<span class="small pull-right">'+ chatTime+'</span></h4><p>'+chatContent+'</p></div></div></div></div><hr>')
    	$("#chatList").scrollTop($("#chatList")[0].scrollHeight)
  /*           var scrollTop = $("#chatList").scrollTop();
            var innerHeight = $("#chatList").innerHeight();
            var scrollHeight = $("#chatList").prop('scrollHeight');

            if (scrollTop + innerHeight >= scrollHeight) {
            	$("#chatList").scrollTop(scrollHeight)
            } else {
            	$("#chatList").scrollTop($("#chatList")[0].scrollHeight)
            } */
    }
    function getInfiniteChat(){
    	setInterval(function(){
    		chatListFunction(lastID);
    		
    	}, 1000)
    }
   
    </script>
   <%--  <script>
			function getUnread(){
				$.ajax({
					type:"post",
					url:"unReadChat.do",
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
			} --%>
	</script>
</head>
<body>
   
   <jsp:include page="../main/header.jsp"/>
   
    <div class="container bootstrap snippet">
    	<div class="row">
    		<div class="col-xs-12">
    			<div class="portlet portlet-default">
    				<div class="portlet-heading">
    					<div class="portlet-title">
    						<h4><i class="fa fa-circle text-green"></i>실시간 채팅창</h4>
    					</div>
    					<div class="clearfix"></div>
    				</div>
    				<div class="chat" class="panel-collapse collapse in">
    					<div id="chatList" class="portlet-body chat-widget chatting-list" style="overflow-y: auto; height: 600px;">
    						
    					</div>
    				</div>
    				<div class="portlet-footer">
   						<div class="row" style="height: 90px;">
   							<div class="form-group col-xs-10">
    							<textarea style="width: 600px; height: 80px;" id="chatContent" class="form-control" placeholder="메시지를 입력하세요." maxlength="100"></textarea>
   							</div>
							<div class="form-group col-xs-2">
								<button type="button" class="btn btn-default pull-right" id="sub">전송</button>
								<div class="clearfix"></div>
							</div>
	   					</div>
	   				</div>
    			</div>
    		</div>
		</div>
    </div>
    <div class="alert alert-danger" id="dangerMessage" style="display: none;">
    	<strong>이름과 내용 모두 입력해주세요.</strong>
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
    <script>
    
	$(function(){
		chatListFunction("0");
		getInfiniteChat();
	})
    </script>
    
    <jsp:include page="../main/footer.jsp"/>
</body>
</html>