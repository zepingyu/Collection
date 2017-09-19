package List;
import org.omg.CORBA.Object;

import java.util.*;
public class Arraylist {

    public static void main(String[] args) {
        ArrayList ai = new ArrayList();
        for(int i = 1; i <= 10; i++) {
            ai.add(i);
        }
        System.out.print(ai.get(1) + " ");
        ai.remove(1);
        Integer[] a = {};
        Integer[] a1 = (Integer[]) ai.toArray(a);
        System.out.println(a1.length + " " + ai.get(1) + " " + a1[1]);

        ArrayList as = new ArrayList();
        for(int i = 1; i <= 10; i++) {
            as.add("s" + i);
        }
        System.out.print(as.get(1) + " ");
        as.remove("s2");
        String[] s = {};
        String[] s1 = (String[])as.toArray(s);
        System.out.println(s1.length + " " + as.get(1) + " " + s1[1]);

        ArrayList asi = new ArrayList();
        asi.add("asi1");
        asi.add(1);
        asi.add(2);
        asi.add("asi2");

        //Object[] o = {};
        //Object[] o1 = (Object[])asi.toArray();
        //System.out.println(o1.length + " " + asi.get(1) + " " + o1[1]);
        //Scanner ss = new Scanner(System.in);
        //ss.hasNextInt();
    }
}
