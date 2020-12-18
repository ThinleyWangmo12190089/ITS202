import java.util.*;
public class BST<Key extends Comparable<Key>, Value>{
	private Node root;

	private class Node{
		Key key;
		Value val;
		Node left,right;
		int size;

		public Node(Key key, Value val, int size){
			this.key = key;
			this.val = val;
			this.size = size;
 		}
	}

	public BST(){
		root = null;
	}

	public int size(){
		return size(root);
	}

	private int size(Node x){
		if(x==null) return 0;
		return x.size;
	}

	public void put(Key key, Value val){
		Node temp = new Node(key, val, 1);
		if(key == null) throw new IllegalArgumentException("first argumemt to put is null");
		if(root == null){
			root = temp;
			return;
		}
		if(check(root, key, val)==true) return;

		Node x = root,y=null;
		while(x!=null){
			int com = key.compareTo(x.key);
			x.size++;
			y = x;
			if(com<0) x = x.left;
			else x = x.right; 
		}
		int com = key.compareTo(y.key);
		if(com<0) y.left = temp;
		else y.right = temp;
		y.size = 1+size(y.left)+size(y.right); 
	}

	private boolean check(Node x, Key key, Value val){
		while(x!=null){
			int com = key.compareTo(x.key);
			if(com<0) x = x.left;
			else if(com>0) x = x.right;
			else{
				x.key = key;
				x.val = val;
				return true;
			}
		}
		return false;
	}

	public Value get(Key key){
		if(key == null) throw new IllegalArgumentException("first argiment to get is null");
		if(size() == 0) throw new NoSuchElementException("get() with empty symbol table");
		Node temp = get(root, key);
		if(temp == null) return null;
		return temp.val;
	}

	private Node get(Node x, Key key){
		while(x!=null){
			int com = key.compareTo(x.key);
			if(com<0) x = x.left;
			else if(com>0) x = x.right;
			else return x; 
		}

		return null;
	}

	public Key min(){
		Node temp = min(root);
		if(temp==null) return null;
		return min(root).key;
	}

	private Node min(Node x){
		Node y = x;
		if(x == null) return null;
		while(x!=null){
			y = x;
			x = x.left;
		}
		return y;
	}

	public Key floor(Key key){
		if(key == null) throw new IllegalArgumentException("argiment to floor is null");
		Node temp = floor(root, key);
		if(temp == null) return null;
		return floor(root, key).key;
	}

	public Node floor(Node x, Key key){
		Node temp = min(root),y=null;
		while(x!=null){
			int com = key.compareTo(x.key);
			if(com<0) x=x.left;
			else if(com>0){
				int cop = x.key.compareTo(temp.key);
				if(cop>0){
					temp = x;
					y = temp;
				}
				x = x.right; 
			}
			else return x;
		}

		return y;
	}

	public Key select(int rank){
		if(rank>=size(root) || rank<0) throw new IllegalArgumentException("argiment to select is not match");
		Node temp = select(root, rank);
		if(temp == null) return null;
		return select(root, rank).key;
	}

	private Node select(Node x, int rank){
		Node z=null;
		int size;
		while(x!=null){
			size = size(x.left);
			if(size>rank) x = x.left;
			else if(size<rank){
				rank = rank-size-1;
				x = x.right;
			}
			else return x;
		}
		return z;
	}

	public Iterable<Key> key(Key key1, Key key2){
		ArrayList queue = new ArrayList();
		key(queue,root,key1,key2);
		return queue;
	}

	private void key(ArrayList queue, Node x, Key key1, Key key2){

		if(x==null) return;
		int com = key1.compareTo(x.key);
		int cmp = key2.compareTo(x.key); 
		if(com<0) key(queue,x.left,key1,key2);
		if(com <= 0 && cmp >=0) queue.add(x.key);
		if(cmp>0) key(queue,x.right,key1,key2);
		
	}

	public void deleteMin() {
        if (size()==0) throw new NoSuchElementException("empty symbol table");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

	public void delete(Key key){
		if(key == null) throw new IllegalArgumentException("arrgument is null");
		root = delete(root, key);
	}

	private Node delete(Node x, Key key){
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


	public static void main(String[] args) {
		BST<String, Integer> obj = new BST<>();

		obj.put("Ada",1);
		obj.put("Ballerina",3);
		System.out.println(obj.get("Ada"));
		obj.put("Html",5);
		obj.put("Java",7);
		System.out.println(obj.get("Java"));
		System.out.println(obj.size());
		System.out.println(obj.min());
		System.out.println(obj.floor("Ballerina"));
		System.out.println(obj.select(3));
		System.out.println(obj.key("Ada","Java"));
		obj.put("Java",8);
		obj.put("Dart",9);
		System.out.println(obj.get("Java"));
		System.out.println(obj.size());
		obj.deleteMin();
		System.out.println(obj.key("Ballerina","Java"));
		obj.delete("Java");
	}
}
