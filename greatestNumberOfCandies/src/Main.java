import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> list = kidsWithCandies(candies,extraCandies);
        String listString = list.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(list);
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // find the greatest number of candies
        int max = Integer.MIN_VALUE;
        for(int i=0; i < candies.length; i++){
            if(candies[i] > max) {
                max = candies[i];
            }
        }

        // add extra candies and compare with all kid's candies
        List<Boolean> result = new ArrayList<>();
        for(int i = 0; i < candies.length; i++){
            candies[i] += extraCandies;

            if(candies[i] >= max){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }

        return result;
    }
}