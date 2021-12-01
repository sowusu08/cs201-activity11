import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FriendScore {
    public /*static void*/ int highestScore(String[] friends) {
        // make a list of each person's friends
        // for each numbered friend store count = length of the list
        // search every other list for that number
        // if a list contains that number count+=length-1

        //              .  .  .

        // make a hashmap where key is number and value is ArrayList of that number's friends
        HashMap<Integer, ArrayList<Integer>>friendsMap = new HashMap<>();

        // loop through array of friend values
        // for each person (where one person's profile is a row)
        for(int row=0; row<friends.length; row++){
            //split row into arrayList of Strings
            ArrayList<String> this_row = new ArrayList<>(Arrays.asList(friends[row].split("")));
            //System.out.println(this_row);
            ArrayList<Integer> this_friends = new ArrayList<>();
            // if the row contains "Y"s get the index of the first instance of a Y and store in "this_friends"
            // then replace element at that index (the "Y") with "N"
            int this_index = 0;
            if(this_row.contains("Y")){
                //System.out.println(this_row);
                this_index = this_row.indexOf("Y");
                //System.out.println(this_index);
                this_friends.add(this_index);
                this_row.set(this_index, "N");
                //System.out.println(this_row);
            }
            // while there are still "Y"s repeat this process
            while(this_row.contains("Y")){
                this_index = this_row.indexOf("Y");
                //System.out.println(this_index);
                this_friends.add(this_index);
                this_row.set(this_index, "N");
            }
            // then store this_friends in map where key is row
            friendsMap.put(row, this_friends);
        }

        // now that map is created...
        // create count array (filled with zeros) with a length equal to the number of rows in friends
        int[] counts = new int[friends.length];

        // loop through each element in map
        // where each element is a person's profile
        HashSet<Integer> totalFriends = new HashSet<>();
        for(Integer key1 : friendsMap.keySet()){
            //System.out.println("Person: "+key1+" Friends: "+friendsMap.get(key1));
            // add to the person's totalFriends set their immediate friends
            // the length of their immediate friends list in friendsMap
            totalFriends.addAll(friendsMap.get(key1));
            //count+=friendsMap.get(key1).size();
            //System.out.println(count);

            // then loop through the other keys in friendsMap.keySet
            for(Integer key2 : friendsMap.keySet()){
                // if any other friends list contains key 1
                if(friendsMap.get(key2).contains(key1)){
                    // get the elements in this list
                    // this will include the person whose friends we're finding (aka key1)
                    ArrayList<Integer> newFriends = friendsMap.get(key2);
                    // add these to "totalFriends" set (only adds unique friends)
                    totalFriends.addAll(newFriends);
                    //newFriends.removeAll(friendsMap.get(key1));
                    // and add the length of this minus one to count
                    //count += newFriends.size() - 1;
                }
            }

            // add size of totalFriends - 1 (excluding the person themselves) to array list
            //if(count != 0){counts[key1] = count;}
            // then reset count
            if(totalFriends.size() != 0){
                counts[key1] = totalFriends.size() - 1;
            // the reset total friends
                totalFriends = new HashSet<>();
            }
        }

        // sort count array list by increasing size of number (last element is largest)
        Arrays.sort(counts);
        // return last number of Array (largest number)
        return counts[counts.length-1];
        //System.out.println("Counts: "+Arrays.toString(counts));        // last number should be answer
        //System.out.println("Counts: "+counts[counts.length-1]);
    }

    /*public static void main(String[] args) {
        String[] test ={"NNNNNNNNNNNNNNY",
                "NNNNNNNNNNNNNNN",
                "NNNNNNNYNNNNNNN",
                "NNNNNNNYNNNNNNY",
                "NNNNNNNNNNNNNNY",
                "NNNNNNNNYNNNNNN",
                "NNNNNNNNNNNNNNN",
                "NNYYNNNNNNNNNNN",
                "NNNNNYNNNNNYNNN",
                "NNNNNNNNNNNNNNY",
                "NNNNNNNNNNNNNNN",
                "NNNNNNNNYNNNNNN",
                "NNNNNNNNNNNNNNN",
                "NNNNNNNNNNNNNNN",
                "YNNYYNNNNYNNNNN"};
        highestScore(test);
    }*/
}