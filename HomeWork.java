import java.util.*;

public class HomeWork {
    public static void main(String[] args) {

//        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
//        reverseString2(new char[]{'h', 'e', 'l', 'l', 'o'});

        String s = "[[{(())}]]";
        //s = "()[]{}";
        //s = "([)]";
        //s = "))";

        System.out.println(s + ":" + isValid2(s));


        System.exit(0);

        Scanner input = new Scanner(System.in);
        System.out.println("Введите крайнюю границу для вывода чисел: ");
        var toNumber = input.nextInt();

        System.out.print(0 + " ");
        for (int i = 1; i <= toNumber; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("fizzbuzz ");
            } else if (i % 3 == 0) {
                System.out.print("fizz ");
            } else if (i % 5 == 0) {
                System.out.print("buzz ");
            } else
                System.out.print(i + " ");
        }
    }

    public static void reverseString(char[] s) {
        char[] reverseS = s;
        for (int i = s.length - 1; i >= 0; i--) {
            System.out.print("\"" + s[i] + "\"");
            if (i != 0)
                System.out.print(",");

        }
    }

    //  reverseString3(new char[]{'h', 'e', 'l', 'l', 'o'});
    public static void reverseString2(char[] s) {
        System.out.println(s);
        for (int i = 0; i < s.length / 2; i++) {
            char ch = s[s.length - i - 1];
            s[s.length - i - 1] = s[i];
            s[i] = ch;
        }
        System.out.println(s);
    }

    public static boolean isValid(String s) {
        System.out.println(s);
        s = s.replaceAll("[^(){}\\[\\]]+", "");
        System.out.println(s);
        if (s.length() % 2 != 0)
            return false;

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            if ((ch == '}') || (ch == ')') || (ch == ']')) {
                stack.push(ch);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            if ((ch == '{') || (ch == '(') || (ch == '[')) {

                var stackChar = stack.pop();
                System.out.println("ch: " + ch);
                System.out.println("stackChar: " + stackChar);

                if ((ch == '{') && !(stackChar == '}'))
                    return false;
                else if ((ch == '(') && !(stackChar == ')'))
                    return false;
                else if ((ch == '[') && !(stackChar == ']'))
                    return false;
            }
        }

        return true;
    }

    public static boolean isValid2(String s) {
        System.out.println(s);
        s = s.replaceAll("[^(){}\\[\\]]+", "");
        System.out.println(s);
        if (s.length() % 2 != 0)
            return false;

        Deque<Character> stack = new LinkedList<>();
        var ch = ' ';
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if ((ch == '{') || (ch == '(') || (ch == '[')) {
                stack.push(ch);
            }
            if (stack.isEmpty()) return false;
            if ((ch == '}') || (ch == ')') || (ch == ']')) {
                var stackChar = stack.pop();
                System.out.println("ch: " + ch);
                System.out.println("stackChar: " + stackChar);

                if ((ch == '}') && !(stackChar == '{'))
                    return false;
                else if ((ch == ')') && !(stackChar == '('))
                    return false;
                else if ((ch == ']') && !(stackChar == '['))
                    return false;

            }
        }
        return stack.isEmpty();
    }


}