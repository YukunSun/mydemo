package net.coderdaily.zk;

import org.junit.Test;

import java.io.IOException;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-05-27 12:34
 * Blog: coderdaily.net
 */
public class ZkTest01 {
    /*@Test
    public void test() throws IOException, InterruptedException {
        final String hostPort = "127.0.0.1:2181";
        Master master = new Master(hostPort);

        master.startZk();

        Thread.sleep(12000);
    }*/

    @Test
    public void runForMasterTest() throws IOException, InterruptedException {
        final String hostPort = "127.0.0.1:2181";
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
        final String hostPort = "127.0.0.1:2181";
        Master master = new Master(hostPort);
        master.startZk();

        master.runForMasterAsync();

        Thread.sleep(5000);

        master.stopZk();
    }

    @Test
    public void saveMetaDataTest() throws IOException, InterruptedException {
        final String hostPort = "127.0.0.1:2181";
        MetaData master = new MetaData(hostPort);
        master.startZk();

        master.createParent("/workers", new byte[0]);
        master.createParent("/assign", new byte[0]);
        master.createParent("/tasks", new byte[0]);
        master.createParent("/status", new byte[0]);

        Thread.sleep(5000);
        master.stopZk();
    }
}
