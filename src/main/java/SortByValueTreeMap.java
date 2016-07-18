import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by yzhao on 7/18/16.
 */
public class SortByValueTreeMap<K,V> extends TreeMap<Integer, LocationDTO> {
    public SortByValueTreeMap(Comparator<Integer> comparator) {
        super(comparator);
    }
}
