
import java.util.*;

/**
 * from leecode ,learn record
 *
 * @Author gaboness
 * @Date 2023/11/23 16:32:00
 */
public class BootMain {
    public static void main(String[] args) {
        heap();
    }

    /**
     * 数组
     * 是将相同类型的元素存储于连续内存空间的数据结构，其长度不可变,扩容创建新数组
     */
    public static void array() {
        int[] arr = new int[]{1, 4, 5, 66};
        int[] arr2 = new int[5];
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        arr2[0] = 1;
        arr2[1] = 2;
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

    /**
     * 链表
     * 以节点为单位，每个元素都是一个独立对象，在内存空间的存储是非连续的
     */
    public static void listNode() {
        ListNode n1 = new ListNode(4); // 节点 head
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        System.out.println(n3.next);
    }

    /**
     * 栈
     * 栈是一种具有 「先入后出」 特点的抽象数据结构，可使用数组或链表实现
     */
    public static void stack() {
        Stack<Integer> stack = new Stack<>();
        // 元素3 入栈
        stack.push(3);
        // 元素4 入栈
        stack.push(4);
        System.out.println(stack.peek());
        // 元素4 出栈
        stack.pop();
        System.out.println(stack.peek());
    }

    /**
     * stack、vector已经不推荐使用
     * 可以使用LinkedList实现栈
     */
    public static void fastStack() {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(3);
        stack.addLast(5);

        stack.removeLast();
        System.out.println(stack.peek());

        stack.removeLast();
        System.out.println(stack.peek());
    }

    /**
     * 队列
     * 队列是一种具有 「先进先出」 特点的抽象数据结构，可使用数组或链表实现
     */
    public static void queue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(3); // 元素3 入队
        queue.offer(5); // 元素5 入队
        System.out.println(queue.peek());
        // 元素3 出队
        queue.poll();
        System.out.println(queue.peek());
    }

    /**
     * 树
     * 非线性数据结构，根据子节点数量可分为 「二叉树」 和 「多叉树」，最顶层的节点称为「根节点 root」。以二叉树为例，每个节点包含三个成员变量：「值 val」、「左子节点 left」、「右子节点 right」
     */
    public static void tree() {
        TreeNode n1 = new TreeNode(3); // 根节点 root
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);

        // 构建引用指向
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
    }

    /**
     * 图
     * 一种非线性结构的数据格式，节点和边组成，节点包含「值 val」、「邻接节点列表 adj」
     * 图可以分为有向图和无向图。表示方法有2种，邻接矩阵和邻接表。
     * <p>
     * 如图：
     * 5-4-2
     * |\|/
     * 3-1
     * <p>
     * 邻接矩阵
     * 顶点集合：[1,2,3,4,5]
     * 邻接矩阵表示的是每个顶点之间是否有边，比如可以看到顶点1和顶点2、3、4、5之间都有边，因此下列矩阵的第一行为：0,1,1,1,1
     * 1 2 3 4 5
     * ----------------   ：
     * 1 0 1 1 1 1
     * 2 1 0 0 1 0
     * 3 1 0 0 0 1
     * 4 1 1 0 0 1
     * 5 1 0 1 1 0
     * <p>
     * <p>
     * <p>
     * 邻接表：
     * 顶点集合：[1,2,3,4,5]
     * 邻接表表示的则是存储该顶点对应的边之和，例如顶点1的邻接顶点是 2,3,4,5,  2,3,4,5在顶点数组中对应的索引下标为1,2,3,4.
     * <p>
     * 1 2 3 4 5
     * ----------------   ：
     * 1 1 2 3 4
     * 2 0 3
     * 3 0 4
     * 4 0 1 4
     * 5 0 2 3
     * <p>
     * 从这2种表示方法可以看出，邻接矩阵更倾向于表示边比较多的图，即顶点少、领边多，边密集型的
     * 邻接表更倾向于顶点比较多，边比较少，边稀疏的图
     */
    public static void graph() {
        int[] vertices = {1, 2, 3, 4, 5};
        int[][] edges = {{0, 1, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 0, 1, 1, 0}};
    }

    /**
     * 散列表是一种非线性数据结构，通过利用 Hash 函数将指定的「键 key」映射至对应的「值 value」，以实现高效的元素查找
     */
    public static void hashing() {
        Map<Integer, String> hash = new HashMap<>();
        hash.put(1, "a");
        hash.put(2, "b");
        hash.put(3, "c");
        System.out.println(hash.get(2));
    }

    /**
     * 堆
     * 是一种基于「完全二叉树」的数据结构，可使用数组实现。以堆为原理的排序算法称为「堆排序」，基于堆实现的数据结构为「优先队列」。堆分为「大顶堆」和「小顶堆」，大（小）顶堆：任意节点的值不大于（小于）其父节点的值。
     * 完全二叉树：除了最后一层，其他层的节点数都达到最大值；如果最后一层不是完全填充的，则最右边的若干个节点是空
     * <p>
     * priorityQueue 默认是小顶堆，如果想实现大顶堆，需要传入一个比较器
     */
    public static void heap() {
        Queue<Integer> heap = new PriorityQueue<>();
        heap.offer(2);
        heap.offer(8);
        heap.offer(6);
        heap.offer(4);
        heap.offer(1);

        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
