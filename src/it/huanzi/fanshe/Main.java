package it.huanzi.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("it.huanzi.fanshe.Person");
        /*Class<Person> personClass = Person.class;
        Class<? extends Person> aClass1 = new Person().getClass();*/
        Constructor constructor = clazz.getConstructor();
        String name = constructor.getName();
        Person person = (Person)constructor.newInstance();
        System.out.println(name+":::"+person);
        Constructor constructor1 = clazz.getConstructor(String.class);
        Person name1 = (Person)constructor1.newInstance("name");
        name1.show();
        Constructor constructor2 = clazz.getConstructor(String.class, int[].class);
        Person haha = (Person)constructor2.newInstance("haha", new int[]{1, 2, 3});


    }

}
