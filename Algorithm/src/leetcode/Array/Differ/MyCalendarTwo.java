package leetcode.Array.Differ;

/**
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 *
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数x 的范围为， start <= x < end。
 *
 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
 *
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 *
 * 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 *
 * 示例：
 *
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(50, 60); // returns true
 * MyCalendar.book(10, 40); // returns true
 * MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true
 * MyCalendar.book(25, 55); // returns true
 * 解释： 
 * 前两个日程安排可以添加至日历中。 第三个日程安排会导致双重预订，但可以添加至日历中。
 * 第四个日程安排活动（5,15）不能添加至日历中，因为它会导致三重预订。
 * 第五个日程安排（5,10）可以添加至日历中，因为它未使用已经双重预订的时间10。
 * 第六个日程安排（25,55）可以添加至日历中，因为时间 [25,40] 将和第三个日程安排双重预订；
 * 时间 [40,50] 将单独预订，时间 [50,55）将和第二个日程安排双重预订
 */
import java.util.*;
public class MyCalendarTwo {
    TreeMap<Integer,Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }
    // 解决方式：利用TreeMap做差分数组（没有直接用数组因为数据长度为0-1e9）
    // 可优化：因为现在是做所有Map值的遍历来查找是否有区间三重覆盖
    //        但其实只需要从比start小的上个节点开始遍历到end，查看这一段区间内的count和是否会>=3
    public boolean book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int count = 0;
        for(int value: map.values()){
            // 这里为什么要加每一个值？这里的值相加下来表示某个区间的重合次数，利用差分的特点
            // 每个值代表了此时存在安排，比如book(5,7),在5期间安排+1,7的时候安排-1，如果没有重合，count从头到尾都是0
            count+=value;
            // 只有重合次数在三次及以上，需要返回false
            if(count>=3){
                // 那么这个时候map不应该添加它的信息，要做恢复
                map.put(start,map.get(start)-1);
                map.put(end,map.get(end)+1);
                // 如果要节省空间，则当start和end值为0时需要释放
                if(map.get(start)==0) map.remove(start);
                if(map.get(end)==0) map.remove(end);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo my = new MyCalendarTwo();

        my.book(10,20);
        my.book(50,60);
        my.book(10,40);
        // 如果此时执行(5.9)  5 10 15 20 40 50 60
        //                  1 2  -1 -1 -1 1  -1
        my.book(5,7);
        // 如果是(5,7)     差分的思想就是用和表示这一段时间的 存在的数量
        // 5  7  15 20 40 50 60
        // 1 -1  2  -1 -1 1  -1
    }
}
