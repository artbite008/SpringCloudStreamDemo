# Spring Cloud Stream Demo

## Spring Cloud Stream介绍
[http://blog.spring-cloud.io/blog/sc-stream.html](http://blog.spring-cloud.io/blog/sc-stream.html)

## 本实例运行步骤
###1，运行rabbitmq docker镜像
```
docker pull rabbitmq:management
docker run --name rabbit -P -d rabbitmq:management
```
第一次创建docker容器以后，再次运行用
```
docker start rabbit 
```
具体AMQP端口和监控端口可以用docker ps查看。
如果docker容器的AMQP端口不是32771，请修改application.properties的spring.rabbitmq.port。

###2，使用默认用户名密码guest/guest访问rabbitmq控制台
[http://localhost:32769](http://localhost:32769)

###3，运行Application.java,程序启动过程中请忽略mogodb的报错信息。

###4，程序启动成功后，在rabbitmq的控制台（http://localhost:32769），查看exchange列表，如果有如下3个新的exchange出现，代表rabbitmq连接成功。
![https://raw.githubusercontent.com/artbite008/SpringCloudStreamDemo/master/images/Snap4.png](https://raw.githubusercontent.com/artbite008/SpringCloudStreamDemo/master/images/Snap4.png)
###5，如上图rabbitmq控制台，点击Exchange: message-in，
