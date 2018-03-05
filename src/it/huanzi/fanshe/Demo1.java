package it.huanzi.fanshe;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wqh on 2018/2/3.
 */
public class Demo1 {
   @Test
    public void  run() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
       Class<Person> personClass = Person.class;
       Constructor<Person> constructor = personClass.getConstructor();
       Person person = constructor.newInstance();
       Method show = personClass.getMethod("show", null);
       String name = show.getName();
       show.invoke(person, null);
   }

   @Test
    public void  run2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
       Class<Person> personClass = Person.class;
       Constructor<Person> constructor = personClass.getConstructor();
       Person person = constructor.newInstance();
       Method show = personClass.getMethod("main", String[].class);
       //拿到main函数的两种方法
       //下面一种的 出现的原因是因为jdk4的时候使用new String[]{"2222","333"} 进行传参数的  那个时候还没有多级...参数
       //show.invoke(person, new Object[]{new String[]{"2","3"}});
       show.invoke(person, (Object)new String[]{"2","3"});
   }

   @Test
    public void filed() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
       Class<? extends Person> clazz = new Person().getClass();
       Constructor<? extends Person> constructor = clazz.getConstructor();
       Person person = constructor.newInstance();
       Field age = clazz.getField("age");
       age.setInt(person,10);
       int age1 = person.getAge();
       System.out.println(age1);


   }
   @Test
    public void filed2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
       Class<? extends Person> clazz = new Person().getClass();
       Constructor<? extends Person> constructor = clazz.getConstructor();
       Person person = constructor.newInstance();
       //getDeclaredField  可以拿到被private修饰的 其他的构造器啊  方法啊  都一样
      Field age = clazz.getDeclaredField("name");
      age.setAccessible(true);
      age.set(person,"hahahah");
      String name = person.getName();
      System.out.println(name);


   }



}
