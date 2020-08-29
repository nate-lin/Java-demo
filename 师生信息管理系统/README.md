摘 要**

师生信息管理系统，是对学校的师生数据进行存储的一项系统。存储的数据可以通过增删改查添加需要的存储数据，并将数据存入后台数据库上。在Internet环境下采用java面向对象+JDBC相结合的技术及数据库进行信息的存储、更新以及管理，设计一个应用于教学教务的师生管理系统。本系统可完成对日常的教育工作中师生档案的数字化管理，加快查询速度，减轻学院教职员工工作压力。而在具体的设计上，随着用户的使用及对系统了解的不断加深，对某一部分或几部分进行重新分析、设计、实施。实现了整个系统的模块和数据库、系统组成、网页设计以及代码编写。

 

**关键词：**师生管理信息系统；信息存储；数据库；JSP技术。



  # 一．系统需求分析

---

## 1.1 开发背景

随着计算机科学的快速发展，大数据、物联网、人工智能等技术逐步成熟，人们的工作和生活逐渐信息化和智能化。人工智能技术的大量应用可以为海量信息的智能化应用提供前所未有的机遇，所以在现有教学硬件基础上，结合办学特色需求，将开发一套较为完整的师生信息管理系统，能实现对本学院的师生信息进行管理，同时极大提高信息管理的效率。网络技术的应用使得计算机之间通信、信息共享成为可能，而数据库技术的应用则为人们提供了数据存储、信息检索、信息分析等功能，从而使得工作更高效地进行。

数据库始于20世纪60年代，经过40多年的发展，现在已经形成了理论体系，成为计算机软件的一个重要分支。数据库技术体现了当代先进的数据管理方法，使计算机的应用真正渗透到国民经济各个部门，在数据处理领域发挥着越来越大的作用。

而互联网技术的出现，更是进一步丰富的人类生活，数字化生存已经一步步走进我们的生活与工作。互联网技术与数据库技术的结合为计算的在人类生活中的应用带来了巨大的影响。产业信息化，管理现代化，科学化已经成为行业发展的重要课题，这不仅是企业提高自身竞争力，甚至是国家提高综合国力，走向国民富强的重要手段。在我国，教育是一个影响着国富民强的重要行业，随着改革开放和市场经济的发展根据中国特有的国情发展，教育得到了国家的大力扶持与社会各界的高度重视，从而使教育业向规范性与现代化的方向高速发展，但是同发达国家相比，我国的教育行业的信息技术的应用程度还很低，只有在大城市中发展较早、规模较大的院校中才使用计算机进行大规模操作，从各方面提高工作效率，取得良好的社会和经济效益，而一些新兴的、规模较小的教育机构还没有全部具备这种功能。因此可见，随着我国教育的迅速发展，信息技术在其上的应用会更加地广泛和深入。

## 1.2 系统需求定义

   在各个院校中，师生的信息管理工作是学院管理工作中的一个重要分支，如果能够提供一种高效的管理手段，必将能够提高师生管理工作的效率。 每次开学将有大量数据需要一一核实进行存储，学生数据较多，查询个人信息比较费力，所以可通过信息管理系统更好的有序管理数据。

每个班级的学生信息由职工进行管理数据并录入系统。教师可查看相连的学生数据对本班的数据汇总，然后年级组长再进行汇总。

过去我国主要靠纸质存储大量的数据管理，此过程需耗人力财力，因纸质不能进行高效的增删改查，还不能准确有效长时间存储，所以，现今的绝大部分公司都对开始往低成本的网络信息方向发展，采取高效的网络数据存储。不仅省财力物力还能高效存储数据，其中市场对此网络技术需求也越来越强烈。

从上述中可以我们看出师生信息管理系统中的信息官系统是一个非常具有市场潜力的项目。

# 二．系统设计

---

本师生管理系统，主要包括两大部分：职工信息存储和学生信息存储。根据增删改查录入数据库，系统里面含有智能的高效查找，按照需求把数据录数据库并执行相应的页面，通过easyui.css、icon.css样式直接调用即可。

一、职工信息存储

●内部信息管理：职工号（interiorNo）、姓名（interiorName）、性别（sex）、任职时间（tentry）、任课班级（localId）、Email（email）、教师考勤（interiorCheck）。

●局部信息管理：任课班级（localName）、考勤记录（localCheck）。

二、学生信息管理

●学生信息：学号（stuNo）、姓名（stuName）、性别（sex）、出生日期（birthday）、班级名称（gradeId）、Email（email）、学生备注（stuDesc）。

