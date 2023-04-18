import java.util.HashMap;
import java.util.Map;

public class Random {
    public static void loopMapClassic() {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("D", 40);
        map.put("E", 50);
        map.put("F", 60);

        for (Map.Entry<String, Integer> mp : map.entrySet()) {
            System.out.println(" KEy " + mp.getKey() + " value " + mp.getValue());
        }


    }
    public static void loopMapJava8() {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("C", 300);//no duplicates
        map.put(null, 40);
        map.put(null, 410);//cant have multiple null value
        map.put("E", null);// no order
        map.put("F", 60);
        map.forEach((k,v)->{
            System.out.println(" KEy " + k + " value " +v);
        });

//        map.forEach((k,v)->{
//            if(k!=null)
//            System.out.println(" KEy " + k + " value " +v);
//        });
    }
    public static void main(String arg[]) {

//        loopMapClassic();
        loopMapJava8();
    }
}
