## 解题思路：

此题求拼接起来的最大数字。设数组 $nums$ 中任意两数字的字符串为 $x$ 和 $y$ ，则规定 **贪心策略**：

- 若拼接字符串 $x + y > y + x$ ，则 $x$ “大于” $y$ 。
- 反之，若 $x + y < y + x$ ，则 $x$ “小于” $y$ 。

> $x$ “小于” $y$  代表：排序完成后，数组中 $x$ 应在 $y$ 左边；“大于” 则反之。

根据以上规则，套用任何排序方法对 $nums$ 执行排序即可。

![Picture1.png](https://pic.leetcode.cn/1690468266-PzVUaU-Picture1.png){:width=500}

### 算法流程：

1. **初始化：** 字符串列表 $strs$ ，保存各数字的字符串格式。
2. **列表排序：** 根据贪心策略对 $strs$ 进行从大到小排序。
3. **返回值：** 拼接 $strs$ 中的所有字符串，并返回。

### 正确性证明：

本题的贪心策略的正确性证明包括以下两个命题：

- **反身性**：对于任意的数字 $x$，有 $xx = xx$。
- **传递性**：假设对于任意的数字 $x$ , $y$ , $z$ ，如果 $xy < yx$ , $yz < zy$ ，那么 $xz < zx$ 一定成立。

反身性是显然成立的，因为任意数字和自己拼接总是相等。下面证明传递性：

设十进制数 $x$ , $y$ , $z$ 分别有 $a$ , $b$ , $c$ 位，则有（左边是字符串拼接，右边是十进制数计算，两者等价）：

$$
xy = x \times 10^b + y \\
yx = y \times 10^a + x
$$

则 $xy < yx$ 可转化为：

$$
x \times 10^b + y < y \times 10^a + x \\
x (10^b - 1) < y (10^a - 1) \\
x / (10^a - 1) < y / (10^b - 1)
$$

同理， 可将 $yz < zy$ 转化为：

$$
y / (10^b - 1) < z / (10^c - 1)
$$

将以上两式合并，整理得：

$$
x / (10^a - 1) < y / (10^b - 1) < z / (10^c - 1) \\
x / (10^a - 1) < z / (10^c - 1) \\
x (10^c - 1) < z (10^a - 1) \\
x \times 10^c + z < z \times 10^a + x
$$

可推出 $xz$ < $zx$ ，传递性证毕。

因此贪心策略是正确的，所得排序结果是全局最优的。

## 代码（内置函数）：

可使用编程语言的内置排序函数实现，需自定义判断规则。

```Python []
class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        def sort_rule(x, y):
            a, b = x + y, y + x
            if a < b: return 1
            elif a > b: return -1
            else: return 0
        
        strs = [str(num) for num in nums]
        strs.sort(key = cmp_to_key(sort_rule))
        if strs[0] == "0":
            return "0"
        return ''.join(strs)
```

```Java []
class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
        if (strs[0].equals("0"))
            return "0";
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }
}
```

```C++ []
class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<string> strs;
        string res;
        for (int i = 0; i < nums.size(); i++)
            strs.push_back(to_string(nums[i]));
        sort(strs.begin(), strs.end(), [](string& x, string& y){ return y + x < x + y; });
        if (strs[0] == "0")
            return "0";
        for (int i = 0; i < strs.size(); i++)
            res.append(strs[i]);
        return res;
    }
};
```

## 代码（快速排序）：

需修改快速排序函数中的排序判断规则。字符串大小（字典序）对比的实现方法：

- Python/C++ 中可直接用 `<` , `>`。
- Java 中使用函数 `A.compareTo(B)`。

```Python []
class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        def quick_sort(l , r):
            if l >= r: return
            i, j = l, r
            while i < j:
                while strs[j] + strs[l] >= strs[l] + strs[j] and i < j: j -= 1
                while strs[i] + strs[l] <= strs[l] + strs[i] and i < j: i += 1
                strs[i], strs[j] = strs[j], strs[i]
            strs[i], strs[l] = strs[l], strs[i]
            quick_sort(l, i - 1)
            quick_sort(i + 1, r)
        
        strs = [str(num) for num in nums]
        quick_sort(0, len(strs) - 1) 
        if strs[-1] == "0":
            return "0"
        return ''.join(strs[::-1])
```

```Java []
class Solution {
    void quickSort(String[] strs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        if (strs[strs.length - 1].equals("0"))
            return "0";
        for(int i = strs.length - 1; i >=0; i--)
            res.append(strs[i]);
        return res.toString();
    }
}
```

```C++ []
class Solution {
public:
    string largestNumber(vector<int>& nums) {
        vector<string> strs;
        for (int i = 0; i < nums.size(); i++)
            strs.push_back(to_string(nums[i]));
        quickSort(strs, 0, strs.size() - 1);
        if (strs[strs.size() - 1] == "0")
            return "0";
        string res;
        for (int i = nums.size() - 1; i >=0; i--)
            res.append(strs[i]);
        return res;
    }
private:
    void quickSort(vector<string>& strs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        while (i < j) {
            while (strs[j] + strs[l] >= strs[l] + strs[j] && i < j) j--;
            while (strs[i] + strs[l] <= strs[l] + strs[i] && i < j) i++;
            swap(strs[i], strs[j]);
        }
        swap(strs[i], strs[l]);
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N \log N)$ ：** $N$ 为最终返回值的字符数量（ $strs$ 列表的长度 $\leq N$ ）；使用快排或内置函数的平均时间复杂度为 $O(N \log N)$ ，最差为 $O(N^2)$ 。
- **空间复杂度 $O(N)$ ：** 字符串列表 $strs$ 占用线性大小的额外空间。
