##### Reverting a single file to a previous version in git
let's start with finding the right commit. You can see the commits which have made modifications to given file(s) very easily:
```
git log path/to/file
```
If your commit messages aren't good enough, and you need to see what was done to the file in each commit, use the -p/--patch option:
```
git log -p path/to/file
```
Or, if you prefer the graphical view of gitk
```
gitk path/to/file
```
You can also do this once you've started gitk through the view menu; one of the options for a view is a list of paths to include.

Either way, you'll be able to find the SHA1 (hash) of the commit with the version of the file you want. Now, all you have to do is this:
```
# get the version of the file from the given commit
git checkout <commit> path/to/file
# and commit this modification
git commit
```
