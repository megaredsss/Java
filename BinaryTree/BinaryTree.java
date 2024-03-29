import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree {
     static class CreateNode {
         int data;
         CreateNode left;
         CreateNode right;

         public CreateNode(int data) {
             this.data = data;
             right = null;
             left = null;

         }
     }
        static CreateNode node;

     private static CreateNode InsertNodeRecursive(CreateNode node, int data){
        if (node == null) {
            return new CreateNode(data);
        }
        if (data > node.data) {
            if (node.right != null) {
                InsertNodeRecursive(node.right, data);
            } else {
                node.right = new CreateNode(data);
            }
        }
        if (data < node.data){
            if (node.left != null){
                InsertNodeRecursive(node.left, data);
            }
            else {
                node.left = new CreateNode(data);
            }
        }
        return node;
    }
    static public void InsertNode(int data){
        node = InsertNodeRecursive(node,data);
    }
    public static boolean SearchNode(int data) {
        return SearchNodeRecursive(node, data);
    }
    private static boolean SearchNodeRecursive(CreateNode node, int data){
        if(node == null){
            return false;
        }
        if (data == node.data){
            return true;
        }
        return data < node.data ? SearchNodeRecursive(node.left, data) : SearchNodeRecursive(node.right, data);
    }



    private static int FindTheSmallestNode(CreateNode node){
        int min = node.data;
        while (node.left != null){
            min = node.left.data;
            node = node.left;
        }
        return min;
    }
    public static void DeleteNode(int data){
        node = DeleteNodeRecursive(node,data);
    }
    static public CreateNode DeleteNodeRecursive(CreateNode node, int data){
        if (node == null){
            return null;
        }
        if (data < node.data){
            node.left = DeleteNodeRecursive(node.left, data);
        }
        else if (data > node.data) {
            node.right =  DeleteNodeRecursive(node.right, data);
        }
        if (data == node.data ){
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null){
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
                node.data = FindTheSmallestNode(node.right);
                node.right = DeleteNodeRecursive(node.right, data);
        }

        return node;
    }
    public void DepthFirstSearch(CreateNode node) {
        if (node != null) {
            DepthFirstSearch(node.left);
            System.out.print(" " + node.data);
            DepthFirstSearch(node.right);
        }
    }

    public void BreadthFirstSearch() {
        if (node == null) {
            return;
        }

        Queue<CreateNode> nodeList = new LinkedList<>();
        nodeList.add(node);

        while (nodeList.isEmpty() == false) {

            CreateNode node = nodeList.remove();

            System.out.print(" " + node.data);

            if (node.left != null) {
                nodeList.add(node.left);
            }

            if (node.right != null) {
                nodeList.add(node.right);
            }
        }
    }


    public static void main(String[] args) {

    }

}


