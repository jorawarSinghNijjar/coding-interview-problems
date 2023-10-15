public class Main {
    public static void main(String[] args) {
        System.out.println(getNumberOfPairs(3));
    }

    private static int getNumberOfPairs(int rep) {
       int sum = 0;
        if(rep <= 1) return 0;
        for(int i = 1; i < rep; i++){
            sum += i;
        }
        return sum;
    }
}