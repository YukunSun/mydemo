package net.coderdaily.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Random;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-04-23 21:13
 * Blog: coderdaily.net
 */
public class Master implements Watcher {
    ZooKeeper zk;
    String hostPort;
    String serverId = Long.toString(new Random(10000L).nextLong());
    boolean isLeader = false;

    public Master() {
    }

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

    /**
     * 检查是否是主节点
     */
    boolean checkMaster() {
        while (true) {
            Stat stat = new Stat();
            try {
                byte[] data = zk.getData("/master", false, stat);
                isLeader = new String(data).equals(serverId);
                return true;
            } catch (KeeperException.NoNodeException e) {
                e.printStackTrace();
                return false;
            } catch (KeeperException.ConnectionLossException e) {

            } catch (KeeperException e) {
                //包括了NoNodeException，ConnectionLossException...
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //选举主节点1：同步方式
    void runForMaster() throws InterruptedException {
        while (true) {
            try {
                zk.create("/master", serverId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                isLeader = true;
                break;
            } catch (KeeperException.NodeExistsException e) {
                isLeader = false;
                break;
            } catch (KeeperException.ConnectionLossException e) {

            } catch (KeeperException e) {
                e.printStackTrace();
            }
            if (checkMaster()) {
                break;
            }
        }
    }

    /**
     * 选举主节点2：异步方式
     */
    void runForMasterAsync() {
        zk.create("/master", serverId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, createCallback, null);
    }

    /**
     * 回调函数
     */
    AsyncCallback.StringCallback createCallback = new AsyncCallback.StringCallback() {
        public void processResult(int rc, String path, Object ctx, String name) {
            switch (KeeperException.Code.get(rc)) {
                case OK:
                    isLeader = true;
                    break;
                case CONNECTIONLOSS://重试
                    checkMasterAsync();
                    return;
                default:
                    isLeader = false;
            }
            System.out.println("i am " + (isLeader ? "" : "not") + "leader...");
        }
    };

    void checkMasterAsync() {
        zk.getData("/master", false, checkCallback, null);
    }

    AsyncCallback.DataCallback checkCallback = new AsyncCallback.DataCallback() {
        public void processResult(int rc, String s, Object o, byte[] bytes, Stat stat) {
            switch (KeeperException.Code.get(rc)) {
                case NONODE:
                    runForMasterAsync();
                    return;
                case CONNECTIONLOSS:
                    checkMasterAsync();
                    break;
            }
        }
    };


    public static void main(String[] args) throws IOException, InterruptedException {
        final String hostPort = "127.0.0.1:2181";
        Master master = new Master(hostPort);

        master.startZk();
        Thread.sleep(12000);
        master.stopZk();
    }
}