package interview;
import java.math.*;
/**
 * @author Xuandong Guo
 * @date 14/11/2022
 */
public class DistanceFromAToB {
    /**
     * 核心代码  : 计算点A -> B 绕过障碍物F的最小距离
     */
    public int shortestPath(int ax, int ay, int bx, int by, int fx, int fy){
        int defaultDistance = Math.abs(ax - bx) + Math.abs(ay - by);

        // 如果在一条线上 且障碍物在两点之间
        if( ( (ax == bx && ax == fx && fy > Math.min(ay, by)  && fy < Math.max(ay,by)))
            || (ay == by && ay == fy && fx> Math.min(ax,bx) && fx < Math.max(ax,bx)) )
        {
            return 2 + defaultDistance;
        }
        return defaultDistance;
    }


}
