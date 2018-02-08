package 综合;

import java.util.HashMap;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2017/12/5 上午10:07
 * Blog: coderdaily.net
 */
public class ConditionalOperator_02 {
    public static void main(String[] args) {
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
//        报NPE错误
        Boolean result = map != null ? map.get("test") : false;
//        不报错
        Boolean result2 = map != null ? map.get("test") : Boolean.FALSE;
    }
}
