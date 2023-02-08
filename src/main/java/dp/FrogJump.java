package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
 *
 *
 *
 * Example 1:
 *
 * Input: stones = [0,1,3,5,6,8,12,17]
 * Output: true
 * Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
 */
public class FrogJump {

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));


        FrogJump frogJump = new FrogJump();
        System.out.println(frogJump.canCross2(stones));
    }

    public static boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> stonesMap = new HashMap<>();

        for (int j : stones) {
            stonesMap.put(j, new HashSet<>());
        }
        stonesMap.get(0).add(0);

        int lastStone = stones[stones.length - 1];
        for (int stone : stones) {
            for (int prevJump : stonesMap.get(stone)) {
                for (int k = prevJump - 1; k <= prevJump + 1; k++) {
                    if (k <= 0) {
                        continue;
                    }

                    int nextPosition = stone + k;
                    if (lastStone == nextPosition) {
                        return true;
                    } else if (stonesMap.containsKey(nextPosition)) {
                        stonesMap.get(nextPosition).add(k);
                    }
                }
            }

        }

        return false;
    }


    Map<Integer, Set<Integer>> stonesMap = new HashMap<>();
    public boolean canCross2(int[] stones) {
        for (int j : stones) {
            stonesMap.put(j, new HashSet<>());
        }
        return isAchievable(0, 0, stones);
    }

    boolean isDone = false;
    boolean isAchievable(int lastJumpLength, int lastIndex, int[] stones) {
//        if(isDone) {
//            return true;
//        }
        int lastIndexK = lastJumpLength;
        int lastIndexKPlus1 = lastJumpLength + 1;
        int lastIndexKMinus1 = lastJumpLength - 1;

        boolean a = processJump(stones, lastIndex, lastIndexK);
        boolean b = processJump(stones, lastIndex, lastIndexKPlus1);
        boolean c = processJump(stones, lastIndex, lastIndexKMinus1);

        return a || b || c;
    }

    boolean processJump(int[] stones, int currIndex, int jumpLength) {
        if(isStonePresent(stones, currIndex, jumpLength)) {
            if(currIndex + jumpLength == stones[stones.length - 1]) {
                isDone = true;
                return true;
            }

            //System.out.println("going for next index = " + (currIndex + jumpLength));
            return isAchievable(jumpLength, currIndex + jumpLength, stones);
        }

        return false;
    }

    boolean isStonePresent(int[] stones, int currIndex, int jumpLength) {
        int findIndex = currIndex + jumpLength;

        if(findIndex > stones[stones.length-1] || jumpLength == 0) {
            return false;
        }

        //System.out.println("find index = " + findIndex);
        //System.out.println("current index = " + currIndex);

        return stonesMap.containsKey(findIndex);
    }
}
