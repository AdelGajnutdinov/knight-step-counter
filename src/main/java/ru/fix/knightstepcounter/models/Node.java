package ru.fix.knightstepcounter.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node {
    // (x, y) represents chess board coordinates
    // dist represent its minimum distance from the source
    private int x, y, dist;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
