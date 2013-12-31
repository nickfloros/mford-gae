App Engine Java Application Copyright (C) 2010-2012 Google Inc.

## Skeleton application for use with App Engine Java.

```
mvn archetype:generate \
-DarchetypeGroupId=com.google.appengine.archetypes \
-DarchetypeArtifactId=skeleton-archetype 
```
 cd testAppv6

 edit pom.xml and change 
```
                <appengine.target.version>1.7.5</appengine.target.version>
```
 to
 ``` 
                <appengine.target.version>1.8.8</appengine.target.version>
```
change jvm version from 
```
                <configuration>
                    <source>1.6</source>
                    <target>1.6</target>
                </configuration>
```
to 
```
  <configuration>
    <source>1.7</source>
  	<target>1.7</target>
  </configuration>
```                                
add
 
	<dependency>
		<groupId>com.google.appengine</groupId>
		<artifactId>appengine-endpoints</artifactId>
		<version>${appengine.target.version}</version>
	</dependency>

Add following test dependancies 

    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.10</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-all</artifactId>
        <version>1.9.0</version>
        <scope>test</scope>
    </dependency>


replace 

			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<version>2.3</version>
				<configuration>
					<archiveClasses>true</archiveClasses>
					<webResources>
						<!-- in order to interpolate version from pom into appengine-web.xml -->
						<resource>
							<directory>${basedir}/src/main/webapp/WEB-INF</directory>
							<filtering>true</filtering>
							<targetPath>WEB-INF</targetPath>
						</resource>
					</webResources>
				</configuration>
			</plugin>

			<plugin>
				<groupId>com.google.appengine</groupId>
				<artifactId>appengine-maven-plugin</artifactId>
				<version>${appengine.target.version}</version>
			</plugin>

with -- which automatically generates the end point 
```
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>2.3</version>
                <configuration>
                    <webXml>${project.build.directory}/generated-sources/appengine-endpoints/WEB-INF/web.xml</webXml>
                    <webResources>
                        <resource>
                        <directory>${basedir}/src/main/webapp/WEB-INF/</directory>
                            <filtering>true</filtering>
                            <targetPath>WEB-INF</targetPath>
                            <excludes>
                                <exclude>web.xml</exclude>
                            </excludes>
                        </resource>
                        <resource>
                            <directory>${project.build.directory}/generated-sources/appengine-endpoints</directory>
                            <includes>
                                <include>WEB-INF/*.discovery</include>
                                <include>WEB-INF/*.api</include>
                            </includes>
                            <filtering>true</filtering>
                        </resource>
                    </webResources>
                </configuration>
            </plugin>

            <plugin>
                <groupId>com.google.appengine</groupId>
                <artifactId>appengine-maven-plugin</artifactId>
                <version>${appengine.target.version}</version>
                <configuration>
                    <enableJarClasses>false</enableJarClasses>
                        <oauth2>false</oauth2>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>endpoints_get_discovery_doc</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
```            			
Requires [Apache Maven](http://maven.apache.org) 3.0 or greater, and JDK 6+ in order to run.

To build, run

    mvn package

Building will run the tests, but to explicitly run tests you can use the test target

    mvn test

To start the app, use the [App Engine Maven Plugin](http://code.google.com/p/appengine-maven-plugin/) that is already included in this demo.  Just run the command.

    mvn appengine:devserver

For further information, consult the [Java App Engine](https://developers.google.com/appengine/docs/java/overview) documentation.

To see all the available goals for the App Engine plugin, run

    mvn help:describe -Dplugin=appengine

To deploy use

```
  mvn appengine:update
```  
