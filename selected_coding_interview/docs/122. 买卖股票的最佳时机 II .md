#### 解题思路：

- **股票买卖策略：**
    - **单独交易日：** 设今天价格 $p_1$、明天价格 $p_2$，则今天买入、明天卖出可赚取金额 $p_2 - p_1$ （负值代表亏损）。
    - **连续上涨交易日：** 设此上涨交易日股票价格分别为 $p_1, p_2, ... , p_n$，则第一天买最后一天卖收益最大，即 $p_n - p_1$；等价于每天都买卖，即 $p_n - p_1=(p_2 - p_1)+(p_3 - p_2)+...+(p_n - p_{n-1})$。
    - **连续下降交易日：** 则不买卖收益最大，即不会亏钱。

- **算法流程：** 
    - 遍历整个股票交易日价格列表 `price`，策略是所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱）。
    1. 设 `tmp` 为第 `i-1` 日买入与第 `i` 日卖出赚取的利润，即 `tmp = prices[i] - prices[i - 1]` ；
    2. 当该天利润为正 `tmp > 0`，则将利润加入总利润 `profit`；当利润为 $0$ 或为负，则直接跳过；
    3. 遍历完成后，返回总利润 `profit`。

- **复杂度分析：**
    - **时间复杂度 $O(N)$ ：** 只需遍历一次`price`；
    - **空间复杂度 $O(1)$ ：** 变量使用常数额外空间。

<![Picture1.png](https://pic.leetcode-cn.com/e31c449ede1c9473817b71dc69aee2298781bd6e8b845dfa27bc935bd44f6922-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/79b0c2212b58c6362cc01f76c7d02d65b585c317c42840f34716ca3a962678dc-Picture2.png),![Picture8.png](https://pic.leetcode-cn.com/1560ded9e2074ca1e7da76e324a7eebb4d0b6934189c974d9bab12590e354000-Picture8.png),![Picture3.png](https://pic.leetcode-cn.com/f1ad32279bfbc53031c47941d59b2c2811896e72333d4069bead36523d82fa61-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/4c1acd9d5b4d110e13c014d44a6152258fbbf7c0e0fdaf3b9f3a1914d50a8e24-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/c1db92e578f4c3c6b3c408ee74c2b7edb0d5bcd343419b0d6d8c2cd2f904dbf8-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/5f5251e161390fdda19a331ac05764743370aa69dd4142010a3ea100940c63e9-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/274e94b876be62bbefbc76890d63d5881031d2d247037348b072ba6841220147-Picture7.png)>

#### 代码：

```Python []
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i in range(1, len(prices)):
            tmp = prices[i] - prices[i - 1]
            if tmp > 0: profit += tmp
        return profit
```

```Java []
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }
}
```
