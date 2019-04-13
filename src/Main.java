import java.util.HashMap;
import java.util.Map;


class MyHashedObject {

    private String data;
    private Map<String, MyHashedObject> InternalKvp;

    public MyHashedObject() {
        this.InternalKvp = new HashMap<>();
    }

    /*
     * Get the next level of our MyHashedObject object
     * @param HashKey
     * @return MyHashedObject result
     */
    public MyHashedObject findHashedObject(String HashKey) {
        MyHashedObject result = null;
        if(this.InternalKvp.containsKey(HashKey)) {
            result = this.InternalKvp.get(HashKey);
        }
        return result;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public Map<String, MyHashedObject> getInternalKvp() {
        return InternalKvp;
    }

    public void setInternalKvp(Map<String, MyHashedObject> internalKvp) {
        InternalKvp = internalKvp;
    }

    @Override
    public String toString() {
        return "MyHashedObject{" +
                "data='" + data + '\'' +
                ", InternalKvp=" + InternalKvp +
                '}';
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Map<String, MyHashedObject> map = new HashMap<>();
        MyHashedObject myHashedObject = new MyHashedObject();
        myHashedObject.setData("Data1");
        map.put("key1", myHashedObject);

        System.out.println(map);

        // Level 2
        Map<String, MyHashedObject> map2 = new HashMap<>();
        MyHashedObject myHashedObject2 = new MyHashedObject();
        myHashedObject2.setData("Data2");
        map2.put("key2", myHashedObject2);

        System.out.println(map2);

        myHashedObject.setInternalKvp(map2);

        MyHashedObject res = map.get("key1").findHashedObject("key2");

        System.out.println(res);

    }
}
