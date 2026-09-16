package oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeqentialAndParallelStream {
    public static void main(String[] args){
        int size = 10000000;
        List<Integer> nums = new ArrayList<>(size);

        Random ran = new Random();

        for(int i=1;i<=size;i++){
            nums.add(ran.nextInt(100));
        }
        // apply sleep in map() method to see differences with small sized array
        long startseq = System.currentTimeMillis();
        int sum1 = nums.stream()
                .map(i->i*2)
                .mapToInt(i->i)
                .sum();
        long endseq = System.currentTimeMillis();


        long startpar = System.currentTimeMillis();
        int sum2 = nums.parallelStream()
                .map(i->i*2)
                .mapToInt(i->i)
                .sum();
        long endpar = System.currentTimeMillis();

        System.out.println("Sequential: "+ sum1);
        System.out.println("Parallel: "+ sum2);
        System.out.println("Sequential: "+ (endseq-startseq));
        System.out.println("Parallel: "+ (endpar-startpar));

    }
}
