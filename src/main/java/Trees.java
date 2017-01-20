/**
 * 
 * @author srt4@uw.edu
 */
public class Trees {

    static class Tree {

        Tree left;
        Tree right;
        String value;

        Tree(Tree left, Tree right, String value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public String toString() {
            return this.value;
        }

    }

    public static void main(String[] args) {
        Tree root = new Tree(new Tree(new Tree(null, null, "LL"), new Tree(null, null, "LR"), "L"),
                new Tree(new Tree(null, null, "RL"), new Tree(null, null, "RR"), "R"), "<>");
        printTreeAtDepth(root, 0);
    }

    static void printTreeAtDepth(Tree root, int depth) {
        System.out.println();
        printTreeAtDepth(root, depth, 0);
        System.out.println();
    }

    static void printTreeAtDepth(Tree root, int targetDepth, int currentDepth) {
        if (root == null) return;

        if (targetDepth == currentDepth) {
            System.out.print(root.value + " ");
        }
        else {
            printTreeAtDepth(root.left, targetDepth, currentDepth + 1);
            printTreeAtDepth(root.right, targetDepth, currentDepth + 1);
        }
    }

}
