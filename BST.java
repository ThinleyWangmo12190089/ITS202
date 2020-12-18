import java.util.*;
public class BST <Key extends Comparable<Key>, Value>{
	private Node root;             
    private class Node {
       private Key key;           
       private Value val;        
       private Node left, right;  
       private int size;            

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
            left = null;
            right = null;
        }
    }
		public BST() {
			root = null;
		}
		//to return the size 
		public int size(){
			return size(root);
		}
		//to return the size of node x
		private int size(Node x){
			if(x==null){
				return 0;
			}
			else{
				return x.size;
			}
		}
		public boolean isEmpty(){
			if(size()==0){
				return true;
			}
			return false;
		}
		public void put(Key key, Value val) {
	    	if(key == null) {
	    		System.out.println("The key cannnot be null");
	    		//throw new IllegalArgumentException("calls put() with a null key");
	    	}
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
	public Key min() 
    {
    	if(isEmpty()) {
    		System.out.println("Cannot be empty");
    	}        
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

    public static void main(String[] args) {
		BST<String, Integer> obj = new BST<>();

		obj.put("Ada",1);
		obj.put("Ballerina",3);
		System.out.println(obj.get("Ada"));
		obj.put("HTML",5);
		obj.put("Java",7);
		System.out.println(obj.get("Java"));
		System.out.println(obj.size());
		System.out.println(obj.min());
		System.out.println(obj.floor("Ballerina"));
		//System.out.println(obj.select(3));
		System.out.println(obj.keys("Ada","Java"));
		obj.put("Java",8);
		obj.put("Dart",9);
		System.out.println(obj.get("Java"));
		System.out.println(obj.size());
		//System.out.println(obj.deleteMin());
		System.out.println(obj.keys("Ballerina","Java"));
		//System.out.println(obj.delete("Java"));
	}	
}
	
