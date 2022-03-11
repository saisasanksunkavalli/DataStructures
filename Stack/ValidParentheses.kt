/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

Problem Link : https://leetcode.com/problems/valid-parentheses/

*/

/**
 * Solution : Used LinkedList to implement the Stack.
 * Stack push method will push the new value
 * to the front of the LinkedList.
 * Stack pop method will remove the head from the LinkedList.
 * Will iterate over the characters of the String by pushing each character to the Stack
 * Check for the case of Closed Parentheses and remove them from stack
 * Return false if the Closed Parentheses is not passed
 * After iteration if the stack is not empty return false
 */



class Solution {
    fun isValid(s: String): Boolean {
        var stack = Stack()
        for(c in s) {
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                stack.push(c)
            } else if ((c.equals(')') && stack.top().equals('('))
                || (c.equals('}') && stack.top().equals('{'))
                || (c.equals(']') && stack.top().equals('['))) {
                stack.pop()
            } else {
                return false
            }
        }
        if (stack.isEmpty()) {
            return true
        }
        return false
    }
}

class Stack {
    var linkedList: LinkedList = LinkedList()

    fun push(c: Char) {
        linkedList.add(c)
    }

    fun pop(): Char {
        return linkedList.remove()
    }

    fun top(): Char {
        return linkedList.top()
    }

    fun isEmpty(): Boolean {
        return linkedList.isEmpty()
    }
}


class LinkedList {
    var head: Node? = null
    var size: Int = 0

    fun add(c: Char) {
        var prevHead = head
        var node = Node()
        node.value = c
        head = node
        head?.next = prevHead
        size++
    }

    fun remove(): Char {
        if (isEmpty()) return '0'
        var prevHead = head
        head = head?.next
        size--
        return prevHead?.value ?: '0'
    }

    fun top(): Char {
        return head?.value ?: '0'
    }

    fun isEmpty(): Boolean {
        return head == null
    }
}


class Node {
    var next: Node? = null
    var value: Char? = null
}