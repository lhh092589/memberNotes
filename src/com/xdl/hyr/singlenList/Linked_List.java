package com.xdl.hyr.singlenList;

/**
 * 单链表功能实现
 */
public class Linked_List {

    //定义一个头结点
    Node head = null;

    /**
     * 结点长度
     * @return
     */
    public int get_length() {
        int list_length = 0;
        Node cur_node;
        cur_node = head;
        while (cur_node != null) {
            list_length++;
            cur_node = cur_node.next;
        }
        return list_length;
    }

    //添加结点
    public void add_node(String data){
        Node node = new Node(data);
        if(head==null){
            head = node;
            return;
        }else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next=node;
        }
    }

    //删除某个结点
    public void deleteNode(String data){
        Node node = head;
        //记录当前结点
        Node pre_node = head;
        //记录当前结点的后一个结点
        Node next_node = node.next;
        //作为记录单链表的索引
        int i = 0;
        while(node != null){
            i++;
            //System.out.print(i);
            if(node.data.equals(data)&&i==1){
                pre_node.data = next_node.data;
                pre_node.next = next_node.next;
                return;
            }else if(node.data.equals(data)&&i!=1){
                //若内容相等，则前一个结点指向后一个结点
                node.next = next_node.next;
                next_node.next = pre_node.next.next;
                return;
                //next_node = next_node.next;
            }else{
                node.next = next_node.next;
                //next_node = pre_node.next.next;
            }
        }
    }

    /**
     * 根据下标删除结点
     * @param index
     * @return
     */
    public boolean delete_Node(int index) {
        if (index < 1 || index > get_length()) {
            System.out.println("你所要删除的元素下标输入有问题");
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        Node pre_node = head;
        Node next_node = pre_node.next;
        int i = 2;
        while (pre_node != null) {
            if (i == index) {
                pre_node.next = next_node.next;
                return true;
            } else {
                pre_node = pre_node.next;
                next_node = next_node.next;
                i++;
            }
        }
        return true;
    }

    /**
     * 根据输入数据求下标
     * @param data:输入的数据
     * @return int：返回输入数据下标
     */
    public int get_data(String data) {
        Node node = head;
        int index = 0;
        while (node != null){
            if (node.data.equals(data)){
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    /**
     * 打印单向链表的值
     */
    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        //创建链表
        Linked_List list = new Linked_List();
        //向结点中添加结点
        list.add_node("a");
        list.add_node("b");
        list.add_node("c");
        list.add_node("d");
        list.printList();
        //查询链表长度
        int i = list.get_length();
        //删除单向链表中的指 定值
        list.delete_Node(4);
        list.printList();
        //5、获取链表长度
        System.out.println("链表长度 "+ list.get_length());

        int index = list.get_data("c");

        if (index == -1){
            System.out.println("你要查找的数据不存在");
        }else{
            System.out.println("你要查找的数据元素下标 " + index);
        }
    }
}
