

class MapUsingHash {
    final private Entity[] entities;

    public MapUsingHash(){
        entities = new Entity[100];
    }

    public void put(String key, String value){
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key, value); // overriding
    }

    public String get(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if (entities[hash] != null && entities[hash].key.equals(key)) {
            return entities[hash].value;
        }
        return null;
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if (entities[hash] != null && entities[hash].key.equals(key) ) {
            entities[hash] = null;
        }
    }

    private class Entity {
        String key;
        String value;

        public Entity(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        MapUsingHash map = new MapUsingHash();
        map.put("Mango", "King Of fruits");
        map.put("Apple", "sweet");
        map.put("litchi", "pink");

        System.out.println(map.get("Apple"));

        // String name = "A";
        // int code = name.hashCode();
        // System.out.println(code);


        // HashMap<String, Integer> map = new HashMap<>();
        // // TreeMap<String, Integer> map = new TreeMap<>();
        // map.put("ali", 89);
        // map.put("syed", 99);
        // map.put("hasan", 56);

        // System.out.println(map);

        // // System.out.println(map.get("ali"));
        // // System.out.println(map.getOrDefault("App", 78));
        // // System.out.println(map.containsKey("ali"));

        // HashSet<Integer> set = new HashSet<>();
        // set.add(89);
        // set.add(98);
        // set.add(89);
        // set.add(43);
        // set.add(21);
        // System.out.println(set);

    }
    

}
