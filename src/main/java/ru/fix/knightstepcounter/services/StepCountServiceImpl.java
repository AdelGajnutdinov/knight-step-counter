package ru.fix.knightstepcounter.services;

import org.springframework.stereotype.Service;
import ru.fix.knightstepcounter.forms.CounterForm;
import ru.fix.knightstepcounter.models.Node;
import ru.fix.knightstepcounter.models.Result;
import ru.fix.knightstepcounter.models.pieces.Knight;

@Service
public class StepCountServiceImpl implements StepCountService {
    @Override
    public Result getStepCount(CounterForm counterForm) {
        int startX = counterForm.getStart().charAt(0) - 'A';
        int startY = Character.getNumericValue(counterForm.getStart().charAt(1));
        int endX = counterForm.getEnd().charAt(0) - 'A';
        int endY = Character.getNumericValue(counterForm.getEnd().charAt(1));

        Node sourceNode = new Node(startX, startY);
        Node destinationNode = new Node(endX, endY);

        return new Result(
                Knight.BFS(sourceNode, destinationNode, counterForm.getWidth(), counterForm.getHeight()));
    }
}
