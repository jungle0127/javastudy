# Java Crytography

美国出口限制规定，JCA可以出口，JCE对部分国家是限制出口的。
JCA和JCE是Java平台提供的用于安全和加密服务的两组API，它们并不执行任何算法，只是连接应用和实际算法实现的一组接口；软件开发商可以根据JCE将各自算法实现后打包成一个Provider动态的加载到Java 运行环境中。

## JCA - Java Cryptography Architecture - Java加密体系结构
> 提供的基本的加密框架，如证书，数字签名，消息摘要和密钥对产生器。
## JCE- Java Cryptography Extension - Java加密扩展包
 > JCE在JCA的基础上做了扩展 ,提供了各种加密算法，消息摘要算法和密钥管理等功能。
 > JCE的实现主要在javax.crypto包及其子包中 
## JSSE- Java Secure Sockets Extension - Java安全套接字扩展包
 > 提供基于SSL的加密功能。确实网络通信安全的服务由JSSE提供。
## JAAS- Java Authentication and Authentication Service - Java 鉴别与安全服务
 > 提供用户身份鉴别功能，如符合标准安全机制的登录模块。
 
 # License 实现机制介绍PPT
 https://wenku.baidu.com/view/137a0a5628ea81c759f57887.html
 
## JAAS 体系结构包括以下package: 
> https://www.aliyun.com/jiaocheng/344430.html
javax.security.auth 
javax.security.auth.callback 
javax.security.suth.login 
javax.security.spi 

## Java加解密：
java.security（源码可见）
javax.crypto（源码不可见）
两个包包含了Java 加解密的核心部分

## 密钥
java.security.interfaces
javax.crypto.interfaces
两个包包含了密钥相关的接口

## 规范

java.security.spec
javax.crypto.spec
两个包包含了密钥规范及算法参数规范的类和接口

Java Security系统博客：
https://blog.csdn.net/AllenWells/article/details/46517859

## Hash security level
https://blog.csdn.net/qq_28289405/article/details/80318469