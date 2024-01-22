//-----github.com/ankit7hub-----
import java.util.Scanner;

interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static PerformOperation isOdd() {
        return new PerformOperation() {
            @Override
            public boolean check(int a) {
                return a % 2 != 0;
            }
        };
    }

    public static PerformOperation isPrime() {
        return new PerformOperation() {
            @Override
            public boolean check(int a) {
                if (a < 2) return false;
                for (int i = 2; i <= Math.sqrt(a); i++)
                    if (a % i == 0) return false;
                return true;
            }
        };
    }

    public static PerformOperation isPalindrome() {
        return new PerformOperation() {
            @Override
            public boolean check(int a) {
                String str = Integer.toString(a);
                String reverse = new StringBuilder(str).reverse().toString();
                return str.equals(reverse);
            }
        };
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        PerformOperation op;
        while (T-- > 0) {
            int condition = scanner.nextInt();
            int num = scanner.nextInt();
            switch (condition) {
                case 1:
                    op = MyMath.isOdd();
                    System.out.println(op.check(num) ? "ODD" : "EVEN");
                    break;
                case 2:
                    op = MyMath.isPrime();
                    System.out.println(op.check(num) ? "PRIME" : "COMPOSITE");
                    break;
                case 3:
                    op = MyMath.isPalindrome();
                    System.out.println(op.check(num) ? "PALINDROME" : "NOT PALINDROME");
                    break;
                default:
                    System.out.println("Invalid condition");
            }
        }
        scanner.close();
    }
}
