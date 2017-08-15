# rm

- ##### 只删除文件夹

  ###### 准备数据
  ```
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
  ```
  ###### 执行
  ```
    ubuntu$ ls -rf ./*/
    ./folder-01/:
    .  file-A  ..  file-B  file-C

    ./folder-02/:
    .  file-A  ..  file-B  file-C
    ./folder-03/:
    .  file-A  ..  file-B  file-C
    -----------------------------------------------
    ubuntu$ rm -rf ./*/
    ubuntu$ tree
    .
    ├── superfile-A.txt
    ├── superfile-B.txt
    └── superfile-C.txt

    0 directories, 3 files

    # 备注 在执行rm时候一般可以先将rm 替换成ls 看结果是不是自己想要删除的，然后再执行rm
  ```

- ##### 只删除文件
  ###### 准备数据
  ```
    ubuntu$ mkdir -p folder-{01..03}
    ubuntu$ touch folder-0{1..3}/file-{A..C}
    ubuntu$ touch superfile-{A..C}.txt
    ubuntu$ ls
    folder-01  folder-02  folder-03  superfile-A.txt  superfile-B.txt  superfile-C.txt
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
  ```
  ###### 执行
  ```
  ubuntu$ rm -f ./* 2> /dev/null
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
  └── folder-03
    ├── file-A
    ├── file-B
    └── file-C

  3 directories, 9 files
  ubuntu$
  ```

  ```
  # 有提示 并且告诉你现在具体执行什么
  ubuntu$ find . -maxdepth 1 -type f -exec rm -iv "{}" "+"
  ```

  ```
  # 直接删除 通过指定maxdepth 为1 删除所有的第一层的。如果需要全部删除，那么去掉这个参数。另外注意参数的前后位置，因为参数其实是用 -and 连接起来的
  ubuntu$ find . -maxdepth 1 -type f -delete
  ```
