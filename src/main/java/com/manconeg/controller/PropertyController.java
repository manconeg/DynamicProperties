package com.manconeg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.manconeg.dynamicProperty.DynamicProperty;

@Controller
public class PropertyController {
    @DynamicProperty("test")
    String value = "default";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody String test() {
        return value;
    }
}
