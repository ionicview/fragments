# redirection

- #### cat - Concatenate files 连接文件

- #### sort - Sort lines of text 排序文本行

- #### uniq - Report or omit repeated lines 报道或省略重复行

- #### grep - Print lines matching a pattern  打印匹配行

- #### wc - Print newline, word, and byte counts for each file 打印文件中换行符，字，和字节个数

- #### head - Output the first part of a file 输出文件第一部分

- #### tail - Output the last part of a file 输出文件最后一部分

- #### tee - Read from standard input and write to standard output and files 从标准输入读取数据，并同时写到标准输出和文件

- #### eg:
  ```
  ubuntu$ ls
  testFolder
  ubuntu$ ls -l /usr/bin/ > ls-output.txt
  ubuntu$ ls
  ls-output.txt  testFolder
  ubuntu$ wc ls-output.txt
    801  7606 51686 ls-output.txt
  ubuntu$ ls -l /usr/bin/ >> ls-output.txt
  ubuntu$ wc ls-output.txt
    1602  15212 103372 ls-output.txt
  ubuntu$ > ls-output.txt
  ubuntu$ wc ls-output.txt
  0 0 0 ls-output.txt
  ```
- #### ERROR 虽然我们已经将这些文件流的前 三个称作标准输入、输出和错误，shell 内部分别将其称为文件描述符0、1和2
  ```
  ubuntu$ ls -l /bin/usr 2> ls-error.txt
  ```
- #### &> 来重定向标准输出和错误到文件 ls-output.txt
  ```
  ubuntu$ ls -l /bin/usr &> ls-output.txt
  ```
- #### 处理不需要的输出
  ```
  ubuntu$ ls -l /bin/usr 2> /dev/null
  ```
- #### cat Concatenate two or more file to new file
  ```
  ubuntu$ head -10 test-0.txt test-1.txt
  ==> test-0.txt <==
  test 0

  ==> test-1.txt <==
  test 1
  ubuntu$ cat test-0.txt test-1.txt > test-2.txt | head -10 test-2.txt
  test 0
  test 1
  $
  ```
- #### cat 标准输入
  ```
  ubuntu$ cat > test-3.txt
  this is standard input. and then press ctrl + d to stop.
  ubuntu$ cat test-3.txt
  this is standard input. and then press ctrl + d to stop.
  $
  ```
- 一直监视, 使用”-f”选项，tail 命令继续监测这个文件，当新的内容添加到文件后，它们会立即 出现在屏幕上。这会一直继续下去直到你输入 Ctrl-c
  ```
  ubuntu$ tail -f ls-output.txt
  -rwxr-xr-x 1 root   root        5518 Feb 12  2014 xzdiff
  lrwxrwxrwx 1 root   root           6 Feb 12  2014 xzegrep -> xzgrep
  lrwxrwxrwx 1 root   root           6 Feb 12  2014 xzfgrep -> xzgrep
  -rwxr-xr-x 1 root   root        5421 Feb 12  2014 xzgrep
  -rwxr-xr-x 1 root   root        1825 Feb 12  2014 xzless
  -rwxr-xr-x 1 root   root        2168 Feb 12  2014 xzmore
  -rwxr-xr-x 1 root   root       31408 Feb 18  2016 yes
  -rwxr-xr-x 1 root   root         802 Jan  1  2015 yum
  -rwxr-xr-x 1 root   root       14768 Jun 16 20:59 zdump
  -rwxr-xr-x 1 root   root       48459 Mar 13  2016 zipdetails

  ```
- #### tee 相当于peek pip中内容然后输入到文件中，同时不影响后续的操作
  ```
  ubuntu$ ls /usr/bin | tee ls.txt | grep zip
  gpg-zip
  zipdetails
  ubuntu$ ls
  ls-output.txt  ls.txt  test-0.txt  test-1.txt  test-2.txt  test-3.txt  testFolder
  ubuntu$ wc ls.txt
   800  800
  ```
