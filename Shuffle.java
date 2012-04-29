/* Shuffle
 * July 10, 2002
 * Cheng Leong
 *
 * As part of a prescreen for Seilevel employment.
 * 1) In either C++, Java or C# implement an algorithm that starts
 * with the the letters of the alphabet in order and shuffles them so
 * that they are in random order.
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Randomly shuffles the letters of the alphabet and prints them out.
 **/
public class Shuffle {

    /** Initial order of the alphabet **/
    protected static String initialAlphabet = "abcdefghijklmnopqrstuvwxyz";

    /** 
     * Command line interface to print the shuffled alphabet to stdout.
     * All command line arguments are ignored.
     *
     * @param args command line arguments.
     **/
    public static void main(String[] args) {

        // initialize random number generator
        // use a SecureRandom implementation if stronger randomness desired
        Random randomizer = new Random();

        LinkedList ll = new LinkedList();
        int lpos = 0;
        // insert each letter of the alphabet into a random position
        // in the linked list
        for (int apos=0; apos<initialAlphabet.length(); apos++) {
            ll.add(lpos, new Character(initialAlphabet.charAt(apos)));
            // insert next one anywhere from before first to after last
            lpos = randomizer.nextInt(ll.size()+1);
        }

        // print the (shuffled) list to stdout
        for (Iterator it=ll.iterator(); it.hasNext(); ) {
            System.out.print( it.next().toString() );
        }
        
        System.out.println();
    } // main
    
} // Shuffle    
