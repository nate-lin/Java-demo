# 在线购物商城实训手册

## 一、 实训介绍

---

实训周期：2周，48课时

指导老师：万伟

实训任务：

   根据给出的文档、工具、部分源代码，编写一个完整的在线购物商城网站。

实训目标：

实训过程可以分为两个阶段，第一阶段为准备阶段，第二阶段为网站开发阶段。两个阶段的主要目标如下：

l 第一阶段：通过阅读文档，熟悉系统需求、准备数据库、熟悉系统中用到的小工具的使用方法。

l 第二阶段：按需求模块，参考开发文档，逐一开发各个页面。

## 二、 第一阶段：小工具的使用

---

1. 实训任务

熟悉CommonUtils、JdbcUtils、TxQueryRunner、MailUtils、BaseServlet、EncodingFilter、VerifyCodeServlet等小工具的使用方法。

2. 参考资料

文档：1小工具.doc

代码：小工具文件加下的所有源代码，其中：

   src文件夹：各个小工具的源代码，供学习研究。

   jar文件夹：各个小工具编译后的jar包，可将这些程序包导入到自己程序中直接使用。

   demo文件夹：各个小工具的使用例子。

3. 实训步骤

第一步：导入Demo项目到工作空间中。

第二步：阅读各小工具的源代码程序（结合小工具.doc文档），掌握小工具的使用方法。

第三步：修改一些必要的参数，运行小程序，查看各小工具的运行结果。

4. 实训结果

请将各个小工具程序的运行结果截图贴在此处。如果对于控制台无输出，可以将数据表数据变化、邮箱收发结果等信息作为程序运行成功的证据进行截图。

（0）  准备测试数据库：

在mysql中创建一个测试数据库，添加数据表：account，数据表字段请参考Person类。                

 ![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143100486.png)                                                

 

（1）  CommonUtils

运行CommonUtils.java程序，将输出结果贴在此处。

  ![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143138895.png)       

F22150E85FAD44CB99099B225794AA7C

log4j:WARN No appenders could be found for logger (org.apache.commons.beanutils.converters.BooleanConverter).

log4j:WARN Please initialize the log4j system properly.

Person [pid=A3539E6333D0452C97A5AE22294865B1, name=null, age=18, birthday=Thu Jan 01 00:00:00 CST 1970]

（2）  JdbcUtils

修改c3p0-config.xml文件中数据库和账号信息，修改并运行AccountServiceTest.java程序，将查询结果c1、c2输出在控制台，将结果贴在此处。

 ![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143203114.png)

（3）  TxQueryRunner

运行PersonDaoTest.java程序，将控制台输出结果和数据表结果贴在此处。

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143231050.png)



[Person [pid=2B74D0C5B157407D89DD335B9332FEED, name=张三, age=18, birthday=1970-01-01], Person [pid=325B8C71BC5046E78D2C977731070F97, name=李四, age=81, birthday=1970-01-01], Person [pid=7359F4EA3A7E489D9B2E2E8AD468FE61, name=王五, age=66, birthday=1970-01-01], Person [pid=92BCCDCC401B46DFB70EE9642EC2067B, name=张三, age=18, birthday=1970-01-01], Person [pid=A46E70D65BE64F7084E36098063F9EB7, name=王五, age=66, birthday=1970-01-01], Person [pid=B297C2B2F9C04F0E8363B94BA82B6C87, name=李四, age=81, birthday=1970-01-01], Person [pid=B36212E953B745FC9CC48DD577E44E13, name=李四, age=81, birthday=1970-01-01], Person [pid=D25635B023594DC3BD78DE81A5D43208, name=王五, age=66, birthday=1970-01-01], Person [pid=FB2709B1BF924783965D850B65355FB9, name=张三, age=18, birthday=1970-01-01]]

（4）  MailUtils

修改MailUtilsTest.java程序，将收件箱、发件箱改为自己的邮箱，运行程序，将收件箱中收到的邮件内容截图贴在此处。

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143303488.png)         

 

（5）  BaseServlet

在浏览器中输入：http://localhost:8080/day01/AServlet?method=regist，观察页面结果，将正确的结果贴在此处。

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143320197.png)         

 

