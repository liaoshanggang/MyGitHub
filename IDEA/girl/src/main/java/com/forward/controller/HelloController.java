package com.forward.controller;

import com.forward.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
//==Spring4后新增的，等于@ResponseBody配合@Controller处理http请求
//@Controller必须配合模板使用
@RestController
/*@Controller
@ResponseBody*/
@RequestMapping("/say")
public class HelloController {

    //通过注解把配置文件内容注入到cupSize属性变量里面来
/*    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    //配置里面使用当前配置
    @Value("${content}")
    private String content;*/

//    cupSize: B
//    age: 18
//    content: "cupSize:${cupSize}, age:${age}"
//面向对象是关注的功能是垂直划分成不同的并且相对独立的，它会封装成良好的类并且它们有属于自己的行为
    //而AOP技术则恰恰相反，它利用的是一种横切的技术，将面向对象构建的庞大的类的体系进行水平的切割，
// 并且会将那些影响多个类的公共行为封装成一个可重用的模块，这个模块称为切面，思想就是将通用的逻辑从业务逻辑分离出来
    @Autowired
    private GirlProperties girlProperties;//@Component

    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)//配置url映射
    public String say(){
        //2、cd 项目 mvn spring-boot:run
        //3、mvn install cd target java -jar girl-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
        //return "Hello Spring Boot!"+cupSize+age+content;
        return girlProperties.getCupSize();
        //return "index";
    }

    // //http://localhost:8080/say/bye/id
    @RequestMapping(value = {"/bye/{id}"},method = RequestMethod.GET)//配置url映射
    public String say1(@PathVariable("id") Integer id){//获取url中的数据
        return "id:"+id;
    }

    //http://localhost:8080/say/yes?id=
    @RequestMapping(value = {"/yes"},method = RequestMethod.GET)//配置url映射
    public String say2(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){//获取请求参数的值
        return "myId:"+myId;
    }

    //@RequestMapping(value = {"/bye/{id}"},method = RequestMethod.GET)//配置url映射//长
    @GetMapping(value = "/short")//组合注解 get put post...
    public String say3(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){//获取请求路径的值
        return "myId:"+myId;
    }
}
