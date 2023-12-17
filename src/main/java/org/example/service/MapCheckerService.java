package org.example.service;

import org.example.constant.UserStats;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapCheckerService {

    private static MapCheckerService instance;

    public Map<Long, Long> mapChecker(Map<String, UserStats> map) {

        Map<Long, Long> resultMap = new HashMap<>();

        if (map.isEmpty()) {
            return Collections.emptyMap();
        }

        for (Map.Entry<String, UserStats> entry : map.entrySet()) {

            String userIdString = entry.getKey();

            Long userIdKey = Long.parseLong(userIdString);
            Long userId = entry.getValue().getUserId();

            if (!userId.equals(userIdKey)) {
                return Collections.emptyMap();

            } else {
                Long visitCount = entry.getValue().getVisitCount();

                if (visitCount != null) {
                    resultMap.put(userId, visitCount);

                }

//                return Collections.emptyMap();
            }
        }

        return resultMap;
    }

    public static MapCheckerService getInstance() {
        if (instance == null) {
            instance = new MapCheckerService();
        }
        return instance;
    }
}
