package leetcode;

import java.util.TreeSet;

public class MyCalendarI {

  class MyCalendar {

    private TreeSet<Calendar> calendars;

    public MyCalendar() {
      calendars = new TreeSet<>();
    }

    public boolean book(int start, int end) {
      if (start > end) {
        return false;
      }
      Calendar calendar = new Calendar(start, end);

      Calendar before = calendars.floor(calendar);
      if (before != null && (before.start == calendar.start || calendar.start < before.end)) {
        return false;
      }

      Calendar after = calendars.ceiling(calendar);

      if (after != null && (after.start == calendar.start || calendar.end > after.start)) {
        return false;
      }

      calendars.add(calendar);
      return true;
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
