<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="${pageContext.request.contextPath}/css/orders.css" rel="Stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/header.css" rel="Stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/footer.css" rel="Stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/personage.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<jsp:include page="header.jsp"/>
<!-- nav主导航-->
<nav id="nav">
    <ul>
        <li><a href="index.html" class="acti">首页</a></li>
        <li><a href="index.html#computer" >电脑办公</a></li>
        <li><a href="index.html#stationery" >办公文具</a></li>
    </ul>
</nav>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <jsp:include page="left.jsp"/>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span ><a href="${pageContext.request.contextPath}/user/showPerson.do">我的信息</a></span>
            <span class="rs_header_active"><a href="${pageContext.request.contextPath}/user/showPassword.do">安全管理</a></span>
        </div>

        <!--安全管理 -->
        <div class="rs_content">
            <p class="change_password_title">更改密码</p>
            <div class="new_password">
                <span class="word">输入旧密码：</span><input 
                	type="password"
               		name="oldPassword"
                	id="oldPassword"/>
                <span class="change_hint" id="oldPasswordSpan"></span>
            </div>
            <div class="new_password">
                <span class="word">输入新密码：</span><input 
                	type="password"
                	name="newPassword"
                	id="newPassword"
                	
                	/><span class="change_hint" id="newPasswordSpan"></span>
            </div>
            <div class="confirm_password">
                <span class="word">确认新密码：</span><input 
                	type="password"
                	name="confirmPassword"
                	id="confirmPassword"
                	
                	/><span class="confirm_hint" id="confirmPasswordSpan"></span>
            </div>
            <div class="save_password">
                <a href="#" onClick="updatePwd()" style="color:#fff">保存更改</a>
            </div>
        </div>


    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="${pageContext.request.contextPath}/images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="${pageContext.request.contextPath}/images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="${pageContext.request.contextPath}/images/footer/footerFont.png" alt=""/></p>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="${pageContext.request.contextPath}/images/footer/wechat.png" alt=""/>
                    <img src="${pageContext.request.contextPath}/images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="${pageContext.request.contextPath}/images/footer/ios.png" class="lf">
            <img src="${pageContext.request.contextPath}/images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="${pageContext.request.contextPath}/images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>

</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/orders.js"></script>
<script type="text/javascript">
//提交请求
$(function(){
	  $("#leftsidebar_box dd").hide();
	    $("#leftsidebar_box .count_managment dd").show();
	    $("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder1.png");
        $("#leftsidebar_box .count_managment").find('img').attr("src","../images/myOrder/myOrder2.png");
})
function updatePwd(){
	var oldPwd=$("#oldPassword").val();
	var newPwd=$("#newPassword").val();
	var confirmPwd=$("#confirmPassword").val();
	if(
		checkPasswordEquals(oldPwd)&&
		checkPasswordEquals(newPwd)&&
		checkPasswordEquals(confirmPwd)
		){
		$.ajax({
			"url":"${pageContext.request.contextPath}/user/updatePassword.do",
			"data":"oldPassword="+oldPwd+"&newPassword="+newPwd,
			"Type":"POST",
			"dataType":"json",
			"success":function(obj){
				alert(obj.state+","+obj.message);
				if(obj.state==1){
					$("#oldPassword").val("");
					$("#newPassword").val("");
					$("#confirmPassword").val("");
					$("#oldPasswordSpan").html("");
					$("#newPasswordSpan").html("");
					$("#confirmPasswordSpan").html("");
				}
			}
		});
		
	}else{
		alert("信息不正确");
	}
}
//验证密码长度
	function checkPasswordLength(pwd){
	return pwd.length>=6 && pwd.length<=9;
}
//验证两次输入的密码是否相同
	function checkPasswordEquals(){
	 var value1=$("#newPassword").val();
	 var value2=$("#confirmPassword").val();
	 if(value1==value2){
		 return true;
	 }else{
		 return false;
	 }
}
$("#oldPassword").blur(function(){
	var value=$("#oldPassword").val();
	if(checkPasswordLength(value)){
		$("#oldPasswordSpan").html("密码长度正确");
		$("#oldPasswordSpan").css("color","#0f0");
	}else{
		$("#oldPasswordSpan").html("密码长度错误");
		$("#oldPasswordSpan").css("color","#f00");
	}
});
$("#newPassword").blur(function(){
	var value=$("#newPassword").val();
	if(checkPasswordLength(value)){
		$("#newPasswordSpan").html("密码长度正确");
		$("#newPasswordSpan").css("color","#0f0");
	}else{
		$("#newPasswordSpan").html("密码长度错误");
		$("#newPasswordSpan").css("color","#f00");
	}
});
$("#confirmPassword").blur(function(){
	var value=$("#confirmPassword").val();
	if(checkPasswordLength(value)){
		$("#confirmPasswordSpan").html("密码长度正确");
		$("#confirmPasswordSpan").css("color","#0f0");
		if(checkPasswordEquals()){
			$("#confirmPasswordSpan").html("密码长度正确");
			$("#confirmPasswordSpan").css("color","#0f0");
		}else{
			$("#confirmPasswordSpan").html("两次密码不相同");
			$("#confirmPasswordSpan").css("color","#f00");
		}
	}else{
		$("#confirmPasswordSpan").html("密码长度错误");
		$("#confirmPasswordSpan").css("color","#f00");
	}
});

</script>
</html>