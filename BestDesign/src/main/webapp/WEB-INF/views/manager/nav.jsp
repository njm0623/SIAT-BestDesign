<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('.menu li:has(ul)').click(function(e) {
		e.preventDefault();

		if($(this).hasClass('active')) {
			$(this).removeClass('active');
			$(this).children('ul').slideUp();
		} else {
			$('.menu li ul').slideUp();
			$('.menu li').removeClass('active');
			$(this).addClass('active');
			$(this).children('ul').slideDown();
		}

		$('.menu li ul li a').click(function() {
			window.location.href = $(this).attr('href');
		})
	});
});
</script>
<style type="text/css">
.accordion-menu {
	width: 20%;
	min-width: 300px;
	margin: 10px;
	display: inline-block;
	line-height: 18px;
	text-align: left;
}

.accordion-menu .menu { width: 60%; }

.accordion-menu .menu li a {
	color: #494949;
	display: block;
	padding: 15px 20px;
	background: #e9e9e9;
}
.accordion-menu .menu li a:hover { background: #16a085; color: #fff; }
.accordion-menu .menu i.fa {
	font-size: 12px;
	line-height: 18px;
	float: right;
	margin-left: 10px;
}

.accordion-menu .menu ul { display: none; }
.accordion-menu .menu ul li a {
	background: #424242;
	color: #e9e9e9;
}

.accordion-menu .menu .active > a {
	background: #16a085;
	color: #fff;
}
</style>
</head>
<body>
<div class="col-md-4 hidden-xs">
						<!--Sidebar Dropdown  -->
						<div class="left-menu">
						<div class="accordion-menu">
							<ul class="menu">
								<li><a href="#">회원관리<i class="fa fa-chevron-down"></i></a>
									<ul>
										<li><a href="../manager/userBoardList.do">회원</a></li>
										<li><a href="../manager/designBoardList.do">디자이너</a></li>
									</ul>
								</li>
								<li><a href="#"> 게시물 관리 <i class="fa fa-chevron-down"></i></a>
									<ul>
										<li><a href="../manager/requestBoardList.do">그려주세요 목록</a></li>
										<li><a href="../manager/saleBoardList.do">드로잉샵 목록</a></li>
										<li><a href="../manager/contactBoardList.do">문의게시판 목록</a></li>
									</ul>
								</li>
								<li><a href="../manager/saleConfirm.do">매출 현황</a>
								</li>
							</ul>
						</div>
						</div>
					</div>
</body>
</html>