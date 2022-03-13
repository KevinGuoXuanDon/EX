package Huawei;
import java.util.*;
import java.io.*;

//判断ip地址是第几类
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class IP {
    private static final String INVALID_ALL_1 = "255.255.255.255";
    private static final String ZERO_TO_255 = "(\\d{1,2}|[0-1]\\d{2}|2[0-4]\\d|25[0-5])";
    private static final String FORMAT_255 = ZERO_TO_255 + "\\." + ZERO_TO_255 + "\\." + ZERO_TO_255 + "\\." + ZERO_TO_255;

    public static void main(String[] args) throws IOException {
        int aCount = 0, bCount = 0, cCount = 0, dCount = 0, eCount = 0,
                failCount = 0, privCount = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            String[] line = str.split("~");

            // 首先判断非法ip
            if (!isValidIp(line[0])) {
                ++failCount;
                continue;
            }

            // 解析ip地址数值
            String[] ipAddress = line[0].split("\\.", -1);
            int[] ip = new int[ipAddress.length];
            for (int i = 0; i < ipAddress.length; ++i) {
                ip[i] = Integer.parseInt(ipAddress[i]);
            }
            // 然后忽略【0.*.*.*】和【127.*.*.*】的IP地址
            if (ip[0] == 0 || ip[0] == 127) {
                continue;
            }

            // 接着是非法掩码
            if (!isValidMask(line[1])) {
                ++failCount;
                continue;
            }

            // 判断a, b, c, d, e五类地址
            if (ip[0] >= 1 && ip[0] <= 126) {
                ++aCount;
            }
            if (ip[0] >= 128 && ip[0] <= 191) {
                ++bCount;
            }
            if (ip[0] >= 192 && ip[0] <= 223) {
                ++cCount;
            }
            if (ip[0] >= 224 && ip[0] <= 239) {
                ++dCount;
            }
            if (ip[0] >= 240 && ip[0] <= 255) {
                ++eCount;
            }

            // 判断私有地址
            if (ip[0] == 10) {
                ++privCount;
            }
            if (ip[0] == 172 && ip[1] >= 16 && ip[1] <= 31) {
                ++privCount;
            }
            if (ip[0] == 192 && ip[1] == 168) {
                ++privCount;
            }
        }

        System.out.printf("%d %d %d %d %d %d %d", aCount, bCount, cCount, dCount, eCount, failCount, privCount);
    }

    public static boolean isValidIp(String ip) {
        if (ip.equals(INVALID_ALL_1)) {
            return false;
        }

        if (!ip.matches(FORMAT_255)) {
            return false;
        }

        return true;
    }

    public static boolean isValidMask(String mask) {
        if (mask.equals(INVALID_ALL_1)) {
            return false;
        }

        if (!mask.matches(FORMAT_255)) {
            return false;
        }

        String[] mp = mask.split("\\.", -1);
        int target = 0, count = 3;
        for (int i = 0; i < mp.length; ++i, --count) {
            target = target | Integer.parseInt(mp[i]) & 0xFF;
            if (count > 0) {
                target <<= 8;
            }
        }
        if (Integer.bitCount(~target + 1) != 1) {
            return false; // 中间不能有0
        }
        return true;
    }
}
