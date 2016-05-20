package com.atlassian.test;


public class LinkedList {
    static void print(LinkedListNode end){
        do{
            System.out.println(end.val);
            end = end.next;
        }while (end != null);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedListNode firstList= new LinkedListNode("1");
        firstList= _insert_node_into_singlylinkedlist(firstList,"2");
        firstList= _insert_node_into_singlylinkedlist(firstList,"3");
        
        LinkedListNode secondList=  new LinkedListNode("1");
        secondList=_insert_node_into_singlylinkedlist(secondList,"2");
        secondList= _insert_node_into_singlylinkedlist(secondList,"3");
        print(firstList);
        System.out.println("");
        print(secondList);
        System.out.println("");
        System.out.println(find(firstList,secondList));

    }
    public static class LinkedListNode{
        String val;
        LinkedListNode next;

        LinkedListNode(String node_value) {
            val = node_value;
            next = null;
        }
    };

    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, String val){
        if(head == null) {
            head = new LinkedListNode(val);
        }
        else {
            LinkedListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }

    static int find(LinkedListNode list, LinkedListNode sublist) {
        int index=0;
        LinkedListNode firstList=list;
        LinkedListNode secondList=sublist;
        if (firstList==null || secondList==null){
            return -1;
        }
        while (firstList!=null ) {
            if (firstList.val.equals(secondList.val)){
                secondList=secondList.next;
                firstList=firstList.next;
                if (secondList==null) {
                    return index;
                }
            }else {
                secondList=sublist;
                firstList=firstList.next;
                index++;
            }
        }
        return -1;
    }
    
}
