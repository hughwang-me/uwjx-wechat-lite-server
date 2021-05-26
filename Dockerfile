FROM registry.cn-shanghai.aliyuncs.com/uwjx/serverjre8:8
MAINTAINER Hugh Wang "18501667737@1633.com"
ENV LANG en_US.utf8
WORKDIR /root
COPY target/uwjx-wechat-lite-server-1.0.0.jar .
EXPOSE 9050
CMD java -jar uwjx-wechat-lite-server-1.0.0.jar --spring.profiles.active=prod