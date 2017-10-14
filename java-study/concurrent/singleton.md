## 寻找最优雅的多线程下的单例模式

#### 1 最常用的， 但是这样的方式在并发中不能精确控制()单例)具体创建的时间。 如果觉得这种不足不重要，那么这种模式应该首选的
```java
package testatomic;

public class SingletonDemo {
	public static int STATUS = 1;// for test
	private static SingletonDemo instatnce = new SingletonDemo();
	private SingletonDemo() {
		System.out.println("single ton is created.");
	}
	public static SingletonDemo getInstance() {
		return instatnce;
	}
}
```
```java
// 测试类的加载过程
package testatomic;

public class SingletonDemoTest {
	public static void main(String[] args) {
		System.out.println("main");// 1
    System.out.println(SingletonDemo.STATUS);//calss load then fill static variables
	}
}
```
```result
main
single ton is created.
1
```
---

#### 2 lazySingleton 这种可以控制在第一次调用的时候去创建对象。但是使用了同步锁。效率不是很好。
```java
package testatomic;

public class LazySingleton {

	private static LazySingleton instatnce = null;
	private LazySingleton() {
		System.out.println("lazy singleton is created.");
	}
	public synchronized static LazySingleton getInstance() {// add synchronized to ensure this calss is instatnced once
		if (instatnce == null) {
			instatnce = new LazySingleton();
		}
		return instatnce;
	}
}
```
#### 3 使用内部类实现，应该能完美解决上边两个的问题。
---
```java
package testatomic;

public class StaticSingleton {

	public static int STATUS = 1;// for test FIXME to delete

	private StaticSingleton() {
		System.out.println("StaticSingleton is created.");
	}

	private static class SingletonHolder {
		private static StaticSingleton instance = new StaticSingleton();
	}

	public static StaticSingleton getInstance() {
		return SingletonHolder.instance;
	}
}

```
```java
package testatomic;

public class TestMain {
	public static void main(String[] args) {
		System.out.println("main");
		// access static variable can'nt create instance.
		System.out.println(StaticSingleton.STATUS);
		// invoke getInstance then create StaticSingleton.
		StaticSingleton singleton = StaticSingleton.getInstance();
	}
}
```
```result
main
1
StaticSingleton is created.
```
