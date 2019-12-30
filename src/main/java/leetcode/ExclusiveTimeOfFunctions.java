package leetcode;

import java.util.LinkedList;
import java.util.List;

public class ExclusiveTimeOfFunctions {

  public int[] exclusiveTime(int n, List<String> logs) {
    if (n <= 0) {
      return null;
    }

    int[] result = new int[n];

    LinkedList<Log> logStack = new LinkedList<>();

    for (String s : logs) {
      Log log = new Log(s);

      if (log.signal == Signal.Start) {
        logStack.push(log);
        continue;
      }
      Log start = logStack.pop();
      int time = log.time - start.time - start.internalTime + 1;
      result[log.id] += time;
      if (!logStack.isEmpty()) {
        logStack.peek().internalTime += time + start.internalTime;
      }
    }

    return result;
  }


  private static class Log {

    private Integer id;

    private Signal signal;

    private Integer time;

    private Integer internalTime = 0;

    private Log(String log) {
      String[] tmp = log.split(":");
      id = Integer.valueOf(tmp[0]);
      signal = tmp[1].equals("start") ? Signal.Start : Signal.End;
      time = Integer.valueOf(tmp[2]);
    }

    @Override
    public String toString() {
      return "Log{" +
          "id=" + id +
          ", signal=" + signal +
          ", time=" + time +
          '}';
    }
  }

  private enum Signal {
    Start, End
  }

}
