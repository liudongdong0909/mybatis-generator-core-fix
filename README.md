# mybatis-generator-core-fix
mybatis generator 生成数据库备注为注释 修整部分代码的样式

本工程为maven项目，可以直接打包使用

1. master 主要是原生样式的代码生成，不包含任何的第三方。

2. branches-swagger 主要是整合了 swagger来生成带有swagger 注释的model， 用于在线文档。

3. branches-swagger-tkmapper 主要整合了 swagger 和 tk 通用mapper ，以及hibernate-validator的数据校验

生成后的样式：
```

package com.imooc.seckill.model;

import java.util.Date;

/**
 * 秒杀
 * TbSeckill
 * 数据库表：tb_seckill
 */
public class TbSeckill {

    /**
     * 商品库存id
     * 表字段 : tb_seckill.id
     */
    private Long id;

    /**
     * 商品名称
     * 表字段 : tb_seckill.name
     */
    private String name;



    /**
     * 获取 商品库存id 字段:tb_seckill.id
     *
     * @return tb_seckill.id, 商品库存id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 商品库存id 字段:tb_seckill.id
     *
     * @param id the value for tb_seckill.id, 商品库存id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 商品名称 字段:tb_seckill.name
     *
     * @return tb_seckill.name, 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 商品名称 字段:tb_seckill.name
     *
     * @param name the value for tb_seckill.name, 商品名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

}
```

# mybatis-generator的使用
参照：
Intellij IDEA 2016学习系列之（二）mybatis-generator自动生成:http://blog.csdn.net/liudongdong0909/article/details/51534735


Intellij IDEA 2016学习系列之（三）修改mybatis-generator源码生成中文:http://blog.csdn.net/liudongdong0909/article/details/52427967

## 在自己工程中的resources 文件下新建一个：generatorConfig.xml


```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
  PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
  "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>

	<!-- 本地数据库连接jar -->
	<classPathEntry location="D:/mysql-connector-java-5.1.20-bin.jar" />

	<context id="testTables" targetRuntime="MyBatis3">

		<!--<commentGenerator>
			&lt;!&ndash; 是否去除自动生成的注释 true：是 ： false:否 &ndash;&gt;
			<property name="suppressAllComments" value="true" />
		</commentGenerator>-->
		<commentGenerator type="org.mybatis.generator.internal.DG2CommentGenerator">
			<property name="javaFileEncoding" value="UTF-8"/>
			<!-- 是否去除自动生成的注释 true：是 ： false:否 -->
			<!--建议一定要保留suppressAllComments属性(使用默认值false)，
            一定要取消(设为true)时间戳suppressDate，避免重复提交SVN。-->
			<property name="suppressAllComments" value="false" />
			<property name="suppressDate" value="true" />
		</commentGenerator>

		<!--数据库连接的信息：驱动类、连接地址、用户名、密码 -->
		<jdbcConnection driverClass="com.mysql.jdbc.Driver"
			connectionURL="jdbc:mysql://localhost:3306/ecps" userId="root" password="root">
		</jdbcConnection>

		<!-- 默认false，把JDBC DECIMAL 和 NUMERIC 类型解析为 Integer，为 true时把JDBC DECIMAL 
			和 NUMERIC 类型解析为java.math.BigDecimal -->
		<javaTypeResolver>
			<property name="forceBigDecimals" value="false" />
		</javaTypeResolver>

		<!-- targetProject:生成PO类的位置 -->
		<javaModelGenerator targetPackage="com.ecps.pojo"
			targetProject="../ecps-manager-pojo/src/main/java">
			<!-- enableSubPackages:是否让schema作为包的后缀 -->
			<property name="enableSubPackages" value="false" />
			<!-- 从数据库返回的值被清理前后的空格 -->
			<property name="trimStrings" value="true" />
		</javaModelGenerator>

		<!-- targetProject:mapper映射文件生成的位置 -->
		<sqlMapGenerator targetPackage="com.ecps.mapper"
			targetProject="../ecps-manager-mapper/src/main/java">
			<!-- enableSubPackages:是否让schema作为包的后缀 -->
			<property name="enableSubPackages" value="false" />
		</sqlMapGenerator>

		<!-- targetPackage：mapper接口生成的位置 -->
		<javaClientGenerator type="XMLMAPPER" targetPackage="com.ecps.mapper"
			 targetProject="../ecps-manager-mapper/src/main/java">
			<!-- enableSubPackages:是否让schema作为包的后缀 -->
			<property name="enableSubPackages" value="false" />
		</javaClientGenerator>

		<!-- 指定数据库表 -->
		
		<table schema="" tableName="tb_user"></table>

	</context>
</generatorConfiguration>

```
## IDEA 中在自己工程的pom.xml中添加：
```
 <build>
        <finalName>${project.artifactId}</finalName>
            <plugins>
                <plugin>
                    <groupId>org.mybatis.generator</groupId>
                    <artifactId>mybatis-generator-maven-plugin</artifactId>
                    <version>1.3.2</version>
                    <configuration>
                        <!--配置文件的位置-->
                        <configurationFile>src/main/resources/generatorConfig.xml</configurationFile>
                        <verbose>true</verbose>
                        <overwrite>true</overwrite>
                    </configuration>
                    <executions>
                        <execution>
                            <id>Generate MyBatis Artifacts</id>
                            <goals>
                                <goal>generate</goal>
                            </goals>
                        </execution>
                    </executions>
                    <dependencies>
                        <dependency>
                            <groupId>org.mybatis.generator</groupId>
                            <artifactId>mybatis-generator-core</artifactId>
                            <!-- 版本是本工程checkout 之后 clean install 之后的版本号-->
                            <version>1.3.2-fix</version>
                        </dependency>
                    </dependencies>
                </plugin>
            </plugins>
    </build>
```
## Eclipse 中在install本工程后，直接时候插件生成即可，不需要配置pom.xml
