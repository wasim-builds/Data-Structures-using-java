import java.util.HashMap;
public class HashMaping {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap();
        map.put("wasim",1);
        map.put("venu",2);
        map.put("vallika",3);
        System.out.println(map);
        System.out.println(map.get("venu"));
        if(map.containsKey("venu")){
            System.out.println("venu is there in map");
        }else{
            System.out.println("venu is not there in map");
        }
        System.out.println(map.remove("venu"));
        System.out.println(map);
        
    }
}
  