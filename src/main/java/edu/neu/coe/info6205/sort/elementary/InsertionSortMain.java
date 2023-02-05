package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.sort.par.Main;
import edu.neu.coe.info6205.util.Stopwatch;
import edu.neu.coe.info6205.util.Timer;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import java.util.Arrays;
import java.util.zip.InflaterInputStream;

public class InsertionSortMain {
    public static void main(String[] args) {

        runsorts("warmup");
        runsorts("Random array runtime at ");
        runsorts("Sorted array runtime at ");
        runsorts("Reversed array runtime at ");
        runsorts("Partially sorted array runtime at ");
    }

    private static void runsorts(String typeofarrayString) {

        int INITIAL_LENGTH = 200;
        Integer[][] tests = initializearrays(typeofarrayString);
        //run
        Double runtime = 0.0;
        Timer timer = new Timer();
        for (int j = 0; j < tests.length; j++){
            for (int i = 0; i < 5; i ++){
//                sorter.sort(tests[j], 0, tests[j].length - 1);
                int index = j;
                Integer[][] finalTests = initializearrays(typeofarrayString);
                runtime = timer.repeat((int)(20 * Math.pow(2,j)), () -> finalTests[index], x -> new InsertionSort<Integer>().sort(x));
                System.out.println(typeofarrayString + INITIAL_LENGTH * Math.pow(2,i) + "on test[" + index + "]. Running" + " times is: " + runtime);
            }
        }
        timer.stop();
    }

    private static Integer[][] initializearrays(String typeofarrayString) {
        //initialize
        int INITIAL_LENGTH = 200;
        Integer[][] tests = new Integer[5][];
        for (int i=0;i<tests.length; i++){
            tests[i] = new Integer[(int)(INITIAL_LENGTH * Math.pow(2,i))];
        }
        //System.out.println(tests[1].length);
        for (int j = 0; j < tests.length; j ++ ) {
            for (int i = 0; i < INITIAL_LENGTH * Math.pow(2,j); i++) {
                tests[j][i] = (int) (Math.random() * 1000 * Math.pow(2, j));
            }
        }

        if (typeofarrayString == "Reversed array runtime at "){
            for (int i = 0; i < tests.length; i ++){
                Arrays.sort(tests[i]);
            }
            for (int i = 0; i<tests.length; i ++){
                int left = 0;
                int right = tests[i].length - 1;
                int t = 0;
                while (left < right){
                    t = tests[i][left];
                    tests[i][left] = tests[i][right];
                    tests[i][right] = t;
                    left ++;
                    right --;
                }
            }
        }
        if (typeofarrayString == "Sorted array runtime at "){
            for (int i = 0; i < tests.length; i ++){
                Arrays.sort(tests[i]);
            }
        }
        if (typeofarrayString == "Partially sorted array runtime at "){
            for (int i = 0; i<tests.length; i ++){
                for (int j = 0; j <tests[i].length / 2; j ++){
                    tests[i][j] = (int)(Math.random() * 1000 * Math.pow(2, i));
                }
            }
        }
        return tests;
    }

}

