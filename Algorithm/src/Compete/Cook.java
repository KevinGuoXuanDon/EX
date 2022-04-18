package Compete;

/**
 * 欢迎各位勇者来到力扣城，城内设有烹饪锅供勇者制作料理，为自己恢复状态。
 *
 * 勇者背包内共有编号为 0 ~ 4 的五种食材，其中 meterials[j] 表示第 j 种食材的数量。
 * 通过这些食材可以制作若干料理，cookbooks[i][j] 表示制作第 i 种料理需要第 j 种食材的数量
 * 而 attribute[i] = [x,y] 表示第 i 道料理的美味度 x 和饱腹感 y。
 *
 * 在饱腹感不小于 limit 的情况下，请返回勇者可获得的最大美味度。如果无法满足饱腹感要求，则返回 -1。
 *
 * 注意：
 *
 * 每种料理只能制作一次。
 * 示例 1：
 *
 * 输入：meterials = [3,2,4,1,2]
 * cookbooks = [[1,1,0,1,2],[2,1,4,0,0],[3,2,4,1,0]]
 * attribute = [[3,2],[2,4],[7,6]]
 * limit = 5
 *
 * 输出：7
 *
 * 解释：
 * 食材数量可以满足以下两种方案：
 * 方案一：制作料理 0 和料理 1，可获得饱腹感 2+4、美味度 3+2
 * 方案二：仅制作料理 2， 可饱腹感为 6、美味度为 7
 * 因此在满足饱腹感的要求下，可获得最高美味度 7
 */
public class Cook {
    int max;
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        max = -1;
        traceBack(materials,cookbooks,attribute,limit,0,0);
        return max;
    }
    public void traceBack(int[] materials, int[][] cookbooks, int[][] attribute, int limit, int delicious, int index){
        // 出现满足饱食就更新
        if(limit<=0){
            max = Math.max(max,delicious);
        }
        // 搜索完毕
        if(index == materials.length) return;
        int[] clone = materials.clone();
        for(int i= 0; i<clone.length;i++){
            if(clone[i]<cookbooks[index][i]) return;
            clone[i]-=cookbooks[index][i];
        }
        limit-=attribute[index][1];
        delicious+=attribute[index][0];
        traceBack(clone,cookbooks,attribute,limit,delicious,index+1);
    }
}
