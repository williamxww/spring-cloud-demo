



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



spring boot 源码

https://blog.csdn.net/dm_vincent/article/details/76735888



HashMap源码解析

https://www.cnblogs.com/ITtangtang/p/3948406.html



OSGI原理？