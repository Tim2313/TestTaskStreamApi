import org.example.constant.UserStats;
import org.example.service.MapCheckerService;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MainTest {

    private static final MapCheckerService mapCheckerService = MapCheckerService.getInstance();

    @Test
    public void shouldCheck() {
        Map<String, UserStats> testMap = new HashMap<>();

        UserStats stats1 = new UserStats();
        stats1.setUserId(1L);
        stats1.setVisitCount(5L);
        testMap.put("1", stats1);

        UserStats stats2 = new UserStats();
        stats2.setUserId(2L);
        stats2.setVisitCount(10L);
        testMap.put("2", stats2);

        Map<Long, Long> result = mapCheckerService.mapChecker(testMap);

        assert result.get(1L) == 5L;
        assert result.get(2L) == 10L;
    }
}


