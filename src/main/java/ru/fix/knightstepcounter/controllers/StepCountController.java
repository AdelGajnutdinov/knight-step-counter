package ru.fix.knightstepcounter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.fix.knightstepcounter.models.Result;
import ru.fix.knightstepcounter.services.StepCountService;

@RestController
public class StepCountController {
    @Autowired
    private StepCountService stepCountService;

    @GetMapping("/horse/rest/count")
    public Result getStepCount(@RequestParam("start") String start,
                                               @RequestParam("end") String end,
                                               @RequestParam("width") int width,
                                               @RequestParam("height") int height) {
        return stepCountService.getStepCount(start, end, width, height);
    }
}
