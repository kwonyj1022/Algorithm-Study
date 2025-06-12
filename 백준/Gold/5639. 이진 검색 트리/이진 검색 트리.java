import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.isBlank()) {
                break;
            }
            root.insert(Integer.parseInt(input));
        }
        solve(root);
        System.out.print(sb);
	}

    static void solve(Node node) {
        if (node == null) {
            return;
        }
        solve(node.left);
        solve(node.right);
        sb.append(node.n).append('\n');
    }

    static class Node {
        int n;
        Node left;
        Node right;

        Node(int n) {
            this.n = n;
        }

        void insert(int n) {
            if (n < this.n) {
                if (left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }
}
