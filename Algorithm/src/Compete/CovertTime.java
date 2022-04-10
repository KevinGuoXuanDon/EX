package Compete;

/**
 * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 *
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 *
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 *
 * 返回将current 转化为 correct 需要的 最少操作数 。
 *
 * 示例 1：
 *
 * 输入：current = "02:30", correct = "04:35"
 * 输出：3
 * 解释：
 * 可以按下述 3 步操作将 current 转换为 correct ：
 * - 为 current 加 60 分钟，current 变为 "03:30" 。
 * - 为 current 加 60 分钟，current 变为 "04:30" 。 
 * - 为 current 加 5 分钟，current 变为 "04:35" 。
 * 可以证明，无法用少于 3 步操作将 current 转化为 correct 。
 *
 */
public class CovertTime {
    public int convertTime(String current, String correct) {
        String[] currentTime = current.split(":");
        int currentHour = Integer.valueOf(currentTime[0]);
        int currentMin = Integer.valueOf(currentTime[1]);
        String[] correctTime = correct.split(":");
        int correctHour = Integer.valueOf(correctTime[0]);
        int correctMin = Integer.valueOf(correctTime[1]);
        int timeGap = 60*(correctHour-currentHour) + correctMin-currentMin;
        return caculateOpre(timeGap);
    }
    public int caculateOpre(int timeGap){
        int count=0;
        if(timeGap>=60){
            count += timeGap/60;
            timeGap %= 60;
        }
        if(timeGap>=15){
            count += timeGap/15;
            timeGap %= 15;
        }
        if(timeGap>=5){
            count += timeGap/5;
            timeGap %= 5;
        }
        if(timeGap>=1){
            count += timeGap;
        }
        return count;
    }
}
