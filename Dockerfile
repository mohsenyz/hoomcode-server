FROM java:8

MAINTAINER Mohsen yazdani

ADD build/libs/hoomcode-all-1.0.jar application.jar

EXPOSE 80

CMD java -jar application.jar