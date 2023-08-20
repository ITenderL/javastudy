package com.itender.reflection;

/**
 * @author itender
 * @date 2023/1/28 14:45
 * @desc
 */
public class JavaReflection {
    public static void main(String[] args) {
        //
        // // 1.知道具体类的情况下可以使用,但是我们一般是不知道具体类的，基本都是通过遍历包下面的类来获取 Class 对象，通过此方式获取 Class 对象不会进行初始化
        // Class<Person> personClass = Person.class;
        //
        // // 2.通过 Class.forName()传入类的全路径获取：
        //  Class<Person> aClass1 = Class.forName("com.itender.reflection.Person");
        //
        // // 3.通过实例对象instance。getClass()获取
        // final Person person = new Person();
        // final Class<? extends Person> aClass = person.getClass();
    }
}
