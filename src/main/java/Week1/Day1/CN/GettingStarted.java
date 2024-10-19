package Week1.Day1.CN;

public class GettingStarted {

      public static void main(String[] args) {
            System.out.println("Welcome to TestLeaf");
            int rollno = 1001;
            System.out.println(rollno);
            short age = 25;
            System.out.println(age);
            long mobile = 9989898869l;
            System.out.println(mobile);
            char initial = 'A';
            System.out.println(initial);
            boolean maritalStatus = true;
            System.out.println(maritalStatus);
            float weight = 65.5f;
            System.out.println(weight);
            double height = 175.0;
            System.out.println(height);
            String name = "Haja";
            System.out.println(name);

            if(age >= 18) {
                System.out.println("Eligible to vote");
            } else if(age < 0) {
                System.out.println("Not a valid age");
            } else {
                System.out.println("Not eligible to vote");
            }


            for (int i = 1; i <= 10; i++) {
                if (i==5){
                    continue;
                }
                System.out.println(i);
            }
//
//		int i = 1;
//		while (i<=10) {
//			System.out.println(i);
//			i++;
//		}
        }
    }