●班级信息：班级名称（gradeName）、班级描述（gradeDesc）。

## 2.1系统总体模块

### 2.1.1 页面功能分配

  该系统页面功能如下所示：

●  DbUti.java：数据库连接的基本信息。

●  easyui.css、icon.css：层叠样式表文件，定义页面风格。 

●  index.jsp：登录页面，用于登录跳转进去主页界面。

●  main.jsp：提供从登录页面跳转到师生信息管理系统主页面的功能。

●  gradeInfoManage.jsp：用于编辑班级信息。

●  interiorInfoManage.jsp：用于编辑内部信息管理。

●  localInfoManage.jsp：用于编辑局部信息管理。

●  studentInfoManage.jsp用于编辑学生信息。

●  success.jsp：用于注册成功跳转的页面。

●  register.jsp：用于注册新用户，注册成功后把用户密码存进数据库。

●  lunbo.jsp：跳转进去的主页面首页的一个轮播图。

●  reward.jsp：用于主页面底下的支付宝打赏。

● wechat.jsp：用于主页面底下的联系作者的扫码添加微信。

### 2.1.2 系统功能模块设计

  该系统的功能模块如图2.1。

![image-20200829152039293](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829152039293.png)



## 2.2 数据库设计

2.2.1 数据库设计思路

  该系统采用mysql 数据库作为后台数据库。通过分析要在数据库中存储一下基本信息。

●  用户登录信息(t_user)：用户id号、用户账号、用户密码。

●  学生信息(t_student)：编号学号、姓名、性别、出生日期、班级名称、Email、学生备注。

●  班级信息(t_grade)：编号、班级名称、班级描述。

● 内部信息管理（t_interioer）：职工号、姓名、性别、任职时间、任课班级、Email、教师考勤

● 局部信息管理(t_local)：任课班级、考勤记录（

上述五个数据表的连接关系如下所示。

●  学生信息(t_student)与班级信息(t_grade)通过班级名称建立连接关系。

●  内部信息管理（t_interioer）与局部信息管理(t_local)通过任课班级建立连接关系。

2.2.2 创建数据表

(1) 用户登录信息表t_user 

  该信息表用于存储用户的基本信息，包括用户ID号(id)、用户账号(admin)、用户密码(password)，如图2.2所示。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image019.jpg)   

​                                                            图2.2 管理员信息表t_user

 

(2)学生信息表t_student

  该信息表用于存储学生的基本信息，包括学号（stuNo）、姓名（stuName）、性别（sex）、出生日期（birthday）、班级名称（gradeId）、Email（email）、学生备注（stuDesc），如图2.3所示。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image021.jpg)   

​                                                            图2.3 学生信息表t_student

(3) 班级信息(t_grade)

  该信息表用于存储班级的基本信息，包括班级名称（gradeName）、班级描述（gradeDesc），如图2.4所示。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image023.jpg)   

​                                                            图2.4班级信息表t_grade

(4) 局部信息管理(t_local)

  该信息表用于存储职工的基本信息，包括任课班级（localName）、考勤记录（localCheck）。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image025.jpg)  

​                                                            图2.5 局部信息管理表t_local

(5) 内部信息管理（t_interioer）

  该信息表用于存储教师的基本信息，包括职工号（interiorNo）、姓名（interiorName）、性别（sex）、任职时间（tentry）、任课班级（localId）、Email（email）、教师考勤（interiorCheck），如图2.6所示。



  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image027.jpg)   

​                                                            图2.6 内部信息管理表t_interioer

## 2.3 用户界面设计

### 2.3.1 登录页面

index.jsp是系统首页，用于登录。当正确输入账号和密码后，单击“登录”按钮即可。如没有账号点击“注册”，如需重新输入，则单击“重置”。页面显示效果如图2.7所示。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image029.jpg)  

​                                                            图2.7 系统首页显示效果图

### 2.3.2 注册页面

register.jsp是系统注册页面，用于注册。当正确输入账号和密码后，单击“注册”按钮即可。如需重新输入，则单击“重置”。页面显示效果如图2.80所示。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image031.jpg)  

​                                                            图2.8 系统注册显示效果图

### 2.3.3 师生信息管理系统主页

  main.jsp是整个师生信息管理系统的主页面，当成功登录后，就会跳转到此界面中。该页面左边菜单栏中包含了本系统所要实现的师生的信心管理的所有功能，如学生信息、班级信息、职工信息管理、教师信息管理，搜索等功能。页面显示效果如图2.9所示。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image033.jpg)  

