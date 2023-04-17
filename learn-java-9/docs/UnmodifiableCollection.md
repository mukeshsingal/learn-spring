# Factory methods for Unmodifiable Collection

### Create Immutable Object in Java 1.9
```java
import java.util.*;

public class UnmodifiableCollection {
    public static void main(String[] args) {
        List<String> l =            List.of("A", "B", "C", "D");
        Set<String> s =             Set.of("A","B","C","D");
        Map<String, String> m =     Map.of("A", "Option A", "B", "Option B", "C", "Option C");
    }
}
``` 


### What is Collection?
Represent group of object as a single entity. Collection are of three types:
- List 
    - Duplication of same objects are allowed 
    - Insertion order is preserved.    
- Set
    - Duplication of object are not allowed. All objects are unique.
    - Insertion order is not preserved.
- Queue

### What is Map?
Represent group of key value pairs. Here Keys are uniqe and cannot be duplicated but value can be duplicated.

### Immutable?
Unmodifiable objects are Immutable Objects. Once the object is created, changes in content is not allowed in Immutable Objects. 
Advantages with Immutable Objects: 
- Memory Utilization will be improved. Same object will be used access all references.
- Performance improvement. Not required to any other object.

### Factory Method?
If a method return the Same class object, that method is called Factory method. For Eg.
```java
DateFormat d = DateFormat.getInstance();
List l = List.of();
Set s = Set.of();
Map m = Map.of();
Map m = Map.ofEnteries();
Jenkins instance = Jenkins.getInstance();
``` 

### Create Immutable Object till Java 1.8
```java
import java.util.*;
public class UnmodifiableCollection{
    public static void main(String[] args){
        /* Create Immutable List */
        List<String> list = new ArrayList<String>();
        list.add("Item1");
        list.add("Item2");
        list.add("Item3");
        
        List<String> immuteList = Collections.unmodifiableList(list);
        
        /* Create Immutable Set */
        Set<String> set = new HashSet<String>();
            set.add("Item1");
            set.add("Item2");
            set.add("Item3");
    
        List<String> immuteSet = Collections.unmodifiableSet(set);
        
        /*Create Immutable Map */
        Map<String, String> m = new HashMap<>();
        m.put("A", "Option A");
        m.put("B", "Option B");
        m.put("C", "Option C");
        Map<String, String> immuteMap = Collections.unmodifiableMap(m);
            
    }    
}
```
Now if we try to add new element in `immuteList` we will get __UnsupportedOperationException__.

### Serialization for Immutable Collections
Process of writing object to a file is called Serialization. Process of reading object from a file is called Deserialization.
To make a class Serializable class has to implement an interface `Serializable`.
> if we want to serialize a ` Unmodifiable Collection` then internal object also should be Serialize. Also even after deserialization restored object also will be immutable.
