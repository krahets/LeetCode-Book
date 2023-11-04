## 解题思路：

> 给定一长度为 $N$ 的无序数组，其中位数的计算方法：首先对数组执行排序（使用 $O(N \log N)$ 时间），然后返回中间元素即可（使用 $O(1)$ 时间）。

根据以上思路，可以将数据流保存在一个列表中，并在添加元素时 **保持数组有序** 。此方法的时间复杂度为 $O(N)$ ，其中包括： 查找元素插入位置 $O(\log N)$ （二分查找）、向数组某位置插入元素 $O(N)$ （插入位置之后的元素都需要向后移动一位）。 

> 借助 **堆** 可进一步优化时间复杂度。

建立一个 **小顶堆** $A$ 和 **大顶堆** $B$ ，各保存列表的一半元素，且规定：

- $A$ 保存 **较大** 的一半，长度为 $\frac{N}{2}$（ $N$ 为偶数）或 $\frac{N+1}{2}$（ $N$ 为奇数）。
- $B$ 保存 **较小** 的一半，长度为 $\frac{N}{2}$（ $N$ 为偶数）或 $\frac{N-1}{2}$（ $N$ 为奇数）。

随后，中位数可仅根据 $A, B$ 的堆顶元素计算得到。

![Picture1.png](https://pic.leetcode-cn.com/bcfaca2b1920d2dd6bbb01aeff990698eb36d53830c38ed499ea3239a15296b3-Picture1.png){:width=500}

### 算法流程：

> 设元素总数为 $N = m + n$ ，其中 $m$ 和 $n$ 分别为 $A$ 和 $B$ 中的元素个数。

**函数 `addNum(num)` ：**

1. 当 $m = n$（即 $N$ 为 **偶数**）：需向 $A$ 添加一个元素。实现方法：将新元素 $num$ 插入至 $B$ ，再将 $B$ 堆顶元素插入至 $A$ 。
2. 当 $m \ne n$（即 $N$ 为 **奇数**）：需向 $B$ 添加一个元素。实现方法：将新元素 $num$ 插入至 $A$ ，再将 $A$ 堆顶元素插入至 $B$ 。

> 假设插入数字 $num$ 遇到情况 `1.` 。由于 $num$ 可能属于 “较小的一半” （即属于 $B$ ），因此不能将 $nums$ 直接插入至 $A$ 。而应先将 $num$ 插入至 $B$ ，再将 $B$ 堆顶元素插入至 $A$ 。这样就可以始终保持 $A$ 保存较大一半、 $B$ 保存较小一半。

**函数 `findMedian()` ：**

1. 当 $m = n$（ $N$ 为 **偶数**）：则中位数为 $($ $A$ 的堆顶元素 + $B$ 的堆顶元素 $)/2$。
2. 当 $m \ne n$（ $N$ 为 **奇数**）：则中位数为 $A$ 的堆顶元素。

<![Picture2.png](https://pic.leetcode-cn.com/d2592f943c0fd1eaa4e8a2c16480914907f1e9d2ba1f995e8f942d856178ed97-Picture2.png),![Picture3.png](https://pic.leetcode-cn.com/e9d88312332faa583069420df1e74a891f767d0bd2460c87b2ebe235b166e72f-Picture3.png),![Picture4.png](https://pic.leetcode-cn.com/afef056087d60ecc5c492c4c1443117ad6836cbf87fef3c619cfec876239a65e-Picture4.png),![Picture5.png](https://pic.leetcode-cn.com/74d154aa3bd575617860af2e90efb34cfe010ba375a94777859ae18944c49668-Picture5.png),![Picture6.png](https://pic.leetcode-cn.com/4ed9e5c760dd0d2a72cc64a3ee68c4b6809260a4fc1f6044be9c69ee726e8c84-Picture6.png),![Picture7.png](https://pic.leetcode-cn.com/88665d76d519800fb73c6bfca1ce4a5fb8b610ad2bb8098f482281b0c1aab6b4-Picture7.png),![Picture8.png](https://pic.leetcode-cn.com/6b0f054825e3a9cb2e311dc151cd98fbe18b0a5593845e3a31d8b72bcd49f48d-Picture8.png),![Picture9.png](https://pic.leetcode-cn.com/2cccae18c6e7c3ce1ebd07740ff95495ffbf27023895cac1ee00d7cdc45700c6-Picture9.png),![Picture10.png](https://pic.leetcode-cn.com/30da0e3c05ce2f6d191e638de344ef42f2b83eb69fc073ab1536c4f0abf1d2b3-Picture10.png),![Picture11.png](https://pic.leetcode-cn.com/68a1972bd8f51f8b042717a82f2984787729d8daec41f965e9a26f0adccd3a29-Picture11.png),![Picture12.png](https://pic.leetcode-cn.com/2a7e10fc49d6bd0a19f9cc4c8bb793eee8a8382fa0ef004de40fed3df96b4304-Picture12.png),![Picture13.png](https://pic.leetcode-cn.com/15969490140ba0d730443c13c019bbbf396478691a711cb5e59854ac9f06e5fc-Picture13.png),![Picture14.png](https://pic.leetcode-cn.com/d8d22df91c39ce03cdd43a814ebe5146c35087db9487afb2f45ed3a667ecbd98-Picture14.png)>

## 代码：

- Python 中 heapq 模块是小顶堆。实现 **大顶堆** 方法： 小顶堆的插入和弹出操作均将元素 **取反** 即可。
- Java 使用 `PriorityQueue<>((x, y) -> (y - x))` 可方便实现大顶堆。
- C++ 中 `greater` 为小顶堆， `less` 为大顶堆。

```Python []
from heapq import *

class MedianFinder:
    def __init__(self):
        self.A = [] # 小顶堆，保存较大的一半
        self.B = [] # 大顶堆，保存较小的一半

    def addNum(self, num: int) -> None:
        if len(self.A) != len(self.B):
            heappush(self.A, num)
            heappush(self.B, -heappop(self.A))
        else:
            heappush(self.B, -num)
            heappush(self.A, -heappop(self.B))

    def findMedian(self) -> float:
        return self.A[0] if len(self.A) != len(self.B) else (self.A[0] - self.B[0]) / 2.0
```

```Java []
class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
```

```C++ []
class MedianFinder {
public:
    priority_queue<int, vector<int>, greater<int>> A; // 小顶堆，保存较大的一半
    priority_queue<int, vector<int>, less<int>> B; // 大顶堆，保存较小的一半
    MedianFinder() { }
    void addNum(int num) {
        if (A.size() != B.size()) {
            A.push(num);
            B.push(A.top());
            A.pop();
        } else {
            B.push(num);
            A.push(B.top());
            B.pop();
        }
    }
    double findMedian() {
        return A.size() != B.size() ? A.top() : (A.top() + B.top()) / 2.0;
    }
};
```

> Push item on the heap, then pop and return the smallest item from the heap. The combined action runs more efficiently than heappush() followed by a separate call to heappop().

根据以上文档，可将 Python 代码优化为：

```Python []
from heapq import *

class MedianFinder:
    def __init__(self):
        self.A = [] # 小顶堆，保存较大的一半
        self.B = [] # 大顶堆，保存较小的一半

    def addNum(self, num: int) -> None:
        if len(self.A) != len(self.B):
            heappush(self.B, -heappushpop(self.A, num))
        else:
            heappush(self.A, -heappushpop(self.B, -num))

    def findMedian(self) -> float:
        return self.A[0] if len(self.A) != len(self.B) else (self.A[0] - self.B[0]) / 2.0
```

### 复杂度分析：

- **时间复杂度 $O(\log N)$ ：**
  - **查找中位数 $O(1)$ ：** 获取堆顶元素使用 $O(1)$ 时间。
  - **添加数字 $O(\log N)$ ：** 堆的插入和弹出操作使用 $O(\log N)$ 时间。  
- **空间复杂度 $O(N)$ ：** 其中 $N$ 为数据流中的元素数量，小顶堆 $A$ 和大顶堆 $B$ 最多同时保存 $N$ 个元素。