​                                                            图2.9 学生成绩管理系统显示效果图

### 2.3.4学生信息页面

如图2.10所示为学生信息页面，可进行增删改查录入数据到数据库中。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image035.jpg)  

​                                                            图2.10 学生信息页面显示效果图

### 2.3.5班级信息页面

如图2.11所示为班级信息页面，可进行增删改查录入数据到数据库中。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image037.jpg)  

​                                                            图2.11 班级信息页面显示效果图

2.3.6局部信息管理页面

如图2.12所示为局部信息管理页面，可进行增删改查录入数据到数据库中。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image039.jpg)  

​                                                            图2.12 局部信息管理页面显示效果图

2.3.6内部信息管理页面

如图2.13所示为学生信息页面，可进行增删改查录入数据到数据库中。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image041.jpg)  

​                                                            图2.13 内部信息管理页面显示效果图

2.3.7添加作者微信页面

如图2.14所示为添加作者微信页面，点击主页的下方的微信联系即可扫码添加作者微信。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image043.jpg)  

​                                                      2.13 添加作者微信页面显示效果图



2.3.8打赏页面

如图2.14所示为打赏页面，点击主页的下方的打赏即可付款给作者。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image045.jpg)  

​                                                             图2.14 打赏页面显示效果图



# 三．系统实现与测试

## 3.1系统开发的具体细节

系统的目录结构如图，同一个包存放同类型的类



| ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image047.jpg) | ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image049.jpg) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
|                                                              |                                                              |

## 3.2客户功能实现

### 3.2.1系统登录

---

1.在com.system.dao包中创建UserDao类，因为用户类型包括“登录”和“注册”，所以需要在UserDao类中编写login(Connection con,User user)方法和register(Connection con,User user)，判断用户是登录还注册从而数据进行数据获取，如用户是登录则，查询t_user表格获取登录，否则从t_user表格插入数据从而进行登录。

 ```java
//登录
	public User login(Connection con,User user) throws Exception{
		User resultUser=null;
		String sql="select * from t_user where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));	}
		return resultUser;	}
//注册
	public int register(Connection con,User user) throws Exception{
		String selcet = "select count(*) as totalCount from t_user";
		ResultSet query = con.prepareStatement(selcet).executeQuery();
		int rowCount = 0; 
		if(query.next()) { 
		  rowCount=query .getInt("totalCount")+1;
		}
		String sql="insert into t_user(id,userName,password) values("+rowCount+","+user.getUserName()+","+user.getPassword()+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		boolean execute = pstmt.execute();
		if (execute) {
			return 1;
		}
		return 0;}

 ```



2.在com.system.model包中创建User类，自定义用户登录的属性

```java
public class User {
	private int id;
	private String userName;
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}

```

 

3. 在com.system.web中创建LoginServle类，用于对数据的合法判断

```java
try {
			con=dbUtil.getCon();
			User currentUser=userDao.login(con, user);
			if(currentUser==null){
				request.setAttribute("error", "用户名或密码错误！");
				// 服务器跳转
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				// 获取Session
				HttpSession session=request.getSession();
				session.setAttribute("currentUser", currentUser);
				// 客户端跳转
				response.sendRedirect("main.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

```



4.登录页面在web.,xml里面的配置文件

```xml
<servlet>
  	<servlet-name>loginServlet</servlet-name>
  	<servlet-class>com.system.web.LoginServlet</servlet-class>
  </servlet>
<servlet>
  	<servlet-name>localListServlet</servlet-name>
  	<servlet-class>com.system.web.LocalListServlet</servlet-class>
  </servlet>
servlet-mapping>
  	<servlet-name>loginServlet</servlet-name>
  	<url-pattern>/login</url-pattern>
  </servlet-mapping>
<servlet-name>localListServlet</servlet-name>
  	<url-pattern>/localList</url-pattern>
  </servlet-mapping>

```



### 3.2.2客户主页面

---

1.主页面的权限验证

```html
<%
	// 权限验证
	if(session.getAttribute("currentUser")==null){
		response.sendRedirect("index.jsp");
		return;
	}
%>

```



2.主页进行实例化菜单

