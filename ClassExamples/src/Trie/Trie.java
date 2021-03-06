package Trie;

import java.util.*;

public class Trie {
	//Prefix tree
	
	private class TrieNode {
		Map<Character, TrieNode> children = new TreeMap<>();
		boolean word = false;
	}
	
	private TrieNode root;
	
	public Trie() {
		this.root = new TrieNode();
	}
	
	public void insertString(String s) {
		insertString(root, s);
	}
	private void insertString(TrieNode root, String s) {
		TrieNode cur = root;
		for (char ch : s.toCharArray()) {
			TrieNode next = cur.children.get(ch);
			if (next == null) {
				cur.children.put(ch, next = new TrieNode());
				cur = next;
			}
			cur.word = true;
		}
	}
	
	public void printSorted() {
		printSorted(root, "");
	}
	private void printSorted(TrieNode root, String s) {
		if (root.word) {
			System.out.println(s);
		}
		for (Character ch : root.children.keySet()) {
			printSorted(root.children.get(ch), s + ch);
		}
	}
	
	public boolean search(String s) {
		return search(root, s);
	}
	private boolean search(TrieNode root, String s) {
		if (s != null) {
			String rest = s.substring(1);
			char ch = s.charAt(0);
			TrieNode child = root.children.get(ch);
			if (s.length() == 1 && child != null) {
				return true;
			}
			if (child == null) {
				return false;
			} else {
				return search(child, rest);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Trie tree = new Trie();
		
		tree.insertString("hello");
		tree.insertString("world");
		tree.insertString("hi");
		tree.insertString("ant");
		tree.insertString("an");
		
		System.out.println(tree.search("ant"));
		System.out.println(tree.search("an"));
		System.out.println(tree.search("hello"));
		System.out.println(tree.search("cant"));
		System.out.println(tree.search("hig"));
		System.out.println(tree.search("he"));
		
		tree.printSorted();
	}

}
