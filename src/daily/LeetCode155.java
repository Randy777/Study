package daily;

import java.util.Stack;

/**
 *设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *     push(x) —— 将元素 x 推入栈中。
 *     pop() —— 删除栈顶的元素。
 *     top() —— 获取栈顶元素。
 *     getMin() —— 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class LeetCode155 {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public LeetCode155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            int top = minStack.peek();
            //小于的时候才入栈
            if (x <= top) {
                minStack.push(x);
            }
        }else{
            minStack.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();
        int t = minStack.peek();
        if(pop == t){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
