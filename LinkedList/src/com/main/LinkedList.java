/*********************
 * Program: Singly Linked List
 * Done by: Anis Sarker
 *********************/

package com.main;

import java.util.Scanner;

public class LinkedList {
	
	private class Node {
		private int value;
		Node next = null;
		Node(int value) {
			this.value = value;
		}
	}
	
	protected Node head = null;
	protected Node tail = null;
	
	public void addToFront(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
		if(newNode.next == null) {
			tail = newNode;
		}
	}
	
	public void addToIndex(int index, int value) {
		Node newNode = new Node(value);
		Node current = head;
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		} else if(index == 0) {
			addToFront(value);
		} else {
			for(int i = 0; i < index -1; ++i) {
				if(current == null) {
					throw new IndexOutOfBoundsException();
				}
				current = current.next;
			}
			if(current.next == null) {
				tail = newNode;
			} else {
				newNode.next = current.next;
				current.next = newNode;
			}
		}
	}
	
	public void addToBack(int value) {
		Node newNode = new Node(value);
		if(tail == null) {
			head = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void displayList() {
		Node current = head;
		if(head == null) {
			System.out.println("List is empty!\nNothing to display!");
		} else {
			while(current != null) {
				System.out.print(current.value + " -> ");
				current = current.next;
			}
			System.out.println();
		}
	}
	
	public void replaceHead(int value) {
		Node newNode = new Node(value);
		newNode.next = head.next;
		head = newNode;
	}
	
	public boolean isContains(int value) {
		Node current = head;
		if(head == null) {
			System.out.println("List is empty!");
		} 
		while(current != null) {
			if(current.value == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public int getByIndex(int index) {
		Node current = head;
		for(int i = 0; i < index; ++i) {
			current = current.next;
		}
		return current.value;
	}
	
	public void removeFromFront() {
		if(head == tail) {
			head = null;
			tail = null;
		} else {
			System.out.println(head.value + " is removed!");
			head = head.next;
		}
	}
	
	public void removeByIndex(int index) {
		Node current = head;
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		} else if(index == 0){
			removeFromFront();
		} else {
			for(int i = 0; i < index -1; ++i) {
				if(current == null) {
					throw new IndexOutOfBoundsException();
				}
				current = current.next;
			}
			current.next = current.next.next;
			if(current.next == null) {
				tail = current;
			}
		}
	}
	
	public void removeFromBack() {
		if(head == null) {
			tail = null;
			System.out.println("List is empty!");
		} else if(head == tail) {
			head = null;
			tail = null;
			System.out.println(head.value + " is deleted!");
		} else {
			Node current = head;
			while(current.next != tail) {
				current = current.next;
			}
			System.out.println(tail.value + " is deleted!");
			tail = current;
			current.next = null;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int s = 0;
		int num, index;
				
		do {
			System.out.println("[1] Insert into front");
			System.out.println("[2] Insert into middle");
			System.out.println("[3] Insert into rear");
			System.out.println("[4] Display the list");
			System.out.println("[5] Remove from front");
			System.out.println("[6] Remove by index");
			System.out.println("[7] Remove from rear");
			System.out.println("[8] Search in the list");
			System.out.println("[9] Search by index in the list");
			System.out.println("[0] Exit");
			
			System.out.print("Select: ");
			s = in.nextInt();
			switch(s) {
				case 1: System.out.print("Enter a number to add: ");
						num = in.nextInt();
						list.addToFront(num);
						break;
				case 2: System.out.print("Enter index & number to add: ");
						index = in.nextInt();
						num = in.nextInt();
						list.addToIndex(index, num);
						break;
				case 3: System.out.print("Enter a number to add: ");
						num = in.nextInt();
						list.addToBack(num);
						break;
				case 4: list.displayList();
						break;
				case 5: list.removeFromFront();
						break;
				case 6: System.out.print("Index to delete: ");
						index = in.nextInt();
						list.removeByIndex(index);
						break;
				case 7: list.removeFromBack();
						break;
				case 8: System.out.print("Search a number: ");
						num = in.nextInt();
						if(list.isContains(num)) {
							System.out.println(num + " found!");
						} else {
							System.out.println(num + " not found!");
						}
						break;
				case 9: System.out.print("Search by index: ");
						index = in.nextInt();
						System.out.println(index + " no index contains: " + list.getByIndex(index));
						break;
				default:
						System.out.println("System exited!");
						System.exit(0); break;
			}
		} while(s != 0);
	}
}
