package ru.fix.knightstepcounter.services;

import org.springframework.stereotype.Service;
import ru.fix.knightstepcounter.exceptions.PositionFormatException;
import ru.fix.knightstepcounter.models.Node;
import ru.fix.knightstepcounter.models.Result;
import ru.fix.knightstepcounter.models.pieces.Knight;

@Service
public class StepCountServiceImpl implements StepCountService {

    @Override
    public Result getStepCount(String start, String end, int width, int height) throws
            StringIndexOutOfBoundsException,
            PositionFormatException {
        if (!Character.isUpperCase(start.charAt(0)) ||
                !Character.isUpperCase(end.charAt(0)) ||
                !Character.isDigit(end.charAt(1)) ||
                !Character.isDigit(end.charAt(1))) {
            throw new PositionFormatException();
        }
        int startX = start.charAt(0) - 'A';
        int endX = end.charAt(0) - 'A';
        int startY = Character.getNumericValue(start.charAt(1)) - 1;
        int endY = Character.getNumericValue(end.charAt(1)) - 1;

        Node sourceNode = new Node(startX, startY);
        Node destinationNode = new Node(endX, endY);

        return new Result(Knight.BFS(sourceNode, destinationNode, width, height));
    }
}
