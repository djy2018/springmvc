package com.wisely.highlight_springmvc4.math.test1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dujiayong
 * @date 2018/10/18
 **/
public class Test1 {

    private static class Node implements Comparable<Node> {
        private int val;
        private int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    public static int[] twoSum(int[] source, int target) {
        int[] result = {0, 0};
        Node[] nodes = new Node[source.length];
        for (int i = 0; i < source.length; i++) {
            Node node = new Node(source[i], i);
            nodes[i] = node;
        }
        Arrays.sort(nodes);
        int lo = 0;
        int hi = nodes.length - 1;
        while (lo < hi) {
            if (nodes[lo].val + nodes[hi].val == target) {
                if (nodes[lo].index < nodes[hi].index) {
                    result[0] = nodes[lo].index + 1;
                    result[1] = nodes[hi].index + 1;
                } else {
                    result[0] = nodes[hi].index + 1;
                    result[1] = nodes[lo].index + 1;
                }
                break;
            } else if (nodes[lo].val + nodes[hi].val > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] source = {7, 11, 2, 15};
        int[] result = twoSum(source, 9);
        System.out.println(result.toString());
    }

}
