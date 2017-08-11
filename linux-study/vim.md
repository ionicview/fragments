# vim

- #### how to show lines numbers in windows side (怎样在vim中显示行数)  
    first into cmd mode, and then input `:set nu` or `:set number`
- #### 一次可以带开很多文件
    ```
    ubuntu$ ls -l /usr/bin/ > ls-output.txt
    ubuntu$ ls /usr/bin/ | head -10 > 10ls-output.txt
    ubuntu$ vim ls-output.txt 10ls-output.txt
    # 然后在vim中通过两种方式切换不同的文件
    1.cmd mode `:n` next `:N` pre
    2.cmd mode `:buffers` then `:buffer 2` to switch second file.
    ```
- #### 在正在编辑的文件中临时添加一个文件
    ```
    ubuntu$ vim ls-output.txt
    input cmd mode then input `:e 10ls-output.txt`
    # 但是这种方式临时假如进来的文件不能通过 :n or :N 来切换只能通过 :buffers
    ```
- #### 合并一个文件的内容到另一个文件的指定行
    ```
    ubuntu$ vim ls-output.txt
    # 通过 10G 跳转到第十行
    # 在10行之后添加10ls-output.txt的内容
    :e 10ls-output.txt
    ```

- #### 自己常用的 详细的请参考如下链接
  ```
  http://billie66.github.io/TLCL/book/chap13.html
  ```
  ```
  l or 右箭头	向右移动一个字符
  h or 左箭头	向左移动一个字符
  j or 下箭头	向下移动一行
  k or 上箭头	向上移动一行
  0 (零按键)	移动到当前行的行首。
  ^	移动到当前行的第一个非空字符。
  $	移动到当前行的末尾。
  w	移动到下一个单词或标点符号的开头。
  W	移动到下一个单词的开头，忽略标点符号。
  b	移动到上一个单词或标点符号的开头。
  B	移动到上一个单词的开头，忽略标点符号。
  Ctrl-f or Page Down	向下翻一页
  Ctrl-b or Page Up	向上翻一页
  numberG	移动到第 number 行。例如，1G 移动到文件的第一行。
  G	移动到文件末尾。

  # 修改
  A 跳到行尾然后进入insert mode
  o	当前行的下方打开一行。
  O	当前行的上方打开一行。

  # 删除
  x	当前字符
  3x	当前字符及其后的两个字符。
  dd	当前行。
  5dd	当前行及随后的四行文本。
  dW	从光标位置开始到下一个单词的开头。
  d$	从光标位置开始到当前行的行尾。
  d0	从光标位置开始到当前行的行首。
  d^	从光标位置开始到文本行的第一个非空字符。
  dG	从当前行到文件的末尾。
  d20G	从当前行到文件的第20行。

  # 复制
  yy	当前行。
  5yy	当前行及随后的四行文本。
  yW	从当前光标位置到下一个单词的开头。
  y$	从当前光标位置到当前行的末尾。
  y0	从当前光标位置到行首。
  y^	从当前光标位置到文本行的第一个非空字符。
  yG	从当前行到文件末尾。
  y20G	从当前行到文件的第20行。

  # 连接行
  J 输入大写的 J 命令

  # 查找一行 f 命令能搜索一特定行
  # 命令 fa 会把光标定位到同一行中 下一个出现的”a”字符上。在进行了一次行内搜索后，输入分号能重复这次搜索。
  fa
  ```
