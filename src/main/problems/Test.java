package main.problems;

import java.util.*;

public class Test {
    public static void main(String args[] ) throws Exception {
        takeInput();
    }

    private static void takeInput() {
        Scanner sc = new Scanner(System.in);

        int totalCases = sc.nextInt();

        for (int i = 0; i < totalCases; i++) {
            long startNumber = sc.nextInt();
            long endNumber = sc.nextInt();

            long minMentorId = (long) Math.floor(Math.sqrt(startNumber));
            long maxMentorId = (long) Math.ceil(Math.sqrt(endNumber));

            Set<Long> employeesWithMentors = new HashSet();

            calculateNumberOfEmployeesInGivenRange(startNumber, endNumber, minMentorId, maxMentorId, employeesWithMentors);
        }

        sc.close();
    }

    private static void calculateNumberOfEmployeesInGivenRange(long startNumber, long endNumber, long minMentorId, long maxMentorId, Set<Long> employeesWithMentors) {

        for (long mentorId = minMentorId; mentorId <= maxMentorId; mentorId++) {

            long currMentorMin = (long) Math.pow(mentorId, 2);
            long currMentorMax = (long) Math.pow(mentorId+1, 2);

            long rem = currMentorMin % mentorId;

            long startEmpId = rem == 0 ? currMentorMin : (currMentorMin+rem);

            long whileBreakNumber = endNumber < currMentorMax ? endNumber : currMentorMax;
            while (startEmpId < whileBreakNumber) {
                employeesWithMentors.add(startEmpId);

                startEmpId += mentorId;
            }

        }

        System.out.println(employeesWithMentors.size());
    }
}

