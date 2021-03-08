package log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2 {


    private static final Logger logger = LoggerFactory.getLogger(Log4j2.class);



    public static void main(String[] args) {
        logger.trace("这是trace日志");
        logger.debug("这是debug信息");
        logger.info("这是info信息");
        logger.warn("这是warning信息");
        logger.error("这是error信息");
    }
}
