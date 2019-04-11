package ru.fix.knightstepcounter.forms;

import lombok.Data;
import ru.fix.knightstepcounter.models.Node;

@Data
public class CounterForm {
    //start position of a piece (ex. A2)
    private String start;
    //end position of a piece (ex. D2)
    private String end;
    private int width;
    private int height;
}
