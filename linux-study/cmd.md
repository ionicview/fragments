# cmd  

- #### 清空屏幕
  ```
  1. clear
  2. ctrl + l
  ```
- #### 历史记录
  ```
  1. ctrl + r  然后输入自己最近输入的cmd,Linux会自动匹配到最新一条。重复按Ctrl+r 会一直向前追溯
     ctrl + j 选中当前的cmd
  2. history 10 最近十条历史记录
  eg:
  ubuntu$ history 10
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
  ubuntu$
  3. 特定某一条记录 !加上索引
  eg:
  ubuntu$ !847
    ls -a
    .  ..  10ls-output.txt  cat-output.txt  ls-output.txt  testFolder
  ubuntu$
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
  ```
- #### 直前の一単語を削除します。
  ```
  ctrl + w
  ```
- ####　ctrl + w, ctrl + u, ctrl + k で削除した文字を貼り付けます。なので上の 3 つは実は削除というより切り取りに近いです。
  ```
  ctrl + y
  ```
- #### コンソールを上にスクロールします。
  ```
  shift + page up
  ```
- #### コンソールを下にスクロールします。
  ```
  shift + page down
  ```
- #### 一単語次へ移動します。
  ```
  esc + f
  ```
- #### 一単語前へ移動します。
  ```
  esc + b
  ```
