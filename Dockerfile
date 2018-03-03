FROM dockerfile/java:oracle-java8

MAINTAINER Mohsen yazdani



ADD build/libs/hoomcode-all-1.0.jar application.jar
ADD runner.sh runner.sh

RUN chmod +x runner.sh

CMD ["sh", "runner.sh"]

EXPOSE 80
