import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;

	static class Node {
		char val;
		Node left;
		Node right;

		public Node(char val) {
			this.val = val;
		}
	}

	static class Tree {
		Node root;

		public void createNode(char val, char leftVal, char rightVal) {
			if (root == null) {
				root = new Node(val);
				root.left = leftVal != '.' ? new Node(leftVal) : null;
				root.right = rightVal != '.' ? new Node(rightVal) : null;
			} else {
				searchNode(root, val, leftVal, rightVal);
			}
		}

		public void searchNode(Node node, char val, char leftVal, char rightVal) {
			if (node == null) {
				return;
			} else if (node.val == val) {
				node.left = leftVal != '.' ? new Node(leftVal) : null;
				node.right = rightVal != '.' ? new Node(rightVal) : null;
			} else {
				searchNode(node.left, val, leftVal, rightVal);
				searchNode(node.right, val, leftVal, rightVal);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		sb = new StringBuilder();
		Tree tree = new Tree();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			tree.createNode(root, left, right);
		}

		preorder(tree.root);
		sb.append("\n");
		inorder(tree.root);
		sb.append("\n");
		postorder(tree.root);
		sb.append("\n");

		System.out.print(sb.toString());
	}

	private static void preorder(Node root) {
		if (root == null) return;
		sb.append(root.val);
		if (root.left != null) preorder(root.left);
		if (root.right != null) preorder(root.right);
	}

	private static void inorder(Node root) {
		if (root == null) return;
		if (root.left != null) inorder(root.left);
		sb.append(root.val);
		if (root.right != null) inorder(root.right);
	}

	private static void postorder(Node root) {
		if (root == null) return;
		if (root.left != null) postorder(root.left);
		if (root.right != null) postorder(root.right);
		sb.append(root.val);
	}
}