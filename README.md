# Spring Cloud Stream Demo

## Spring Cloud Stream中文介绍
[http://blog.spring-cloud.io/blog/sc-stream.html](http://blog.spring-cloud.io/blog/sc-stream.html)

## Spring Cloud Stream Reference Guide
[https://docs.spring.io/spring-cloud-stream/docs/Ditmars.RELEASE/reference/htmlsingle/#_spring_cloud_stream_core](https://docs.spring.io/spring-cloud-stream/docs/Ditmars.RELEASE/reference/htmlsingle/#_spring_cloud_stream_core)


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

###3，运行Application.java,程序启动过程中请忽略mongodb的报错信息。

###4，程序启动成功后，在rabbitmq的控制台（http://localhost:32769），查看exchange列表，如果有如下3个新的exchange出现，代表rabbitmq连接成功。
![https://raw.githubusercontent.com/artbite008/SpringCloudStreamDemo/master/images/Snap4.png](https://raw.githubusercontent.com/artbite008/SpringCloudStreamDemo/master/images/Snap4.png)

###5，如上图rabbitmq控制台，点击Exchange: message-in，出现下图的输入界面。依次输入Routing key、Headers、Payload如下图。然后点击发布消息。
![https://raw.githubusercontent.com/artbite008/SpringCloudStreamDemo/master/images/Snap5.png](https://raw.githubusercontent.com/artbite008/SpringCloudStreamDemo/master/images/Snap5.png)

###6，查看程序控制台。
看到下面这个日志说明刚才在rabbitmq控制台发布的消息已经被程序MessagingChannel.java的handle方法收到。
```
[com.github.artbite008.springcloudstreamdemo.messaging.MessageReceiver]- got message from message-in, test
```
看到下面这个日志说明刚才在通过程序代码MessagingChannel.java中的代码“messagingChannel.output().send(msg)”发布的消息已经被rabbitmq控制台收到，并通过下图的转发机制，重新转发到message-in-test这个exchange, 最后被MessageReceiver.java的test方法收到。
```
[com.github.artbite008.springcloudstreamdemo.messaging.MessageReceiver]- got message from message-in-test, TEST
```

message-out exchange绑定到message-in-test
![https://raw.githubusercontent.com/artbite008/SpringCloudStreamDemo/master/images/Snap6.png](https://raw.githubusercontent.com/artbite008/SpringCloudStreamDemo/master/images/Snap6.png)
