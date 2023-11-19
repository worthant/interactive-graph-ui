#!/bin/bash

echo "Deploying to Helios"

## Remove existing deployment
ssh -p 2222 UNI_NUMBER@se.ifmo.ru "rm -rf wildfly-26.1.3/standalone/deployments/interactive-graph-ui-1.0-SNAPSHOT.war"
# add new deployment
scp -P 2222 ./target/interactive-graph-ui-1.0-SNAPSHOT.war UNI_NUMBER@se.ifmo.ru:wildfly-26.1.3/standalone/deployments