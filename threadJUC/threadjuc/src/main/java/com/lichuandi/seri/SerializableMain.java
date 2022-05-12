package com.lichuandi.seri;

import java.io.*;
import java.util.Arrays;

/**
 * @author digege
 * @date 2021/9/3 17:59
 * @description：序列化 把一个Java对象变为byte[]数组，需要使用ObjectOutputStream。它负责把一个Java对象写入一个字节流
 * @page com.lichuandi.seri version：1
 */
public class SerializableMain {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        //序列化
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // 写入int:
            output.writeInt(12345);
            // 写入String:
            output.writeUTF("Hello");
            // 写入Object:
            output.writeObject(Double.valueOf(123.456));
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));
        //反序列化
        // byte[] data = { 72, 101, 108, 108, 111, 33 };
        byte[] bytes = buffer.toByteArray();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        try (ObjectInputStream input = new ObjectInputStream(inputStream)) {
            int n = input.readInt();
      System.out.println(n);
            String s = input.readUTF();
      System.out.println(s);
            try {
                Double d = (Double) input.readObject();
        System.out.println(d);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
