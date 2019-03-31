package net.coderdaily.io.nio;

import org.junit.Test;

import java.io.*;
import java.util.regex.Pattern;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2018/6/9 上午10:49
 * Blog: coderdaily.net
 */
public class FileTest {

    /**
     * 打印某目录下的某一规则的文件
     */
    @Test
    public void fileTest() {
        File fileDir = new File("/Users/sunyk");
        //在调用list时会回调FilenameFileter里的accept()
        String[] list = fileDir.list(new DirFilter("D.*"));
        for (String f : list) {
            System.out.println(f);
        }

        File isExist = new File("test");
        System.out.println(isExist.exists());
        System.out.println(isExist.mkdir());
        System.out.println(isExist);
        System.out.println(isExist.delete());
    }

    class DirFilter implements FilenameFilter {
        private Pattern pattern;

        public DirFilter(String regex) {
            pattern = Pattern.compile(regex);
        }

        @Override
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }

    /**
     * BufferedReader缓冲读取文件
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Test
    public void bufferedReaderTest() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/sunyk/Documents/ideaworks/mydemo/jdkdemo/src/test/java/net/coderdaily/nio/FileTest.java"));
        StringBuilder builder = new StringBuilder();
        String s;
        while ((s = reader.readLine()) != null) {
            builder.append(s).append("\n");
        }
        reader.close();
        System.out.println(builder.toString());
    }
}
