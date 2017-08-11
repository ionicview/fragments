# ls
- #### ls 展示多个文件夹下边的内容  
  ```
  ubuntu$ ls . test/testFolder/
  .:
  rabbit-python  redis-4.0.0.tar.gz  temp  test

  test/testFolder/:
  test1.txt
  ```
- #### 只显示文件夹  
  ```
  ubuntu$ ls -d */
  testFolder/
  ubuntu$ ls
  10ls-output.txt  cat-output.txt  ls-output.txt  testFolder
  ```
- #### 显示所有文件包括  . .. 等
  ```
  ubuntu$ ls -a
  .  ..  10ls-output.txt  cat-output.txt  ls-output.txt  testFolder
  ```
- #### 按照时间顺序排列
  ```
  ubuntu$ ls -l -t
  total 112
  drwxrwxr-x 2 ubuntu ubuntu  4096 Aug 11 09:36 testFolder
  -rw-rw-r-- 1 ubuntu ubuntu 51477 Aug 10 12:58 cat-output.txt
  -rw-rw-r-- 1 ubuntu ubuntu    94 Aug 10 11:15 10ls-output.txt
  -rw-rw-r-- 1 ubuntu ubuntu 51686 Aug 10 11:08 ls-output.txt
  ubuntu$
  ```
- #### 按照时间顺序排列 翻转
    ```
    ubuntu$ ls -l -t -r
    total 112
    -rw-rw-r-- 1 ubuntu ubuntu 51686 Aug 10 11:08 ls-output.txt
    -rw-rw-r-- 1 ubuntu ubuntu    94 Aug 10 11:15 10ls-output.txt
    -rw-rw-r-- 1 ubuntu ubuntu 51477 Aug 10 12:58 cat-output.txt
    drwxrwxr-x 2 ubuntu ubuntu  4096 Aug 11 09:36 testFolder
    ubuntu$
    ```
