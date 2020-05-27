import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ABeforeB {
/*
check if a string has all a's before b's.
 */

    public static boolean check(String s){
        var stack = new LinkedList<Character>();
        if(s.length()==0) return true;
        if(s.length()==1) return true;

        boolean flipped = false; //we can only have one legal transition in the array
        for(int left = 0,right = 1; right < s.length(); right++){
            var leftValue = Character.valueOf(s.charAt(left));
            var rightValue = Character.valueOf(s.charAt(right));

            if(leftValue==rightValue) left = right++;
            if(leftValue!=rightValue) {
                if(flipped)
                    return false;
                else{
                    flipped = true;
                }
                left=right;
            }
        }
        return true;
    }
    public static boolean check2(String s) {
        var lastA = s.indexOf("a");//O(n)
        var firstB = s.indexOf("b");//O(n)
        if (lastA==-1||firstB==-1) return true;
        if (lastA > firstB ){
            return false;
        } else {
            return true;
        }
    }

    public static boolean check3(String s) {
        var as = new HashSet<Integer>();
        var bs = new HashSet<Integer>();

        IntStream.rangeClosed(0,s.length()-1).forEach(
                index -> {
                    if(s.charAt(index) == 'a') as.add(index);
                    else bs.add(index);
                }
        );

        for ( var ai = as.iterator(); ai.hasNext() ;){
            int a = ai.next();
            for ( var bi = bs.iterator(); bi.hasNext();){
                int b = bi.next();
                if(a>b) return false;
            }
        }
        return true;
    }

    public static boolean check4(String s) {

        AtomicInteger mostRecentB = new AtomicInteger();
        AtomicInteger mostRecentA = new AtomicInteger();
        long validCount = IntStream.rangeClosed(0,s.length()-1)
                .takeWhile(
                    index -> {
                        if(s.charAt(index) == 'b') mostRecentB.set(index);
                        if(s.charAt(index) == 'a') mostRecentA.set(index);
                        if( mostRecentA.get() > mostRecentB.get()) return false;
                        else return true;
                    }
                ).count();
        if(validCount < s.length()) return false;
        else return true;
    }

    public static  boolean sorted1(String[] input) {
        Comparator<String> orderNumberSort = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                Pattern pattern = Pattern.compile("");
                Stream s1groups = pattern.matcher(s1).results();
                Stream s2groups = pattern.matcher(s1).results();

                return s1.compareTo(s2);
            }
        };

        Iterator<String> iterator = Stream.of(input).iterator();
            if(!iterator.hasNext()) return true; //empty
            if(input.length == 1)  return true; //only 1 element, sorted by definition

        String previous = iterator.next();
        String current = iterator.next();
        while (iterator.hasNext()){
            if(orderNumberSort.compare(current,previous)>0){
                return false;
            }
            previous = current;
        }
        return true;
    }
}