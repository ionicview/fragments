# diff

- #### 比较两个文件的不同  

  ###### 准备数据
  ```
  ubuntu$ cat -n test-A.txt
       1  1
       2  2
       3  3
       4  4
       5  5
       6  test-A
  ubuntu$ cat -n test-B.txt
       1  header
       2  1
       3  2
       4  3
       5  4
       6  5
       7  6
       8  7
       9  8
      10  test-B
  ubuntu$
  ```
  ##### normal diff
  ```
  ubuntu$ diff test-A.txt test-B.txt
  0a1  // 0指的是test-A.txt文件中的最开始，a 指的是added, 1 test-B.txt的第1行
  > header
  6c7,10 // // 6指的是test-A.txt文件中的第6行，c 指的是changed, 7,10 test-B.txt的第7到11行
  < test-A
  ---
  > 6
  > 7
  > 8
  > test-B
  ```
  ##### q diff 只比较内容是否相同
  ```
  ubuntu$ diff -q test-A.txt test-B.txt
  Files test-A.txt and test-B.txt differ
  ubuntu$

  ubuntu$ cp test-A.txt test-C.txt
  ubuntu$ diff -q test-A.txt test-C.txt
  ubuntu$
  ```

  ##### 对照
  ```
  ubuntu$ diff -c test-A.txt test-B.txt
  *** test-A.txt  2017-08-12 08:13:02.444152135 +0000
  --- test-B.txt  2017-08-12 08:13:57.333071722 +0000
  ***************
  *** 1,6 ****
    1
    2
    3
    4
    5
  ! test-A
  --- 1,10 ----
  + header
    1
    2
    3
    4
    5
  ! 6
  ! 7
  ! 8
  ! test-B
  ubuntu$


  ```
  ##### 统一 用的最多
  ```
  ubuntu$ diff -u test-A.txt test-B.txt
  --- test-A.txt  2017-08-12 08:13:02.444152135 +0000
  +++ test-B.txt  2017-08-12 08:13:57.333071722 +0000
  @@ -1,6 +1,10 @@
  +header
   1
   2
   3
   4
   5
  -test-A
  +6
  +7
  +8
  +test-B
  ubuntu$

  ```

  ##### 全部张开 对比 
  ```
  ubuntu$ diff -y  test-A.txt test-B.txt
                                                                > header
  1                                                               1
  2                                                               2
  3                                                               3
  4                                                               4
  5                                                               5
  test-A                                                        | 6
                                                                > 7
                                                                > 8
                                                                > test-B
  ubuntu$
  ```
