import java.util.Comparator;

/**
 * Created by Samson on 06-11-2016.
 *
 *  This class stores int values in a binary search tree.
 2  Duplicates are allowed. Each node of the tree has the binary
 3  search tree property.
 */
public class SearchTree<E extends Comparable<E>> {

    private TreeNode<E> overAllRoot;

    // post: constructs an empty tree
    public SearchTree(){
        overAllRoot = null;
    }

    public TreeNode<E> getOverAllRoot() {
        return overAllRoot;
    }

    // post: value is added to overall tree so as to preserve the
    //      binary search tree property
    public void add(E value){
        overAllRoot = add(overAllRoot, value);
    }

    // post: value is added to overall tree so as to preserve the
    //      binary search tree property
    private TreeNode<E> add(TreeNode<E> root, E value){
        if(root == null){
            root = new TreeNode(value);
        } else {
            int compare = ((Comparable<E>) value).compareTo(root.data);
            if (compare <= 0){
                root.left = add(root.left, value);
            } else {
                root.right = add(root.right, value);
            }
        }

        return root;
    }

    // post: returns true if overall tree contains value
    public boolean contains(E value){
        return contains(overAllRoot, value);
    }

    // post: returns true if overall tree contains value
    private boolean contains(TreeNode<E> root, E value){
        if(root == null){
            return false;
        } else{
            int compare = value.compareTo(root.data);
            if( compare == 0){
                return true;
            } else if(compare < 0){
                return contains(root.left, value);
            } else {
                return contains(root.right, value);
            }
        }
    }


    // post: prints the tree contents using an inorder traversal
    public void print(){
        printInorder(overAllRoot);
        System.out.println();
    }
    // post: prints the tree contents using a preorder traversal
    public void printPreorder(){
        System.out.print("preorder:");
        printPreorder(overAllRoot);
        System.out.println();
    }

    // post: prints in preorder the tree with given root
    private void printPreorder(TreeNode<E> root){
        if(root != null){
            System.out.println(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using an inorder traversal
    public void printInorder(){
        System.out.println("inorder:");
        printInorder(overAllRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(TreeNode<E> root){
        if(root != null){
            printInorder(root.left);
            System.out.println(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder(){
        System.out.println("postorder:");
        printPostorder(overAllRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(TreeNode<E> root){
        if(root != null){
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.println(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    // inorder traversal and using indentation to indicate
    // node depth; prints right to left so that it looks
    // correct when the output is rotated.
    public void printSideways(){
        printSideways(overAllRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    // root, indenting each line to the given level
    private void printSideways(TreeNode<E> root, int level){
        if(root != null ){
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++){
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }

    public int countLeaves(){
        return countLeaves(overAllRoot);
    }

    private int countLeaves(TreeNode root){
        if(root == null){
            return 0;
        } else if(root.left == null && root.right == null){
            return 1;
        } else {
            return countLeaves(root.left) + countLeaves(root.right);
        }
    }

    public int sum(){
        return sum(overAllRoot);
    }

    private int sum(TreeNode root){
        try {
            if(root == null){
                return 0;
            } else {
                return (int) root.data + sum(root.left) + sum(root.right);
            }
        } catch (ClassCastException e){
            System.out.print("Can only find sum of numbers: ");
            return 0;
        }
    }

    public int countLeftNodes(){
        return countLeftNodes(overAllRoot);
    }

    private int countLeftNodes(TreeNode root){
        int count = 0;
        if (root.left != null){
            count += 1 + countLeftNodes(root.left);
        }
        if(root.right != null){
            count += countLeftNodes(root.right);
        }
        return count;
    }

}
