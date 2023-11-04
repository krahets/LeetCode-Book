## 方法一：快速排序

本题使用排序算法解决最直观：对数组 `nums` 执行排序，再返回倒数第 $k$ 个元素即可。使用任意排序算法皆可，本文采用并介绍 **快速排序** ，为下文 **方法二** 做铺垫。

快速排序算法有两个核心点，分别为 “哨兵划分” 和 “递归” 。

- **哨兵划分操作：** 以数组某个元素（一般选取首元素）为 **基准数** ，将所有小于基准数的元素移动至其左边，大于基准数的元素移动至其右边。
- **递归：** 对 **左子数组** 和 **右子数组** 递归执行 **哨兵划分**，直至子数组长度为 1 时终止递归，即可完成对整个数组的排序。

> 如下图所示，为哨兵划分操作流程。通过一轮 **哨兵划分** ，可将数组排序问题拆分为 **两个较短数组的排序问题** （本文称之为左（右）子数组）。

<![Picture2.png](https://pic.leetcode-cn.com/1612615167-etrYaH-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/1612615167-PHsLgY-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1612615167-aMCCrd-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1612615167-smzuGu-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1612615167-WXDRIU-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1612615167-lWmBlA-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/1612615167-ghPekO-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/1612615167-azMHYj-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/1623073951-BKkDwO-Picture10.png)>

如下图所示，为示例数组 `[2,4,1,0,3,5]` 的快速排序流程。观察发现，快速排序和**二分查找**的原理类似，都是以 $O(\log n)$ 时间复杂度实现搜索区间缩小。

![Picture1.png](https://pic.leetcode-cn.com/1612615552-rifQwI-Picture1.png){:width=550}

### 代码：

```Python []
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        def quick_sort(nums, l, r):
            # 子数组长度为 1 时终止递归
            if l >= r: return
            # 哨兵划分操作（以 nums[l] 作为基准数）
            i, j = l, r
            while i < j:
                while i < j and nums[j] >= nums[l]: j -= 1
                while i < j and nums[i] <= nums[l]: i += 1
                nums[i], nums[j] = nums[j], nums[i]
            nums[l], nums[i] = nums[i], nums[l]
            # 递归左（右）子数组执行哨兵划分
            quick_sort(nums, l, i - 1)
            quick_sort(nums, i + 1, r)
        
        quick_sort(nums, 0, len(nums) - 1)
        return nums[-k]
```

```Java []
class Solution {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void quickSort(int[] nums, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作（以 nums[l] 作为基准数）
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        // 递归左（右）子数组执行哨兵划分
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
}
```

```C++ []
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        quickSort(nums, 0, nums.size() - 1);
        return nums[nums.size() - k];
    }
private:
    void quickSort(vector<int>& nums, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作（以 nums[l] 作为基准数）
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums[i], nums[j]);
        }
        swap(nums[i], nums[l]);
        // 递归左（右）子数组执行哨兵划分
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N \log N)$ ：** 库函数、快排等排序算法的平均时间复杂度为 $O(N \log N)$ 。
- **空间复杂度 $O(N)$ ：** 快速排序的递归深度最好（平均）为 $O(\log N)$ ，最差情况（即输入数组完全倒序）为 $O(N)$。

## 方法二： 基于快速排序的分治

设 $n$ 是数组长度。根据快速排序原理，如果某次哨兵划分后，**基准数的索引正好是 $n-k$ ，则意味着它就是第 $k$ 大的数字** ，那么就可以直接返回它，无需继续递归下去了。

### 代码：

```Python []
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        def quick_sort(l, r):
            i, j = l, r
            while i < j:
                while i < j and nums[j] >= nums[l]: j -= 1
                while i < j and nums[i] <= nums[l]: i += 1
                nums[i], nums[j] = nums[j], nums[i]
            nums[l], nums[i] = nums[i], nums[l]
            if i > len(nums) - k: return quick_sort(l, i - 1) 
            if i < len(nums) - k: return quick_sort(i + 1, r)
            # 若基准数索引为 n - k ，则直接返回该元素
            return nums[-k]
            
        return quick_sort(0, len(nums) - 1)
```

```Java []
class Solution {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int quickSort(int[] nums, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        if (i > nums.length - k) return quickSort(nums, k, l, i - 1);
        if (i < nums.length - k) return quickSort(nums, k, i + 1, r);
        // 若基准数索引为 n - k ，则直接返回该元素
        return nums[nums.length - k];
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, k, 0, nums.length - 1);
    }
}
```

```C++ []
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        return quickSort(nums, k, 0, nums.size() - 1);
    }
private:
    int quickSort(vector<int>& nums, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums[i], nums[j]);
        }
        swap(nums[i], nums[l]);
        if (i > nums.size() - k) return quickSort(nums, k, l, i - 1);
        if (i < nums.size() - k) return quickSort(nums, k, i + 1, r);
        // 若基准数索引为 n - k ，则直接返回该元素
        return nums[nums.size() - k];
    }
};
```

### 复杂度分析：

本方法优化时间复杂度的本质是通过判断舍去了不必要的哨兵划分的递归操作。

- **时间复杂度 $O(N)$ ：** 其中 $N$ 为数组元素数量；对于长度为 $N$ 的数组执行哨兵划分操作的时间复杂度为 $O(N)$ ；每轮哨兵划分后根据 $k$ 和 $i$ 的大小关系选择递归，由于 $i$ 分布的随机性，则向下递归子数组的平均长度为 $\frac{N}{2}$ ；因此平均情况下，哨兵划分操作一共有 $N + \frac{N}{2} + \frac{N}{4} + ... + \frac{N}{N} = \frac{N - \frac{1}{2}}{1 - \frac{1}{2}} = 2N - 1$ （等比数列求和），即总体时间复杂度为 $O(N)$ 。
- **空间复杂度 $O(\log N)$ ：** 划分函数的平均递归深度为 $O(\log N)$ 。
