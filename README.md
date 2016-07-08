# kuromoji-neologd-dic

A simple sbt tool to build the [macab-ipadic-neologd](https://github.com/neologd/mecab-ipadic-neologd) dictionary for kuromoji.

This tool uses the following bash script in build.sbt :

* https://github.com/kazuhira-r/kuromoji-with-mecab-neologd-buildscript/blob/master/build-atilika-kuromoji-with-mecab-ipadic-neologd.sh

## Requirements

* Java 7 or later
* sbt 0.13.8 or later
* OS: Linux/Mac

## How to build

```
sbt clean buildDictionary
```

The task will build dictionaries and deploy them to src/main/resources/ipadic/neologd/ .

Then you can create a jar package by following the sbt standard task as follows:   
 
```
sbt package
```

## Jar file

We release a jar file including all built dictionaries at github release: https://github.com/jxpress/kuromoji-neologd-dic/releases  

(Note that the size of the released jar file is about 118MB)

### Usage 

A simple way to use built neologd dictionaries is to replace kuromoji default ipa dictionaries.
This way needs to re-build kuromoji itself.



Otherwise, you need to implement a custom `ResourceResolver` and Tokenizer `Builder` class.  

For scala examples: 

* https://github.com/jxpress/kuromoji4s/blob/master/src/main/scala/net/jxpress/kuromoji4s/ipadic/DictionaryResourceResolver.scala
* https://github.com/jxpress/kuromoji4s/blob/master/src/main/scala/net/jxpress/kuromoji4s/ipadic/Builder.scala

In [kuromoji4s](https://github.com/jxpress/kuromoji4s), both two custom classes have been implemented.
