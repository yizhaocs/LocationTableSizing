import java.util.Date;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yzhao on 7/13/16.
 */
public class TreeMapLRU {
    public static void main(String[] args){
        System.out.println(dateToInteger("2016-07-01 01:48:39"));

    }


    private static Long dateToInteger(String date){
        String[] splitDate = date.split(" ");
        String[] splitFirstHalf = splitDate[0].split("-");
        String[] splitSecondHalf = splitDate[1].split(":");

        StringBuilder result = new StringBuilder();
        for(String s: splitFirstHalf){
            result.append(s);
        }

        for(String s: splitSecondHalf){
            result.append(s);
        }
        return Long.valueOf(result.toString());
    }

    private class timeStampComparator implements Comparator<Long> {

        Map<Integer, LocationDTO> map;

        public timeStampComparator(Map<Integer, LocationDTO> base) {
            this.map = base;
        }

        /**
         * in null case, we want it to throw an exception
         * we don't want it to fail silently
         */
        public int compare(Long a, Long b) {
            Long oldTimeStamp = dateToInteger(map.get(a).toString());
            return oldTimeStamp.compareTo(b);
        }
    }

    /**
     * this is the limit size tree map, where we want to store as many as n entries
     *
     * we will use this with our FB history map
     *
     */
    private class TimeTreeMap extends TreeMap<Integer, LocationDTO> {
        private Date newTimeStamp;

        public TimeTreeMap(Comparator<Integer> comparator, Date newTimeStamp) {
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
