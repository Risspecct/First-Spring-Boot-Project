package users.rishik.spring_demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/add_numbers")
    public int add_nums(@RequestParam int a, @RequestParam int b)
    {
        return a+b;
    }

    @GetMapping("/mul_numbers")
    public int mul_num(@RequestParam int a, @RequestParam int b)
    {
        return a*b;
    }

}
