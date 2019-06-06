package net.coderdaily.zk;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-06 19:44
 * Blog: coderdaily.net
 * <p>
 * 1.如何让zk保存一些指定的信息
 * 2.为了复用一些方法才继承的Master，没别的意思
 */
public class MetaData extends Master {
    AsyncCallback.StringCallback createCallback = new AsyncCallback.StringCallback() {
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)) {
                case OK:
                    System.out.println(path + ":create success...");
                    break;
                //纯粹为了重试
                case CONNECTIONLOSS:
                    createParent(path, (byte[]) ctx);
                    break;
                case NODEEXISTS:
                    System.out.println(path + ":node already exists...");
                    break;
                default:
                    System.out.println(path + ":create fail...");
            }
        }
    };

    public MetaData(String hostPort) {
        super(hostPort);
    }

    public void createParent(String path, byte[] data) {
        zk.create(path,
                data,//需要保存的信息
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT,
                createCallback,
                data//上下文，就是org.apache.zookeeper.AsyncCallback.StringCallback.processResult的ctx参数，也就是为了回调函数的重试操作，才将ctx等于了data
        );
    }
}
