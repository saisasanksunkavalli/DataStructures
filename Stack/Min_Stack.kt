/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

    MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.


Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.

Problem Link : https://leetcode.com/problems/min-stack/
*/

/**
 * Solution : Used LinkedList to implement the Stack.
 * Stack push method will push the new value
 * to the front of the LinkedList.
 * Stack pop method will remove the head from the LinkedList.
 * LinkedList Node will contain a custom variable min, which while adding to the linkedList will be
 * calculated using minOf(value, head.min)
 * getMin method will always return head.min
 */

class MinStack() {
    var linkedList: LinkedList = LinkedList()

    fun push(`val`: Int) {
        linkedList.add(`val`)
    }

    fun pop() {
        linkedList.remove()
    }

    fun top(): Int {
        return linkedList.top()
    }

    fun getMin(): Int {
        return linkedList.head?.min ?: Int.MAX_VALUE
    }

}

class LinkedList {
    var head: Node? = null
    var size: Int = 0

    fun add(value: Int) {
        var prevHead = head
        var node = Node()
        node.value = value
        node.min = minOf(value, head?.min ?: Int.MAX_VALUE)
        head = node
        head?.next = prevHead
        size++
    }

    fun remove(): Int {
        if (isEmpty()) return -1
        var prevHead = head
        head = head?.next
        size--
        return prevHead?.value ?: -1
    }

    fun top(): Int {
        return head?.value ?: -1
    }

    fun isEmpty(): Boolean {
        return head == null
    }
}


class Node {
    var next: Node? = null
    var value: Int? = null
    var min: Int? = null
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */