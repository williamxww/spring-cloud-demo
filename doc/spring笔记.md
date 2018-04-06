



### ClassLoader

org.springframework.util.ClassUtils#getDefaultClassLoader

```java
public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread().getContextClassLoader();
		}
		catch (Throwable ex) {
			// Cannot access thread context ClassLoader - falling back...
		}
		if (cl == null) {
			// No thread context class loader -> use class loader of this class.
			cl = ClassUtils.class.getClassLoader();
			if (cl == null) {
				// getClassLoader() returning null indicates the bootstrap ClassLoader
				try {
					cl = ClassLoader.getSystemClassLoader();
				}
				catch (Throwable ex) {
					// Cannot access system ClassLoader - oh well, maybe the caller can live with null...
				}
			}
		}
		return cl;
	}
```

BootstrapClassLoader、ExtClassLoader、AppClassLoader分别对应的加载路径为 `sun.boot.class.path`、 `java.ext.dirs` 和 `java.class.path`



读取多个jar的META-INF/spring.factories文件，

org.springframework.boot.SpringApplication#getSpringFactoriesInstances(java.lang.Class<T>)



spring boot 源码

https://blog.csdn.net/dm_vincent/article/details/76735888

https://segmentfault.com/a/1190000006918229



SpringApplication对象创建时，初始化ApplicationContextInitializer, ApplicationListener
两接口的相关实现放置在META-INF/spring.factories

准备Environment
context初始化前的准备


org.springframework.context.annotation.AnnotatedBeanDefinitionReader#registerBean(java.lang.Class<?>, java.lang.String, java.lang.Class<? extends java.lang.annotation.Annotation>...)
AnnotatedGenericBeanDefinition


HashMap源码解析

https://www.cnblogs.com/ITtangtang/p/3948406.html



OSGI原理？



spring cloud ribbon原理

https://www.cnblogs.com/kongxianghai/p/8445030.html



先写ICE-springcloud

研究spring cloud sidecar

spring-cloud-netflix-sidecar

怎么支持GO的



标记@RibbonClient
RibbonClientConfiguration


SidecarController#DiscoveryClient的实现类是如何注入的

SidecarProperties的 @ConfigurationProperties("sidecar")原理