# git diff

- #### 常用的命令  

  你的本地仓库由 git 维护的三棵“树”组成。第一个是你的 工作目录，它持有实际文件；第二个是 暂存区（Index)，它像个缓存区域，临时保存你的改动；最后是 HEAD，它指向你最后一次提交的结果。

  ```
  # git diff (remote)
    git diff origin/master  # 比较本地仓库和远端仓库master分支的不同
    git fetch origin/master # 更新远端仓库到本地，但是不合并
    git merge origin/master or git merge # 合并

  # git diff (local 和 Index暂存区) 不会显示新增的内容只是比较delete和modify
    git status # 可以显示create file
    git diff

  # git diff (HEAD 和 Index 暂存区)
    git diff --cached

  # git diff (locate 和 HEAD)
    git diff HEAD

  # git diff log-id(version) (local and log-id)
    git diff 2267a906cc5d252a95eeecc54922f65362fd1e29
  ```
