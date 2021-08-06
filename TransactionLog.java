package amazon;

import java.util.*;

public class TransactionLog {


    public static String[] getUserWithLogMoreThanThreshold(List<String> logData, int threshold) {
        Map<String, Integer> map = new HashMap<>();
        for (String logs : logData) {
            String[] log = logs.split(" ");
            map.put(log[0], map.getOrDefault(log[0], 0) + 1);
            if (log[0] != log[1]) {
                map.put(log[1], map.getOrDefault(log[1], 0) + 1);
            }
        }

        List<String> userId = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= threshold) {
                userId.add(entry.getKey());
            }
        }

        Collections.sort(userId);

        return userId.toArray(new String[userId.size()]);
    }
}
