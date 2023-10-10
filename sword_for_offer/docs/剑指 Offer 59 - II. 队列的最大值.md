## 解题思路：

> 对于普通队列，入队 `push_back()` 和出队 `pop_front()` 的时间复杂度均为 $O(1)$ ；本题难点为实现查找最大值 `max_value()` 的 $O(1)$ 时间复杂度。
> 假设队列中存储 $N$ 个元素，从中获取最大值需要遍历队列，时间复杂度为 $O(N)$ ，单从算法上无优化空间。

如下图所示，最直观的想法是 **维护一个最大值变量** ，在元素入队时更新此变量即可；但当最大值出队后，并无法确定下一个 **次最大值** ，因此不可行。

![Picture1.png](https://pic.leetcode-cn.com/1609261470-WanZuG-Picture1.png){:width=500}

考虑利用 **数据结构** 来实现，即经常使用的 “空间换时间” 。如下图所示，考虑构建一个递减列表来保存队列 **所有递减的元素** ，递减链表随着入队和出队操作实时更新，这样队列最大元素就始终对应递减列表的首元素，实现了获取最大值 $O(1)$ 时间复杂度。

![Picture2.png](https://pic.leetcode-cn.com/1609261470-gMTEAf-Picture2.png){:width=500}

为了实现此递减列表，需要使用 **双向队列** ，假设队列已经有若干元素：

1. 当执行入队 `push_back()` 时： 若入队一个比队列某些元素更大的数字 $x$ ，则为了保持此列表递减，需要将双向队列 **尾部所有小于 $x$ 的元素** 弹出。
2. 当执行出队 `pop_front()` 时： 若出队的元素是最大元素，则 双向队列 需要同时 **将首元素出队** ，以保持队列和双向队列的元素一致性。

> 使用双向队列原因：维护递减列表需要元素队首弹出、队尾插入、队尾弹出操作皆为 $O(1)$ 时间复杂度。

### 函数设计：

初始化队列 `queue` ，双向队列 `deque` ；

**最大值 `max_value()` ：**

- 当双向队列 `deque` 为空，则返回 $-1$ ；
- 否则，返回 `deque` 首元素；

**入队 `push_back()` ：**

1. 将元素 `value` 入队 `queue` ；
2. 将双向队列中队尾 **所有** 小于 `value` 的元素弹出（以保持 `deque` 非单调递减），并将元素 `value` 入队 `deque` ；

**出队 `pop_front()` ：**

1. 若队列 `queue` 为空，则直接返回 $-1$ ；
2. 否则，将 `queue` 首元素出队；
3. 若 `deque` 首元素和 `queue` 首元素 **相等** ，则将 `deque` 首元素出队（以保持两队列 **元素一致** ） ；

> 设计双向队列为 **单调不增** 的原因：若队列 `queue` 中存在两个 **值相同的最大元素** ，此时 `queue` 和 `deque` 同时弹出一个最大元素，而 `queue` 中还有一个此最大元素；即采用单调递减将导致两队列中的元素不一致。

<![Picture3.png](https://pic.leetcode-cn.com/1609261619-jyPPLT-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/1609261619-bCHZki-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/1609261619-VJHbWU-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/1609261757-CwSwSi-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/1609261619-TeDGxf-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/1609261619-xvlryq-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/1609261619-ARzNSA-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/1609261619-UZBWSp-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/1609261619-CiZXVu-Picture11.png)>

### 复杂度分析：

- **时间复杂度 $O(1)$ ：** `max_value()`, `push_back()`, `pop_front()` 方法的均摊时间复杂度均为 $O(1)$ ；
- **空间复杂度 $O(N)$ ：** 当元素个数为 $N$ 时，最差情况下`deque` 中保存 $N$ 个元素，使用 $O(N)$ 的额外空间；

## 代码：

```Python []
import queue

class MaxQueue:
    def __init__(self):
        self.queue = queue.Queue()
        self.deque = queue.deque()

    def max_value(self) -> int:
        return self.deque[0] if self.deque else -1

    def push_back(self, value: int) -> None:
        self.queue.put(value)
        while self.deque and self.deque[-1] < value:
            self.deque.pop()
        self.deque.append(value)

    def pop_front(self) -> int:
        if self.queue.empty(): return -1
        val = self.queue.get()
        if val == self.deque[0]:
            self.deque.popleft()
        return val
```

```Java []
class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }
    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty() && deque.peekLast() < value)
            deque.pollLast();
        deque.offerLast(value);
    }
    public int pop_front() {
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        return queue.poll();
    }
}
```

```C++ []
class MaxQueue {
    queue<int> que;
    deque<int> deq;
public:
    MaxQueue() { }
    int max_value() {
        return deq.empty() ? -1 : deq.front();
    }
    void push_back(int value) {
        que.push(value);
        while(!deq.empty() && deq.back() < value)
            deq.pop_back();
        deq.push_back(value);
    }
    int pop_front() {
        if(que.empty()) return -1;
        int val = que.front();
        if(val == deq.front())
            deq.pop_front();
        que.pop();
        return val;
    }
};
```
