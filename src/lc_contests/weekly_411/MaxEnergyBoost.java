package lc_contests.weekly_411;

import java.util.Arrays;

class MaxEnergyBoostSolution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        long[] dp = new long[energyDrinkA.length];
        Arrays.fill(dp, -1);

        long fromDrinkA = dp(0, true, true, dp, energyDrinkA, energyDrinkB);
        Arrays.fill(dp, -1);


        long fromDrinkB = dp(0, true, false, dp, energyDrinkA, energyDrinkB);
        return Math.max(fromDrinkA, fromDrinkB);
    }

    /**
     * canDrink = used to handle canDrink thing.
     */
    public long dp(int index, boolean canDrink, boolean drinkFromA, long[] dp, int[] energyDrinkA, int[] energyDrinkB) {
        if (index > energyDrinkA.length) {
            return 0;
        }

        if (index == energyDrinkA.length) {
            if (drinkFromA) {
                return energyDrinkA[index - 1];
            } else {
                return energyDrinkB[index - 1];
            }
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        long stayEnergy = -1;
        long switchEnergy = -1;
        if (canDrink) {

            // stay
            if (drinkFromA) {
                stayEnergy = energyDrinkA[index] + dp(index + 1, true, true, dp, energyDrinkA, energyDrinkB);
            } else {
                stayEnergy = energyDrinkB[index] + dp(index + 1, true, false, dp, energyDrinkA, energyDrinkB);
            }

            // swtich
            if (drinkFromA) {
                switchEnergy = energyDrinkA[index] + dp(index, false, false, dp, energyDrinkA, energyDrinkB);
            } else {
                switchEnergy = energyDrinkB[index] + dp(index, false, true, dp, energyDrinkA, energyDrinkB);
            }

        }

        if (!canDrink) {
            if (drinkFromA) {
                stayEnergy = dp(index + 1, true, true, dp, energyDrinkA, energyDrinkA);
            } else {
                stayEnergy = dp(index + 1, true, false, dp, energyDrinkA, energyDrinkB);
            }
        }

        dp[index] = Math.max(stayEnergy, switchEnergy);
        return dp[index];
    }


}


public class MaxEnergyBoost {
    public static void main(String[] args) {
        MaxEnergyBoostSolution solution = new MaxEnergyBoostSolution();
        int[] AUt1 = {4, 1, 1};
        int[] BUT1 = {1, 1, 3};

        System.out.println(solution.maxEnergyBoost(AUt1, BUT1));

    }
}
