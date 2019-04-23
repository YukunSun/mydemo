package net.coderdaily.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: sun.yukun@foxmail.com
 * Time: 2019-04-23 11:07
 * Blog: coderdaily.net
 */
public class LogbackTest {
    static final Logger LOG = LoggerFactory.getLogger(LogbackTest.class);

    public static void main(String[] args) {
        LOG.trace("Hello World!");
        LOG.debug("How are you today?");
        LOG.info("I am fine.");
        LOG.warn("I love programming.");
        LOG.error("I am programming.");
    }
}
