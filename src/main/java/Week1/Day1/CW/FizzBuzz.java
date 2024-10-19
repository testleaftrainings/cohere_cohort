package Week1.Day1.CW;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    @Test
    public void test1()  {
        int n = 1;
        List<String> res = fizzBuzz(n);
        System.out.println(res);
    }

    @Test
    public void test2() {
        int n =5;
        List<String> res = fizzBuzz(n);
        System.out.println(res);
    }

    @Test
    public void test3() {
        int n = 15;
        List<String> res = fizzBuzz(n);
        System.out.println(res);
    }

    public static List<String> fizzBuzz(int n){
        List<String> result = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                result.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                result.add("Fizz");
            }
            else if (i % 5 == 0) {
                result.add("Buzz");
            }
            else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

}
