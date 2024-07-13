package main.problems.heycoach.assignments;

public class P2387_RestaurantTrip {
    /**
     * QUESTION
     *
     * Restaurant Trip
     * A group of friends decide that they want to make frequent visits to a newly opened restaurant which is owned by one of their other friend to popularize the restaurant.
     *
     * The group plans to visit it in groups of at least two people on a given day. Given the number of friends ‘n’ and the amount of money that i th friend has y[i] and the amount of food that i th friend would eat x[i], you have to make groups in a way that the bill calculated is in their budget. Find out the maximum amount of consecutive days these friends could go to the restaurant given that no person can go more than once.
     *
     * Example:
     * Consider a scenario where n=6, x = [8,3,9,2,4,5] and y = [5,3,1,4,5,10]. Now let us look at all the ways they can visit the restaurant.
     * On the first day first and sixth friend can visit (A group of at least 2) together they eat 8+5=13 amount of food. The budget for them is 5+10 = 15 (15<13).
     * Now on the second day (Note that first and sixth friend can no longer visit the restaurant now) 2nd 4th and 5th friend can visit the restaurant and together they will eat, 3+2+4=10 and their budget is 3+4+5=12 (12>10). They can go to the restaurant for a maximum of two days and thus the answer should be two.
     * Input Format:
     * A single line which contains the number of friends ‘n’.
     *
     * Second line contains ‘n’ space separated integers containing the amount of food that each friend would eat.
     *
     * Third line contains ‘n’ space separated integers containing the amount of money that each friend can spend.
     *
     * Output Format:
     * Print a single integer denoting the number of days they will visit the restaurant.
     * Sample Inputs:
     * 6
     *
     * 1 4 1 2 4 2
     *
     * 1 3 3 2 3 4
     *
     * 4
     *
     * 1 2 3 4
     *
     * 1 1 2 2
     * Sample Outputs:
     * 3 (for 1st testcase)
     *
     * 0 (for 2nd testcase)
     * Constraints:
     * 2<=n<=10^5
     */
}