（6） EncodingFilter

访问index.jsp，将浏览器结果贴在此处。

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143345173.png)         

 

（7）VerifyCodeServlet

访问MyJsp.jsp，将浏览器结果贴在此处。

 ![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143404284.png)       

 

**5.问题讨论**

1. 在自己的项目中如果要使用第三方jar包，需要如何做？请写出操作步骤。

将需要引用的 jar 包添加到项目的 resources 目录下，比较多也可以在 resources 下再创建一个目录来保存，这样和配置文件区分开。

2. @Test注解起什么作用？使用该注解必须要导入什么包到程序中？

作用：@Test 注解是TestNG的核心注解，被打上该注解的方法，表示为一个测试方法，类比JUnit是一个道理，@Test注解是JUnit测试的基础，它提供了其他作用。使用该注解必须要导入JUnit测试包到程序中。

3. 分析PersonDao.java、PersonDaoTest.java，以及“\小工具\src\tools\src\cn\itcast\jdbc”文件夹下的Dao.java、JdbcUtils.java、TxQueryRunner.java三个源代码文件，回答：

a)    Dao层的作用是什么

dao层是数据访问层，代表要操作的数据。

b)   TxQueryRunner的作用是什么？这个类位于哪个包中？

TxQueryRunner它是QueryRunner的子类！需要导入commons-dbutils.jar

\*  用起来与QueryRunner相似！

\*  这个类支持事务!它底层使用了JdbcUtils来获取连接！

简化jdbc操作

\* QueryRunner的三个方法：

\* update() -->insert、update、delete

\* query() -->select

\* batch() -->批处理

c)    JdbcUtils的作用是什么？TxQueryRunner与JdbcUtils有什么关系？

（1）JDBCUtils的作用：连接数据库的四大参数是：驱动类、URL、用户名、密码，这些参数都是与特定数据库关联，如果将来想要更改数据库，那么就要去修改这四大参数，那么为了不去修改代码，我们需要写一个JDBCUtils类，让它从配置文件中读取到配置参数，然后创建连接对象。

（2）TxQueryRunner对数据库进行操作，JdbcUtils为TxQueryRunner的操作提供事务管理，如果与事务有关就不关闭数据库连接，否则就关闭数据库连接，两者起到相互协作关系，但JdbcUtils在他们两个之间又起到决定性作用。

d)   你的程序中如果要访问数据库，代码实现的基本思路是什么？

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143510610.png)         

 

## 三、  第二阶段：网站开发

---

1. 实训任务

根据提供的文档和项目原型，编写各模块代码。

2. 实训步骤

第一步：参考“2项目搭建.doc"文档，了解系统前端与后台模块需求。

第二步：利用数据库工具，导入good.sql脚本文件，创建数据库，熟悉数据表。

第三步：创建项目（也可以直接导入原型项目，在项目原型基础上编写代码），根据“2项目搭建.doc"文档的”项目框架“模块介绍，导入数据包到项目中，编辑配置文件。

第四步：分析理解项目原型中提供的页面结构，熟悉各文件夹和文件的作用。

第五步：选择当前要开发的功能模块，找到相应的jsp文件，阅读页面代码，结合”4后台功能实现.doc"文档，修改、编写程序代码，完成模块前后端程序。

第六步：完成一个模块后，继续开发下一个模块。

3. 实训结果

实训结束，请将本阶段编写的网站代码、本文件、实训总结一起打包发给学习委员。

4. 实训总结

实训结束后，对本项目实训进行总结，总结内容包括：

## 一、本项目的目的和意义

## 二、系统分析

### l 系统需求分析

功能概述和分析：对系统功能的大略介绍，以及系统设计的目标；

功能模块分析：给出完整的功能模块图

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143554557.png)

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143626250.png)

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143657969.png)

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143719434.png)

数据库分析：从概念模型（给出E-R图）到数据模型（数据库表结构）的设计；

![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143823521.png)                                                                          

 

l 系统的技术介绍

Ø JavaScript；

1.JavaScript介绍

