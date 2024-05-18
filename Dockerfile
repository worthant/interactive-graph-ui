FROM openjdk:17-alpine

ENV WILDFLY_VERSION preview-26.1.3.Final
ENV WILDFLY_HOME /opt/wildfly

RUN apk update && apk add --no-cache \
    wget \
    bash \
    zip \
    unzip

RUN wget https://github.com/wildfly/wildfly/releases/download/26.1.3.Final/wildfly-preview-26.1.3.Final.zip \
    && unzip wildfly-$WILDFLY_VERSION.zip -d /opt \
    && ln -s /opt/wildfly-$WILDFLY_VERSION $WILDFLY_HOME \
    && rm wildfly-$WILDFLY_VERSION.zip

RUN wget https://jdbc.postgresql.org/download/postgresql-42.3.1.jar -O /tmp/postgresql.jar \
    && $WILDFLY_HOME/bin/jboss-cli.sh --command="module add --name=org.postgresql --resources=/tmp/postgresql.jar --dependencies=javax.api,javax.transaction.api"

ENV POSTGRES_DB studs
ENV POSTGRES_USER UNI_NUMBER
ENV POSTGRES_PASSWORD PASSWORD
ENV PORTBASE 32318
ENV JCONSOLE_PORT 32321

COPY ./resources/standalone.xml $WILDFLY_HOME/standalone/configuration/
COPY ./target/interactive-graph-ui-1.0-SNAPSHOT.war $WILDFLY_HOME/standalone/deployments/

EXPOSE $PORTBASE $JCONSOLE_PORT

CMD $WILDFLY_HOME/bin/standalone.sh -b 0.0.0.0 \
    -Dcom.sun.management.jmxremote \
    -Dcom.sun.management.jmxremote.port=$JCONSOLE_PORT \
    -Dcom.sun.management.jmxremote.rmi.port=$JCONSOLE_PORT \
    -Dcom.sun.management.jmxremote.authenticate=false \
    -Dcom.sun.management.jmxremote.ssl=false \
    -Djava.rmi.server.hostname=172.17.0.1  # Укажите IP адрес сети docker0
