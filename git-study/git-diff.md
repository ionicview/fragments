# git diff

- #### 常用的命令  


  ```
  # git diff 远端仓库
    git diff origin/master  # 比较本地仓库和远端仓库master分支的不同
    git fetch origin/master # 更新远端仓库到本地，但是不合并
    git merge origin/master or git merge # 合并

  # git diff 本地仓库和上次commit之后的也就是HEAD
    git status
    git diff

  # git diff add 之后的文件
    git diff --cached

  ```