在1995年时，由Netscape公司的Brendan Eich，在网景导航者浏览器上首次设计实现而成。因为Netscape与Sun合作，Netscape管理层希望它外观看起来像Java，因此取名为JavaScript。

\2. JavaScript特点

安全性较高

跨平台，兼容性好

\3. JavaScript的组成

JavaScript主要由三部分组成：ECMAScript、DOM、BOM。

ECMAScript：描述了JavaScript的基本语法（所有浏览器都支持）；

DOM：文档对象模型。提供了处理网页内容的方法；

BOM：浏览器对象模型。提供了与浏览器进行交互的方法；

Ø JQuery；

jQuery是一个快速、简洁的JavaScript框架，是继Prototype之后又一个优秀的JavaScript代码库（或JavaScript框架）。jQuery设计的宗旨是“write Less，Do More”，即倡导写更少的代码，做更多的事情。它封装JavaScript常用的功能代码，提供一种简便的JavaScript设计模式，优化HTML文档操作、事件处理、动画设计和Ajax交互。

Ø MySQL；

MySQL是一种关系数据库管理系统，关系数据库将数据保存在不同的表中，而不是将所有数据放在一个大仓库内，这样就增加了速度并提高了灵活性。

MySQL所使用的 SQL 语言是用于访问数据库的最常用标准化语言。MySQL 软件采用了双授权政策，分为社区版和商业版，由于其体积小、速度快、总体拥有成本低，尤其是开放源码这一特点，一般中小型网站的开发都选择 MySQL 作为网站数据库。由于其社区版的性能卓越，搭配 PHP 和 Apache 可组成良好的开发环境

Ø MVC；

MVC全名是Model View Controller，是模型(model)－视图(view)－控制器(controller)的缩写，一种软件设计典范，用一种业务逻辑、数据、界面显示分离的方法组织代码，将业务逻辑聚集到一个部件里面，在改进和个性化定制界面及用户交互的同时，不需要重新编写业务逻辑。MVC被独特的发展起来用于映射传统的输入、处理和输出功能在一个逻辑的图形化用户界面的结构中。

Ø JDBC；

JDBC（Java DataBase Connectivity,java数据库连接）是一种用于执行SQL语句的Java API，可以为多种关系数据库提供统一访问，它由一组用Java语言编写的类和接口组成。JDBC提供了一种基准，据此可以构建更高级的工具和接口，使数据库开发人员能够编写数据库应用程序，同时，JDBC也是个商标名。

Ø DBUtils；

Commons DbUtils是Apache组织提供的一个对JDBC进行简单封装的开源工具类库，使用它能够简化JDBC应用程序的开发，同时也不会影响程序的性能。

Ø C3P0；

C3P0是一个开源的JDBC连接池，它实现了数据源和JNDI绑定，支持JDBC3规范和JDBC2的标准扩展。目前使用它的开源项目有Hibernate，Spring等。

l 系统开发平台及运行环境介绍；

Ø 系统开发平台：例如，给出你当前的操作系统（win7）、Web服务器（Tomcat6）、IDE（MyEclipse10）等；

Ø 系统运行环境：例如，本系统可以安装到Linux、windows等系统上；可以使用的Web服务器；客户可以使用的浏览器等；

## 四、    系统实现

用简明扼要的文字描述各模块的实现过程，可以加上功能结构图、流程图、用例图、状态图等，也可以将网页运行结果贴图。

| 1.    网上书城系统流程图  用户通过后台数据验证进行登录，如校验通过，则进行登录；如校验不通过，则用户进行注册。        ![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829143950466.png) **网上书城系统功能结构设计图** |
| ------------------------------------------------------------ |
| ![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144007432.png)     **网上书城系统流程图** |
| ![](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144142483.png)  **网上书城系统数据图** |

2. 游客因后台数据库没有游客信息，所以需点击注册页面进行注册，游客注册后的数据录入后台t_user表中。

在输入框游客的账号密码信息点击立即注册按钮,提交用户信息到后台处理,后台校验信息合法性,是否格式一致,如通过则注册成功,否则转发错误信息到登陆页面。

