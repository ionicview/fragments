```java
package testatomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Test AtomicReference
 *
 * @author chenwb47
 *
 */
public class Main {

	// declare loop count for multiThread.
	private static int LOOP_COUNT = 10_000;
	// declare a simple list, after use synchronized to ensure thread safe.
	private static List<String> list = new ArrayList<>();

	// declare a AtomicInteger that can ensure thread safe.
	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	// declare a CopyOnWriteArrayList<String> that can ensure thread safe because of
	// when modify element in CopyOnWriteArrayList
	// copy old and create new array then convert to list;
	private static CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

	// declare a AtomicReference that content new ArrayList<>().
	private static volatile AtomicReference<List<String>> atomicReference = new AtomicReference<List<String>>(
			new ArrayList<>());

	// use volatile fill content but volatile can'nt ensure thread safe; It just can
	// ensure the shared variable can be viewed by multiThread on is modified.
	private static volatile List<String> volatileList = new ArrayList<>();
	private static AtomicReference<List<String>> atomicReferenceHasVolatileContent = new AtomicReference<List<String>>(
			volatileList);

	// use sync to save java8 lambda inner updateAndGet function
	private static AtomicReference<List<String>> atomicReferenceSelfSyncProcesser = new AtomicReference<List<String>>(
			new ArrayList<>());

	static class MyTask implements Runnable {

		@Override
		public void run() {

			// OK
			synchronized (Main.class) { // equals Collections.synchronizedList(list);
				list.add("test");
			}

			// OK
			atomicInteger.incrementAndGet();

			// OK
			copyOnWriteArrayList.add("test");

			// NG
			atomicReference.getAndUpdate((tempList) -> {
				tempList.add("test");
				return tempList;
			});
			// NG
			atomicReferenceHasVolatileContent.updateAndGet((tempList) -> {
				tempList.add("test");
				return tempList;
			});
			// OK
			atomicReferenceSelfSyncProcesser.updateAndGet((tempList) -> {
				// 需要自己保证线程安全，因为我们提供的ArrayList不是线程安全的。
				// updateAndGet 这个方法不是Unsafe。
				synchronized (Main.class) {
					tempList.add("test");
					return tempList;
				}
			});

		}

	}

	public static void main(String[] args) throws InterruptedException {

		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			threads.add(new Thread(new MyTask()));
		}
		for (Thread thread : threads) {
			thread.start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
		// OK
		System.out.println("synchronized list.size" + printSizeAndStatus(list.size()));
		System.out.println("atomicInteger" + printSizeAndStatus(atomicInteger.get()));
		System.out.println("copyOnWriteArrayList.size" + printSizeAndStatus(copyOnWriteArrayList.size()));
		// NG
		System.out.println("atomicReference.get().size" + printSizeAndStatus(atomicReference.get().size()));
		System.out.println("atomicReferenceHasVolatileContent.get().size"
				+ printSizeAndStatus(atomicReferenceHasVolatileContent.get().size()));
		// OK
		System.out.println("atomicReferenceSelfSyncProcesser.get().size"
				+ printSizeAndStatus(atomicReferenceSelfSyncProcesser.get().size()));

	}

	private static String printSizeAndStatus(int size) {
		StringBuilder sb = new StringBuilder();
		sb.append(" : ").append(size).append(',');
		return size == LOOP_COUNT ? sb.append(" OK.").toString() : sb.append(" NG.").toString();
	}
}
```
---
```
>>>
synchronized list.size : 10000, OK.
atomicInteger : 10000, OK.
copyOnWriteArrayList.size : 10000, OK.
atomicReference.get().size : 9996, NG.
atomicReferenceHasVolatileContent.get().size : 9999, NG.
atomicReferenceSelfSyncProcesser.get().size : 10000, OK.
```
