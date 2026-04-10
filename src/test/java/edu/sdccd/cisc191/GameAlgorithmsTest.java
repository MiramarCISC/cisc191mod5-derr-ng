package edu.sdccd.cisc191;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameAlgorithmsTest {

    @Test
    void recursiveBinarySearchFindsExistingMiddleValue() {
        int[] matchIds = {101, 205, 309, 412, 587, 640, 777};
        assertEquals(3, GameAlgorithms.findMatchRecursive(matchIds, 412));
    }

    @Test
    void recursiveBinarySearchFindsFirstAndLastValues() {
        int[] matchIds = {10, 20, 30, 40, 50};
        assertEquals(0, GameAlgorithms.findMatchRecursive(matchIds, 10));
        assertEquals(4, GameAlgorithms.findMatchRecursive(matchIds, 50));
    }

    @Test
    void recursiveBinarySearchReturnsNegativeOneWhenMissing() {
        int[] matchIds = {5, 15, 25, 35, 45};
        assertEquals(-1, GameAlgorithms.findMatchRecursive(matchIds, 100));
    }

    @Test
    void iterativeBinarySearchFindsExistingValue() {
        int[] matchIds = {3, 8, 13, 21, 34, 55, 89};
        assertEquals(4, GameAlgorithms.findMatchIterative(matchIds, 34));
    }

    @Test
    void iterativeBinarySearchReturnsNegativeOneWhenMissing() {
        int[] matchIds = {2, 4, 6, 8, 10};
        assertEquals(-1, GameAlgorithms.findMatchIterative(matchIds, 7));
    }

    @Test
    void containsMatchFindsMatchInBracketTree() {
        BracketNode quarter1 = new BracketNode("Quarterfinal A");
        BracketNode quarter2 = new BracketNode("Quarterfinal B");
        BracketNode semifinal = new BracketNode("Semifinal 1", quarter1, quarter2);
        BracketNode finalMatch = new BracketNode("Championship", semifinal, null);

        assertTrue(GameAlgorithms.containsMatch(finalMatch, "Quarterfinal B"));
        assertTrue(GameAlgorithms.containsMatch(finalMatch, "Championship"));
    }

    @Test
    void containsMatchReturnsFalseWhenMissing() {
        BracketNode root = new BracketNode("Final",
                new BracketNode("Semifinal A"),
                new BracketNode("Semifinal B"));
        assertFalse(GameAlgorithms.containsMatch(root, "Bronze Match"));
    }

    @Test
    void recursiveTileCountFindsConnectedRegionSize() {
        char[][] map = {
                {'.', '.', '#', '#'},
                {'.', '#', '.', '.'},
                {'.', '#', '.', '#'},
                {'#', '#', '.', '.'}
        };

        assertEquals(4, GameAlgorithms.countConnectedTilesRecursive(copyMap(map), 0, 0));
        assertEquals(5, GameAlgorithms.countConnectedTilesRecursive(copyMap(map), 1, 2));
    }

    @Test
    void iterativeTileCountFindsConnectedRegionSize() {
        char[][] map = {
                {'.', '.', '#', '#'},
                {'.', '#', '.', '.'},
                {'.', '#', '.', '#'},
                {'#', '#', '.', '.'}
        };

        assertEquals(4, GameAlgorithms.countConnectedTilesIterative(copyMap(map), 0, 0));
        assertEquals(5, GameAlgorithms.countConnectedTilesIterative(copyMap(map), 1, 2));
    }

    @Test
    void tileCountReturnsZeroForBlockedOrOutOfBoundsStarts() {
        char[][] map = {
                {'#', '.', '#'},
                {'.', '.', '#'}
        };

        assertEquals(0, GameAlgorithms.countConnectedTilesRecursive(copyMap(map), 0, 0));
        assertEquals(0, GameAlgorithms.countConnectedTilesIterative(copyMap(map), 0, 0));
    }

    private static char[][] copyMap(char[][] original) {
        char[][] copy = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
}
