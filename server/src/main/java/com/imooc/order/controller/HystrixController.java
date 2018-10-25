package com.imooc.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

//    /**
//     * 超时测试配置,hystrix如果不设置访问超时时间默认为1秒。
//     * @return
//     */
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="3000")
//    })

    // @ 10次请求中，错误率达到60%则打开断路器。主逻辑休眠10秒
    //休眠过后。会半开断路器状态。放一个请求试探服务是否请求成功，如果成功则关闭断路器恢复访问。如果失败则继续断开
    //熔断测试设置
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")
    })

    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("number")Integer number){
        //用于测试，打开两个窗口http://localhost:7001/getProductInfoList?number=1
        //http://localhost:7001/getProductInfoList?number=2
        //多次访问第一个请求后则也会触发断路器，第二个请求也会失败
        if(number % 2 == 0){
            return "success";
        }
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:9001/product/listForOrder", Arrays.asList("157875196366160022"),String.class);
    }
    private String defaultFallback(){
        return "操作过于频繁";
    }
}
