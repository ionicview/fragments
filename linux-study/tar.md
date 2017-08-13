# tar

- #### awesome web link
  <http://qiita.com/supersaiakujin/items/c6b54e9add21d375161f>
  <http://qiita.com/astro_super_nova/items/e7ff4ef5ec9fa253fd61>
- #### 自己总结一些比较常用的  ```
    ```
    c -> create  创建 (压缩时候用)
    v -> verbose 详细 (就是说可以在标准输出控制台上打印出解压或者压缩的什么文件)
    x -> extract 提取 (解压的时候用)
    f -> file 文件 (指定文件名)

    a	auto 自动识别压缩文件
    z	gzip	   .gz
    j	bzip2　	.bg2
    J	xz 	     .xz
  ```

  ```
  eg:

  tar.gz
    圧縮
    tar -zcvf xxxx.tar.gz directory
    解凍
    tar -zxvf xxxx.tar.gz

  tar.bz2
    圧縮
    tar -jcvf xxxx.tar.bz2 directory
    解凍
    tar -jxvf xxxx.tar.bz2

  tar.xz
    圧縮
    tar -Jcvf xxxx.tar.xz directory
    解凍
    tar -Jxvf xxxx.tar.xz

  tar
    圧縮
    tar -cvf xxxx.tar directory
    解凍
    tar -xvf xxxx.tar
    zip
    圧縮
    zip -r xxxx.zip directory
    解凍  
    unzip xxxx.zip
  ```
