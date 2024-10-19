package Week1.Day1.HW;

public class PrimeOrNot {
    public static void main(String[] args) {
        int n = 2;
        if (isPrime(n)){
            System.out.println("Prime Number");
        }else {
            System.out.println("Not a prime Number");
        }
    }
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        else if (n==2) {
            return true;
        }
        else if(n % 2 == 0 || n % 3 == 0){
            return false;
        }
        for(int i = 5; i * i <= n; i+=6){
            if(n % i == 0 || n % i+2 == 0){
                return false;
            }
        }
        return true;
    }
}
