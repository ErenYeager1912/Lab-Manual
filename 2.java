import java.util.HashMap;
import java.util.Map;
class UndergroundSystem {
    private static class CheckInInfo {
        String stationName;
        int time;
        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    private static class RouteData {
        double totalTime;
        int count;
        RouteData(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }
    private Map<Integer, CheckInInfo> checkInMap;
    private Map<String, RouteData> routeMap;
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkInMap.remove(id);
        String routeKey = info.stationName + "->" + stationName;
        int duration = t - info.time;
        RouteData route = routeMap.getOrDefault(routeKey, new RouteData(0, 0));
        route.totalTime += duration;
        route.count++;
        routeMap.put(routeKey, route);
    }
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteData route = routeMap.get(routeKey);
        return route.totalTime / route.count;
    }
}
