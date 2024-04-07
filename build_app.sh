#!/bin/bash

cd /var/lib/jenkins/workspace/$1

mvn clean package
