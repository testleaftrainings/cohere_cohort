package Week1.Day2.CN;

public class LearnMethods {
    // Access Modifier, return type, name of the method

    /*
     * Access Modifiers:
     * public, private, protected, default
     *
     * Return type:
     * void, int, float, boolean, char
     *
     *
     */

    public void learnMethod(String name, int age) {
        System.out.println(name);
        System.out.println(age);

    }

    public int addNumbers(int num1, int num2) {
        int output = num1+num2;
        return output;
    }

    public static void main(String[] args) {
        LearnMethods lm = new LearnMethods();
        int output = lm.addNumbers(5, 6);
        System.out.println(output);
    }


}
