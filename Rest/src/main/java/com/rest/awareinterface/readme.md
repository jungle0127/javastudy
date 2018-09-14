Spring中提供了一些以Aware结尾的接口，实现了Aware接口的bean在被初始化后，可以获取相应资源

接口 									作用
BeanNameAware 					在Bean中得到它在IOC容器中的Bean的实例的名字
BeanFactoryAware 				在Bean中得到Bean所在的IOC容器，从而直接在Bean中使用IOC容器的服务
ApplicationContextAware 		在Bean中得到Bean所在的应用上下文，从而直接在Bean中使用上下文的服务
MessageSourceAware 				在Bean中得到消息源
ApplicationEventPublisherAware 	在bean中得到应用上下文的事件发布器，从而可以在Bean中发布应用上下文的事件
ResourceLoaderAware 			在Bean中得到ResourceLoader，从而在bean中使用ResourceLoader加载外部对应的Resource资源