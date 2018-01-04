package com.luopc.base.sort;

public class BtDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class BinaryTree {
	private class Node{
		private Comparable data;
		private Node left;
		private Node right;
		public Node(Comparable data) {
			this.data = data;			
		}
		
	}

	private Node root;
	public void add(Object data) {
		Node node = new Node((Comparable)data);
	}
}