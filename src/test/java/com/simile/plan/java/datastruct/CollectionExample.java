package com.simile.plan.java.datastruct;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;

/**
 * @Author yitao
 * @Created 2021/08/27
 */
public class CollectionExample {

	 Collection collection;

	 List list;
	 ArrayList arrayList;
	 LinkedList linkedList;

	 Vector vector;

	 Set set;
	 HashSet hashSet;
	 LinkedHashSet linkedHashSet;
	 TreeSet treeSet;

	 Queue queue;
	 Deque deque;

	 ArrayDeque arrayDeque;

	 PriorityQueue priorityQueue;

	 BlockingQueue blockingQueue;
	 ArrayBlockingQueue arrayBlockingQueue;
	 LinkedBlockingQueue linkedBlockingQueue;
	 PriorityBlockingQueue priorityBlockingQueue;

	 ConcurrentLinkedQueue concurrentLinkedQueue;
	 ConcurrentLinkedDeque concurrentLinkedDeque;

	 SynchronousQueue synchronousQueue;
	 LinkedBlockingDeque linkedBlockingDeque;

	 ConcurrentSkipListSet concurrentSkipListSet;

	 @Test
	 public void testArrayDeque(){
		 ArrayDeque arrayDeque = new ArrayDeque();
		 arrayDeque.addFirst("1");
		 arrayDeque.addFirst("2");
		 System.out.println(arrayDeque);
		 arrayDeque.addLast("3");
		 arrayDeque.addLast("4");
		 System.out.println(arrayDeque);
		 arrayDeque.add("5");
		 System.out.println(arrayDeque);
		 System.out.println(arrayDeque.element());
		 System.out.println(arrayDeque.getFirst());
		 System.out.println(arrayDeque.getLast());
		 System.out.println(arrayDeque.poll());
		 System.out.println(arrayDeque);
		 System.out.println(arrayDeque.pollFirst());
		 System.out.println(arrayDeque);
		 System.out.println(arrayDeque.pollLast());
		 System.out.println(arrayDeque);
		 System.out.println(arrayDeque.pop());
		 System.out.println(arrayDeque);
		 arrayDeque.push("6");
		 System.out.println(arrayDeque);
	 }




}
