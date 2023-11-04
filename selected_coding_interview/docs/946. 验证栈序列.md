## 解题思路：

如下图所示，给定一个压入序列 $pushed$ 和弹出序列 $popped$ ，则压入 / 弹出操作的顺序（即排列）是 **唯一确定** 的。

![Picture1.png](https://pic.leetcode-cn.com/1188474dc6a377fc258004bca84e5a130b663eeb24bf22c4fa4eb998a0249f97-Picture1.png){:width=500}

如下图所示，栈的数据操作具有 **先入后出** 的特性，因此某些弹出序列是无法实现的。

![Picture2.png](https://pic.leetcode-cn.com/3f43b224553bf3a37f9758dbb41655e547795e293524a148380c6f335af315e4-Picture2.png){:width=500}

考虑借用一个辅助栈 $stack$ ，**模拟** 压入 / 弹出操作的排列。根据是否模拟成功，即可得到结果。

- **入栈操作：** 按照压栈序列的顺序执行。
- **出栈操作：** 每次入栈后，循环判断 “栈顶元素 $=$ 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。

> 由于题目规定 `栈的所有数字均不相等` ，因此在循环入栈中，每个元素出栈的位置的可能性是唯一的（若有重复数字，则具有多个可出栈的位置）。因而，在遇到 “栈顶元素 $=$ 弹出序列的当前元素” 就应立即执行出栈。

### 算法流程：

1. **初始化：** 辅助栈 $stack$ ，弹出序列的索引 $i$ 。
2. **遍历压栈序列：** 各元素记为 $num$ 。
   1. 元素 $num$ 入栈。
   2. 循环出栈：若 $stack$ 的栈顶元素 $=$ 弹出序列元素 $popped[i]$ ，则执行出栈与 $i++$ 。
3. **返回值：** 若 $stack$ 为空，则此弹出序列合法。

<![Picture3.png](https://pic.leetcode-cn.com/33835fb3df651d93d659895384988371e50d1f2fc6773fb4e4f1539ade09ba33-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/92c7af00dfef949480599e229883c03ec7283f6f5206d8414d98771ebdc69115-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/ca8300ed98b8e03433661bb08a50b114d0364e7504f5705c18d12117de2a6b0b-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/fa133ea2602a09c88779b2ddfc7d4fdda6b3896efdb9e58a6565ad346cf46278-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/ac7d8c2bebee22110298c6977e62546014b8692f244ba1921904304b130e8e9e-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/75d2d318a1f6a2f4e4638a9bd5711ea1b9ab849fbfc2a442be898d499eed926d-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/d905d5e62029bdef4c31bf63c3bde4f7accf49f300558fd30569474b61989234-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/5329e3532d0e9f4dae3aa10ef029e03e27c465adc7768a545acc2a3724fa6a41-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/e861009affb8c7b36911193ab4b317352f97a25d340f9cb3b01f457d49bd0ee7-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/d42823ece52a7c105010480eb4a8cdb130637949f18f0be9443a5dd6fbb95764-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/d5e5da64bc2f62ad94e3a3dc65cf049ffa4268a8a4ab44bf9337d9d8378ccde2-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/b30701ab475dd8a4f8f8ee45abf086367e8cad82d3f8475555a828fdb57ea992-Picture14.png)>

## 代码：

题目指出“ $pushed$ 一定是 $popped$ 的排列”。因此，无需考虑 $pushed$ 和 $popped$ **长度不同** 或 **包含元素不同** 的情况。

```Python []
class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack, i = [], 0
        for num in pushed:
            stack.append(num) # num 入栈
            while stack and stack[-1] == popped[i]: # 循环判断与出栈
                stack.pop()
                i += 1
        return not stack
```

```Java []
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num); // num 入栈
            while (!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
```

```C++ []
class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int> stk;
        int i = 0;
        for (int num : pushed) {
            stk.push(num); // num 入栈
            while (!stk.empty() && stk.top() == popped[i]) { // 循环判断与出栈
                stk.pop();
                i++;
            }
        }
        return stk.empty();
    }
};
```

### 复杂度分析：

- **时间复杂度 $O(N)$ ：** 其中 $N$ 为列表 $pushed$ 的长度；每个元素最多入栈与出栈一次，即最多共 $2N$ 次出入栈操作。
- **空间复杂度 $O(N)$ ：** 辅助栈 $stack$ 最多同时存储 $N$ 个元素。
