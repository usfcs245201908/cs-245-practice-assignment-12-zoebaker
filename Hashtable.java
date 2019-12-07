public class Hashtable {

    int sizeOfHashTable;
    HashNode[] elements;

    //constructor
    Hashtable(){
        sizeOfHashTable = 1000;
        elements = new HashNode[1000];
    }
    //constructor
    Hashtable(int size){
        sizeOfHashTable = size;
        elements = new HashNode[size];
    }


    boolean containsKey(String key){
        int hash = hash(key);
        if(elements[hash] != null) {
            return true;
        }


        return false;
    }

    //returns value associated with key
    String get(String key){
        int hash = hash(key);
        if(elements[hash] != null) {
            HashNode temp = elements[hash];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    return temp.value;
                }
                temp = temp.next;
            }
        }

        return null;
    }

    //puts HashNode in the table
    void put(String key, String value){
        HashNode hashElement = new HashNode(key, value);
        int hash = hash(key);
        if(elements[hash] == null) {
            elements[hash] = hashElement;
        } else {
            hashElement.next = elements[hash];
            elements[hash] = hashElement;
        }
    }

    //removes value associated with key from table
    String remove(String key){
        int hash = hash(key);
        if(elements[hash] != null) {
            HashNode temp = elements[hash];
            while (temp != null) {
                if (temp.key.equals(key)) {
                    elements[hash] = null;
                    return temp.value;
                }
                temp = temp.next;
            }


        }
        return null;
    }


    private int hash(String key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % sizeOfHashTable;
    }

}