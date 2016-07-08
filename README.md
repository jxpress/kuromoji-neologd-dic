# Building mecab-ipaidc-neologd dictionary for kuromoji (version 0.9)


# Requirement

* Java 7 or later
* Linux/Mac (/bin/sh)
* ssh/git command

# usage

We use the following bash script for building the [neologd](https://github.com/neologd/mecab-ipadic-neologd) dictionary   

* https://github.com/kazuhira-r/kuromoji-with-mecab-neologd-buildscript/blob/master/build-atilika-kuromoji-with-mecab-ipadic-neologd.sh


```
sbt clean buildDictionary
```

After above sbt command, ipadic-neologd dictionaries for kuromoji will be deployed to src/main/resources/ipadic/neologd/ .



Hiroyasu Yamada