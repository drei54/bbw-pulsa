Tools
-----------------------------
1. Java 
2. Eclipse (IDE)
3. Spring boot (Framework)
4. Compiler (Maven)
5. Mysql (Database)
6. Git (Repository)

GIT Repository
----------------------------
https://github.com/drei54/bbw-pulsa.git

Run:
-----------------------------
1. Install Maven
	https://maven.apache.org/install.html
2. Clone Project
	open cmd 
	git clone https://github.com/drei54/bbw-pulsa.git [enter]
3. Setting DB
	a. Edit application.propertis in folder bbw-pulsa\src\main\resources\
		i spring.datasource.url = jdbc:mysql://localhost:3306/{database_name}?useSSL=false
		ii. spring.datasource.username = {username}
		iii. spring.datasource.password = {password}
	b. Import Database db.08-03-2018.sql in folder bbw-pulsa\db\

4. Run Apps
	a. open cmd
	b. cd bbw-pulsa
	c. mvn clean install
	d. mvn spring-boot:run

Test
---------------------------
1. open browser
2. go to http://localhost:8083
