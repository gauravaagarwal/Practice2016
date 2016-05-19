package com.codility.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class BFSGraph {

	public static void main(String[] args) {
		 buildGraph();
	}

	  
    public static class GNode {
        String name;
        boolean visited=false;
        GNode(String _name){
            name=_name;
        }
        HashSet<GNode> linkNodes=new HashSet<GNode>();
        void add(GNode node){
            linkNodes.add(node);
        }
        @Override
        public int hashCode() {
            final int PRIME = 31;
            int result = 1;
            result = PRIME * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final GNode other = (GNode) obj;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }
        public int shortestLength(GNode searchNode){
            int INCREMENT=6;
            if (linkNodes.size()==0||searchNode.linkNodes.size()==0)
                return -1;
            int depth=INCREMENT;
            UniqueQueue queue= new UniqueQueue();
            queue.add(this);
            UniqueQueue tempQueue = new UniqueQueue();
            while(!queue.isEmpty()) {
                GNode currentNode=queue.remove();
                currentNode.visited=true;
                tempQueue.addAll(currentNode.linkNodes);

                System.out.println(currentNode);
                if (currentNode.linkNodes.size()!=0)
                    if (currentNode.linkNodes.contains(searchNode)){
                        return depth;
                    }
                if (queue.isEmpty() ){
                    depth=depth+INCREMENT;
                    queue=(tempQueue);
                    tempQueue = new UniqueQueue();
                } 
            }
            return -1;
        }
        public String toString(){
            return "#"+name+" "+visited;
        }
    }
    public static class UniqueQueue {
        LinkedList<GNode> queue = new LinkedList<GNode>(){
            @Override
            public boolean addAll(Collection<? extends GNode> c) {
                boolean added=false;
                for (GNode entry : c) {
                    if (!entry.visited) {
                       added= super.add(entry);
                    }
                }
                return added;
            }
        };
        public boolean addAll(Collection<? extends GNode> c) {
            return queue.addAll(c);
            
        }
        public GNode remove(){
           return queue.pollFirst();
        }
        public boolean add(GNode g){
            return queue.add(g);
        }
        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }
    public static void buildGraph(){
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        String ans="";
        for (int i=1;i<=T;i++){
            int nodes=scanner.nextInt();
            int edges=scanner.nextInt();
            ArrayList<GNode> nodeList = new ArrayList<GNode>(nodes){
                @Override
                public GNode get(int index) {
                    //change indexing to match array indexing
                    return super.get(index-1);
                }
            };
            for (int j=1;j<=nodes;j++) {
                nodeList.add(new GNode(new Integer(j).toString()));
            }
            //System.out.println(nodeList);
            for (int k=1;k<=edges;k++){
                int node1=scanner.nextInt();
                int node2=scanner.nextInt();
                GNode nodeOne=nodeList.get(node1);
                GNode nodeTwo=nodeList.get(node2);
                //System.out.println("nodeOne "+ nodeOne + "nodeTwo "+nodeTwo);
                nodeOne.add(nodeTwo);
                nodeTwo.add(nodeOne);
            }
            int strtNode=scanner.nextInt();
            GNode startNode= nodeList.get(strtNode);

           // System.out.println("startNode "+ startNode);
            for (GNode node : nodeList) {
               // System.out.println("forNode "+ node);
                for (GNode node1 : nodeList) {
                    node1.visited=false;
                }
                if (!node.equals(startNode)) {
                    ans+=(node.shortestLength(startNode)+" ");
                }
            }
            ans+=("\n");
        }
        System.out.print(ans);
    }
}
