# ExecutorService
---
```
ExecutorService fiExecutorService = Executors.newFixedThreadPool(10);
MyTask myTask = new MyTask();
fiExecutorService.execute(myTask);
相当于xxxThread.start();// havent join
```
因为java系统给我们提供的线程池包，他只会把提交的任务交给线程，并启动，不会join.

---

同时如果myTask是继承了Thread，通过对他的守护线程设置不会起作用，因为
线程池默认使用的是DefaultThreadFactory，具体实现如下；（可以自定义Factory）
```
 public Thread newThread(Runnable r) {
    Thread t = new Thread(group, r,
                          namePrefix + threadNumber.getAndIncrement(),
                          0);
    if (t.isDaemon())
        t.setDaemon(false);
    if (t.getPriority() != Thread.NORM_PRIORITY)
        t.setPriority(Thread.NORM_PRIORITY);
    return t;
}
```
