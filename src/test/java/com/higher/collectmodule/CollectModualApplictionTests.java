package com.higher.collectmodule;

import com.higher.collectmodule.exception.BusinessException;
import com.higher.collectmodule.pojo.Box;
import com.higher.collectmodule.service.BoxService;
import com.higher.collectmodule.util.ResultCodeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@SpringBootTest
class CollectModualApplictionTests {

    @Autowired
    BoxService boxService;
    @Test
    void addBox() {

    }
}
