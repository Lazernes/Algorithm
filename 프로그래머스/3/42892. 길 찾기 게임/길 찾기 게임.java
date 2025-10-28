import java.util.*;

class Solution {

    static Node[] tree;
    static int[][] answer;
    static int index;
    static int n;   // node의 개수
    
    static class Node {
        int x, y;
        int value;
        Node left, right;
        
        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right= right;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        n = nodeinfo.length;
        answer = new int[2][n];
        tree = new Node[n];
        
        for(int i=0;i<n;i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            
            tree[i] = new Node(x, y, i+1, null, null);
        }
        
        // Node의 y값이 큰 순서대로 정렬, y값이 같다면 x값이 작은 순서로 정렬
        Arrays.sort(tree, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if(n1.y == n2.y) return n1.x - n2.x;
                else return n2.y - n1.y;
            }
        });
        
        Node root = tree[0];
        for(int i=1;i<tree.length;i++) {
            InsertNode(root, tree[i]);
        }
        
        index = 0;
        preorder(root);
        index = 0;
        postorder(root);
        
        return answer;
    }
    
    static void InsertNode(Node parent, Node child) {
        if(child.x < parent.x) {
            if(parent.left == null){
                parent.left = child;
            } else {
                InsertNode(parent.left, child);
            }
        } else {
            if(parent.right == null) {
                parent.right = child;    
            } else {
                InsertNode(parent.right, child);
            }
            
        }
    }
    
    static void preorder(Node node) {
        if(node != null){
            answer[0][index++] = node.value;
            preorder(node.left);
            preorder(node.right);
        }
    }
    
    static void postorder(Node node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            answer[1][index++] = node.value;
        }
    }
}