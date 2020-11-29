import java.util.*;

public class BSTNorecursion<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST
    int size = 0;
    int nodeCount ;

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;            // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
            left = null;
            right = null;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BSTNorecursion() {
        root = null;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size()==0)
        {
            return true;
        }
        return false;       
    }

    //to return number of key-value pairs in symbol table
    public int size() {
        return size;      
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if(x == null) return 0;
        else return x.size;       
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        Node x = root;
        if (key == null)
        {
            throw new IllegalArgumentException("Argument to get value() is null");
        }
        
        while(x.key != key)
        {
            int temp = key.compareTo(x.key);
            if (temp < 0)
            {
                x = x.left;
            }
            else if (temp > 0)
            {
                x = x.right;
            }
            if (x.key == key)
            {
                return x.val;
            }
        }
        return x.val;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    
    public void put(Key key, Value val) {
       if(key == null)
       {
            throw new IllegalArgumentException("Argument to get value() is null");
       }
       else 
       {
            Node newest = new Node(key,val,1);
            if(root == null)
            {
                root = newest;
            }
            else
            {
                Node x = root;
                Node parent;
                while(x!=null)
                {
                    parent = x;
                    int temp = key.compareTo(x.key);
                    if(temp < 0)
                    {
                        x = x.left;
                        if(x == null)
                        {
                            parent.left = newest;
                            size = size + 1;
                            return;
                        }
                        else if(x.key == key)
                        {
                            x.val = val;
                            return;
                        }
                    }
                    else if(temp > 0)
                    {
                        x = x.right;
                        if(x == null)
                        {
                            parent.right = newest;
                            size = size + 1;
                            return;
                        }
                        else if(x.key == key)
                        {
                            x.val = val;
                            return;
                        }
                    }
                    else if(temp > 0)
                    {
                        x = x.right;
                        if(x == null)
                        {
                            parent.right = newest;
                            size = size + 1;
                            return;
                        }
                    }
                }
            }
            size = size + 1;
       }  
    }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        Node x = root;
       if(isEmpty())
       {
            throw new NoSuchElementException("No such elemenys in the table");
       }
       else
       {
            while(x.left != null)
            {
                x = x.left;
            }
            return x.key;
       }
    } 

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        Node x = getFloor(root, key);
        Node temp = x;
        if(key == null)
        {
            throw new IllegalArgumentException("key is Null");
        }
        else if (size() == 0)
        {
            throw new NoSuchElementException("No such key");
        }
        if(x == null)
        {
            return null;
        }
        if(x.left != null)
        {
            temp = x.left;

            while(temp.right !=null)
            {
                temp = temp.right;
            }
        }
        return temp.key;
    } 

    public Node getFloor(Node x, Key key)
    {
        Node node = null;
        if(key == null)
        {
            throw new IllegalArgumentException("Key is Null");
        }
        while(x != null)
        {
            int temp = key.compareTo(x.key);
            if(temp == 0)
            {
                return x;
            }
            if(temp > 0)
            {
                node = x;
                x = x.right;
            }
            else 
            {
                x = x.left;
            }
        }
        return node;
    }

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        nodeCount = 0;
        if((k<0) || k>=size())
        {
            throw new IllegalArgumentException("Rank should be between 0 and its szie");
        }
        return select(root, k+1).key;
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = root;
        while(!stack.empty() || cur != null)
        {
            if(cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            else
            {
                cur = stack.pop();
                nodeCount++;
                if(nodeCount == k)
                    break;
                cur = cur.right; 
            }
        }
        return cur;
    } 

    

    // /**
    //  * Returns all keys in the symbol table in the given range,
    //  * as an {@code Iterable}.
    //  *
    //  * @param  lo minimum endpoint
    //  * @param  hi maximum endpoint
    //  * @return all keys in the symbol table between {@code lo} 
    //  *         (inclusive) and {@code hi} (inclusive)
    //  * @throws IllegalArgumentException if either {@code lo} or {@code hi}
    //  *         is {@code null}
    //  */
    public Iterable<Key> keys(Key lo, Key hi) {
        if(lo == null || hi == null)
        {
            throw new IllegalArgumentException("Argument is null");
        }
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    private void keys(Node x,Queue<Key> queue, Key lo, Key hi) { 
        if(x == null)
        {
            return;
        }
        Node node1 = x;
        while(node1 != null)
        {
            int temp = node1.key.compareTo(hi);
            int emp = node1.key.compareTo(lo);

            if(node1.left == null)
            {
                if (temp <= 0 && emp >= 0) queue.offer(node1.key);
                node1 = node1.right;
            }
            else
            {
                Node node2 = node1.left;
                while(node2.right != null && node2.right != node1)
                {
                    node2 = node2.right;
                }
                if(node2.right == null)
                {
                    node2.right = node1;
                    node1 = node1.left;
                }
                else
                {
                    node2.right = null;
                    if(temp <= 0 && emp >= 0) queue.offer(node1.key);
                    node1 = node1.right;
                }
            }
        }
    } 
}