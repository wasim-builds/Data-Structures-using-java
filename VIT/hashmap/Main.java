import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("wasim",1);
        map.put("lokesh",2);
        map.put("mahesh",3);
        System.out.println(map);
        // if(map.containsKey("wasim")){
        //     System.out.println("contains");
        // }
        // System.out.println(map.get("wasim"));

        for(Map.Entry<String,Integer> e:map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        Set<String> keys = map.keySet();
        for(String key: keys){
            System.out.println(keys+" ");
        }

        // key exist
        // key not exsit null
        // if key contains then return true
        // or false
    }
}