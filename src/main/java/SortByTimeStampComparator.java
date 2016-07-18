import java.util.Comparator;
import java.util.Map;

/**
 * Created by yzhao on 7/13/16.
 */
public class SortByTimeStampComparator implements Comparator<Integer> {
    Map<Integer, LocationDTO> map;

    public SortByTimeStampComparator(Map<Integer, LocationDTO> map){
        this.map = map;
    }

    public int compare(Integer a, Integer b) {
        return (map.get(a).getModification_ts().compareTo(map.get(b).getModification_ts()))* -1;
    }
}
