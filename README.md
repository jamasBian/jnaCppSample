# jnaCppSample
解决JNA中遇到的各种UnsatisfiedLinkError
经过三天的艰苦奋斗，各种查找，总算理清了JNA调用中的问题。解决方法如下:

- 1, DLL明明放好在目录，找不到的问题。
System.setProperty("jna.library.path", "D:\\DLL_DIRECTORY\\");

- 2，明明有函数，就是说找不到的问题！
使用Dependency Walker查看函数的名字，每个人，每次出的名字都不一样！前缀，后缀也经常不一样！各种编译器各种虐心的格式。

```
map.put("add", "?add@@YAHHH@Z");
map.put("factorial", "?factorial@@YAHH@Z");
map.put("Execute", "?Execute@@YAHPEBD0NNNNN@Z");
```

之类的，进行对应。实际就是实现FunctionMapper接口，把实际的函数名对应过去。

- 3，以上的问题，应该是C++的函数库，为解决重载搞出的问题。C当中，不存在。


