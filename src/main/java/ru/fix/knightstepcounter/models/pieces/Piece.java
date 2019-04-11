package ru.fix.knightstepcounter.models.pieces;

import lombok.Data;

@Data
abstract class Piece {
    // Check if (x, y) is valid chess board coordinates
    static boolean valid(int x, int y, int width, int height) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }
}
