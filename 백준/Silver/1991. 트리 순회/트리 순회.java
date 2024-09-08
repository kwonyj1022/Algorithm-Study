import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Node[] nodes;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node((char) ('A' + i));
        }
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Node node = nodes[str.charAt(0) - 'A'];
            node.left = str.charAt(2) == '.' ? null : nodes[str.charAt(2) - 'A'];
            node.right = str.charAt(4) == '.' ? null : nodes[str.charAt(4) - 'A'];
        }

        preorder(nodes[0]);
        sb.append("\n");
        inorder(nodes[0]);
        sb.append("\n");
        postorder(nodes[0]);
        System.out.print(sb);
    }

    static void preorder(Node node) {
        if (node == null) {
            return;
        }
        sb.append(node.name);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        sb.append(node.name);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        sb.append(node.name);
    }

    static class Node {

        char name;
        Node left;
        Node right;

        public Node(char name) {
            this.name = name;
            this.left = null;
            this.right = null;
        }
    }
}
