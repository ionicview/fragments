# cmd
- #### 清空屏幕
  ```
  1. clear
  2. ctrl + l
  ```
- ####　历史记录
  ```
  1. ctrl + r  然后输入自己最近输入的cmd,Linux会自动匹配到最新一条。重复按Ctrl+r 会一直向前追溯
     ctrl + j 选中当前的cmd
  2. history 10 最近十条历史记录
  eg:
  $history 10
    840  pwd
    841  cd ..
    842  cd test/
    843  ls
    844  ls -d ./*/
    845  ls -d */
    846  ls
    847  ls -a
    848  history
    849  history 10
  $
  3. 特定某一条记录 !加上索引
  eg:
  $!847
    ls -a
    .  ..  10ls-output.txt  cat-output.txt  ls-output.txt  testFolder
  $
  4. 使用上下键回到特定的历史cmd 之后可以使用ctrl+o 依次执行剩下的命令。
     对于重复执行有用
  ```
- #### カーソルより前の文字列を全て削除します。
  ```
  ctrl + u
  ```
- #### カーソルより後の文字列を全て削除します。結構よく使います。
  ```
  ctrl + k
  ```
- #### 処理を中断します。
```
  ctrl + c
````
