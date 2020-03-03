package com.ssm.movie.util;

import java.io.*;

public class SerializableUtil {

    /**
     * 对象序列化成数组
     * @param object
     * @return
     * @throws Exception
     */
    public static byte[] serializable(Object object) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return bytes;
    }

    /**
     * 数组反序列化为对象
     * @param bytes
     * @return
     * @throws Exception
     */
    public static Object unUerializable(byte[] bytes) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object readObject = objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        return readObject;
    }



}
