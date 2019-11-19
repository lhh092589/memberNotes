package com.xdl.hyr.singlenList;

/**
 * 结点实体类
 */
public class Node {
    //指针
    Node next;
    //结点内容
    Object data;

    public Node(Node next, Object data) {
        this.next = next;
        this.data = data;
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node() {
    }
}
