package com.ksyun.aiot;


import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.Iterator;

public class CsvDataProviderIterator implements Iterator<Object[]> {
    private CSVReader reader;
    private Converter[] parameterConverters;
    private Class<?>[] parameterTypes;

    public CsvDataProviderIterator(Class cls, Method method, String filePath) {
        InputStream is = cls.getClassLoader().getResourceAsStream(filePath);
        InputStreamReader isr = new InputStreamReader(is);
        reader = new CSVReader(isr);
        parameterTypes = method.getParameterTypes();
        int len = parameterTypes.length;
        parameterConverters = new Converter[len];
        for (int i = 0; i < len; i++) {
            parameterConverters[i] = ConvertUtils.lookup(parameterTypes[i]);
        }
    }

    private String[] last;

    @Override
    public boolean hasNext() {
        last = reader.readerNext();
        return last != null;
    }

    public String[] getNextLine() {
        if (last == null) {
            try {
                last = reader.readerNext();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return last;
    }

    @Override
    public Object[] next() {
        String[] next;
        if (last != null) {
            next = last;
        } else {
            next = getNextLine();
        }
        last = null;

        return parseLine(next);
    }

    private Object[] parseLine(String[] svals) {
        int len = svals.length;
        Object[] result = new Object[len];
        for (int i = 0; i < len; i++) {
            result[i] = parameterConverters[i].convert(parameterTypes[i], svals[i]);
        }
        return result;
    }
}


/**
 * 封装inputstreamreader
 */
class CSVReader {
    private BufferedReader reader;

    public CSVReader(Reader in) {
        reader = new BufferedReader(in);
    }

    public String[] readerNext() {

        try {
            String line = reader.readLine();
            return line.split(",");
        } catch (Exception e) {
            return null;
        }
    }
}