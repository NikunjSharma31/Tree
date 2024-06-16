import java.util.*;
public class Main
{
    static class Node{
        int data ;
        Node left; 
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class BinaryTree{
        static int index = -1;
        public static Node buildTree(int nodes[]){
            index++;
            if(nodes[index] == -1){
                return null;
            }
            Node newNode =new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            
            return newNode;
        }
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    public static void BFS(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode ==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }
    public static int CountOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int left =  CountOfNodes(root.left);
        int right = CountOfNodes(root.right);
        return left + right +1;
    }
    public static int SumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int left =  SumOfNodes(root.left);
        int right = SumOfNodes(root.right);
        return left + right + root.data;
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        int max = Math.max(left, right)+1;
        return max;
    }
	public static void main(String[] args) {
	    int nodes[] = {1 , 2 , 4 , -1 , -1 , 5 , -1 , -1 , 3 , -1 , 6 , -1 , -1 };
	    BinaryTree obj = new BinaryTree();
	    Node root = obj.buildTree(nodes);
	   // System.out.println(root.data);
	   //System.out.println("PreOrder Traversal : ");
	   //preOrder(root);
	   //System.out.println();
	   //System.out.println("inOrder traversal : ");
	   //inOrder(root);
	   // System.out.println();
	   //System.out.println("PostOrder Traversal : ");
	   //postOrder(root);
	   //System.out.println("BFS Traversal : ");
	   //BFS(root);
	   
	   //System.out.println(CountOfNodes(root));
	   //System.out.println("Sum of nodes : ");
	   //System.out.println(SumOfNodes(root));
	   
	   System.out.println(height(root));
	}
}
