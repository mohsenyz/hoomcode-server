FROM redis:3-alpine

MAINTAINER Mohsen yazdani

RUN apk add --no-cache curl

RUN apk update && apk upgrade && \
    apk add openjdk8-jre && \
    mkdir /tmp/tmprt && \
    cd /tmp/tmprt && \
    apk add zip && \
    unzip -q /usr/lib/jvm/default-jvm/jre/lib/rt.jar && \
    apk add zip && \
    zip -q -r /tmp/rt.zip . && \
    apk del zip && \
    cd /tmp && \
    mv rt.zip /usr/lib/jvm/default-jvm/jre/lib/rt.jar && \
    rm -rf /tmp/tmprt /var/cache/apk/*




ADD build/libs/hoomcode-all-1.0.jar application.jar
ADD runner.sh runner.sh

RUN chmod +x runner.sh

CMD ["./runner.sh"]

EXPOSE 5050