​          ![image-20200829144204061](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144204061.png)     

​                         

![image-20200829144212043](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144212043.png)

3. 用户修改密码信息

会员点击修改密码按钮,跳转到修改密码页面,填写原密码以及新密码+确定新密码，点击提交,后台接收表单数据,修改并更新t_user表中相应的用户密码。

![image-20200829144225463](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144225463.png)                                          

4. 退出登录

用户点击退出按钮,后台数据库接收到提交退出请求 并删除用户session信息,跳转到登陆页面进行重新登录。

​             ![image-20200829144234756](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144234756.png) 

5. 加入购物车

在分栏区选择目标图书加入购物车，点击则进入购买页面，用户可根据自身要求选择图书的数量进行点击购买按钮，在下单的同时也可以修改收货地址，提交订单的同时，网页将弹出订单成功页面。

​            ![image-20200829144244264](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144244264.png)                                                                                                                                          

![image-20200829144254672](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144254672.png)

![image-20200829144315098](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144315098.png)

![image-20200829144326220](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144326220.png)

![image-20200829144339815](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144339815.png)

   6.图书分类管理与图书搜索

图书分类管理，可根据搜索功能进行搜索、查看，也可根据高级搜索按钮进行搜索、查看，如书籍的作者、出版社、书名。

​             ![image-20200829144357588](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144357588.png)                                                                                                              

 ![image-20200829144403891](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144403891.png)

![image-20200829144413778](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144413778.png)

![image-20200829144422535](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144422535.png)

7. 图书订单查看

 用户可以在购物车提交并生成订单后直接进行支付购买,也可以点击我的订单按钮进入到我的订单页面进行相关操作

​                           ![image-20200829144432368](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144432368.png)                                                                                         

![image-20200829144439471](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144439471.png)

![image-20200829144446192](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144446192.png)

 ![image-20200829144453708](https://blog-lin1.oss-cn-shenzhen.aliyuncs.com/img/image-20200829144453708.png)

## 五、    实训收获

---

主要总结在开发过程中学习到的专业知识、解决问题的典型过程。以及以后努力的方向。

在开发过程中开发工具是用J2SE平台，JSP是一种可以撰写跨平台动态网页的面向对象的程序设计语言。  Java jsp技术具有卓越的通用性、高效性、平台移植性和安全性。

网上书城系统的性能主要是从界面和可供操作两个方面来评价的。界面是通过动态jsp网页所显示的优化程度来作为指标的。在操作处理方面，可供三种方式不同的操作，即用户、游客和管理员操作。在程序代码上实现模块化，使得每一个独立的功能都能相互联系，为以后的使用修改减少维护时间，提高效率。

网上书城系统包含jsp网页处理和数据库。本次项目运用了servlet,前后端传参,数据传递,页面转发以及重定。向由管理员进行数据处理，后台管理操作，用户前台登陆、注册信息、查询图书操作。通过后台数据库，可以查找用户信息，通过前台，用户将信息提交到后台数据库，所有的操作是将前台页面与后台页面数据库进行交互的操作。

本项目过程激活码一直激活不了，经查阅资料百度，疑惑基本解决。

**用户模块WEB层（UserServlet类）激活功能基本思路如下**：

1. 获取参数激活码

2. 用激活码调用service方法完成激活

\> service方法有可能抛出异常, 把异常信息拿来，保存到request中，转 发到msg.jsp显示

3. 保存成功信息到request，转发到msg.jsp显示。

**用户模块业务层（UserService类）激活功能基本思路如下：**

1. 通过激活码查询用户

2. 如果User为null，说明是无效激活码，抛出异常，给出异常信息（无效激活码）

3. 查看用户状态是否为true，如果为true，抛出异常，给出异常信息（请不要二次激活）

4. 修改用户状态为true

在本次项目系统开发的过程中，许多知识我并不熟悉，一边查找资料一边编写代码，这大大提高了我的学习、运行新知识的能力，也更加提高了程序纠错能力。通过本次项目，我深刻认识到，知识储备的重要性，想要做好一个项目，就必须有足够的知识，这更告诫我们知识是成功的基础。