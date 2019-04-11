package ru.fix.knightstepcounter.models;

import lombok.Data;

@Data
public class Node {
    // (x, y) represents chess board coordinates
    // dist represent its minimum distance from the source
    private int x, y, dist;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
