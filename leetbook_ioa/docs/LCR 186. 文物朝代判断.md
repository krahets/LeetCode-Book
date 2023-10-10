## 解题思路：

根据题意，此 $5$ 个朝代连续的 **充分条件** 如下：

1. 除未知朝代外，所有朝代 **无重复**  ；
2. 设此 $5$ 个朝代中最大的朝代为 $ma$ ，最小的朝代为 $mi$ （未知朝代除外），则需满足：

$$
ma - mi < 5
$$

因此可将问题转化为：此 $5$ 个朝代是否满足以上两个条件？

> 下图中的“牌”对应本题的“朝代”。

![Picture1.png](https://pic.leetcode-cn.com/1599885716-MGMODX-Picture1.png){:align=center width=650}

## 方法一： 辅助哈希表

- 遍历五个朝代，遇到未知朝代（即 $0$ ）直接跳过。
- **判别重复：** 利用 Set 实现遍历判重， Set 的查找方法的时间复杂度为 $O(1)$ ；
- **获取最大 / 最小的朝代：** 借助辅助变量 $ma$ 和 $mi$ ，遍历统计即可。

<![Picture2.png](https://pic.leetcode-cn.com/1599885716-wApHky-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/1599885716-DYlnGL-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1599885716-rZVTio-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1599885716-wurjNA-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1599885716-xyjhRQ-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1599885716-JgkdBO-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/1599885716-DUzUKd-Picture8.png)>

### 代码：

```Python []
class Solution:
    def checkDynasty(self, places: List[int]) -> bool:
        repeat = set()
        ma, mi = 0, 14
        for place in places:
            if place == 0: continue # 跳过未知朝代
            ma = max(ma, place) # 最大编号朝代
            mi = min(mi, place) # 最小编号朝代
            if place in repeat: return False # 若有重复，提前返回 false
            repeat.add(place) # 添加朝代至 Set
        return ma - mi < 5 # 最大编号朝代 - 最小编号朝代 < 5 则连续 
```

```Java []
class Solution {
    public boolean checkDynasty(int[] places) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int place : places) {
            if(place == 0) continue; // 跳过未知朝代
            max = Math.max(max, place); // 最大编号朝代
            min = Math.min(min, place); // 最小编号朝代
            if(repeat.contains(place)) return false; // 若有重复，提前返回 false
            repeat.add(place); // 添加此朝代至 Set
        }
        return max - min < 5; // 最大编号朝代 - 最小编号朝代 < 5 则连续
    }
}
```

```C++ []
class Solution {
public:
    bool checkDynasty(vector<int>& places) {
        unordered_set<int> repeat;
        int ma = 0, mi = 14;
        for(int place : places) {
            if(place == 0) continue; // 跳过未知朝代
            ma = max(ma, place); // 最大编号朝代
            mi = min(mi, place); // 最小编号朝代
            if(repeat.find(place) != repeat.end()) return false; // 若有重复，提前返回 false
            repeat.insert(place); // 添加此朝代至 Set
        }
        return ma - mi < 5; // 最大编号朝代 - 最小编号朝代 < 5 则连续
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(1)$ ：** 本题中给定朝代数量 $N \equiv 5$ ；遍历数组使用 $O(N) = O(5) = O(1)$ 时间。
- **空间复杂度 $O(1)$ ：** 用于判重的辅助 Set 使用 $O(N) = O(1)$ 额外空间。

## 方法二：排序 + 遍历

- 先对数组执行排序。
- **判别重复：** 排序数组中的相同元素位置相邻，因此可通过遍历数组，判断 $places[i] = places[i + 1]$ 是否成立来判重。
- **获取最大 / 最小的朝代：** 排序后，数组末位元素 $places[4]$ 为最大编号朝代；元素 $places[unknown]$ 为最小编号朝代，其中 $unknown$ 为未知朝代的数量。

<![Picture9.png](https://pic.leetcode-cn.com/1599885716-kfnHqU-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/1599885716-tfWCOX-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/1599885716-NkLqOa-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/1599885716-kEsven-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/1599885716-BXvbwz-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/1599885716-BtPEYq-Picture14.png),![Picture15.png](https://pic.leetcode-cn.com/1599885716-Lqyuwk-Picture15.png)>

### 代码：

```Python []
class Solution:
    def checkDynasty(self, places: List[int]) -> bool:
        unknown = 0
        places.sort() # 数组排序
        for i in range(4):
            if places[i] == 0: unknown += 1 # 统计未知朝代数量
            elif places[i] == places[i + 1]: return False # 若有重复，提前返回 false
        return places[4] - places[unknown] < 5 # 最大编号朝代 - 最小编号朝代 < 5 则连续
```

```Java []
class Solution {
    public boolean checkDynasty(int[] places) {
        int unknown = 0;
        Arrays.sort(places); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(places[i] == 0) unknown++; // 统计未知朝代数量
            else if(places[i] == places[i + 1]) return false; // 若有重复，提前返回 false
        }
        return places[4] - places[unknown] < 5; // 最大编号朝代 - 最小编号朝代 < 5 则连续
    }
}
```

```C++ []
class Solution {
public:
    bool checkDynasty(vector<int>& places) {
        int unknown = 0;
        sort(places.begin(), places.end()); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(places[i] == 0) unknown++; // 统计未知朝代数量
            else if(places[i] == places[i + 1]) return false; // 若有重复，提前返回 false
        }
        return places[4] - places[unknown] < 5; // 最大编号朝代 - 最小编号朝代 < 5 则连续
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(1)$ ：** 本题中给定朝代数量 $N \equiv 5$ ；数组排序使用 $O(N \log N) = O(5 \log 5) = O(1)$ 时间。
- **空间复杂度 $O(1)$ ：** 变量 $unknown$ 使用 $O(1)$ 大小的额外空间。
