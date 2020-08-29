<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>添加作者微信</title>
  <script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script text/javascript>
//定义全局变量
   var imgDom =null;
   var n=0;
   var intervalDom=null;
   var tt=2000;
   var imgs=null;
   var imgArr=["images/1.jpg","images/2.jpg","images/3.jpg","images/4.jpg","images/5.jpg","images/6.jpg","images/7.jpg"]
//页面加载完后执行
window.onload= function(){//初始化变量
imgDom=document.getElementsByTagName("img")[0];
imgs=document.getElementsByClassName("images");
intervalDom=setInterval(next,tt);
}
function next(){     //点击下一页事件
   n++;
   if(n>=imgArr.length){
   n=0;
   }
   imgDom.setAttribute("src",imgArr[n]);
   addBorder();
}
function shang(){     //点击上一页事件
  n--;
  if(n<0){
   n=imgArr.length-1;
  }
  imgDom.setAttribute("src",imgArr[n]);
  addBorder();
}
function stop(){     //鼠标移上停止轮播
clearInterval(intervalDom);
}
function start(){     //鼠标移开继续轮播
   intervalDom=setInterval(next,tt);
}
function addBorder(){     //轮播时同时改变图片对应缩略图的样式
  for(var i=0;i<imgs.length;i++){
      imgs[i].style.border="";     //其他图片样式为空
  }
  imgs[n].style.border="1px solid red";    //对应缩略图样式改变
}
function change(obj,num) {     //点击缩略图跳转到点击的图片,并改变此缩略图的样式
   for(var k=0;k<imgs.length;k++){
       imgs[k].style.border="";     //其他图片样式为空
   }
   obj.style.border="1px solid red";     //改变本缩略图样式
   n=num;
   imgDom.setAttribute("src",imgArr[n]);    //改变图片
}


</script>

</head>

<body>
  <div align="center" style="width:100%;padding-top:10px;padding-right: 20px;">
    <img src="images/1.jpg" alt="" onMouseOver="stop()" onMouseOut="start()" width="1000" hight="700">

<div align="center" style="width: 100%;padding-top: 10px;padding-right: 20px;">
    <img src="images/1.jpg" onClick="change(this,0)" class="images" width="50">
    <img src="images/2.jpg" onClick="change(this,1)" class="images" width="50">
    <img src="images/3.jpg" onClick="change(this,2)" class="images" width="50">
    <img src="images/4.jpg" onClick="change(this,3)" class="images" width="50">
    <img src="images/5.jpg" onClick="change(this,4)" class="images" width="50">
    <img src="images/6.jpg" onClick="change(this,5)" class="images" width="50">
     <img src="images/7.jpg" onClick="change(this,6)" class="images" width="50">
	<!-- <div align="center" style="width:100%;padding-top:30px;padding-right: 10px;">
			<button onClick="shang()">上一张</button>
			<button onClick="next()">下一张</button>
		</div> -->
</div>
	
</div>

</body>

</html>