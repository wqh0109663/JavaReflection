package it.bean.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by wqh on 2018/2/3.
 */
public class TestDemo {
    @Test
    public void run() throws InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        BeanUtils.setProperty(person,"name","老王");
        String name = person.getName();
        System.out.println(name);
    }
    @Test
    public void run2() throws InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        ConvertUtils.register(new Converter() {
            @Override
            public <T> T convert(Class<T> type, Object value) {
                if (value == null)
                    return null;
                if (!(value instanceof String))
                    throw new RuntimeException("类型不对啊哥们");
                //没写完
                return null;
            }
        }, Date.class);
        BeanUtils.setProperty(person,"name","老王");
        String name = person.getName();
        System.out.println(name);
    }



}
