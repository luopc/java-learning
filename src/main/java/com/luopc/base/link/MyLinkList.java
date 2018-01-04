package com.luopc.base.link;

public class MyLinkList {
	
	Node head = null;
	
	public void add(int d) {
		//假设列表为空，则直接增加到头
		Node newNode = new Node(d);
		if(head == null) {
			this.head = newNode;
			return;
		}
		Node tmp = head;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = newNode;
	}
	
	public boolean delete(int index) {
		if(index < 1 || index > length()) {
			return false;
		}
		if(index == 1) {
			head = head.next;
			return true;
		}
		int i = 1;
		Node preNode = head;
		Node cruNode = preNode.next;
		while(cruNode != null) {
			if(i == index) {
				preNode.next = cruNode.next;
				return true;
			}
			preNode = cruNode;
			cruNode = cruNode.next;
			i ++;
		}
		return true;		
	}

	public int length() {
		int len = 0;
		Node tmp = head;
		while(tmp.next != null) {
			len ++;
			tmp = tmp.next;
		}
		return len;
	}
	
	
	public Node order(){
		Node nextNode = null;
		int tmp = 0;
		Node curNode = head;
		while(curNode.next != null) {
			nextNode = curNode.next;
			while(nextNode != null) {
				if(curNode.data > nextNode.data) {
					tmp = curNode.data;
					curNode.data = nextNode.data;
					nextNode.data = tmp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;
	}
	
	public void printLink() {
		Node tmp = head;
		while(tmp != null) {
			System.out.print(tmp.data + ",");
			tmp = tmp.next;
		}
		System.out.println();
	}
	

}
