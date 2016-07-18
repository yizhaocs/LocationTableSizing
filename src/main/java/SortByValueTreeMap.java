import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yzhao on 7/18/16.
 */
public class SortByValueTreeMap<K,V> extends TreeMap<Integer, LocationDTO> {
    public SortByValueTreeMap(Comparator<Integer> comparator) {
        super(comparator);

    }

    public LocationDTO putOverride(Integer key, LocationDTO value) {
        LocationDTO oldValue = get(key);

        put(key, value);


        return oldValue;
    }

    public void copyFrom(Map<Integer, LocationDTO> m) {
        for (Map.Entry<Integer, LocationDTO> e : m.entrySet()) {
            putOverride(e.getKey(), e.getValue());
        }
    }
}
