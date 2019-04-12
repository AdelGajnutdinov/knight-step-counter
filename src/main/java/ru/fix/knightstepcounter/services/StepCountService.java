package ru.fix.knightstepcounter.services;

import ru.fix.knightstepcounter.models.Result;

public interface StepCountService {
    Result getStepCount(String start, String end, int width, int height);
}
