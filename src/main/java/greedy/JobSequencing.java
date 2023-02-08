package greedy;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collections;

/**
 *  Out of 5 jobs a typist has to select 3 such that the profit is maximized
 *  Condition is: the Job and Profit are having a deadline i.e. either they can be delayed till the
 *  deadline hours. Each job requires 1 unit time to complete
 *
*  Jobs        J1      J2      J3      J4       J5
 *  Profit      20      15      10      5       1
 *  deadlines   2       2       1       3       3
 *
 *  Ans:    J2, J1, J4 = 40
 */
public class JobSequencing {
    @AllArgsConstructor
    static class Job {
        String job;
        int profit;
        int deadline;
    }
    public static void main(String[] args) {
        Job j4 = new Job("J4", 5, 3);
        Job j2 = new Job("J2", 15, 2);
        Job j1 = new Job("J1", 20, 6);
        Job j5 = new Job("J5", 1, 3);
        Job j3 = new Job("J3", 10, 1);

        Job[] jobs = {j4, j2, j1, j5, j3};
        jobSequencing(jobs, 5);
    }

    static void jobSequencing(Job[] jobs, int slots) {
        Arrays.sort(jobs, (a,b) -> b.profit - a.profit);

        Job[] availableSlot = new Job[slots];

        for (Job value : jobs) {
            for (int j = Math.min(slots - 1, value.deadline - 1); j >= 0; j--) {
                if (availableSlot[j] == null) {
                    availableSlot[j] = value;
                    break;
                }
            }
        }
        int sum = 0;
        for(Job job: availableSlot) {
            if(job != null) {
                sum += job.profit;
            }
        }

        System.out.println("Total profit = " + sum);
        System.out.println("Jobs = ");
        Arrays.stream(availableSlot).forEach(a -> {if(a != null)System.out.print(a.job + "->");});
    }
}
