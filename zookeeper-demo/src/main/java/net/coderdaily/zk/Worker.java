package net.coderdaily.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Random;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-06-06 20:11
 * Blog: coderdaily.net
 * <p>
 * 怎么去注册从节点
 */
public class Worker implements Watcher {
    ZooKeeper zk;
    String hostPort;
    String serverId = Long.toString(new Random(10000L).nextLong());

    public Worker(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZk() throws IOException {
        zk = new ZooKeeper(hostPort, 50000, this);
    }

    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent.toString() + "," + hostPort);
    }

    void register() {
        zk.create("/workers/worker-" + serverId,
                "Idle".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL,
                stringCallback,
                null
        );
    }

    AsyncCallback.StringCallback stringCallback = new AsyncCallback.StringCallback() {
        public void processResult(int rc, String path, Object o, String s1) {
            switch (KeeperException.Code.get(rc)) {
                case CONNECTIONLOSS:
                    register();
                    break;
                case OK:
                    System.out.println("register success," + serverId);
                    break;
                case NODEEXISTS:
                    System.out.println("already register," + serverId);
                    break;
                default:
                    System.out.println("sth is wrong" + KeeperException.create(KeeperException.Code.get(rc), path));
            }
        }
    };
}
