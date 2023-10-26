package com.simile.plan.java.other;

/**
 * @Author yitao
 * @Created 2023/10/23
 */
import java.util.Random;

class Node {
    int value;
    Node[] next;

    public Node(int level, int value) {
        this.value = value;
        this.next = new Node[level];
    }
}

public class SkipList {
    private static final int MAX_LEVEL = 16; // 最大层数
    private int level; // 当前跳表层数
    private Node head; // 头结点
    private Random random;

    public SkipList() {
        this.level = 1;
        this.head = new Node(MAX_LEVEL, Integer.MIN_VALUE);
        this.random = new Random();
    }

    // 插入元素
    public void insert(int value) {
        int newLevel = randomLevel();
        Node newNode = new Node(newLevel, value);
        Node current = head;

        for (int i = level - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
            if (i < newLevel) {
                Node next = current.next[i];
                current.next[i] = newNode;
                newNode.next[i] = next;
            }
        }

        if (newLevel > level) {
            level = newLevel;
        }
    }

    // 删除元素
    public void delete(int value) {
        Node current = head;
        for (int i = level - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
            if (current.next[i] != null && current.next[i].value == value) {
                current.next[i] = current.next[i].next[i];
            }
        }
    }

    // 查找元素
    public boolean search(int value) {
        Node current = head;
        for (int i = level - 1; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value < value) {
                current = current.next[i];
            }
            if (current.next[i] != null && current.next[i].value == value) {
                return true;
            }
        }
        return false;
    }

    // 随机生成节点的层数
    private int randomLevel() {
        int newLevel = 1;
        while (newLevel < MAX_LEVEL && random.nextDouble() < 0.5) {
            newLevel++;
        }
        return newLevel;
    }

    // 打印跳表
    public void printSkipList() {
        for (int i = level - 1; i >= 0; i--) {
            Node current = head;
            System.out.print("Level " + i + ": ");
            while (current.next[i] != null) {
                System.out.print(current.next[i].value + " -> ");
                current = current.next[i];
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        for (int i = 0; i < 100; i++) {
            skipList.insert(i);
        }
//        skipList.insert(1);
//        skipList.insert(3);
//        skipList.insert(5);
//        skipList.insert(7);
//        skipList.insert(9);
//        skipList.insert(2);
//        skipList.insert(4);
//        skipList.insert(6);
//        skipList.insert(8);

        skipList.printSkipList();

        System.out.println("Search 5: " + skipList.search(5));
        System.out.println("Search 10: " + skipList.search(10));

        skipList.delete(5);
        System.out.println("After deleting 5:");
        skipList.printSkipList();
    }
}

