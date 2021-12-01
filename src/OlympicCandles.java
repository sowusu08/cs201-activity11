import java.util.*;

public class OlympicCandles{

    public int getSum(PriorityQueue<Integer> candles){
        int sum = 0;
        for(int i=0; i<candles.size(); i++){
            sum+=candles.remove();
        }
        return sum;
    }

    public /*int*/ static void numberOfNights(int[] candles){
        // greedy alg
        // light n candles of maximum height each day

        // create copy of "candles" list and put in priority queue in reverse order (pass the queue a new comparator)
        // so that the elements that are removed first are the largest
        PriorityQueue<Integer> heights = new PriorityQueue<>(Collections.reverseOrder());      // creates a priority queue

        for(int i : candles){
            heights.add(i);
        }

        int days = 0;
        // create ArrayList today
        ArrayList<Integer> burned = new ArrayList<>();

        // while number of days is less than or equal to the number of available candles
        while(days <= heights.size()){
            int numCandles = 0;
            int current = 0;
            while(numCandles <= days){
                // take the max candle - 1
                current = heights.remove();
                System.out.println("current candle: "+current);
                numCandles++;
                System.out.println("number of candles burning: "+numCandles);
                // if candle > 0 add to today
                if(current - 1 > 0){burned.add(current - 1);}
                System.out.println("Candles after burning today: "+burned);
                System.out.println("Days passed "+(days+1));
            }


            // if today.size() != 0
            if(burned.size() != 0) {
                // add all candles from today to heights
                heights.addAll(burned);
                // reset today
                burned = new ArrayList<>();

                System.out.println("Remaining candles: "+heights);
            }
            if(){
                // add one to "days"
                days++;
            }
            // add one to "days"
            //days++;
        }

        System.out.println(days);
        //return days;
        /*for(int night=1; night <= candles.length; night++){

        }*/
    }

    public static void main(String[] args) {
        int[] test = {3};
        numberOfNights(test);
    }
}