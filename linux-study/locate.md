# locate 定位

- #### updatedb

  ```
    # locate 数据库由另一个叫做 updatedb 的程序创建。通常，这个程序作为一个 cron 工作例#程周期性运转；
    # 也就是说，一个任务 在特定的时间间隔内被 cron 守护进程执行。大多数装有 locate 的系统会每隔一天运行一回 updatedb 程序。
    # 因为数据库不能被持续地更新，所以当使用 locate 时，你会发现 目前最新的文件不会出现。
    # 为了克服这个问题，可以手动运行 updatedb 程序， 更改为超级用户身份，在提示符下运行 updatedb 命令。
  ```
  ```
    ubuntu$ locate file-A
    ubuntu$ tree
    .
    ├── folder-01
    │   ├── file-A
    │   ├── file-B
    │   └── file-C
    ├── folder-02
    │   ├── file-A
    │   ├── file-B
    │   └── file-C
    ├── folder-03
    │   ├── file-A
    │   ├── file-B
    │   └── file-C
    ├── superfile-A.txt
    ├── superfile-B.txt
    └── superfile-C.txt

    3 directories, 12 files
    ubuntu$ locate file-A
    ubuntu$ updatedb
    updatedb: can not open a temporary file for `/var/lib/mlocate/mlocate.db'
    ubuntu$ sudo updatedb
    ubuntu$ locate file-A
    /home/ubuntu/test/folder-01/file-A.txt
    /home/ubuntu/test/folder-02/file-A.txt
    /home/ubuntu/test/folder-03/file-A.txt
    /home/ubuntu/test/folder-04/file-A.txt
    /home/ubuntu/test/folder-05/file-A.txt
    /home/ubuntu/test/folder-06/file-A.txt
    /home/ubuntu/test/folder-07/file-A.txt
    /home/ubuntu/test/folder-08/file-A.txt
    /home/ubuntu/test/folder-09/file-A.txt
    /home/ubuntu/test/folder-10/file-A.txt
    /home/ubuntu/test/test/superfile-A.txt
    /home/ubuntu/test/test/folder-01/file-A
    /home/ubuntu/test/test/folder-02/file-A
    /home/ubuntu/test/test/folder-03/file-A
    ubuntu$
  ```
  - #### 和grep一块使用 高亮显示
  ```
    ubuntu$ locate zip | grep bin
    /bin/bunzip2
    /bin/bzip2
    /bin/bzip2recover
    /bin/gunzip
    /bin/gzip
    /usr/bin/gpg-zip
    /usr/bin/zipdetails
    /usr/lib/erlang/lib/erts-7.3/ebin/prim_zip.beam
    /usr/lib/erlang/lib/stdlib-2.8/ebin/zip.beam
    /usr/lib/klibc/bin/gunzip
    /usr/lib/klibc/bin/gzip
    ubuntu$
  ```
