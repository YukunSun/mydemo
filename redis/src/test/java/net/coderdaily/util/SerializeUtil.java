package net.coderdaily.util;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/3/5 下午10:21
 * Blog: coderdaily.net
 */
@Component
public class SerializeUtil<E> {

    /**
     * 序列化对象
     *
     * @param object
     * @return
     */
    public String serialize(E object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);

            String str = baos.toString("ISO-8859-1");
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 反序列化
     *
     * @param serializeStr
     * @return
     */
    @SuppressWarnings("unchecked")
    public E unserialize(String serializeStr) {
        String readStr = "";
        if (serializeStr == null || "".equals(serializeStr)) {
            return null;
        }
        try {
            readStr = URLDecoder.decode(serializeStr, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        InputStream bais = null;
        try {
            bais = new ByteArrayInputStream(readStr.getBytes("ISO-8859-1"));
            ois = new ObjectInputStream(bais);
            return (E) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                bais.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
