package ru.fix.knightstepcounter.models.pieces;

import lombok.*;
import ru.fix.knightstepcounter.models.Node;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

@Data
@EqualsAndHashCode(callSuper = true)
public class Knight extends Piece{
    // Below arrays details all 8 possible movements for a knight
    private static int row[] = {2, 2, -2, -2, 1, 1, -1, -1};
    private static int col[] = {-1, 1, 1, -1, 2, -2, 2, -2};

    // Find minimum number of steps taken by the knight
    // from source to reach destination on free chessboard
    // using Breadth-First-Search (BFS)
    public static int BFS(Node src, Node dest, int width, int height) {
        if (!valid(src.getX(), src.getY(), width, height) || !valid(dest.getX(), dest.getY(), width, height))
            return -1;

        // map to check if matrix cell is visited before or not
        Map<Node, Boolean> visited = new HashMap<>();

        // create a queue and enqueue first node
        Queue<Node> q = new ArrayDeque<>();
        q.add(src);

        // run till queue is not empty
        while (!q.isEmpty()) {
            // pop front node from queue and process it
            Node node = q.poll();

            int x = node.getX();
            int y = node.getY();
            int dist = node.getDist();

            // if destination is reached, return distance
            if (x == dest.getX() && y == dest.getY())
                return dist;

            // Skip if location is visited before
            if (visited.get(node) == null) {
                // mark current node as visited
                visited.put(node, true);

                // check for all 8 possible movements for a knight
                // and enqueue each valid movement into the queue
                for (int i = 0; i < 8; ++i) {
                    // Get the new valid position of Knight from current
                    // position on chessboard and enqueue it in the
                    // queue with +1 distance
                    int x1 = x + row[i];
                    int y1 = y + col[i];

                    if (valid(x1, y1, width, height))
                        q.add(new Node(x1, y1, dist + 1));
                }
            }
        }

        // return -1 if path is not possible
        return -1;
    }
}
