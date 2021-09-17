package com.simile.plan.java.thread._volatile;

/**
 * @Author yitao
 * @Created 2021/09/17
 */
public class VolatileExample2 {

	public static void main(String[] args) {
		VolatileModel volatileModel = new VolatileModel();
		synchronized (volatileModel) {
			int i = volatileModel.getI();
			volatileModel.setI(i + 1);
		}

	}
	/*
	public class com.simile.plan.java.thread._volatile.VolatileExample2 {
  public com.simile.plan.java.thread._volatile.VolatileExample2();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class com/simile/plan/java/thread/_volatile/VolatileModel
       3: dup
       4: invokespecial #3                  // Method com/simile/plan/java/thread/_volatile/VolatileModel."<init>":()V
       7: astore_1
       8: aload_1
       9: dup
      10: astore_2
      11: monitorenter
      12: aload_1
      13: invokevirtual #4                  // Method com/simile/plan/java/thread/_volatile/VolatileModel.getI:()I
      16: istore_3
      17: aload_1
      18: iload_3
      19: iconst_1
      20: iadd
      21: invokevirtual #5                  // Method com/simile/plan/java/thread/_volatile/VolatileModel.setI:(I)V
      24: aload_2
      25: monitorexit
      26: goto          36
      29: astore        4
      31: aload_2
      32: monitorexit
      33: aload         4
      35: athrow
      36: return
    Exception table:
       from    to  target type
          12    26    29   any
          29    33    29   any
}

	 */


}
