package com.briup.dingding.web.controller;

import com.briup.dingding.bean.Person;
import com.briup.dingding.exception.CustomerException;
import com.briup.dingding.util.CodeStatus;
import com.briup.dingding.util.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"测试的控制器"})
@RestController
@RequestMapping("/person")
public class PersonController {

    @ApiOperation("测试正常添加数据")
    @PostMapping
    public ResponseEntity<Message> add(Person person){
        return ResponseEntity.ok(new Message(CodeStatus.SUCCESS));
    }

    @ApiOperation("测试正常获取数据")
    @GetMapping("/{id}")
    public ResponseEntity<Message<Person>> get(@PathVariable int id) {
        /*
            假设一下是查询到的数据
         */
        Person person = new Person();
        person.setId(id);
        person.setName("name");
        return ResponseEntity.ok(new Message(CodeStatus.SUCCESS,person));
    }

    @PutMapping
    public ResponseEntity<Message> update(Person person) {
        if (person == null) {
            // 只是为了测试，正常情况下，异常在服务层抛
            throw new CustomerException(CodeStatus.ERROR);
        }
        person.setName("lisi");
        return ResponseEntity.ok(new Message(CodeStatus.SUCCESS));
    }

    @ApiOperation("测试正常获取数据")
    @DeleteMapping("/{id}")
    public ResponseEntity<Message<Person>> delete(@PathVariable int id) {
        return ResponseEntity.ok(new Message(CodeStatus.SUCCESS));
    }

}
