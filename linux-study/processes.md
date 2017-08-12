# processes

- #### top – 显示任务
  ```
  1	top	程序名。
    14:59:20	当前时间。
    up 6:30	这是正常运行时间。它是计算机从上次启动到现在所运行的时间。 在这个例子里，系统已经运行了六个半小时。
  2 users	有两个用户登录系统。
    load average:	加载平均值是指，等待运行的进程数目，也就是说，处于运行状态的进程个数， 这些进程共享 CPU。展示了三个数值，每个数值对应不同的时间周期。第一个是最后60秒的平均值， 下一个是前5分钟的平均值，最后一个是前15分钟的平均值。若平均值低于1.0，则指示计算机 工作不忙碌。
  2	Tasks:	总结了进程数目和各种进程状态。
  3	Cpu(s):	这一行描述了 CPU 正在执行的进程的特性。
    0.7%us	0.7% of the CPU is being used for user processes. 这意味着进程在内核之外。
    1.0%sy	1.0%的 CPU 时间被用于系统（内核）进程。
    0.0%ni	0.0%的 CPU 时间被用于"nice"（低优先级）进程。
    98.3%id	98.3%的 CPU 时间是空闲的。idle
    0.0%wa	0.0%的 CPU 时间来等待 I/O。
  4	Mem:	展示物理内存的使用情况。
  5	Swap:	展示交换分区（虚拟内存）的使用情况。
  ```
- #### jobs – 列出活跃的任务

- #### bg – 把一个任务放到后台执行

- #### fg – 把一个任务放到前台执行

- #### kill – 给一个进程发送信号

- #### killall – 杀死指定名字的进程

- #### shutdown – 关机或重启系统

- #### 其它与进程相关的命令
  ```
  pstree	输出一个树型结构的进程列表，这个列表展示了进程间父/子关系。
  ubuntu$ pstree
    systemd─┬─accounts-daemon─┬─{gdbus}
          │                 └─{gmain}
          ├─acpid
          ├─2*[agetty]
          ├─atd
          ├─cron
          ├─dbus-daemon
          ├─dhclient
          ├─epmd
          ├─2*[iscsid]
          ├─java───40*[{java}]
          ├─lvmetad
          ├─lxcfs───10*[{lxcfs}]
          ├─mdadm
          ├─polkitd─┬─{gdbus}
          │         └─{gmain}
          ├─redis-server───3*[{redis-server}]
          ├─rsyslogd─┬─{in:imklog}
          │          ├─{in:imuxsock}
          │          └─{rs:main Q:Reg}
          ├─snapd───6*[{snapd}]
          ├─sshd───sshd───sshd───bash───pstree
          ├─systemd───(sd-pam)
          ├─systemd-journal
          ├─systemd-logind
          ├─systemd-timesyn───{sd-resolve}
          └─systemd-udevd

  ```
  ```
  vmstat 输出一个系统资源使用快照，包括内存，交换分区和磁盘 I/O。 为了看到连续的显示结果，则在命令名后加上延时的时间（以秒为单位）。例如，“vmstat 5”。 终止输出，按下 Ctrl-c 组合键。
  ```
  Chinese ：<http://www.cnblogs.com/ggjucheng/archive/2012/01/05/2312625.html>
  japanese ：<http://piro791.blog.so-net.ne.jp/2008-10-02>
  ```
  eg ：
    ubuntu$ vmstat 5 7
    procs -----------memory---------- ---swap-- -----io---- -system-- ------cpu-----
     r  b   swpd   free   buff  cache   si   so    bi    bo   in   cs us sy id wa st
     0  0      0  68164  26984 210556    0    0     4     3    3    3  0  0 100  0  0
     0  0      0  68052  26992 210548    0    0     0     4   76  155  0  0 100  0  0
     0  0      0  67884  26992 210560    0    0     0     0   85  168  0  0 100  0  0
     0  0      0  67864  27000 210560    0    0     0     2   75  153  0  0 100  0  0
     0  0      0  67888  27000 210560    0    0     0     0   74  152  0  0 100  0  0
     0  0      0  67888  27000 210560    0    0     0     2   75  151  0  0 100  0  0
     0  0      0  67888  27004 210560    0    0     0     3   74  152  0  0 100  0  0
    ubuntu$
  ```
  ```
  xload	一个图形界面程序，可以画出系统负载的图形。
  tload	与 xload 程序相似，但是在终端中画出图形。使用 Ctrl-c，来终止输出。
  ```
