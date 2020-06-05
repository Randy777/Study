package daily;
/**
 *爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 *
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
 *
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 * */
public class LeetCode837 {
    public static void main(String[] args) {
        int N = 10, K = 1, W = 10;
        System.out.println(new21Game(N, K, W));
    }
    public static double new21Game(int N, int K, int W) {
        double[] dp = new double[K];
        dp[0] = 0;
        return 1;
    }
}
