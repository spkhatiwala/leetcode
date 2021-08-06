import java.util.*;
import java.util.stream.Collectors;

class Main {
    static class Node{
        Node parent;
        int value;
        List<Node> children;
        Node(int val){
            value = val;
            children = new ArrayList<>();
        }
    }
    public static String ArrayChallenge(String[] strArr) {
        Map<Integer, Node> map = new HashMap<>();
        for(String s: strArr) {
            String ss[] = s.substring(1, s.length() - 1).split(",");
            Integer child = Integer.parseInt(ss[0]);
            Integer parent = Integer.parseInt(ss[1]);
            Node childNode = map.getOrDefault(child, new Node(child));
            Node parentNode = map.getOrDefault(parent, new Node(parent));
            map.put(child, childNode);
            map.put(parent, parentNode);
            childNode.parent = parentNode;
            parentNode.children.add(childNode);
        }
        List<Node> rootNodes = map.values().stream().filter(n -> n.parent==null).collect(Collectors.toList());
        if(rootNodes.size() != 1)
            return "false";
        Node node = rootNodes.get(0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node tempNode = queue.poll();
            if(tempNode.children.size()>2)
                return "false";
            for(Node n: tempNode.children){
                queue.add(n);
            }
        }
        return "true";
    }

    public static void main (String[] args) {
        // keep this function call here
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        ListIterator<Integer> listIterator = list.listIterator(0);
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
    }

}