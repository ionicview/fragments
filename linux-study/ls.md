# ls
- #### ls 展示多个文件夹下边的内容  
  ```
  $ls . test/testFolder/
  .:
  rabbit-python  redis-4.0.0.tar.gz  temp  test

  test/testFolder/:
  test1.txt
  ```
- #### 只显示文件夹  
  ```
  $ls -d */
  testFolder/
  $ls
  10ls-output.txt  cat-output.txt  ls-output.txt  testFolder
  ```
- ### 显示所有文件包括  . .. 等
  ```
  $ls -a
  .  ..  10ls-output.txt  cat-output.txt  ls-output.txt  testFolder

  ```
