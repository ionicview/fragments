# ps

- #### 10个重要的Linux ps命令实战  
  <https://linux.cn/article-4743-1.html>  
- #### 最常用的命令一览
  ```

  # 各参数的意思 a ->all,  x-> another terminal
  ubuntu$ ps -ax | less

  # user
  ubuntu$ ps -u ubuntu
    PID TTY          TIME CMD
   1134 ?        00:00:00 systemd
   1136 ?        00:00:00 (sd-pam)
  25326 ?        00:00:00 sshd
  25327 pts/1    00:00:00 bash
  25616 ?        00:00:00 sshd
  25617 pts/2    00:00:00 bash
  25657 pts/2    00:00:00 ps
  28958 ?        00:26:51 redis-server
  ubuntu$

  # sort by cpu
  ubuntu$ ps -aux --sort -pcpu | head -10
  USER       PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
  root         1  0.0  0.9  37680  4840 ?        Ss   May14   0:21 /sbin/init
  root         2  0.0  0.0      0     0 ?        S    May14   0:00 [kthreadd]
  root         3  0.0  0.0      0     0 ?        S    May14   0:02 [ksoftirqd/0]
  root         5  0.0  0.0      0     0 ?        S<   May14   0:00 [kworker/0:0H]
  root         7  0.0  0.0      0     0 ?        S    May14   5:06 [rcu_sched]
  root         8  0.0  0.0      0     0 ?        S    May14   0:00 [rcu_bh]
  root         9  0.0  0.0      0     0 ?        S    May14   0:00 [migration/0]
  root        10  0.0  0.0      0     0 ?        S    May14   0:25 [watchdog/0]
  root        11  0.0  0.0      0     0 ?        S    May14   0:00 [kdevtmpfs]

  # sort by mem
  ubuntu$ ps -aux --sort -pmem | head -10
  USER       PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
  root      1532  0.0 29.3 2089332 146140 ?      Sl   May14  88:52 /usr/java/jdk1.8.0_121/bin/java...
  root     25270  0.0  1.3  95376  6852 ?        Ss   01:52   0:00 sshd: ubuntu [priv]
  root     25584  0.0  1.3  95376  6820 ?        Ss   02:11   0:00 sshd: ubuntu [priv]
  ubuntu   25327  0.0  1.0  21540  5268 pts/1    Ss+  01:52   0:00 -bash
  ubuntu   25617  0.0  1.0  21540  5260 pts/2    Ss   02:12   0:00 -bash
  root         1  0.0  0.9  37680  4840 ?        Ss   May14   0:21 /sbin/init
  root       342  0.0  0.9  36296  4540 ?        Ss   May14   0:17 /lib/systemd/systemd-journald
  root      1032  0.0  0.7   5724  3512 ?        S<Ls May14  10:43 /sbin/iscsid
  ubuntu   25326  0.0  0.6  95376  3404 ?        S    01:52   0:00 sshd: ubuntu@pts/1


  # To see every process on the system using standard syntax:
     $ps -ef

  # To see every process on the system using BSD syntax:
     $ps axu

  # To print a process tree:
     $ps axjf
     $pstree

  # 使用watch进行 动态监视 每隔1秒刷新一次，按照mem和cpu排序 直选择前4个
  watch -n 1 'ps -aux --sort -pmem,+pcpu | head -5'
     Every 1.0s: ps -aux --sort -pmem,+pcpu | head -5                                                                                                Sat Aug 12 02:42:38 2017

     USER       PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
     root      1532  0.0 29.3 2089332 146140 ?      Sl   May14  88:53 /usr/java/jdk1.8.0_121/bin/java...
     root     25270  0.0  1.3  95376  6852 ?        Ss   01:52   0:00 sshd: ubuntu [priv]
     root     25584  0.0  1.3  95376  6820 ?        Ss   02:11   0:00 sshd: ubuntu [priv]
     ubuntu   25327  0.0  1.0  21540  5268 pts/1    Ss+  01:52   0:00 -bas
  ```
