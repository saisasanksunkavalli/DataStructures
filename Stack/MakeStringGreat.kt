/*
Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.



Example 1:

Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
Example 2:

Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
Example 3:

Input: s = "s"
Output: "s"


Constraints:

1 <= s.length <= 100
s contains only lower and upper case English letters.

Problem Link : https://leetcode.com/problems/make-the-string-great/
*/

/**
 * Solution : Used LinkedList to implement the Stack.
 * Stack push method will push the new value
 * to the front of the LinkedList.
 * Stack pop method will remove the head from the LinkedList.
 * Will iterate over the characters of the String by pushing each character to the Stack
 * Check for the case of Adjacent bad characters and remove them from stack before pushing to the Stack
 * Add the characters from Stack to a string & reverse it. It will have a great String.
 */



class Solution {
    fun makeGood(s: String): String {
        var stack = Stack()
        for (c in s) {
            if (stack.isEmpty()) {
                stack.push(c)
                continue
            }
            var top = stack.top()
            if ((c.isLowerCase() && top.isUpperCase() && (top.toLowerCase() == c))
                || (c.isUpperCase() && top.isLowerCase() && (top.toUpperCase() == c))) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }
        var result = ""
        while(!stack.isEmpty()) {
            result += stack.pop()
        }
        return result.reversed()
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
