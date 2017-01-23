package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        Map<Integer, List<String>> hourMap = new HashMap<>();

        for (int i = 0; i <= 11; i++) {
            Integer bit = Integer.bitCount(i);
            List<String> list = hourMap.get(bit);
            if (null == list) {
                list = new ArrayList<>();
            }
            list.add(String.valueOf(i));
            hourMap.put(bit, list);
        }

        Map<Integer, List<String>> minuteMap = new HashMap<>();
        for (int i = 0; i <= 59; i++) {
            Integer bit = Integer.bitCount(i);
            List<String> list = minuteMap.get(bit);
            if (null == list) {
                list = new ArrayList<>();
            }
            list.add(String.format("%02d", i));
            minuteMap.put(bit, list);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            List<String> hourList = hourMap.get(i);
            List<String> minuteList = minuteMap.get(num - i);
            if (null == hourList || hourList.size() == 0 || null == minuteList || minuteList.size() == 0) {
                System.out.println("!!");
                continue;
            }
            for (String hour : hourList) {
                for (String minute : minuteList) {
                    result.add(hour + ":" + minute);
                }
            }

        }

        return result;
    }

}
