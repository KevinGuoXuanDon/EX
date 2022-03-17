package Compete;

import java.util.HashMap;
import java.util.Map;

class DiscountSystem {

    Map<Integer, int[]> map;
    Map<Integer, Integer> user_activity;

    public DiscountSystem() {
        map = new HashMap<>();
        user_activity = new HashMap<>();
    }

    public void addActivity(int actId, int priceLimit, int discount, int number, int userLimit) {
        map.put(actId, new int[]{priceLimit, discount, number, userLimit});
    }

    public void removeActivity(int actId) {
        map.remove(actId);
    }

    public int consume(int userId, int cost) {
        //
        int max_dsct = 0;
        int activityId = 2000;
        for (int key : map.keySet()) {
            int[] arr = map.get(key);
            if (arr[0] <= cost && arr[2] > 0 && arr[3] > user_activity.getOrDefault(key * 10000 + userId, 0)) {
                if (arr[1] > max_dsct || (arr[1] == max_dsct && key < activityId)) {
                    max_dsct = arr[1];
                    activityId = key;
                }
            }
        }
        if (activityId != 2000) {
            user_activity.put(activityId * 10000 + userId, user_activity.getOrDefault(activityId * 10000 + userId, 0) + 1);
            int[] arr = map.get(activityId);
            map.put(activityId, new int[]{arr[0], arr[1], arr[2] - 1, arr[3]});
            return cost - arr[1];
        }
        return cost;
    }
}

/**
 * Your DiscountSystem object will be instantiated and called as such:
 * DiscountSystem obj = new DiscountSystem();
 * obj.addActivity(actId,priceLimit,discount,number,userLimit);
 * obj.removeActivity(actId);
 * int param_3 = obj.consume(userId,cost);
 */