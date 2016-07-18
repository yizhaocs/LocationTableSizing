import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by yzhao on 7/18/16.
 */
public class SortByTimeStampTreeMap<K,V> extends TreeMap<Integer, LocationDTO> {
    public SortByTimeStampTreeMap(Comparator<Integer> comparator) {
        super(comparator);
    }
}
