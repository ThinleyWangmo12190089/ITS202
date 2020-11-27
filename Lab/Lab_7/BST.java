import java.util.*;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

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
    public BST() {
    	root = null;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size() == 0)
        {
            return true;
        }
        return false;
       
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) 
    { 
        if(x == null) {
        	return 0;
        }
        else
        {
        	return x.size;
        }
    }   

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    // public boolean contains(Key key) {
       
    // }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
    	if(key == null) throw new IllegalArgumentException("Called get() with null key");
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if(x == null) 
        {
        	return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0) 
        {
        	return get(x.left, key);
        }
        else if(cmp > 0) 
        {
        	return get(x.right, key);
        }
        else{
        	return x.val;
        }
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
    	if(key == null) throw new IllegalArgumentException("calls put() with a null key");
        root = put(root, key, val);  
    }

    private Node put(Node x, Key key, Value val) {
        if(x == null) 
        {
        	return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0) 
        {
        	x.left = put(x.left, key, val);
        }
        else if(cmp > 0) 
        {
        	x.right = put(x.right, key, val);
        }
        else{
            x.val = val;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() 
    {
    	if(isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    } 

    private Node min(Node x) 
    { 
        if(x.left == null)
        {
        	return x;
        }
        else 
        {
        	return min(x.left);    
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
    	if(key == null) throw new IllegalArgumentException("argument to floor() is null");
    	if(isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
        Node x = floor(root, key);
        if(x == null) throw new NoSuchElementException("argument floor() is too small");
        return x.key;
    } 

    private Node floor(Node x, Key key) 
    {
        if(x == null) 
        {
        	return null;
        }

        int cmp = key.compareTo(x.key);
        if(cmp == 0) 
        {
        	return x;
        }

        if(cmp < 0) 
        {
        	return floor(x.left, key);
        }

        Node t = floor(x.right, key);
        if(t != null)
        { 
        	return t;
        }
        else 
        {
        	return x;
        }
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
        if(k < 0 || k >= size())
        {
        	throw new IllegalArgumentException("argument to select() is invalid");
        }
        else
        {
        	return select(root, k);
        }
    }

    // Return key of rank k. 
    private Key select(Node x, int k) { 
    	if(x == null){
    		return null;
    	}
    	int l = size(x.left);
    	if(l > k){
    		return select(x.left, k);
    	}
    	else if(l < k){
    		return select(x.right, k - 1 -1);
    	}
    	else {
    		return x.key;
    	}
    } 

    

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) 
    {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");
        Queue<Key> queue = new LinkedList<> ();
        keys(root, queue, lo, hi);
        return queue; 
    } 

    private void keys(Node x,Queue<Key> queue, Key lo, Key hi) 
    { 
       if(x == null) return;

       int cmplo = lo.compareTo(x.key);
       int cmphi = hi.compareTo(x.key);

       if(cmplo < 0) 
       {
			keys(x.left, queue, lo, hi);
       }

       if(cmplo <= 0 && cmphi >= 0) 
       {
       		queue.add(x.key);
       }
       
       if(cmphi > 0) 
       {
       		keys(x.right, queue, lo, hi); 
       }
    }

     public void deleteMin() {
        
        root = deleteMin(root);
        
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(Key key) {
        root = delete(root, key);
        
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 


   
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  
    public static void main(String[] args) { 
        BST<Integer, String> obj = new BST<>();  
        obj.put(1,"a");
        obj.put(2,"b"); 
        obj.put(3,"c");  
        obj.put(4,"d"); 
        obj.put(5,"e"); 
        obj.put(6,"f"); 

        System.out.println(obj.isEmpty());
        System.out.println(obj.size());
        System.out.println(obj.get(4));
        System.out.println(obj.min());
        System.out.println(obj.floor(5));
        System.out.println(obj.keys(2,6));

  //       assert(obj.isEmpty() == false);
		// assert(obj.size() == 6);
		// assert(obj.min() == 1);
		// assert(obj.floor(7) == 6);
		// assert(obj.floor(3) == 3);
		// assert(obj.select(3) == 4);
		// assert(obj.get(2) == "b");

		// System.out.println(obj.keys(1, 4));

		// System.out.println("All Test Cases Passed!");

    }
}