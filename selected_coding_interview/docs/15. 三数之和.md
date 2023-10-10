#### 解题思路：

- 暴力法搜索为 $O(N^3)$ 时间复杂度，可通过双指针动态消去无效解来优化效率。
- **双指针法铺垫：** 先将给定 `nums` 排序，复杂度为 $O(NlogN)$。
- **双指针法思路：** 固定 $3$ 个指针中最左（最小）数字的指针 `k`，双指针 `i`，`j` 分设在数组索引 $(k, len(nums))$ 两端，通过双指针交替向中间移动，记录对于每个固定指针 `k` 的所有满足 `nums[k] + nums[i] + nums[j] == 0` 的 `i`,`j` 组合：
    1. 当 `nums[k] > 0` 时直接`break`跳出：因为 `nums[j] >= nums[i] >= nums[k] > 0`，即 $3$ 个数字都大于 $0$ ，在此固定指针 `k` 之后不可能再找到结果了。
    2. 当 `k > 0`且`nums[k] == nums[k - 1]`时即跳过此元素`nums[k]`：因为已经将 `nums[k - 1]` 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
    3. `i`，`j` 分设在数组索引 $(k, len(nums))$ 两端，当`i < j`时循环计算`s = nums[k] + nums[i] + nums[j]`，并按照以下规则执行双指针移动：
        - 当`s < 0`时，`i += 1`并跳过所有重复的`nums[i]`；
        - 当`s > 0`时，`j -= 1`并跳过所有重复的`nums[j]`；
        - 当`s == 0`时，记录组合`[k, i, j]`至`res`，执行`i += 1`和`j -= 1`并跳过所有重复的`nums[i]`和`nums[j]`，防止记录到重复组合。
- **复杂度分析：**
    - 时间复杂度 $O(N^2)$：其中固定指针`k`循环复杂度 $O(N)$，双指针 `i`，`j` 复杂度 $O(N)$。
    - 空间复杂度 $O(1)$：指针使用常数大小的额外空间。

<![Picture1.png](https://pic.leetcode-cn.com/fe0bf4f1476950365f4daf7f6c69959a26efa4ce4838d9ab2ebdc653720d5bc4-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/030717e1cde175687fae914f3f49b3f17c6aaa75656b4be8ab49be14790d691c-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/1638b06c85ea703e8c5266f6c2a5127ea622cad92f098e0faef888c664e56adf-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/c04ad52a5c4335e6a7f5f23c31de4fda75dc79156f218977e82436935c6aec22-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/17f8dd95e4b8ea334a28a48d597faf60f680eb45eb5dc9b31d18d0679b099954-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/f3a5212604b0348c004653ae3bf31e5871f768df0363aea713ab3b504d30694f-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/968378e44e71c89151670d3c0c6528d3599c372c10b51301756883555c0f7818-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/13e88630eba35158eea4540a4a7e057a5035d88084cdd497ff444d741ffb6ac5-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/7d06396d1df00b6654c05d0ee059645d57bc1a0d97d7417b0caacf9cc1b1049e-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/2e170ae1dc32b71606f9782d88c9ea61324675213b3c871c55b2944a2c37c075-Picture10.png)>

#### 代码：

```Python []
class Solution:
    def threeSum(self, nums: [int]) -> [[int]]:
        nums.sort()
        res, k = [], 0
        for k in range(len(nums) - 2):
            if nums[k] > 0: break # 1. because of j > i > k.
            if k > 0 and nums[k] == nums[k - 1]: continue # 2. skip the same `nums[k]`.
            i, j = k + 1, len(nums) - 1
            while i < j: # 3. double pointer
                s = nums[k] + nums[i] + nums[j]
                if s < 0:
                    i += 1
                    while i < j and nums[i] == nums[i - 1]: i += 1
                elif s > 0:
                    j -= 1
                    while i < j and nums[j] == nums[j + 1]: j -= 1
                else:
                    res.append([nums[k], nums[i], nums[j]])
                    i += 1
                    j -= 1
                    while i < j and nums[i] == nums[i - 1]: i += 1
                    while i < j and nums[j] == nums[j + 1]: j -= 1
        return res
```

```Java []
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
```
