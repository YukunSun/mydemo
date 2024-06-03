package net.coderdaily.exception;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: yukunsun@didiglobal.com
 * @time: 2022/3/12 18:40
 * @description:
 */
public class ExceptionTest {

    @Test
    public void exceptionLost() throws InterruptedException {
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        scheduled.scheduleAtFixedRate(() -> {
            throw new IllegalArgumentException();
        }, 1, 1, TimeUnit.SECONDS);

        Thread.sleep(10 * 1000);
    }

    @Test
    public void solution1() throws InterruptedException {
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        scheduled.scheduleAtFixedRate(() -> {
            try {
                System.out.println(1);
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }, 1, 1, TimeUnit.SECONDS);
        Thread.sleep(10 * 1000);
    }
}