```html
$(function(){
	// 数据
	var tree_westData=[{
		text:"职工信息管理",
		children:[{
			text:"局部信息管理",
			attributes:{
				url:"localInfoManage.jsp"
			}
		},{
			text:"内部信息管理",
			attributes:{
				url:"interiorInfoManage.jsp"
			}
		}]
	}];
	// 实例化树菜单
	$("#tree_west").tree({
		data:tree_westData,
		lines:true,
		onClick:function(node){
			if(node.attributes){
				openTab(node.text,node.attributes.url);
			}
		}
	});
	
	// 新增Tab
	function openTab(text,url){
		if($("#tabs").tabs('exists',text)){
			$("#tabs").tabs('select',text);
		}else{
			var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
			$("#tabs").tabs('add',{
				title:text,
				closable:true,
				content:content
			});
		}
	}
});

```

 

### 3.2.3客户注册页面

1.注册页面的数据校验

```html
var status = '${sessionScope.pwdFail}';
        if (status=='yes'){
            alert("两次密码输入不一样，请重新输入")
        }
       var hasUser = '${sessionScope.hasUser}';
        if (hasUser=='yes'){
            alert("该用户已存在")
        }

```

 

2. 将注册的信息保存到数据库

```java
if(password.equals(repassword)){
			//将注册的信息保存到数据库
			try {
				Connection con = dbUtil.getCon();
				User user = new User();
				user.setPassword(password);
				user.setUserName(userName);
				User login = userDao.login(con, user);  //检查用户是否存在
				if (login==null) {
					userDao.register(con, user);
		            //把用户消息放进session中
		            HttpSession session = request.getSession();
		            session.setAttribute("userName",userName);
		            session.setAttribute("password",password);
//		           response.sendRedirect("success.jsp"); //success
		            response.sendRedirect("success.jsp");
		            //request.getRequestDispatcher("success.jsp").forward(request,response);
				}else {
		            request.getSession().setAttribute("hasUser","yes");
		            response.sendRedirect("register.jsp");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else {
            request.getSession().setAttribute("pwdFail","yes");
            response.sendRedirect("register.jsp");
        }
	}

```



## 3.3模块程序描述

### 3.3.1 管理用户登录User过程

---

| 程序文件     | index.jsp                                |
| ------------ | ---------------------------------------- |
| 页面传入参数 | userName，passwprd                       |
| 页面提交URL  | Index.jsp                                |
| 页面传出参数 | Session["userName"]  Session["password"] |
| 功能说明     | 登录系统                                 |
| 特殊注解     | 在此处系统会进入main.jsp                 |

 

页面设计：登录页面index.jsp利用网页表单把用户输入的账号和密码交给目标网页Loginservlet.java进行判断，从而验证用户输入的信息。

### 3.3.2 管理用户登录处理逻辑说明

---

登录页面login.jsp表单递交时，采用的是隐式传递post，对象是服务器。所以在程序清单中首先使用Request.Form()方法取得表单传递过来的数据，并把数据赋值给所定义的变量。然后根据取得的值进行验证：首先验证用户输入的信息是否与数据库中的信息匹配，若验证失败，给出相应的提示信息；若验证成功，则生成Session变量并进入师生信息管理系统。

## 3.4系统测试

### 3..1 界面测试

---

  本系统的所有网页界面虽不华丽唯美，但却简洁清晰。内容布局方便操作、色调搭配素雅，总体符合用户要求。其中，局部信息管理修改页面和内部信息管理添加页面显示效果图如图3.1和3.2所示。

![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image051.jpg)  

​                                                            图3.1 局部信息管理修改页面显示效果图

![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image053.jpg)  

​                                                            图3.2 内部信息管理添加页面显示效果图

### 3.2.2 功能测试

----

经测试，本系统所要实现的功能，都能实现。首先，按提示输入管理账号和密码均为：admin后，单击登陆，则成功进入师生信息管理系统主界面。而当输入的账号或密码与默认的不符时，则会提示用户名获密码错误。这说明表单的提交和验证功能都能成功实现。其次，在师生信息管理系统主界面中，按高速搜索出相应的结果。如图3.2 所示。

  ![img](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/clip_image055.jpg)  

​                                                            图3.3 高速搜索页面显示效果图



 

 

 

 

 

 

 

 



 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

致 谢

在此感谢我的老师们，是你们的细心指导和关怀，使我能够顺利的完成毕业设计。在我的学业和毕业设计的调查研究工作中无不倾注着老师们辛勤的汗水和心血。同时感谢在本次系统开发中，给过我帮助的老师和同学们，谢谢你们对我设计的帮助！最后祝我的母校，蒸蒸日上，更创新高！