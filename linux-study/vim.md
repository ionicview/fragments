# vim 

- #### how to show lines numbers in windows side (怎样在vim中显示行数)  
    first into cmd mode, and then input `:set nu` or `:set number`.
- #### how to  hide lines numbers in windows side (怎样在vim中隐藏行数)
    first into cmd mode and then input `:set nonumber`.
- #### 一次可以带开很多文件
    ```
    $ls -l /usr/bin/ > ls-output.txt
    $ls /usr/bin/ | head -10 > 10ls-output.txt
    $vim ls-output.txt 10ls-output.txt
    # 然后在vim中通过两种方式切换不同的文件
    1.cmd mode `:n` next `:N` pre
    2.cmd mode `:buffers` then `:buffer 2` to switch second file.
    ```
- #### 在正在编辑的文件中临时添加一个文件
    ```
    $vim ls-output.txt
    input cmd mode then input `:e 10ls-output.txt`
    # 但是这种方式临时假如进来的文件不能通过 :n or :N 来切换只能通过 :buffers 
    ```
- #### 合并一个文件的内容到另一个文件的指定行
    ```
    $vim ls-output.txt
    # 通过 10G 跳转到第十行
    # 在10行之后添加10ls-output.txt的内容
    :e 10ls-output.txt
    ```
    
