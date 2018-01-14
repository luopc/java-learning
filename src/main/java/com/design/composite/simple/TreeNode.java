package com.design.composite.simple;

import java.util.Enumeration;
import java.util.Vector;

public class TreeNode {

	private String name;
	private TreeNode parent;
	private Vector<TreeNode> children = new Vector<TreeNode>();
	
	
	public TreeNode(String name) {
		this.name = name;
	}

	public void add(TreeNode node) {
		System.out.println("增加子节点");
		children.add(node);
	}
	
	public void remove(TreeNode node) {
		System.out.println("删除子节点");
		children.remove(node);
	}
			
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	public Enumeration<TreeNode> getChildren() {
		return children.elements();
	}
	public void setChildren(Vector<TreeNode> children) {
		this.children = children;
	}
	
	

}
