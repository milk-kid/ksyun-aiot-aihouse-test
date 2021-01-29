package com.ksyun.aiot;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Iterator;

public class FactoryDataProvider {


    /**
     * //bug 不开多线程，dataprovider多个方法并发之呢个运行一半case
     * @param method
     * @return
     */
    @DataProvider(parallel = false)
    public Iterator<Object[]> csvDataProvider(Method method){
        return getDataProvider(method.getDeclaringClass(),method);
    }

    @Test(dataProvider = "csvDataProvider")
    public void testw(int i){
        System.out.println(i);
    }


    public Iterator<Object[]> getDataProvider(Class cls,Method method){
        String className = cls.getName();
        String dirPlusPefix = className.replace(".", "/");
        String fileName=method.getName()+".csv";
        String filePath = dirPlusPefix+fileName;
        System.out.println(filePath);
        return new com.ksyun.aiot.CsvDataProviderIterator(cls,method,filePath);
    }
}
