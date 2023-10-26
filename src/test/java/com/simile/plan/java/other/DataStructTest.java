package com.simile.plan.java.other;

import org.junit.Test;

/**
 * @Author yitao
 * @Created 2023/10/23
 */
public class DataStructTest {

    @Test
    public void linkedList() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedListNode(i + ""));
        }
        list.print();
    }

    class LinkedList {
        LinkedListNode head;
        LinkedListNode tail;

        public void add(LinkedListNode node) {
            if (head == null) {
                head = node;
            }
            if (tail == null) {
                tail = node;
            } else {
                tail.next = node;
            }
        }

        public void print() {
            LinkedListNode currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.value + " ");
                currentNode = currentNode.next;
            }
        }

        public void reverse(){

        }
    }

    class LinkedListNode {
        LinkedListNode next;
        String value;

        public LinkedListNode(String value) {
            this.value = value;
        }
    }
}
