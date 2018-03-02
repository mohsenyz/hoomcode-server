#!/bin/bash

redis-server &
sleep 20
java -jar application.jar