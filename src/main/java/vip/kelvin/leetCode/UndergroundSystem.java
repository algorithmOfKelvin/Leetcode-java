package vip.kelvin.leetCode;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    Map<Integer, String> enter = new HashMap();
    Map<Integer, Integer> time = new HashMap();
    Map<String, Long> sum = new HashMap();
    Map<String, Integer> cnt = new HashMap();
    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        enter.put(id, stationName);
        time.put(id, t);
    }
    private String concate(String a, String b){
        return a + ".-." + b;
    }

    public void checkOut(int id, String stationName, int t) {
        String e = enter.get(id);
        String way = concate(e, stationName);
        Integer f = time.get(id);
        sum.put(way, sum.getOrDefault(way, 0L) + t - f);
        cnt.put(way, cnt.getOrDefault(way, 0) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        String way = concate(startStation, endStation);
        return (double)sum.get(way) / cnt.get(way);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */