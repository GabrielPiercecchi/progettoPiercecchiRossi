package inactiveClasses;


import org.springframework.web.bind.annotation.*;

@RestController
public class simpleRestController {

    @GetMapping("/hello")
    public HelloWorldClass exampleMethod(@RequestParam(name = "param1", defaultValue = "World") String param1){
        return new HelloWorldClass("mario", "rossi");
    }
    @GetMapping("/world")
    public HelloWorldClass2 exampleMethod2(@RequestParam(name = "param2", defaultValue = "World") String param2){
        return new HelloWorldClass2("luca", "rizzi");
    }
    @PostMapping("/hello")
    public HelloWorldClass exampleMethod3(@RequestBody HelloWorldClass body){
        return body;
    }
}
