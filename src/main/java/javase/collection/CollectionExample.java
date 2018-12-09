package javase.collection;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

public class CollectionExample {
    class Node{
        private String val;
        private Node next;

        public Node(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val;
        }
    }

    @Test
    public void testList(){
        List<Node> nodeList= Lists.newArrayList();
        Node node1=new Node("node1");
        Node node2=new Node("node2");
        Node node3=new Node("node3");

        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node3);
        nodeList.add(node3);

        for(Node node:nodeList){
            System.out.println(node);
        }

        System.out.println("****************");

        nodeList.remove(node3);

        for(Node node:nodeList){
            System.out.println(node);
        }
        System.out.println("****************");
        System.out.println(nodeList.get(3));

        System.out.println("****************");
        System.out.println(nodeList.subList(1,3));
        System.out.println("****************");

        System.out.println(nodeList);
        Collections.reverse(nodeList);
        System.out.println(nodeList);
    }

    @Test
    public void testMap(){
        Map map=new HashMap();
        map.put("hello","haha");
        map.put("world","hehe");
        map.put("today","heihei");
        map.put("tomorrow","heihei");
        map.put("hour","heihei");
        System.out.println(map);

        System.out.println(new TreeMap<>(map));
    }

  public static void main(String args[]) {
    Set set = new HashSet();
    set.add("Bernadine");
    set.add("Elizabeth");
    set.add("Gene");
    set.add("Elizabeth");
    set.add("Clara");
    System.out.println(set);

    Set sortedSet = new TreeSet(set);

    System.out.println(sortedSet);
  }
}