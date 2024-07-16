import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {
        String temp = "hit";

        String s = temp .substring(0, 0) + "" + ('0' + 1) + temp.substring(1);
        int i = 1;

        var num = wrap(temp);

         System.out.println(num);
    }

    private static List<String> wrap(String node) {
        List<String> res = new ArrayList<>();
        char[] temp = node.toCharArray();
        for(int i = 0; i < temp.length; i++) {
            for(int j = 0; j < 26; j++) {
                temp[i] = (char) ('a' + j);
                res.add(new String(temp));
            }

        }
        return res;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] degree = new int[n];

        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                map.get(graph[i][j]).add(i);
                degree[i]++;
            }
        }

        Set<Integer> res = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            if(degree[i] == 0) {
                deque.add(i);
                res.add(i);
            }
        }


        while(!deque.isEmpty()) {
            int node = deque.remove();
            List<Integer> temp = map.get(node);
            res.add(node);

            for(int num : temp) {
                degree[num]--;
                if(degree[num] == 0) deque.add(num);
            }
        }

        List<Integer> result = new ArrayList<>(res);
        Collections.sort(result);
        return result;
    }
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length - k;
        while (start < end) {
            int mid = (start + end) / 2;
            int l = x - arr[mid];
            int r = arr[mid + k] - x;
            if (l > r) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int i = start; i < start + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    private static TreeNode buildTree(Integer[] nums, int index) {
        if (index >= nums.length || nums[index] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums, 2 * index + 1);
        root.right = buildTree(nums, 2 * index + 2);

        return root;
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }
        TreeNode(int x) {
            val = x;
        }
    }


    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            next = next;
        }
    }
}
