#!/bin/bash

echo "Deploying to Helios"

## Remove existing deployment
ssh -p 2222 s368090@se.ifmo.ru "rm -rf wildfly-26.1.3/standalone/deployments/interactive-graph-ui-1.0-SNAPSHOT.war"
# add new deployment
scp -P 2222 ./target/interactive-graph-ui-1.0-SNAPSHOT.war s368090@se.ifmo.ru:wildfly-26.1.3/standalone/deployments