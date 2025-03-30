package ArrayAndString;


import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(2);
        // 将ans转为int数组, 不用stream
        int[] arr = ans.stream().mapToInt(Integer::intValue).toArray();
    }
}


