import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yzhao on 7/13/16.
 */
public class TreeMapTestingMain {
    Map<Integer, LocationDTO> hashmap = new HashMap<Integer, LocationDTO>();



    static int id = 0;
    static String country = null;
    static String state = null;
    static String city = null;
    static String zipcode = null;
    static double latitude = 0;
    static double longitude = 0;
    static int metrocode = 0;
    static int areacode = 0;
    static int gmt_offset = 0;
    static int cbsa_code = 0;
    static int csa_code = 0;
    static int md_code = 0;
    static String md_title = null;
    static int income = 0;
    static int political_affiliation = 0;
    static String ethnicity = null;
    static double rent_owned = 0;
    static String education = null;
    static Date modification_ts = null;


    public static void main(String[] args) {
        orderingTest();
    }

    private static void timeTestSetup(){
// JDBC driver name and database URL
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/geoip";

        //  Database credentials
        String USER = "om";
        String PASS = "N3wQA3ra.";
        int mb = 1024 * 1024;


        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            long lStartTime = System.currentTimeMillis();
            long lEndTime = System.currentTimeMillis();

            long difference = lEndTime - lStartTime;

            System.out.println("Elapsed time:" + difference + "ms");


        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    private static void timeTestProcess(Connection connection) {
        if (connection == null) {
            System.out.println("Connection object is null.");
            return;
        }

        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM location";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {

                cleanup();
                //Retrieve by column name
                id = result.getInt("id");
                country = result.getString("country");
                state = result.getString("state");
                city = result.getString("city");
                zipcode = result.getString("zipcode");
                latitude = result.getDouble("latitude");
                longitude = result.getDouble("longitude");
                metrocode = result.getInt("metrocode");
                areacode = result.getInt("areacode");
                gmt_offset = result.getInt("gmt_offset");
                cbsa_code = result.getInt("cbsa_code");
                csa_code = result.getInt("csa_code");
                md_code = result.getInt("md_code");
                md_title = result.getString("md_title");
                income = result.getInt("income");
                political_affiliation = result.getInt("political_affiliation");
                ethnicity = result.getString("ethnicity");
                rent_owned = result.getDouble("rent_owned");
                education = result.getString("education");
                modification_ts = result.getDate("modification_ts");
                //modification_ts = result.getString("modification_ts");
            }

            result.close();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {


            //finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    private void jdbcSolution() {


    }

    private static void cleanup() {
        id = 0;
        country = null;
        state = null;
        city = null;
        zipcode = null;
        latitude = 0;
        longitude = 0;
        metrocode = 0;
        areacode = 0;
        gmt_offset = 0;
        cbsa_code = 0;
        csa_code = 0;
        md_code = 0;
        md_title = null;
        income = 0;
        political_affiliation = 0;
        ethnicity = null;
        rent_owned = 0;
        education = null;
        modification_ts = null;

    }

    private static void orderingTest(){

        // initialize data
        Map<Integer, LocationDTO> unsortedMap = new TreeMap<Integer, LocationDTO>();

        LocationDTO a = new LocationDTO();
        LocationDTO b = new LocationDTO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = Date.valueOf("2009-06-19");
        Date date2 = Date.valueOf("2009-06-20");

        a.setModification_ts(date1);
        b.setModification_ts(date2);


        unsortedMap.put(1, a); // 2009-12-31
        unsortedMap.put(2, b); // 2010-01-31


        // configure sorted map
        Comparator mTimeComparator = new SortByTimeStampComparator(unsortedMap);
        SortByTimeStampTreeMap<Integer, LocationDTO> sortedMap = new SortByTimeStampTreeMap<Integer, LocationDTO>(mTimeComparator);

        sortedMap.put(1, a);
        sortedMap.put(2, b);



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
