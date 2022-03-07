package algorithmWithLeetcode.bfs;

import java.util.*;

public class CloneGraph133 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);


        cloneGraph(node1);

    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // findAllNodes(node) : find all node in original graph, store in a set
        Set<Node> allNodes = findAllNodes(node);
        allNodes.stream().forEach(n -> System.out.println(n.val));

        // copy all nodes in original graph. store in a map
        // key : original nodes
        // value : copied nodes
        Map<Node, Node> map = copyAllNodes(allNodes);
        map.forEach((k, v) -> {
            System.out.println("Key : " + k.val + "--- Value : " + v.val);
        });

        // copy all edges
        copyEdges(map);

        return map.get(node);
    }

    private static void copyEdges(Map<Node, Node> map) {
        for (Node node : map.keySet()) {
            Node copiedNode = map.get(node);
            for (Node neighbor : node.neighbors) {
                copiedNode.neighbors.add(map.get(neighbor));
            }
        }
    }

    private static Map<Node, Node> copyAllNodes(Set<Node> allNodes) {
        Map<Node, Node> map = new HashMap<>();
        for (Node node : allNodes) {
            map.put(node, new Node(node.val));
        }
        return map;
    }

    private static Set<Node> findAllNodes(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();

        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (Node neighbor : curNode.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return set;

    }

    private static class Node {
        int val;
        List<Node> neighbors;

        public Node() {
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }


}
