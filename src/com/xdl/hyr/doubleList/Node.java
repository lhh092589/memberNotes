package com.xdl.hyr.doubleList;

public class Node {
    public int data;//数据域
    public Node next;//后继指针域
    public Node previous;//前驱指针域

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
    //显示该结点的数据
    public void display() {
        System.out.print( data + " ");
    }
}
