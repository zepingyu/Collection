package LRU;

import java.util.Scanner;

public class LRUTest {
    public static void main(String[] args) {
        LRULinkedHashMap lruLinkedHashMap = new LRULinkedHashMap(3);

        while(true){
            Scanner sc = new Scanner(System.in);
            String key = sc.nextLine();
            String value = sc.nextLine();
            lruLinkedHashMap.put(key,value);

            System.out.println(lruLinkedHashMap.toString());
        }
    }
}
