package leetcode;

import java.util.*;

/**
 * Created by lsy on 2016/4/15.  pro:3sum
 */
public class Sum15 {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<List<Integer>>();
//        int len = nums.length;
//        if (len < 3) {
//            return lists;
//        }
//        Arrays.sort(nums);
//        int minx = nums[0];
//        int miny = nums[1];
//        int minz = nums[2];
//        Map<List<Integer>,Integer> map = new HashMap<List<Integer>, Integer>();
//        for (int x = 0; x < len - 2; x++) {
//            if(x==minx){
//                continue;
//            }
//            x=minx;
//            for (int y = x + 1; y < len - 1; y++) {
//                if(y==miny){
//                    continue;
//                }
//                x=minx
//                for (int z = y + 1; z < len; z++) {
//                    if(x==minx){
//                        continue;
//                    }
//                    y=miny
//                    if (nums[x] + nums[y] + nums[z] == 0) {
//                        List<Integer> list = new ArrayList<Integer>();
//                        list.add(nums[x]);
//                        list.add(nums[y]);
//                        list.add(nums[z]);
//                        map.put(list,1);
//                    }
//                }
//            }
//        }
//        Iterator iterator = map.keySet().iterator();
//        while (iterator.hasNext()) {
//            lists.add((List<Integer>)iterator.next());
//        }
//        return lists;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len < 3) {
            return lists;
        }
        Arrays.sort(nums);

        int minx = nums[0];
        int miny = nums[1];
        int minz = nums[2];
        Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
        for (int x = 0; x < len - 2; x++) {
            if (nums[x] >=0) {
                break;
            }
            for (int y = x + 1; y < len - 1; y++) {
                for (int z = y + 1; z < len; z++) {
                    if(nums[z] <=0){
                        break;
                    }
                    if (nums[x] + nums[y] + nums[z] == 0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[x]);
                        list.add(nums[y]);
                        list.add(nums[z]);
                        map.put(list, 1);
                    }
                }
            }
        }
        if(nums[0]+nums[1]+nums[2]==0){
            List<Integer> list = new ArrayList<Integer>();
            list.add(0);
            list.add(0);
            list.add(0);
            map.put(list,1);
        }
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            lists.add((List<Integer>) iterator.next());
        }
        return lists;
    }

    public static void main(String[] args) {
        Sum15 s = new Sum15();
        int[] nums = new int[]{7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6
        };
        int[] nums2 = new int[]{-2, 0, 1, 1, 2};
        int[] nums3 = new int[]{13, -5, 3, 3, -1, 13, 3, 1, -9, -4, 9, 12, 6, -9, -6, -12, -8, 3, 12, 14, 4, -15, 2, -11, 4, -12, 10, 9, -6, -3, -8, 14, 7, 3, 2, -8, -7, -10, 8, -8, -7, -6, -11, 6, -7, -2, 9, -8, 8, -2, 13, -10, -2, 0, -14, -13, -4, 11, 3, -3, -7, 3, -4, 8, 13, 13, -15, -9, 10, 0, -2, -12, 1, 2, 9, 1, 8, -4, 8, -7, 9, 7, -2, -15, 14, 0, -13, -13, -12, -2, -1, -11, 8, 10, 12, 6, 8, 4, 12, 3, 11, -12, -2, -3, 5, -15, 6, -10, -4, -1, -1, -10, 13};
        int[] nums4 = new int[]{0, 0, 0};
        List list = s.threeSum(nums4);
        System.out.println(list);
    }
}
