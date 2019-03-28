package nl.jcore.java8demo.parameternames;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/demo/parameter-reflection/requestparameters")
public class ParameterNamesController {
    @RequestMapping
    public void demoOld(@RequestParam("name") final String name) {
    }

    @RequestMapping
    public void demoNew(@RequestParam final String name) {
    }
}

