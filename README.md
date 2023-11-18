<!-- Here is the main logo and name of your project -->

<p align="center">
  <a href="resources/MVC.png">
    <picture>
      <img src="resources/logo.png" height="150">
    </picture>
    <h1 align="center">web3-eclipselink-jsf-example</h1>
  </a>
</p>

<!-- Here are some cool labels for your project, delete those, that you don't need -->

<p align="center">
   <a aria-label="WildFly Version" href="https://www.wildfly.org/">
      <img alt="" src="https://img.shields.io/badge/WildFly-26.13-50FA7B?style=for-the-badge&labelColor=000000&color=50FA7B">
   </a>
   <a aria-label="Java Version" href="https://www.oracle.com/java/technologies/javase-jdk17-downloads.html">
      <img alt="" src="https://img.shields.io/badge/Java-17-FFD300?style=for-the-badge&labelColor=000000&color=FFD300">
   </a>
   <a aria-label="JetBrains Runtime Version" href="https://www.jetbrains.com/">
      <img alt="" src="https://img.shields.io/badge/JetBrains_Runtime-17.0.8-00CCFF?style=for-the-badge&labelColor=000000&color=00CCFF">
   </a>
   <a aria-label="Maven Project" href="https://maven.apache.org/">
      <img alt="" src="https://img.shields.io/badge/Maven-Project-FF69B4?style=for-the-badge&labelColor=000000&color=FF69B4">
   </a>
   <!-- New Badge for JavaServer Faces Framework -->
   <a aria-label="JavaServer Faces Framework" href="https://www.oracle.com/java/technologies/javaserverfaces.html">
      <img alt="" src="https://img.shields.io/badge/JSF-Framework-orange?style=for-the-badge&logo=java&labelColor=000000&color=orange">
   </a>
</p>

## Setup Instructions 🛠️

### Project dependencies

---

- **WildFly 26.1.3 Preview Jakarta 9.1**: This is a critical dependency. WildFly 27+ only supports Jakarta EE 10.0.0 where `.xml` configurations for managed beans are no longer available.

- **Jakarta EE Web Profile 9.1.0** and **EclipseLink ORM 3.0.2**: Ensure your `pom.xml` has these. Check [pom.xml](./pom.xml) for reference.

---

### Configuration steps

#### 1. Download and Install WildFly on Helios

- You can [download WildFly 26.1.3 here](https://github.com/wildfly/wildfly/releases/download/26.1.3.Final/wildfly-preview-26.1.3.Final.zip).

#### 2. Standalone Configuration

##### 2.1 Set up Ports

- Use the [port setup](https://github.com/worthant/MVC-GeoValidator#how-to-deploy-your-lab-on-helios-to-make-it-work) from lab2.

##### 2.2 Add PostgreSQL Module

- Run the following command from the `[WILDFLY_ROOT]/bin` directory:

```bash
./jboss-cli.sh
```

**Note**: Don't worry if you get disconnected from the server; it's expected. **Calmly** proceed to the next step!

- Execute the following command:

```bash
module add --name=org.postgresql --resources=/usr/local/share/java/classes/postgresql.jar --dependencies=javax.api,javax.transaction.api
```

##### 2.3 Update `standalone.xml`

- Open `standalone.xml` located at `[WILDFLY_ROOT]/standalone/configuration/`.
- Replace the `<datasources>` section with the snippet below:

> Don't forget to replace `username_from_pgpass` and `password_from_pgpass`  
> You can get them by executing `cat .pgpass` from `~`

```xml
<datasources>
   <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true" statistics-enabled="${wildfly.datasources.statistics-enabled:${wildfly.statistics-enabled:false}}">
            <connection-url>jdbc:postgresql://pg:5432/studs</connection-url>
      <driver>postgresql</driver>
      <security>
            <user-name>username_from_pgpass</user-name>
            <password>password_from_pgpass</password>
      </security>
   </datasource>
   <drivers>
            <driver name="postgresql" module="org.postgresql">
                  <driver-class>org.postgresql.Driver</driver-class>
                  <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
            </driver>
            <driver name="postgres" module="org.postgresql">
                  <driver-class>org.postgresql.Driver</driver-class>
            </driver>
      <driver name="h2" module="com.h2database.h2">
            <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
      </driver>
   </drivers>
</datasources>
```

#### 3. Configure System Resources

In some cases, you might need to increase the metaspace size.

- Add these lines to your `.bash_profile`:

```bash
export _JAVA_OPTIONS="-Xmx512M -XX:MaxMetaspaceSize=3200m"
export JAVA_VERSION="17.0+"
export JAVA_HOME="/usr/local/openjdk17"
export PATH=/usr/local/openjdk17/bin/:$PATH
```

> You can do it like this: `echo 'these lines here' >> .bash_profile`  
> Or just open Vim and do it [like this](https://linuxize.com/post/how-to-copy-cut-paste-in-vim/)

**Note**: Don't forget to relogin into Helios for these changes to take effect.  

**! Important !**: If your server crashed - check if it is still running (`ps -A`) and then `kill -9 [PID]`

#### 4. Update Database Credentials

- Provide the correct login and password in the `resources/db.cfg` file.

> Same credentials from `.pgpass`

#### 5. Build and Deploy

- Build the Maven `.war` archive and deploy it to the server using my [deploy.sh](./deploy.sh):

```bash
./deploy.sh
```
