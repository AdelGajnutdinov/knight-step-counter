package ru.fix.knightstepcounter.services;

import ru.fix.knightstepcounter.forms.CounterForm;
import ru.fix.knightstepcounter.models.Result;

public interface StepCountService {
    Result getStepCount(CounterForm counterForm);
}
