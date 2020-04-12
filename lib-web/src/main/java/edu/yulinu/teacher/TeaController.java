package edu.yulinu.teacher;

import edu.yulinu.common.utils.ResponseWarp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: libmanage
 * @description:
 * @author: Xiaodong
 * @date: 2020-04-12 15:46
 **/
@RestController
@RequestMapping("/teacher")
public class TeaController {
    @PostMapping
    public ResponseWarp createCourse(@RequestBody C){
        return null;
    }
}
