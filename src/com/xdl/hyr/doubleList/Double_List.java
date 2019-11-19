package com.xdl.hyr.doubleList;

import java.io.IOException;
import java.util.Scanner;

public class Double_List {

        public static Node head = null;//表头
        public static int length = 0;

        //在链表头部添加结点
        public static void addHead(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = newNode;//如果链表为空，增加新结点
            }
            else {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            }
            length++;
        }

        //在链表头部删除结点
        public static void deleteHead() {
            if(head == null){
                System.out.println("空表，删除的结点不存在");
            }
            else {
                Node curNode = head;
                head = curNode.next;
                head.previous = null;
            }
            length--;
        }

        //在链表尾部添加结点
        public static void addTail(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node curNode = head;
                int count = 1;
                while (count < length) {
                    curNode = curNode.next;
                    count++;
                }
                newNode.next = null;
                newNode.previous = curNode;
                curNode.next = newNode;
            }
            length++;
        }

        //在链表尾部删除结点
        public static void deleteTail() {
            if(head == null){
                System.out.println("空表，删除的结点不存在");
            }else{
                Node preNode = head;
                int count = 1;
                while(count < length-1) {
                    preNode = preNode.next;
                    count++;
                }
                preNode.next = null;
            }
            length--;
        }


        //正向遍历链表
        public static void printOrderNode() {
            if(head == null) {
                System.out.println("空表");
            }
            Node curNode = head;
            while (curNode != null) {
                curNode.display();
                curNode = curNode.next;
            }
            System.out.println();
        }

        //反向遍历链表
        public static void printReverseNode() {
            if(head == null) {
                System.out.println("空表");
            }
            Node curNode = head;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            while (curNode != null) {
                curNode.display();
                curNode = curNode.previous;
            }
            System.out.println();
        }

        //在指定位置插入结点
        public static void insertList(int data, int index) {
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;//链表为空，插入
            }
            if(index > length+1 || index < 1) {
                System.out.println("结点插入的位置不存在，可插入的位置为1到"+(length+1));
            }
            if(index == 1) {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;//在链表开头插入
            } else{              //在链表中间或尾部插入
                Node preNode = head;
                int count = 1;
                while(count < index-1) {
                    preNode = preNode.next;
                    count++;
                }
                Node curNode = preNode.next;
                newNode.next = curNode;
                newNode.previous = preNode;
                preNode.next = newNode;
                if(curNode != null) {
                    curNode.previous = newNode;
                }
            }
            length++;
        }

        //在指定位置删除结点
        public static void deleteList(int index) {
            if(index > length || index < 1) {
                System.out.println("结点删除的位置不存在，可删除的位置为1到"+length);
            }
            if(index == 1) {
                Node curNode = head;
                head = curNode.next;
                head.previous = null;
                length--;
            } else{
                Node preNode = head;
                int count = 1;
                while(count < index-1) {
                    preNode = preNode.next;
                    count++;
                }
                Node curNode = preNode.next;
                Node laterNode = curNode.next;
                preNode.next = laterNode;
                if(laterNode != null) {  //若被删除结点的后继结点不是null结点，那么设置其前驱结点
                    laterNode.previous = preNode;//指针指向被删除结点的前驱结点
                }
                length--;
            }
        }

        //查找数据是否存在,与单链表一样
        public static boolean containData(int data) {
            if(head == null){
                System.out.println("空表");
                return false;
            }
            Node curNode = head;
            while(curNode.data!= data){
                if(curNode.next == null) {
                    System.out.println("结点数据不存在");
                    return false;
                }
                curNode =curNode.next;
            }
            System.out.println("结点数据存在");
            return true;
        }

        //获取指定位置的数据，与单链表一样
        public static void getIndexData(int index) {
            if(head == null){
                System.out.println("空表");
            }
            if(index > length || index < 1) {
                System.out.println("结点位置不存在，可获取的位置为1到"+length);
            }
            Node curNode = head;
            int count =1;
            while(count != index) {
                curNode =curNode.next;
                count++;
            }
            curNode.display();
            System.out.println();
        }

        //修改指定位置的结点数据，与单链表一样
        public static void updateIndexData(int index, int data) {
            if(head == null){
                System.out.println("空表");
            }
            if(index > length || index < 1) {
                System.out.println("结点位置不存在，可更新的位置为1到"+length);
            }
            Node curNode = head;
            int count =1;//while也可以用for循环方式解决
            while(count != index) {
                curNode =curNode.next;
                count++;
            }
            curNode.data = data;
        }

        //打印链表
        public static void printList(){
            Node tmp = head;
            while(tmp != null){
                System.out.print(tmp.data + " ");
                tmp = tmp.next;
            }
            System.out.println();
        }

        public static void main(String []args) throws IOException {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入需要添加的结点,输入0表示结束");
            while (true) {
                int s = sc.nextInt();
                if(s == 0) {
                    break;
                }else {
                    addHead(s);
                }
            }
            //输入样例
            //1
            //2
            //3
            //0 输入0结束
            printList();
            //删除头结点
            deleteHead();
            printList();
            //正向遍历
            printOrderNode();

            Scanner in = new Scanner(System.in);
            System.out.print("请输入添加结点的位置：");
            int index = sc.nextInt();
            System.out.print("请输入添加结点的值");
            int data = sc.nextInt();
            insertList(data, index);
            printList();
        }
    }
