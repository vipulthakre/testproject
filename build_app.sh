#!/bin/bash

cd /var/lib/jenkins/workspace/$1

sudo mvn clean package
