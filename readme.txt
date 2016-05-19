1.spring-mybatis.xml
	<!-- SqlSession模板类实例 -->
	<bean id="sessionTemplate" class="org.mybatis.spring.SqlSessionTemplate" destroy-method="close" scope="prototype">
		<constructor-arg index="0" ref="sqlSessionFactory" />
	</bean>
	
  Q:bean中的destory-method 和 scope 分别怎么理解?
	
	
2.Q:权限控制 使用spring security | shrio ?
  A:
  


3.Q:Cannot change version of project facet Dynamic Web Module to 3.0
  A:update < web.xml >-< web-app >-< version >
  
  Q:Dynamic Web Module 3.0 requires Java 1.6 or newer error.
  A:pom.xml add:
	<build>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<configuration>
					<source>1.7</source>
					<target>1.7</target>
				</configuration>
			</plugin>
		</plugins>
	</build>
	
4.Q:druid encode password
  A:java -cp druid-0.2.23.jar com.alibaba.druid.filter.config.ConfigTools password
  

5.Q:<packaging>war</packaging>   web.xml is missing and <failOnMissingWebXml> is set to true
  A:create the web.xml file.
  
6.Q:maven有哪些内置变量
  A:Maven内置变量说明：
	${basedir} 项目根目录
	${project.build.directory} 构建目录，缺省为target
	${project.build.outputDirectory} 构建过程输出目录，缺省为target/classes
	${project.build.finalName} 产出物名称，缺省为${project.artifactId}-${project.version}
	${project.packaging} 打包类型，缺省为jar
	${project.xxx} 当前pom文件的任意节点的内容
	
7.Q:maven生命周期 build阶段
  A:generate-sources: 通常是通过插件支持创建额外的源代码。
	compile: 编译项目应用代码
	test-compile: 编译项目单元测试代码
	test: 运行项目单元测试（一般为Junit 测试）
	package: 打包项目可以执行代码（以Jar/War/Ear形式）
	integration-test: 如有需要处理及部署应用以便执行系统集成测试。
	install: 将应用打包发布到本地Maven 软件包以便其它Maven引用。（注意Install不是指安装Java应用）
	deploy: 发布到远程Maven软件包以便其他Maven项目下载引用。
	
8.Q:
  

