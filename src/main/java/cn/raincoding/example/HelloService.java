package cn.raincoding.example;

import cn.raincoding.annotation.MyService;

/**
 * @author zengqm01
 * @date 2022/7/8 17:26
 */
@MyService(name = "helloService")
public class HelloService {

    public String hello(String name) {
        return "hello " + name;
    }

}
