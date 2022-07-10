package leetcode.DP;

/**
 * 在第 1天，有一个人发现了一个秘密。
 *
 * 给你一个整数delay，表示每个人会在发现秘密后的 delay天之后，每天给一个新的人分享秘密。
 * 同时给你一个整数forget，表示每个人在发现秘密forget天之后会忘记这个秘密。
 * 一个人不能在忘记秘密那一天及之后的日子里分享秘密。
 *
 * 给你一个整数n，请你返回在第 n天结束时，知道秘密的人数。
 * 由于答案可能会很大，请你将结果对109 + 7取余后返回。
 *
 * 示例 1：
 *
 * 输入：n = 6, delay = 2, forget = 4
 * 输出：5
 * 解释：
 * 第 1 天：假设第一个人叫 A 。（一个人知道秘密）
 * 第 2 天：A 是唯一一个知道秘密的人。（一个人知道秘密）
 * 第 3 天：A 把秘密分享给 B 。（两个人知道秘密）
 * 第 4 天：A 把秘密分享给一个新的人 C 。（三个人知道秘密）
 * 第 5 天：A 忘记了秘密，B 把秘密分享给一个新的人 D 。（三个人知道秘密）
 * 第 6 天：B 把秘密分享给 E，C 把秘密分享给 F 。（五个人知道秘密）
 */
public class NumberOfPeopleAwareOfSecret {
    static int mod = (int)1e9+7;
    public int peopleAwareOfSecret(int n, int delay, int forget){
        // 记录知道秘密的总人数，不去处理忘记人数
        long[] dp = new long[n+1];
        dp[1]=1;
        for(int i =2;i<=n;i++){
            // 对于第i天，i-delay天的人可以分享秘密 (这里计算的都是总人数)
            long canShare = i-delay>=0? dp[i-delay]:0;
            // 对于第i天，会有i-forget天的人忘记秘密。（这里计算的都是总人数）
            long forgetPeople = i-forget>=0? dp[i-forget]:0;
            // 那么这一天分享人数 = 分享人数-忘记人数
            // 所以对于这一天，知道秘密的人数是昨天的人数+新分享的人-忘记秘密的人
            dp[i] = (dp[i-1]+canShare-forgetPeople + mod)%mod;
        }
        return (int)(dp[n]-dp[n-forget]);
    }
}
