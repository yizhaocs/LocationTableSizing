import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yzhao on 7/13/16.
 */
public class TreeMapTestingMain {
    public static void main(String[] args) {

        // initialize data
        Map<Integer, LocationDTO> unsortedMap = new TreeMap<Integer, LocationDTO>();

        LocationDTO a = new LocationDTO();
        LocationDTO b = new LocationDTO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf.parse("2009-12-31");
            date2 = sdf.parse("2010-01-31");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        a.setModification_ts(date1);
        b.setModification_ts(date2);

        unsortedMap.put(2, a);
        unsortedMap.put(1, b);


        // configure sorted map
        Comparator mTimeComparator = new SortByTimeStampComparator(unsortedMap);
        SortByTimeStampTreeMap<Integer, LocationDTO> sortedMap = new SortByTimeStampTreeMap<Integer, LocationDTO>(mTimeComparator);

        sortedMap.put(2, a);
        sortedMap.put(1, b);


        // printout
        System.out.println("Before sort by time stamp");
        for (LocationDTO l : unsortedMap.values()) {
            System.out.println(l.getModification_ts());
        }

        System.out.println("After sort by time stamp");
        for (LocationDTO l : sortedMap.values()) {
            System.out.println(l.getModification_ts());
        }

    /*    // initialize data
        Map<Integer, LocationDTO> unsortedMap = new TreeMap<Integer, LocationDTO>();

        LocationDTO a = new LocationDTO();
        LocationDTO b = new LocationDTO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf.parse("2009-12-31");
            date2 = sdf.parse("2010-01-31");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        a.setModification_ts(date1);
        b.setModification_ts(date2);

        unsortedMap.put(2, a);
        unsortedMap.put(1, b);


        // configure sorted map
        Comparator mTimeComparator = new TimeStampComparator(unsortedMap);
        Map<Integer, LocationDTO> sortedMap = new TreeMap<Integer, LocationDTO>(mTimeComparator);
        sortedMap.putAll(unsortedMap);


        // printout
        System.out.println("Before sort by time stamp");
        for (LocationDTO l : unsortedMap.values()) {
            System.out.println(l.getModification_ts());
        }

        System.out.println("After sort by time stamp");
        for (LocationDTO l : sortedMap.values()) {
            System.out.println(l.getModification_ts());
        }
*/
    }




/*

    public static <Integer, LocationDTO extends Comparable<? super LocationDTO>> SortedSet<Map.Entry<Integer, LocationDTO>> entriesSortedByValues(Map<Integer, LocationDTO> map) {
        SortedSet<Map.Entry<Integer, LocationDTO>> sortedEntries = new TreeSet<Map.Entry<Integer, LocationDTO>>(
                new Comparator<Map.Entry<Integer, LocationDTO>>() {
                    public int compare(Map.Entry<Integer, LocationDTO> e1, Map.Entry<Integer, LocationDTO> e2) {
                        LocationDTO a = e1.getValue();
                        LocationDTO b = e2.getValue();
                        return a.compareTo(b);
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }


    private static Long dateToInteger(String date) {
        String[] splitDate = date.split(" ");
        String[] splitFirstHalf = splitDate[0].split("-");
        String[] splitSecondHalf = splitDate[1].split(":");

        StringBuilder result = new StringBuilder();
        for (String s : splitFirstHalf) {
            result.append(s);
        }

        for (String s : splitSecondHalf) {
            result.append(s);
        }
        return Long.valueOf(result.toString());
    }
*/


}
