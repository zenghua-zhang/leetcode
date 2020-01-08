package leetcode;

import java.util.TreeSet;

public class MyCalendarI {

  class MyCalendar {

    private TreeSet<Calendar> calendars;

    public MyCalendar() {
      calendars = new TreeSet<>();
    }

    public boolean book(int start, int end) {
      if (start >= end) {
        return false;
      }
      Calendar calendar = new Calendar(start, end);

      Calendar before = calendars.floor(calendar);
      Calendar after = calendars.ceiling(calendar);

      if ((before == null || calendar.start >= before.end)
          && (after == null || calendar.end <= after.start)) {
        calendars.add(calendar);
        return true;
      }

      return false;
    }

    private class Calendar implements Comparable<Calendar> {

      private int start;

      private int end;

      private Calendar(int start, int end) {
        this.start = start;
        this.end = end;
      }

      @Override
      public int compareTo(Calendar that) {
        if (this.start < that.start) {
          return -1;
        } else if (this.start > that.start) {
          return 1;
        }
        return 0;
      }
    }

  }

}
