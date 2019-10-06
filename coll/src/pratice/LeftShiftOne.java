package pratice;

import java.util.Scanner;


public class LeftShiftOne {

    //左移字符串里的所有1
    public static void leftShiftOneString(){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] text = input.toCharArray();

        int before = 0;
        int after = text.length - 1;

        while(before < after){
            while(text[before] == '1'){
                before++;
            }
            while(text[after] == '0'){
                after--;
            }
            if(text[before] == '0' && before < after){
                char middle = text[before];
                text[before] = text[after];
                text[after] = middle;
                before++;
                after--;
            }
        }
        System.out.println(text);
    }

    public static void main(String[] args) {
        while(true){
            leftShiftOneString();
        }
    }
}
