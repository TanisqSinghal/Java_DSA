import java.util.HashMap;

class FindItenereyFromTickets {

    public static String getStart(HashMap<String, String> map) {
        HashMap<String, String> revMap = new HashMap<>();

        for(String city : map.keySet()) {
            revMap.put(map.get(city), city);
        }

        for(String city : map.keySet()) {
            if(!revMap.containsKey(city)) {
                return city;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chennai", "Bengluru");
        map.put("Mumbai", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");

        String start = getStart(map);
        System.out.print(start);
        for(String city : map.keySet()) {
            System.out.print(" -> "+map.get(start));
            start = map.get(start);
        }
    }
}