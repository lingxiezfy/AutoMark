package automark.test;


import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;    
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;  
  
/** 
* 配置文件载入
*/  
@RunWith(SpringJUnit4ClassRunner.class)  
@WebAppConfiguration(value = "src/automark") 
@ContextConfiguration({  
	"file:WebContent/WEB-INF/spring-servlet.xml"
})  


public class BaseTest {
	
}
