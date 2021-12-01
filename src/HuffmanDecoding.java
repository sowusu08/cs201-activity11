import java.util.ArrayList;
import java.util.Arrays;

public class HuffmanDecoding {

    // create TreeNode class
    /*
    public class TreeNode {
        int info;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            info = x;
        }
        TreeNode(int x, TreeNode lNode, TreeNode rNode){
            info = x;
            left = lNode;
            right = rNode;
        }
    }
    */

    public String decode(String archive, String[] dictionary) {
        // create letters array
        String[] alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        // create a tree with the letters stored in leaves
        // create root of empty tree

        // loop through dictionary
        /*for(String path : dictionary){
            // recursively add letter as leaf given each path
            add()
        }*/

        String ret="";

        // create String arrayList of dictionary
        ArrayList<String> dictList = new ArrayList(Arrays.asList(dictionary));

        // or init string path
        String path = "";
        // loop through each character in archive
        for(int i = 0; i < archive.length(); i++) {
            // append first char from archive
            path+= Character.toString(archive.charAt(i));
            // check if dictList contains the string
            int index = dictList.indexOf(path);

            // if index == -1 (dictList doesn't contain the path) continue appending
            if(index==-1){continue;}
            // otherwise add String from "alph" at that index to "ret"
            // and set path to ""
            else{
            ret+=alph[index];
            path="";
            }
        }

        // return ret;
        return ret;
    }
}