# gc null
## 首先认识一下null的gcc处理
```
// 因为本地的lombok不好使以及代码的简单 所以没有用private来修饰属性
```
```java
public class Person {
	String name;
	int age;
	Fun fun;

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("GC Perosn " + this);
	}
}
```
```java
public class Fun {
	String name;
	String describetion;

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("GC Fun " + this);
	}
}
```
```java
public class GCTest {

	public static void main(String[] args) throws Throwable {

		Person person = new Person();
		person.name = "chen";
		person.age = 23;
		Fun fun = new Fun();
		fun.name = "basketball";
		fun.describetion = "it is a wonderful sport in";
		person.fun = fun;

		System.out.println(person);
		System.out.println(person.fun);
		person = null;
		System.gc();
		// GC
		System.out.println(person);
		System.out.println(fun);

	}

}

```
```
result :

Person@15db9742
Fun@6d06d69c
Perosn be GCPerson@15db9742
null
Fun@6d06d69c

fun 暂时不会被GC
```
## ThreadLocal null
### default use
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalGCTest {

	private static volatile ThreadLocal<Person> personTL = new ThreadLocal<>();

	static class MyTask implements Runnable {
		@Override
		public void run() {
			if (personTL.get() == null) {
				personTL.set(new Person());
				System.out.println("new person in thread:" + Thread.currentThread().getName());
			} else {
				System.out.println("use old person in thread:" + Thread.currentThread().getName());
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		defaultTest();
		Thread.sleep(1000);
		System.exit(1);
	}

	private static void defaultTest() {
		// ThreadLocal default
		System.out.println("ThreadLocal default start ... ");
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 6; i++) {
			executorService.execute(new MyTask());
		}

	}

}

```
```
result :
ThreadLocal default start ...
new person in thread:pool-1-thread-3
new person in thread:pool-1-thread-1
new person in thread:pool-1-thread-2
use old person in thread:pool-1-thread-1
use old person in thread:pool-1-thread-3
use old person in thread:pool-1-thread-2
```
