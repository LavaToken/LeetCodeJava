import java.util.List;
import java.util.ArrayList;

public class findMinDifference {
    public static void main(String[] args){
        ArrayList<String> test = new ArrayList<>();
        test.add("12:00");
        test.add("1:00");
        System.out.println(min(test));
    }

    public static int min(List<String> timePoints) {
        int firstTime = Integer.valueOf(timePoints.get(0));
        return firstTime;
    }
}
