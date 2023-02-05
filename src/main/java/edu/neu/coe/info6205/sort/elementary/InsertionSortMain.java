package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.sort.par.Main;
import edu.neu.coe.info6205.util.Stopwatch;
import edu.neu.coe.info6205.util.Timer;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import java.util.Arrays;

public class InsertionSortMain {
    public static void main(String[] args) {
        //initialize
        Integer[][] tests = new Integer[5][];
        for (int i=0;i<tests.length; i++){
            tests[i] = new Integer[(int)(50 * Math.pow(2,i))];
        }
        System.out.println(tests[1].length);
        for (int j = 0; j < tests.length; j ++ ) {
            for (int i = 0; i < 50 * Math.pow(2,j); i++) {
                tests[j][i] = (int) (Math.random() * 1000 * Math.pow(2, j));
            }
        }
//        System.out.println(Arrays.toString(tests[1]));
        InsertionSort<Integer> sorter = new InsertionSort<Integer>();
        Timer timer = new Timer();
        timer.repeat(10, () -> tests[0], x -> sorter.sort(x));
        Double runtime = 0.0;
//        Timer[] timers = new Timer[20];
//        for(int i = 0; i <20; i++){
//            timers[i] = new Timer();
//        }
//        for (int j = 0;j<tests.length; j ++){
//            for (int i = 0; i < 5; i ++){
//                int index = j;
//                runtime = timer.repeat((int)(100* (Math.pow(2,i))), () -> tests[index], x -> sorter.sort(x));
//                System.out.println("Random array runtime at " + 50 * Math.pow(2,i) + " times is: " + runtime);
//            }
//        }Stopwatch stopwatch = new Stopwatch();
        for (int j = 0; j < tests.length; j++){
            for (int i = 0; i < 5; i ++){
//                sorter.sort(tests[j], 0, tests[j].length - 1);
                int index = j;
                runtime = timer.repeat(10, () -> tests[index], x -> new InsertionSort<Integer>().sort(x));
                System.out.println("Random array runtime at " + 50 * Math.pow(2,i) + "on test[" + index + "]. Running" + " times is: " + runtime);
            }
        }
        
    }
}
