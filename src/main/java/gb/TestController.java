package gb;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TestController {
  
  public static String message = "Hello world!";
  
  @RequestMapping("/test")
  public String test() {
    return message;
  }
  
};
