package leetcode;

import java.util.concurrent.atomic.AtomicBoolean;

public class PrintInOrder {

  class Foo {

    private AtomicBoolean firstPrint;

    private AtomicBoolean secondPrint;

    public Foo() {
      firstPrint = new AtomicBoolean(false);
      secondPrint = new AtomicBoolean(false);

    }

    public void first(Runnable printFirst) throws InterruptedException {

      // printFirst.run() outputs "first". Do not change or remove this line.
      printFirst.run();

      firstPrint.lazySet(true);
    }

    public void second(Runnable printSecond) throws InterruptedException {

      while (!firstPrint.get()) {
      }

      // printSecond.run() outputs "second". Do not change or remove this line.
      printSecond.run();

      secondPrint.lazySet(true);
    }

    public void third(Runnable printThird) throws InterruptedException {
      while (!secondPrint.get()) {

      }

      // printThird.run() outputs "third". Do not change or remove this line.
      printThird.run();
    }
  }
}
