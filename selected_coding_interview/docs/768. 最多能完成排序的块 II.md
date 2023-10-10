#### 解题思路：

-  **排序块定义：**
    - **排序块** 充分条件： 设此块中最大数字为 $head$ , 若此块后面的所有数字都 $>= head$ ，则此块为排序块。
    - **排序块** 最短长度为 $1$，即单个元素可以独立看作一个排序块。

- **贪心法则** （划分出尽可能多的排序块）：
    - **思路一：** 
        - 设定双指针指向数组头部，判断双指针内数字集合形成的块是否满足排序块条件，并尽量使窗口最小（贪心）。
        - 每次形成排序块时计数，并越过此排序块重新指定双指针位置，重复以上步骤直到划分完整个数组。
        - 此思路容易理解，但每次确定 $1$ 个块都需要遍历整个数组，在某些极端情况（例如如 $[1,2,3,4,5]$ ）时间复杂度达到 $O(N^2)$ 。
    - **思路二（本题解采用）：** 
        - 判断是否是排序块只需要用到该块的 **元素最大值** $head$ 。我们联想到，是否可以遍历一遍数组 $arr$ ，动态判断到目前数字 $num$ 为止最多能分出多少排序块，并保存每个排序块的最大值 $head$ 。每遍历到下个数字 $num$ ，动态判断前面所有的排序块是否成立，并更新所有排序块：
            - 当某排序块 $num < head$ ：将此排序块`[A]`与 `num` 合并，形成新排序块`[A | num]`，最大值仍为 $head$ ；
            - 当某排序块 $num >= head$ ：原排序块保留，并新加排序块 `[num]` 。
        - 而对于整个数组的排序块，其 $head$ 大小是从左到右递增的。例如：数组 $[1,2,1,3,4,7,5,6]$ 最多可划分为 $[1|2,1|3|4|7,5,6]$ ，$head$ 为 $[1,2,3,4,7]$ 。因此，若给数组尾部加入一个随机正整数 $n$ ，尾部的排序块更容易被合并（最先满足 $num < head$ ）。当 $n$ 值较小时（ $<$ 前面多个排序块的 $head$ ），则需按尾部到首部的顺序合并多个排序块。
        - 这种先入（首部到尾部添加排序块）后出（尾部到首部判断并合并排序块）的特性，让我们联想到使用 **栈** 保存排序块最大值 $head$ 。在遍历过程中，通过维护栈的 $head$ 序列，实现排序块的动态更新。

- **算法流程：**
    1. 遍历数组 $arr$ 中的每个数字 $num$ ；
    2. 当栈 $stack$ 不为空且数字 $num<$栈顶值 时： *（代表此 $num$ 会改变前面排序块分布）*
        - 栈顶 `pop()` 出栈，并保存栈顶值为 $head$ 。 *（此情况下，新排序块最大值还为 $head$ ，因此先暂存）*
        - 当 $stack$ 不为空且数字 $num<$栈顶值 时，循环栈顶 `pop()` 出栈。 *（判断加入 $num$ 需要合并的所有排序块，每 `pop()` 一个 $head$ 代表合并一个块）*
        - 将保存的栈顶值 $head$ 重新 `push()` 入栈。 *（将 $head$ 重新加入，作为新排序块的最大值）*
    3. 当栈 $stack$ 为空或数字 $num>=$栈顶值 时： *（代表此 $num$ 不影响前面排序块分布）*
        - 将 $num$ 数字 `push()` 入栈。 *（加入单个元素的新排序块 `[num]`）*
    4. 遍历完成后，栈中保存 **所有排序块的对应最大值** $head$ ，因此返回栈 $stack$ 长度即可获得排序块数量。

- **复杂度分析：**
    - 时间复杂度 $O(N)$ ：遍历一遍 $arr$ 为 $O(N)$，修正排序块最多遍历一遍 $arr$ 为 $O(N)$；
    - 空间复杂度 $O(N)$ ：极端情况下排序块数量等于数组长度，此时 $stack$ 占用线性大小额外空间。

    > 图解中每一种颜色代表一个排序块。

<![Picture1.png](https://pic.leetcode-cn.com/cc3fd6b7e42ec300e7d51908124b98d17b2917025be6098cb8b35b77e1c8003c-Picture1.png),![Picture2.png](https://pic.leetcode-cn.com/8477e73390ea48c33f946066d4c52efbc3ba22d4a0e1f2b7af66992e7fff797c-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/ca514d92c928d321ee61d8205cbd3e21ef90b576d627d0e1c604947cbd3abffe-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/d9bfefb2afe79da963d6ba9a1b7a53dcabc91d9b5e7f8235b2ab617f953b674d-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/155a3d25edb4fe2f41d4b46523c80af3149dae8c68bff52dead51c3a4266a896-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/71c6c6e0a5f6cd5a0121f42604c7b113356226edc59f9e9a445eb88e07444e85-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/839d73e64f983b16c4a67d9189460ac612b19d914784ef0d8208cf3aa31853f8-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/01fa2ab372e5f48a856336ebbc2ba664d4e9823775ad72c5a0ee56dfce932faa-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/aa7b182d7498ed7a0893214614ed68db16207cdd1d1ecee94dca54a1e64edded-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/9fc98562cc9f89a2db21ff28e7c63550314c6f5b5579924f7c6b6f69124c7dd1-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/9cb8746da417dc8fd378bf2759d463416c39fa6bee729b5447b7272e8b90cb04-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/9a853b812725998aae2f46b85d85c43e1d210378ae566868692277f02d38dfcd-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/0e1bfaf04e87d4855f15c11317ee3201806569c09986335e8d9f57cc232f216b-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/746e63054238716fefae6a10df0d2f597870f7a0722f6cb606797b93ac39ad2c-Picture14.png),![Picture15.png](https://pic.leetcode-cn.com/c04aaa21d1bd0da5ba2772d02a5249d8e857f0817a9679df2d6264a0cce254ad-Picture15.png)>

#### 代码：

```python [-Python]
class Solution:
    def maxChunksToSorted(self, arr: [int]) -> int:
        stack = []
        for num in arr:
            if stack and num < stack[-1]: 
                head = stack.pop()
                while stack and num < stack[-1]: stack.pop()
                stack.append(head)
            else: stack.append(num)
        return len(stack)
```

```java [-Java]
class Solution {
    public int maxChunksToSorted(int[] arr) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int num : arr) {
            if(!stack.isEmpty() && num < stack.getLast()) {
                int head = stack.removeLast();
                while(!stack.isEmpty() && num < stack.getLast()) stack.removeLast();
                stack.addLast(head);
            }
            else stack.addLast(num);
        }
        return stack.size();
    }
}
```
