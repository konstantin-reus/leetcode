import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {8,7,4,3}, 11));
        System.out.println(combinationSum(new int[] {2,3,6,7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            return result;
        }
        findSums(result, new ArrayList<Integer>(), candidates, target, 0, 0);
        return result;
    }

    private static void findSums(List<List<Integer>> result, List<Integer> curPath, int[] candidates, int target, int curSum, int curIndex) {
        if (curIndex > candidates.length - 1) {
            return;
        }
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            result.add(curPath);
            return;
        }
        int curCandidate = candidates[curIndex];
        // if add cur element
        List<Integer> probablePath2 = new ArrayList<>(curPath);
        probablePath2.add(curCandidate);
        findSums(result, probablePath2, candidates, target, curSum + curCandidate, curIndex);

        //if skip cur element
        List<Integer> probablePath1 = new ArrayList<>(curPath);
        findSums(result, probablePath1, candidates, target, curSum, curIndex + 1);
    }

}
