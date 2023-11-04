## 解题思路：

栈实现队列的出队操作效率低下：栈底元素（对应队首元素）无法直接删除，需要将上方所有元素出栈。

**两个栈可实现将列表倒序**：设有含三个元素的栈 `A = [1,2,3]` 和空栈 `B = []` 。若循环执行 `A` 元素出栈并添加入栈 `B` ，直到栈 `A` 为空，则 `A = []` , `B = [3,2,1]` ，即栈 `B` 元素为栈 `A` 元素倒序。

**利用栈 `B` 删除队首元素**：倒序后，`B` 执行出栈则相当于删除了 `A` 的栈底元素，即对应队首元素。

![Picture1.png](https://pic.leetcode-cn.com/1599286207-HnnMhX-Picture1.png){:width=500}

因此，可以设计栈 `A` 用于加入队尾操作，栈 `B` 用于将元素倒序，从而实现删除队首元素。

### 函数设计：

1. **加入队尾 `push()` ：** 将数字 `val` 加入栈 `A` 即可。
2. **获取队首元素 `peek()` ：**
    1. **当栈 `B` 不为空：** `B`中仍有已完成倒序的元素，因此直接返回 `B` 的栈顶元素。
    2. **否则，当 `A` 为空：** 即两个栈都为空，无元素，因此返回 -1 。
    3. **否则：** 将栈 `A` 元素全部转移至栈 `B` 中，实现元素倒序，并返回栈 `B` 的栈顶元素。
3. **弹出队首元素 `pop()` ：**
    1. 执行 `peek()` ，获取队首元素。
    2. 弹出 `B` 的栈顶元素。
4. **队列判空 `empty()` ：** 当栈 `A` 和 `B` 都为空时，队列为空。

## 代码：

```Python []
class MyQueue:

    def __init__(self):
        self.A, self.B = [], []

    def push(self, x: int) -> None:
        self.A.append(x)

    def pop(self) -> int:
        peek = self.peek()
        self.B.pop()
        return peek

    def peek(self) -> int:
        if self.B: return self.B[-1]
        if not self.A: return -1
        # 将栈 A 的元素依次移动至栈 B
        while self.A:
            self.B.append(self.A.pop())
        return self.B[-1]

    def empty(self) -> bool:
        return not self.A and not self.B

```

```Java []
class MyQueue {
    private Stack<Integer> A;
    private Stack<Integer> B;

    public MyQueue() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
    }

    public int pop() {
        int peek = peek();
        B.pop();
        return peek;
    }

    public int peek() {
        if (!B.isEmpty()) return B.peek();
        if (A.isEmpty()) return -1;
        while (!A.isEmpty()){
            B.push(A.pop());
        }
        return B.peek();
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
```

```C++ []
class MyQueue {
private:
    std::stack<int> A, B;

public:
    MyQueue() {}

    void push(int x) {
        A.push(x);
    }

    int pop() {
        int peek = this->peek();
        B.pop();
        return peek;
    }

    int peek() {
        if (!B.empty()) return B.top();
        if (A.empty()) return -1;
        while (!A.empty()){
            B.push(A.top()), A.pop();
        }
        int res = B.top();
        return res;
    }

    bool empty() {
        return A.empty() && B.empty();
    }
};
```

### 复杂度分析：

以下分析仅满足添加 $N$ 个元素并删除 $N$ 个元素，即栈初始和结束状态下都为空的情况。

- **时间复杂度：** `push()`, `empty()` 函数的时间复杂度为 $O(1)$ ；`peek()` , `pop()` 函数在 $N$ 次队首元素删除操作中总共需完成 $N$ 个元素的倒序，均摊时间复杂度为 $O(1)$ 。
- **空间复杂度 $O(N)$ ：** 最差情况下，栈 `A` 和 `B` 共保存 $N$ 个元素。
