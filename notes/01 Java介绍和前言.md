# Java特点

1. 面向对象
2. 健壮性：强类型机制、异常处理、垃圾自动收集保证程序的健壮性
3. 跨平台性：一个编译好的`.class`文件可以在多个系统下运行
4. 解释型语言：编译后的代码不能被机器直接执行，需要解释器来执行

# Java运行机制和运行过程

## Java核心机制-JVM

JVM是一个虚拟机，包含在**JDK**中，不同的操作系统需要不同的虚拟机。

`.java`文件通过`javac`指令编译为`.class`文件，之后使用`java`指令将程序运行在各个操作系统的虚拟机（JVM）上，流程如下：

​	`Test.java` - compile `javac` -> `Test.class` - run `java` -> JVM for * OS

## JDK，JRE

1. JDK基本介绍

   JDK（Java Development Kit，Java开发工具包），JDK=JRE+Java开发工具（java, javac, javadoc, javap等）。安装JDK后就不需要单独安装JRE

2. JRE基本介绍

   JRE（Java Runtime Environment，Java运行环境），JRE=JVM+Java的核心类库。如果想要运行一个开发好的Java程序（`.class`文件），计算机中只需要安装JRE即可。


# Java开发注意事项和细节

1. Java源文件以`.java`为拓展名，源文件的基本组成部分是类（class）

2. Java应用程序的执行入口是`main()`方法，有固定的书写格式：

   ```java
   public static void main(String[] args){...}
   ```

3. Java语言严格区分大小写
4. 程序中大括号成对出现，应该先写 {} 再写代码
5. 源文件中最多只能有一个`public`类，其他类的数量不限
6. 如果源文件包含一个`public`类，文件名必须以类名命名
7. 也可以将`main()`方法写在非`public`类中，这样程序的入口就是非`public`类中的`main()`方法

