import java.util.Date;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yzhao on 7/13/16.
 */
public class TreeMapLRU {
    public static void main(String[] args){

    }


//    private static Integer dateToInteger(Date date){
//
//    }

    private class FBHistoryTreeMapComparator implements Comparator<Integer> {

        Map<Integer, LocationDTO> map;

        public FBHistoryTreeMapComparator(Map<Integer, LocationDTO> base) {
            this.map = base;
        }

        /**
         * in null case, we want it to throw an exception
         * we don't want it to fail silently
         */
        public int compare(Integer a, Integer b) {
            //Integer oldTimeStamp = (int) (map.get(a).getModification_ts()/1000);
//            return oldTimeStamp.compareTo(b);
            return 0;
        }
    }

    /**
     * this is the limit size tree map, where we want to store as many as n entries
     *
     * we will use this with our FB history map
     *
     */
    private class LimitSizeTreeMap extends TreeMap<Integer, LocationDTO> {
        private Date newTimeStamp;

        public LimitSizeTreeMap(Comparator<Integer> comparator, Date newTimeStamp) {
            super(comparator);

            this.newTimeStamp = newTimeStamp;
        }

        public LocationDTO putOverride(Integer key, LocationDTO newValue) {
            LocationDTO oldValue = get(key);

            put(key, newValue);


            return oldValue;
        }
    }

}
