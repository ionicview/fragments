# find

- ##### awesome web site
  <http://billie66.github.io/TLCL/book/chap18.html>
- ##### eg:
  - 文件类型  
    ```
      b	块设备文件
      c	字符设备文件
      d	目录
      f	普通文件
      l	符号链接

      ubuntu$ find ~ | wc -l
      59
      ubuntu$ find ~ -type f | wc -l
      48
      ubuntu$ find ~ -type d | wc -l
      11
      ubuntu$
    ```
  - 大小
    ```
    b	512 个字节块。如果没有指定单位，则这是默认值。
    c	字节
    w	两个字节的字
    k	千字节(1024个字节单位)
    M	兆字节(1048576个字节单位)
    G	千兆字节(1073741824个字节单位)

    ubuntu$ find ~ -type f -size +1M # size >= 1M
    /home/ubuntu/redis-4.0.0.tar.gz
    /home/ubuntu/temp/jdk-8u121-linux-x64.tar.gz
    /home/ubuntu/temp/apache-tomcat-9.0.0.M18.tar.gz
    ubuntu$
    ```
  - -newer file 匹配的文件和目录的内容在指定的文件之后修改或者创建
    ```
    #　准备数据

    ubuntu$ mkdir -p folder-{01..10}
    ubuntu$ touch folder-{01..10}/file-{A..D}.txt

    ubuntu$ tree
    .
    ├── folder-01
    │   ├── file-A.txt
    │   ├── file-B.txt
    │   ├── file-C.txt
    │   └── file-D.txt
    ├── folder-02
    │   ├── file-A.txt
    │   ├── file-B.txt
    │   ├── file-C.txt
    │   └── file-D.txt
    ├── folder-03
    │   ├── file-A.txt
    │   ├── file-B.txt
    │   ├── file-C.txt
    │   └── file-D.txt
    ├── folder-04
    │   ├── file-A.txt
    │   ├── file-B.txt
    │   ├── file-C.txt
    │   └── file-D.txt
    ├── folder-05
    │   ├── file-A.txt
    │   ├── file-B.txt
    │   ├── file-C.txt
    │   └── file-D.txt
    ├── folder-06
    │   ├── file-A.txt
    │   ├── file-B.txt
    │   ├── file-C.txt
    │   └── file-D.txt
    ├── folder-07
    │   ├── file-A.txt
    │   ├── file-B.txt
    │   ├── file-C.txt
    │   └── file-D.txt
    ├── folder-08
    │   ├── file-A.txt
    │   ├── file-B.txt
    │   ├── file-C.txt
    │   └── file-D.txt
    ├── folder-09
    │   ├── file-A.txt
    │   ├── file-B.txt
    │   ├── file-C.txt
    │   └── file-D.txt
    └── folder-10
        ├── file-A.txt
        ├── file-B.txt
        ├── file-C.txt
        └── file-D.txt
  　10 directories, 40 files

    ubuntu$ touch timestamp
    ubuntu$ stat timestamp
      File: 'timestamp'
      Size: 0               Blocks: 0          IO Block: 4096   regular empty file
    Device: ca01h/51713d    Inode: 429060      Links: 1
    Access: (0664/-rw-rw-r--)  Uid: ( 1000/  ubuntu)   Gid: ( 1000/  ubuntu)
    Access: 2017-08-15 11:57:42.380585283 +0000
    Modify: 2017-08-15 11:57:42.380585283 +0000
    Change: 2017-08-15 11:57:42.380585283 +0000
     Birth: -

    ubuntu$ touch timestamp
    ubuntu$ stat timestamp
      File: 'timestamp'
      Size: 0               Blocks: 0          IO Block: 4096   regular empty file
    Device: ca01h/51713d    Inode: 429060      Links: 1
    Access: (0664/-rw-rw-r--)  Uid: ( 1000/  ubuntu)   Gid: ( 1000/  ubuntu)
    Access: 2017-08-15 11:58:00.628880446 +0000
    Modify: 2017-08-15 11:58:00.628880446 +0000
    Change: 2017-08-15 11:58:00.628880446 +0000
     Birth: -
    ubuntu$

    ubuntu$ touch folder-{01..10}/file-D
  ```

  ```
    #　执行
    ubuntu$ find . -type f -newer timestamp | sort
    ./folder-01/file-D
    ./folder-02/file-D
    ./folder-03/file-D
    ./folder-04/file-D
    ./folder-05/file-D
    ./folder-06/file-D
    ./folder-07/file-D
    ./folder-08/file-D
    ./folder-09/file-D
    ./folder-10/file-D
    ubuntu$

    ubuntu$ find . -type f -newer timestamp | sort
    ./folder-01/file-D
    ./folder-02/file-D
    ./folder-03/file-D
    ./folder-04/file-D
    ./folder-05/file-D
    ./folder-06/file-D
    ./folder-07/file-D
    ./folder-08/file-D
    ./folder-09/file-D
    ./folder-10/file-D

    ubuntu$ find . -type d -newer timestamp -and -name "*1*" |sort
    ./folder-01
    ./folder-10

  ```

  - 几个预定义的 find 命令操作
  ```
    -delete	删除当前匹配的文件。
    -ls	  对匹配的文件执行等同的 ls -dils 命令。并将结果发送到标准输出。
    -print	把匹配文件的全路径名输送到标准输出。如果没有指定其它操作，这是 默认操作。
    -quit	一旦找到一个匹配，退出。`
  ```
 - xargs / exec
  ```
    ubuntu$ find -type d -name "*1*" | xargs ls -a
    ./folder-01:
    .  ..  file-A.txt  file-B.txt  file-C.txt  file-D  file-D.txt

    ./folder-10:
    .  ..  file-A.txt  file-B.txt  file-C.txt  file-D  file-D.txt
    ubuntu$
  ```
  ```
    # ; 代表语句完了,找到一个执行一次ls -l
    ubuntu$ find -type d -name "*1*" -exec ls -l '{}' ';'
    total 0
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-A.txt
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-B.txt
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-C.txt
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 12:00 file-D
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-D.txt
    total 0
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-A.txt
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-B.txt
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-C.txt
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 12:00 file-D
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-D.txt

    #  + 只执行一次 ls -l
    ubuntu$ find -type d -name "*1*" -exec ls -l '{}' '+'
    ./folder-01:
    total 0
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-A.txt
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-B.txt
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-C.txt
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 12:00 file-D
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-D.txt

    ./folder-10:
    total 0
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-A.txt
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-B.txt
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-C.txt
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 12:00 file-D
    -rw-rw-r-- 1 ubuntu ubuntu 0 Aug 15 11:53 file-D.txt
    ubuntu$
  ```
