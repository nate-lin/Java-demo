# 登录和注册后台实用源码

# 创建工程详情

## 创建一个名字为“lgtest”的工程

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829140835383.png)

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829140903005.png)

## 工程目录详情

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829140942236.png)

# 1. 连接数据库

## 1.1创建用户类（User.java）

```java
**
 * 用户Model类
 *
 */
public class User {

	private int id;
	private String userName;//用户名
	private String password;//密码
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

```



## 1.2连接数据库（DbUtil.java）

```java
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    //注意：根据自身数据库进行设置
    //数据库端口号：3306； 数据库表名：db_Infosystem  
	private String dbUrl="jdbc:mysql://localhost:3306/db_Infosystem";
    // 数据库用户名：root
	private String dbUserName="root";
    //数据库密码：123456
	private String dbPassword="123456";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	/**
	 * 关闭数据库连接
	 */
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}
}
}

```



## 1.3处理字符串类（StringUtil.java）

```java
public class StringUtil {

	public static boolean isEmpty(String str){
		if("".equals(str)|| str==null){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isNotEmpty(String str){
		if(!"".equals(str)&&str!=null){
			return true;
		}else{
			return false;
		}
	}
}

```



## 1.4登录和注册校验（UserDao.java）

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.system.model.User;

public class UserDao {

	/**
	 * 登录验证
	 * 
	 */
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
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
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
		return 0;
	}
}

```



# 2. 注册页面

## 2.1注册页面（register.jsp）

```html
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<script>
        var status = '${sessionScope.pwdFail}';
        if (status=='yes'){
            alert("两次密码输入不一样，请重新输入")
        }
       var hasUser = '${sessionScope.hasUser}';
        if (hasUser=='yes'){
            alert("该用户已存在")
        }
    </script>
</head>
<body>
	<div align="center" style="padding-top: 50px;">
		<form action="${pageContext.request.contextPath}/Register" method="post">
		<table  width="740" height="500" background="images/register.jpg" >
			<tr height="180">
				<td colspan="4"></td>
			</tr>
			<tr height="10">
				
				<td width="45%"></td>
				<td width="10%">用户名：</td>
				<td><input type="text" value="${userName }" name="userName"  required id="userName"/></td>
				<td width="30%"></td>
			</tr>
			<tr height="10">
				<td width="45%"></td>
				<td width="13%">密  码：</td>
				<td><input type="password" value="${password }" name="password" required id="password"/></td>
				<td width="30%"></td>
			</tr>
			
			<tr height="10">
				<td width="45%"></td>
				<td width="13%">确认密码：</td>
				<td><input type="password" value="${repassword }" name="repassword"  required id="repassword"/></td>
				<td width="30%"></td>
			</tr>
			<tr height="10">
				<td width="45%"></td>
				<td width="13%"><input type="submit" value="立即注册"/></td>
				<td><input type="reset"></td>
				<td width="30%"></td>
			</tr>
			<tr height="10">
				<td width="45%"></td>
				<td colspan="3">
					<font color="red">${error }</font>
				</td>
			</tr>
			<tr >
				<td></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>

```



## 2.2注册校验（success.jsp）

```java
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.dao.UserDao;
import com.system.model.User;
import com.system.util.DbUtil;
import com.system.util.StringUtil;

public class OutServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
        //注销session或者移除session中的数据
        session.removeAttribute("userName");
        session.removeAttribute("password");
        
        response.sendRedirect("loginjsp");
        }
	
}

```



## 2.3注册校验Servlet（OutServlet.java）

```java
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.dao.UserDao;
import com.system.model.User;
import com.system.util.DbUtil;
import com.system.util.StringUtil;

public class RegisterServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
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

	
}

```



## 2.4Servlet--实现用户的注册功能（RegisterServlet.java）

```java
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.dao.UserDao;
import com.system.model.User;
import com.system.util.DbUtil;
import com.system.util.StringUtil;

public class RegisterServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
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

	
}


```



# 3. 登录页面

## 3.1登录页面（login.jsp）

 ```html
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<script type="text/javascript">
	function resetValue(){
		document.getElementById("userName").value="";
		document.getElementById("password").value="";
	}
</script>
</head>
<body>
	<div align="center" style="padding-top: 50px;">
		<div class="mid_main">
            <div class="title">               
        </div>
		<form action="login" method="post">
		<table  width="740" height="500" background="images/login.jpg" >
			<tr height="180">
				<td colspan="4"></td>
			</tr>
			<tr height="10">
				<td width="45%"></td>				
				<td width="10%">用户名：</td>
				<td><input type="text" value="${userName }" name="userName" id="userName"/></td>
				<td width="30%"></td>
			</tr>
			<tr height="10">
				<td width="45%"></td>
				<td width="10%">密  码：</td>
				<td><input type="password" value="${password }" name="password" id="password"/></td>
				<td width="30%"></td>
			</tr>
			<tr height="10">
				<td width="45%"></td>
				<td width="10%"><input type="submit" value="登录"/></td>
				<td><input type="button" value="重置" onclick="resetValue()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/register.jsp"><input type="button" value="注册" ></a></td>
				
				<td width="30%"></td>
			</tr>
			<tr height="10">
				<td width="45%"></td>
				<td colspan="3">
					<font color="red">${error }</font>
				</td>
			</tr>
			<tr >
				<td></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
 ```



## 3.2登录Servlet（LoginServlet.java）

 ```java
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.dao.UserDao;
import com.system.model.User;
import com.system.util.DbUtil;
import com.system.util.StringUtil;

public class LoginServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		request.setAttribute("userName", userName);
		request.setAttribute("password", password);
		if(StringUtil.isEmpty(userName)||StringUtil.isEmpty(password)){
			request.setAttribute("error", "用户名或密码为空！");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		User user=new User(userName,password);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			User currentUser=userDao.login(con, user);
			if(currentUser==null){
				request.setAttribute("error", "用户名或密码错误！");
				// 服务器跳转
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				// 获取Session
				HttpSession session=request.getSession();
				session.setAttribute("currentUser", currentUser);
				// 客户端跳转
              //登录成功跳转进去main.jsp页面
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
		
	}
}

 ```



## 3.3主页面（main.jsp）

```html
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>主页</title>
</head>
<body>
欢迎进入主页面
</body>
</html>

```

 

# 4. 配置web.xml文件（web.xml）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
  <display-name>test</display-name>
   <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>

 <servlet>
  	<servlet-name>loginServlet</servlet-name>
  	<servlet-class>com.system.web.LoginServlet</servlet-class>
  </servlet>
  
  <servlet>
    <servlet-name>RegisterServlet</servlet-name>
    <servlet-class>com.system.web.RegisterServlet</servlet-class>
  </servlet>
    
    <servlet>
        <servlet-name>OutServlet</servlet-name>
        <servlet-class>com.system.web.OutServlet</servlet-class>
    </servlet>
   
  <servlet-mapping>
  	<servlet-name>loginServlet</servlet-name>
  	<url-pattern>/login</url-pattern>
  </servlet-mapping>
  
   <servlet-mapping>
        <servlet-name>OutServlet</servlet-name>
        <url-pattern>/Out</url-pattern>
    </servlet-mapping>
    
    <servlet-mapping>
        <servlet-name>RegisterServlet</servlet-name>
        <url-pattern>/Register</url-pattern>
    </servlet-mapping>
  </web-app>

```

 

# 5.实现效果图

![登录页面效果图](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/登录页面效果图.png)

![注册页面效果图](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/注册页面效果图.png)