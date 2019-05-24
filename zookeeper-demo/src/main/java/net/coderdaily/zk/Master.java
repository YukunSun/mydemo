package net.coderdaily.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-04-23 21:13
 * Blog: coderdaily.net
 */
public class Master implements Watcher {
    ZooKeeper zk;
    String hostPort;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZk() throws IOException {
        zk = new ZooKeeper(hostPort, 50000, this);
    }

    void stopZk() throws InterruptedException {
        zk.close();
    }

    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final String hostPort = "127.0.0.1:2181";
        Master master = new Master(hostPort);

        master.startZk();

        Thread.sleep(12000);
    }
}
