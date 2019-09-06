一、目录结构：
  |- HomeDir
     |- hyou-codemaker-1.0.0.jar
     |- config
        |- application.properties
     |- vm
        |- bean.vm
        |- dao.vm
        |- mapper.vm
        |- serviceImpl.vm
        |- serviceInterface.vm




二、各文件说明
1. hyou-codemaker-1.0.0.jar ：可执行文件入口
2. application.properties   ： 配置文件，包括数据库连接、代码生成时的一些基本参数等配置
3. bean.vm                  ： Bean类（Pojo）代码模板
4. dao.vm                   ： MyBatis Mapper接口定义类模板（不用Dao方式调用SQL的话这个用不到）
5. mapper.vm                ： MyBatis SQL Mapper配置文件模板
6. serviceImpl.vm           ：Service实现类代码模板
7. serviceInterface.vm      : Service接口类代码模板




三、使用说明
1. 修改配置文件 ./conf/application.properties

1.1. jdbc.ds.url      : 数据库连接URL
1.2. jdbc.ds.username ：数据库连接用户名
1.3. jdbc.ds.password : 数据库连接密码

  -- 数据库连接配置，需要有infomation_schema的读权限，可以读取表结构信息。


1.4. config.bean.tableName : 要生成代码的数据库表名
  -- 目前只支持单表生成代码，可通过配置文件指定生成代码的数据库表。
  -- 也可以在执行java -jar 指令的时候动态的指定该参数(参见下文)。


1.5. config.base.schameName : 表所在的数据库schame名称

1.6. config.base.author     : 代码作者(你的名字)
1.7. config.base.version    : 代码版本号

1.8. config.base.destDir    : 代码文件生成的目录路径(./destfiles 表示当前目录下的destfiles文件夹内)

1.9. config.base.pojoPackage : Bean类的包名
1.10. config.base.daoPackage : Dao类的包名(不用Dao模式的话可以不用管它)
1.11. config.base.serviceItfcPackage : Service接口类的包名
1.12. config.base.serviceImplPackage : Service实现类的包名


2. 执行命令说明

2.1 方式一，示例：
  java -jar hyou-codemaker-1.0.0.jar
  
  -- 这种方式要生成代码的表名在application.properties中获取

2.2. 方式二，示例：
  java -Dconfig.bean.tableName=t_school -jar hyou-codemaker-1.1.0.jar
  
  -- 这种方式通过参数动态指定要生成代码的表名，其中“t_school”这个参数值为具体的表名

2.3. 方式三，示例：
  java -jar hyou-codemaker-1.2.0.jar t_table t_city t_school
  
  -- 这种方式用于多个表生成代码，后面的参数"t_table t_city t_school"即为表名，多个表以空格分隔.
