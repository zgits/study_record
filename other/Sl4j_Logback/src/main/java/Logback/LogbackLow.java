package Logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackLow {


    private static final Logger logger = LoggerFactory.getLogger(LogbackLow.class);


    public static void main(String[] args) {
        logger.trace("这是trace日志{}",LogbackLow.class);
        logger.debug("这是debug信息{}",LogbackLow.class);
        logger.info("这是info信息{}",LogbackLow.class);
        logger.warn("这是warning信息{}",LogbackLow.class);
        logger.error("这是error信息{}",LogbackLow.class);
    }
}
