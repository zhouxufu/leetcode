package demo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Demo1 {


        public static void main(String[] args)
        {
            Foo<String> foo = new Foo<String>(){};
            Type type = ((ParameterizedType)foo.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            System.out.println(type);
        }

    abstract static class Foo<T>{
        public Class<T> getTClass()
        {
            Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            return tClass;
        }
    }

}
