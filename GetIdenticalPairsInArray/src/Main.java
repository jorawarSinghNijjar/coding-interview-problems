import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int sum = 0;

        for(int num : nums){
            int pairCount = map.getOrDefault(num,0);
            sum+=pairCount;
            map.put(num,pairCount+1);
        }

        return sum;
    }

}