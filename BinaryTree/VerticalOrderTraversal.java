package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    class Pair{
        int hd;
        Node node;

        public Pair(int hd, Node node){
            this.hd = hd;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, root));

        while(!queue.isEmpty()){
            Pair current = queue.poll();

            // add node to treemap
            if(map.containsKey(current.hd)){
                List<Integer> temp = map.get(current.hd);
                temp.add(current.node.data);
                map.put(current.hd, temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(current.node.data);
                map.put(current.hd, temp);
            }
            
            if(current.node.left != null)
                queue.add(new Pair(current.hd - 1, current.node.left));
            if(current.node.right != null)
                queue.add(new Pair(current.hd + 1, current.node.right));

        }

        result.addAll(map.values());

        return result;
    }

    class Tuple{
        int hd;     // col
        int level;  // row
        Node node;

        public Tuple(int hd, int level, Node node){
            this.hd = hd;
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraverse(Node root){
        if(root == null){
            return null;
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Deque<Tuple> queue = new ArrayDeque<>();
        queue.add(new Tuple(0, 0, root));

        while(!queue.isEmpty()){
            Tuple current = queue.poll();

            // if map doesn't contains a value(TreeMap) for the key(hd) :
            // create a new TreeMap as the value
            if(!map.containsKey(current.hd))
                map.put(current.hd, new TreeMap<>());
            
            // if map doesn't contains a value(PriorityQueue) for the key(hd) :
            // create a new PriorityQueue as the value
            if(!map.get(current.hd).containsKey(current.level))
                map.get(current.hd).put(current.level, new PriorityQueue<>());

            /* 
             * map.get(current.hd) :  TreeMap at (hd)
             *    .get(current.level) : PriorityQueue at (level)
             *    .add(current.node.data) : add data to the PriorityQueue(minHeap)
             */
            map.get(current.hd).get(current.level).add(current.node.data);

            if(current.node.left != null)
                queue.add(new Tuple(current.hd - 1, current.level + 1, current.node.left));
            if(current.node.right != null)
                queue.add(new Tuple(current.hd + 1, current.level + 1, current.node.right));
        }

        List<List<Integer>> result = new ArrayList<>();
        // for each value in the TreeMap 'map' as 'imap'
        for(TreeMap<Integer, PriorityQueue<Integer>> imap : map.values()){
            // 1. add an ArrayList (at the end : 
            //    to be accessed with the index(size - 1))
            result.add(new ArrayList<>());

            // 2. get the PriorityQueue from the 'imap' as 'pq'
            for(PriorityQueue<Integer> pq : imap.values()){

                // 2.a add every value in pq to the arrayList at index(size - 1) of result
                while(!pq.isEmpty()){
                    /*
                     * result.get(result.size() - 1) : ArrayList at index(size - 1)
                     *       .add(pq.poll()) : add the smallest element
                     */
                    result.get(result.size() - 1).add(pq.poll());
                }
            }
        }

        return result;
    }

/* Most Efficient Solution */
// class TreeNode{
//     int val;
//     TreeNode node;
// }

// //实现Comparable interface ，这个也很重要，背下来。
// class Pair1 implements Comparable<Pair>{
//     int col;
//     int depth;
//     int val;
//     Pair1(int col,int depth,int val) {
//         this.col = col;
//         this.depth = depth;
//         this.val = val;
//     }
//     //要实现Comparable interface，必须实现这个方法。
//     public int compareTo(Pair o) {
//         if(this.col!=o.col)
//             return this.col-o.col;
//         else if(this.depth!=o.depth)
//             return this.depth-o.depth;
//         return this.val-o.val;
//     }
// }


// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         //这个pq自动应用上面的compareto方法吗
//         PriorityQueue<Pair> pq = new PriorityQueue<>();
        
//         fill(root,pq,0,0);
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> loc = new ArrayList<>();
//         Pair first = pq.poll();
//         loc.add(first.val);
//         int lvl = first.col;
//         while(!pq.isEmpty()) {
//             Pair pop = pq.poll();
//             if(lvl!=pop.col) {
//                 ans.add(loc);
//                 loc = new ArrayList<>();
//             }
//             loc.add(pop.val);
//             lvl = pop.col;
//         }
//         ans.add(loc);
//         return ans;
//     }
//     public void fill(TreeNode root,PriorityQueue<Pair> pq,int depth,int col) {
//         if(root==null)
//             return;
//         fill(root.left,pq,depth+1,col-1);
//         fill(root.right,pq,depth,col+1);
//         Pair pair = new Pair(col,depth,root.val);
//         pq.add(pair);
//     }
// }


}
