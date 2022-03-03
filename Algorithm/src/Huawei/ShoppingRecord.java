package Huawei;

import java.util.Scanner;

public class ShoppingRecord {
    //Shopping Item
    static class Item {
        //物品重要性
        int w;
        //物品价值
        int v;
        //附件判断，如果大于0则说明不是主件
        int attachId;
        //记录一下附件的id，默认为-1
        int attach1 = -1;
        int attach2 = -1;

        public Item(int w, int v, int attachId) {
            this.w = w;
            this.v = v;
            this.attachId = attachId;
        }

        public void setAttach1(int attach1) {
            this.attach1 = attach1;
        }

        public void setAttach2(int attach2) {
            this.attach2 = attach2;
        }
    }

    /**
     * 50 5
     * 20 3 5
     * 20 3 5
     * 10 3 0
     * 10 2 0
     * 10 1 0         //前面的5指的是这一行
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int itemNumber = sc.nextInt();
        int[][] dp = new int[itemNumber + 1][money + 1];
        Item[] items = new Item[itemNumber + 1];
        //读取输入值，设置item数组,需要注意的是这里从1开始，也就是数组的第一个元素需要空出来
        //目的是匹配题目的序号，index不-1
        for (int i = 1; i <= itemNumber; i++) {
            int value = sc.nextInt();
            int w = sc.nextInt();
            int attachedId = sc.nextInt();
            //添加当前这个物件
            items[i] = new Item(w, value, attachedId);
            // 如果当前这个物件是一个附件，则需要对其主件做一个标记
            if (attachedId > 0) {
                // 如果这是第一个附件,则设置第一个附件ID，否则设置第二个
                if (items[attachedId].attach1 == -1) {
                    items[attachedId].setAttach1(i);
                } else {
                    items[attachedId].setAttach2(i);
                }
            }
        }
        //开始动态规划,同样的从1开始，匹配序号
        for (int i = 1; i <= itemNumber; i++) {
            for (int j = 0; j <= money; j++) {
                //对于每一个物件，首先考虑它是主件还是附件，附件一律先跳过，在最后考虑.
                if (items[i].attachId > 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                //判断主件，则需要判断一下几种情况.
                else {
                    // 1. 只添加主件
                    int value = items[i].v;
                    int valueOfAttach1 = 0;
                    int valueOfAttach2 = 0;
                    int valueOfAttach1And2 = 0;
                    int target = items[i].w * value;
                    int targetWithAttach1 = 0;
                    int targetWithAttach2 = 0;
                    int targetWithAttach1And2 = 0;
                    // 2. 主件和附件1,前提是附件1不为空
                    if (items[i].attach1 != -1) {
                        Item attach1 = items[items[i].attach1];
                        valueOfAttach1 = attach1.v;
                        targetWithAttach1 = target + valueOfAttach1 * attach1.w;
                        valueOfAttach1 += value;
                    }
                    // 3. 主件和附件2
                    if (items[i].attach2 != -1) {
                        Item attach2 = items[items[i].attach2];
                        valueOfAttach2 = attach2.v;
                        targetWithAttach2 = target + valueOfAttach2 * attach2.w;
                        valueOfAttach2 += value;
                    }
                    // 4, 主件和附件1，附件2
                    if (items[i].attach2 != -1 && items[i].attach1 != -1) {
                        Item attach1 = items[items[i].attach1];
                        Item attach2 = items[items[i].attach2];
                        valueOfAttach1And2 = attach1.v + attach2.v + value;
                        targetWithAttach1And2 = attach2.v * attach2.w + attach1.v * attach1.w + target;
                    }
                    if (j < value) dp[i][j] = dp[i - 1][j];
                    else {
                        if (j >= value) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - value] + target);
                        if (j >= valueOfAttach1 && valueOfAttach1 != 0)
                            dp[i][j] = Math.max(dp[i][j], dp[i][j - valueOfAttach1] + targetWithAttach1);
                        if (j >= valueOfAttach2 && valueOfAttach2 != 0)
                            dp[i][j] = Math.max(dp[i][j], dp[i][j - valueOfAttach2] + targetWithAttach2);
                        if (j >= valueOfAttach1And2 && valueOfAttach1And2 != 0)
                            dp[i][j] = Math.max(dp[i][j], dp[i][j - valueOfAttach1And2] + targetWithAttach1And2);
                    }
                }
            }
        }
        System.out.print(dp[itemNumber][money]);
    }
}
