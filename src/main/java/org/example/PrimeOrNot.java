package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PrimeOrNot {
    public static void main(String[] args) {

        int n = 24;
        boolean isPrime = true;
        if(n<=1){
            isPrime = false;
        } else if (n==2) {
            isPrime = true;
        }else if (n%2==0){
            isPrime = false;
        }else {
            for (int i = 3; i <= Math.sqrt(n); i+=2){
                if(n%i==0){
                    isPrime = false;
                    break;
                }
        }

        }
        if(isPrime){
            System.out.println("n is prime");
        }else{
            System.out.println("n is not prime");
        }

    }
    }
