package net.coderdaily.zk;

import org.junit.Test;

import java.io.IOException;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-05-27 12:34
 * Blog: coderdaily.net
 */
public class ZkTest01 {

    final String hostPort = "127.0.0.1:2181";

    @Test
    public void sessionTrackTest() throws IOException, InterruptedException {
        Master master = new Master(hostPort);

        master.startZk();

        Thread.sleep(12000);
        /**
         * 如果程序退出，但没到sessionTimeout设置的超时时间，session依然会保存，除非直接调用zk.close()
         *
         * 1.可以使用telnet 连接zk，然后使用dump命令查看session信息
         */
        master.stopZk();
    }

    @Test
    public void runForMasterTest() throws IOException, InterruptedException {
        Master master = new Master(hostPort);
        master.startZk();

        master.runForMaster();

        if (master.checkMaster()) {
            System.out.println("I am the leader...");
            Thread.sleep(60000);
        } else {
            System.out.println("someone else is leader");
        }
        master.stopZk();
    }

    @Test
    public void runForMasterAsyncTest() throws InterruptedException, IOException {
        Master master = new Master(hostPort);
        master.startZk();

        master.runForMasterAsync();

        Thread.sleep(5000);

        master.stopZk();
    }

    @Test
    public void saveMetaDataTest() throws IOException, InterruptedException {
        MetaData master = new MetaData(hostPort);
        master.startZk();

        master.createParent("/workers", new byte[0]);
        master.createParent("/assign", new byte[0]);
        master.createParent("/tasks", new byte[0]);
        master.createParent("/status", new byte[0]);

        Thread.sleep(5000);
        master.stopZk();
    }

    /**
     * 注册从节点
     *
     * @throws IOException
     */
    @Test
    public void registerWorkersTest() throws IOException, InterruptedException {
        Worker worker = new Worker(hostPort);
        worker.startZk();

        worker.register();

        Thread.sleep(1000);
    }
}
