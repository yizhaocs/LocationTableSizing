import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yzhao on 7/13/16.
 */
public class TimeComparator implements Comparator<Integer> {
    Map<Integer, LocationDTO> map = new TreeMap<Integer, LocationDTO>();

    public TimeComparator(Map<Integer, LocationDTO> map){
        this.map.putAll(map);
    }

    public int compare(Integer a, Integer b) {
        return map.get(a).getModification_ts().compareTo(map.get(b).getModification_ts());
    }
}
