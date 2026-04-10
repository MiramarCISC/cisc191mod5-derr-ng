package edu.sdccd.cisc191;

/**
 * A simple tournament bracket node.
 * Each node can point to earlier matches on the left and right.
 */
public class BracketNode {
    private final String matchName;
    private final BracketNode left;
    private final BracketNode right;

    public BracketNode(String matchName) {
        this(matchName, null, null);
    }

    public BracketNode(String matchName, BracketNode left, BracketNode right) {
        this.matchName = matchName;
        this.left = left;
        this.right = right;
    }

    public String getMatchName() {
        return matchName;
    }

    public BracketNode getLeft() {
        return left;
    }

    public BracketNode getRight() {
        return right;
    }
}
