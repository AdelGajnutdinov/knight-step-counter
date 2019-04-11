package ru.fix.knightstepcounter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.fix.knightstepcounter.forms.CounterForm;
import ru.fix.knightstepcounter.models.Result;
import ru.fix.knightstepcounter.services.StepCountService;
import ru.fix.knightstepcounter.services.StepCountServiceImpl;

@RestController
public class StepCountController {
    @Autowired
    private StepCountService stepCountService;

    @GetMapping("/hourse/rest/count")
    public Result getStepCount(CounterForm counterForm) {
        return stepCountService.getStepCount(counterForm);
    }

    @GetMapping("/hourse/rest")
    public String getHello() {
        return "hello";
    }
}
