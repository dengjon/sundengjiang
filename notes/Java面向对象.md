# 类与对象

基本使用案例：

```java
class Cat {
    String name;
    int age;
    String color;
}
Cat cat1 = new Cat(); //创建一个对象
cat1.name = ...; //属性赋值
cat1.age = ...;
cat1.color = ...;
```

**注意事项**

`Person p2 =  p1;`其中`p1`是一个对象，类似数组的引用赋值，传递的是地址。

# 方法

定义和使用流程：

1. 在类中定义方法：

   ```java
   public void speak() {...} // public:方法公开; void:没有返回值; speak:方法名
   public int getSum(int num1, int num2) {
       ...;
       return ...;
   }
   ```

2. 创建对象后，直接调用方法：

   ```java
   Person p1 = new Person();//创建对象
   p1.speak(); //调用方法
   ```

   



