/* TelephoneWord
 * July 10, 2002
 * Cheng Leong
 *
 * As part of a prescreen for Seilevel employment.
 *
 * 2) In either C++, Java or C#, implement an algorithm to print out
 * all of the 7 letter combinations of a phone number. For example,
 * 555-3232 can be represented as JKKEBFC. Treat 1 and 0 as spaces.
 */

import java.util.HashMap;

/**
 * Calculates letter combinations of a phone number
 **/
public class TelephoneWord {

    /** Character (digit) to String (letter) mapping **/
    protected static HashMap letterMap = null;

    /**
     * Creates and populates letterMap with Digit to Letter mappings.
     **/
    protected static void initLetterMap() {
        letterMap = new HashMap(10);
        letterMap.put(new Character('0'), " ");
        letterMap.put(new Character('1'), " ");
        letterMap.put(new Character('2'), "ABC");
        letterMap.put(new Character('3'), "DEF");
        letterMap.put(new Character('4'), "GHI");
        letterMap.put(new Character('5'), "JKL");
        letterMap.put(new Character('6'), "MNO");
        letterMap.put(new Character('7'), "PRS");
        letterMap.put(new Character('8'), "TUV");
        letterMap.put(new Character('9'), "WXZ");
    }

    /** 
     * Command line interface to read in a phone number and return all
     * possible permutations of "words".  The first command line
     * argument is used as the phone number.
     *
     * @param args command line arguments.
     **/
    public static void main(String[] args) {
        // Check args for usage
        if (args.length < 1) {
            System.out.println("usage: TelephoneWord telephonenumber");
            System.out.println("Prints all alphabetic permutations of the giventelephone-style number");
            return;
        }

        // use first argument as telephone number
        String telephone = args[0];
        
        // recursively print permutations of the given number
        permuteTelephone(null, telephone);

    } // main

    /**
     * Recursively takes a prefix string and a string to expand.  If
     * no more characters remain, the prefix is printed to stdout,
     * otherwise the expansions are appended to the prefix and the new
     * remainder is processed.
     *
     * @param prefix A prefix to put before the expansion of the
     * given number
     * @param remainder A String that requires expansion
     **/
    protected static void permuteTelephone(String prefix, String remainder) {
        // if there is nothing to expand then print the results
        if (((null == remainder) || (remainder.length()<1))
            && (null!=prefix)) {
            System.out.println(prefix);
            return;
        }
        
        // initialize digit to letter mapping if necessary
        if (null==letterMap) { initLetterMap(); }

        // find all expansions for the current digit
        Character currentDigit = new Character(remainder.charAt(0));
        remainder = remainder.substring(1);
        String expansions = (String)(letterMap.get(currentDigit));
        if (null==expansions) {
            // skip this 'digit'
            permuteTelephone(prefix, remainder);
            return;
        }
        String expansion = null;
        // recurse for each expansion
        for (int i=0; i<expansions.length(); i++) {
            expansion = expansions.substring(i, i+1); // one character
            if (null==prefix) {
                permuteTelephone(expansion, remainder);  
            } else {
                permuteTelephone(prefix + expansion, remainder);
            }
        } // next expansion
    } // permuteTelephone
    
} // TelephoneWord
