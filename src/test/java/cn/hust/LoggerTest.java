package cn.hust;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @program: sell
 * @author: yaopeng
 * @create: 2019-10-06 20:17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//   private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void testLog(){
        String name = "inhust";
        String password = "123456";
        log.debug("debug..");
        log.info("name="+name+", password="+password);
        log.info("name:{}, password:{}",name,password);
        log.error("error");
    }

}
