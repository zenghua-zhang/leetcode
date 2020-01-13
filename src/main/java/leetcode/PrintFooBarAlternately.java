package leetcode;

import java.util.concurrent.atomic.AtomicBoolean;

public class PrintFooBarAlternately {

  class FooBar {

    private AtomicBoolean foo;

    private int n;

    public FooBar(int n) {
      this.n = n;
      foo = new AtomicBoolean(true);
    }
    public void foo(Runnable printFoo) throws InterruptedException {

      for (int i = 0; i < n; i++) {
        while (!foo.get()) {
          Thread.sleep(1);
        }
        // printFoo.run() outputs "foo". Do not change or remove this line.
        printFoo.run();
        foo.set(false);
        this.notifyAll();
      }
    }

    public void bar(Runnable printBar) throws InterruptedException {

      for (int i = 0; i < n; i++) {
        while (foo.get()) {
          Thread.sleep(1);
        }

        // printBar.run() outputs "bar". Do not change or remove this line.
        printBar.run();

        foo.set(true);
        this.notifyAll();

      }
    }
  }
}
