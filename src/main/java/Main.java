import com.carrotsearch.sizeof.RamUsageEstimator;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by yzhao on 7/11/16.
 */
public class Main {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/geoip";

    //  Database credentials
    static final String USER = "om";
    static final String PASS = "N3wQA3ra.";
    static final int mb = 1024 * 1024;

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
    static String modification_ts = null;


    static int t1 = 300000;
    static int t2 = 400000;
    static int t3 = 500000;
    static int t4 = 600000;
    static int t5 = 700000;
    static int t6 = 800000;
    static int t7 = 900000;


    public static void main(String[] args) {
        try {
            fileSolution();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    private static void fileSolution() throws IOException {
        Scanner s = new Scanner(new File("/Users/yzhao/Desktop/location.csv"));

        Runtime runtime = Runtime.getRuntime();
        Map<Integer, SoftReference<LocationDTO>> locationCache = new HashMap<Integer, SoftReference<LocationDTO>>();

        int count = 0;
        int countForNullForT1 = 0;
        int countForNullForT2 = 0;
        int countForNullForT3 = 0;
        int countForNullForT4 = 0;
        int countForNullForT5 = 0;
        int countForNullForT6 = 0;
        int countForNullForT7 = 0;
        int countForNullForT8 = 0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] splitArray = line.split("\t");
            // System.out.println(line);
//            System.out.println(Arrays.toString(splitArray));
//            System.out.println(splitArray.length);
            cleanup();
            //Retrieve by column name

            if (splitArray[0] != null && splitArray[0].equals("NULL") == false)
                id = Integer.valueOf(splitArray[0]);

            if (splitArray[1] != null && splitArray[1].equals("NULL") == false)
                country = splitArray[1];

            if (splitArray[2] != null && splitArray[2].equals("NULL") == false)
                state = splitArray[2];

            if (splitArray[3] != null && splitArray[3].equals("NULL") == false)
                city = splitArray[3];

            if (splitArray[4] != null && splitArray[4].equals("NULL") == false)
                zipcode = splitArray[4];

            if (splitArray[5] != null && splitArray[5].equals("NULL") == false)
                latitude = Double.valueOf(splitArray[5]);

            if (splitArray[6] != null && splitArray[6].equals("NULL") == false)
                longitude = Double.valueOf(splitArray[6]);

            if (splitArray[7] != null && splitArray[7].equals("NULL") == false)
                metrocode = Integer.valueOf(splitArray[7]);

            if (splitArray[8] != null && splitArray[8].equals("NULL") == false)
                areacode = Integer.valueOf(splitArray[8]);

            if (splitArray[9] != null && splitArray[9].equals("NULL") == false)
                gmt_offset = Integer.valueOf(splitArray[9]);

            if (splitArray[10] != null && splitArray[10].equals("NULL") == false)
                cbsa_code = Integer.valueOf(splitArray[10]);

            if (splitArray[11] != null && splitArray[11].equals("NULL") == false)
                csa_code = Integer.valueOf(splitArray[11]);

            if (splitArray[12] != null && splitArray[12].equals("NULL") == false)
                md_code = Integer.valueOf(splitArray[12]);

            if (splitArray[13] != null && splitArray[13].equals("NULL") == false)
                md_title = splitArray[13];

            if (splitArray[14] != null && splitArray[14].equals("NULL") == false)
                income = Integer.valueOf(splitArray[14]);

            if (splitArray[15] != null && splitArray[15].equals("NULL") == false)
                political_affiliation = Integer.valueOf(splitArray[15]);

            if (splitArray[16] != null && splitArray[16].equals("NULL") == false)
                ethnicity = splitArray[16];

            if (splitArray[17] != null && splitArray[17].equals("NULL") == false)
                rent_owned = Double.valueOf(splitArray[17]);

            if (splitArray[18] != null && splitArray[18].equals("NULL") == false)
                education = splitArray[18];

            if (splitArray[19] != null && splitArray[19].equals("NULL") == false)
                modification_ts = splitArray[19];


            LocationDTO mLocationDTO = new LocationDTO();

            if (splitArray[0].equals("NULL") == false)
                mLocationDTO.setId(id);
            if (splitArray[1].equals("NULL") == false)
                mLocationDTO.setCountry(country);
            if (splitArray[2].equals("NULL") == false)
                mLocationDTO.setState(state);
            if (splitArray[3].equals("NULL") == false)
                mLocationDTO.setCity(city);
            if (splitArray[4].equals("NULL") == false)
                mLocationDTO.setZipcode(zipcode);
            if (splitArray[5].equals("NULL") == false)
                mLocationDTO.setLatitude(latitude);
            if (splitArray[6].equals("NULL") == false)
                mLocationDTO.setLongitude(longitude);
            if (splitArray[7].equals("NULL") == false)
                mLocationDTO.setMetrocode(metrocode);
            if (splitArray[8].equals("NULL") == false)
                mLocationDTO.setAreacode(areacode);
            if (splitArray[9].equals("NULL") == false)
                mLocationDTO.setGmt_offset(gmt_offset);
            if (splitArray[10].equals("NULL") == false)
                mLocationDTO.setCbsa_code(cbsa_code);
            if (splitArray[11].equals("NULL") == false)
                mLocationDTO.setCsa_code(csa_code);
            if (splitArray[12].equals("NULL") == false)
                mLocationDTO.setMd_code(md_code);
            if (splitArray[13].equals("NULL") == false)
                mLocationDTO.setMd_title(md_title);
            if (splitArray[14].equals("NULL") == false)
                mLocationDTO.setIncome(income);
            if (splitArray[15].equals("NULL") == false)
                mLocationDTO.setPolitical_affiliation(political_affiliation);
            if (splitArray[16].equals("NULL") == false)
                mLocationDTO.setEthnicity(ethnicity);
            if (splitArray[17].equals("NULL") == false)
                mLocationDTO.setRent_owned(rent_owned);
            if (splitArray[18].equals("NULL") == false)
                mLocationDTO.setEducation(education);
            if (splitArray[19].equals("NULL") == false)
                mLocationDTO.setModification_ts(modification_ts);


            SoftReference mSoftReference = new SoftReference(mLocationDTO);
            locationCache.put(id, mSoftReference);
            count++;

            if (count == t1) {
                nullValueCount(countForNullForT1, locationCache, runtime);
            } else if (count == t2) {
                nullValueCount(countForNullForT2, locationCache, runtime);
            } else if (count == t3) {
                nullValueCount(countForNullForT3, locationCache, runtime);
            } else if (count == t4) {
                nullValueCount(countForNullForT4, locationCache, runtime);
            } else if (count == t5) {
                nullValueCount(countForNullForT5, locationCache, runtime);
            } else if (count == t6) {
                nullValueCount(countForNullForT6, locationCache, runtime);
            } else if (count == t7) {
                nullValueCount(countForNullForT7, locationCache, runtime);
            } else if (count == 970393) {
                nullValueCount(countForNullForT8, locationCache, runtime);

                SoftReference<LocationDTO> result1 = locationCache.get(40526);
                SoftReference<LocationDTO> result2 = locationCache.get(40527);
                System.out.println(result1.get().getCity());
                System.out.println(result2.get().getCity());
            }
        }


    }

    private static void nullValueCount(int countForNull, Map<Integer, SoftReference<LocationDTO>> locationCache, Runtime runtime) {
        System.out.println();
        for (SoftReference w : locationCache.values()) {
            if (w.get() == null) {
                countForNull++;
            }
        }
        System.out.println("Map Null count before gc:" + countForNull);
        System.out.println("Map Used Heap Memory before gc:" + RamUsageEstimator.humanReadableUnits(RamUsageEstimator.sizeOfAll(locationCache)));

        System.out.println("Total Used Heap Memory:"
                + (runtime.totalMemory() - runtime.freeMemory()) / mb + "mb");
        System.out.println(locationCache.size());
    }

    private static void jdbcSolution() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            long lStartTime = System.currentTimeMillis();
            getLocation(connection);
            long lEndTime = System.currentTimeMillis();

            long difference = lEndTime - lStartTime;

            System.out.println("Elapsed time:" + difference + "ms");

            //Print used memory

//            //Print free memory
//            System.out.println("Free Memory:"
//                    + runtime.freeMemory() / mb);
//
//            //Print total available memory
//            System.out.println("Total Memory:" + runtime.totalMemory() / mb);

            //Print Maximum available memory
//            System.out.println("Max Memory:" + runtime.maxMemory() / mb + "mb");
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

    private static void getLocation(Connection connection) {
        if (connection == null) {
            System.out.println("Connection object is null.");
            return;
        }

        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();


        // THashMap<Integer, LocationDTO> locationCache = new THashMap<Integer, LocationDTO>();
        // THashMap<Integer, WeakReference<LocationDTO>> locationCache = new THashMap<Integer, WeakReference<LocationDTO>>();
        // TIntObjectHashMap<LocationDTO> locationCache = new TIntObjectHashMap<LocationDTO>();
        //  TIntObjectHashMap<WeakReference<LocationDTO>> locationCache = new TIntObjectHashMap<WeakReference<LocationDTO>>();
        //  TIntObjectHashMap<SoftReference<LocationDTO>> locationCache = new TIntObjectHashMap<SoftReference<LocationDTO>>();
        //Map<Integer, LocationDTO> locationCache = new HashMap<Integer, LocationDTO>();
//        Map<Integer, WeakReference<LocationDTO>> locationCache = new HashMap<Integer, WeakReference<LocationDTO>>();
        Map<Integer, SoftReference<LocationDTO>> locationCache = new HashMap<Integer, SoftReference<LocationDTO>>();
        //Map<Integer, LocationDTO> locationCache = new WeakHashMap<Integer, LocationDTO>();
        // Map<Integer, WeakReference<LocationDTO>> locationCache = new WeakHashMap<Integer, WeakReference<LocationDTO>>();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM location";
            ResultSet result = statement.executeQuery(sql);
//            System.out.println("JDBC Used Heap Memory before gc:" + RamUsageEstimator.humanReadableUnits(RamUsageEstimator.sizeOf(result)));

            int count = 0;
            int countForNullForT1 = 0;
            int countForNullForT2 = 0;
            int countForNullForT3 = 0;
            int countForNullForT4 = 0;
            //STEP 5: Extract data from result set
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
                //modification_ts = result.getDate("modification_ts");
                modification_ts = result.getString("modification_ts");


               /*
               LocationDTO mLocationDTO = new LocationDTO();
                mLocationDTO.setId(id);

               if (country != null)
                    mLocationDTO.setCountry(country.getBytes(Charset.forName("UTF-8")));

                if (state != null)
                    mLocationDTO.setState(state.getBytes(Charset.forName("UTF-8")));
                if (city != null)
                    mLocationDTO.setCity(city.getBytes(Charset.forName("UTF-8")));
                if (zipcode != null)
                    mLocationDTO.setZipcode(zipcode.getBytes(Charset.forName("UTF-8")));
                mLocationDTO.setLatitude(latitude);
                mLocationDTO.setLongitude(longitude);
                mLocationDTO.setMetrocode(metrocode);
                mLocationDTO.setAreacode(areacode);
                mLocationDTO.setGmt_offset(gmt_offset);
                mLocationDTO.setCbsa_code(cbsa_code);
                mLocationDTO.setCsa_code(csa_code);
                mLocationDTO.setMd_code(md_code);
                if (md_title != null)
                    mLocationDTO.setMd_title(md_title.getBytes(Charset.forName("UTF-8")));
                mLocationDTO.setIncome(income);
                mLocationDTO.setPolitical_affiliation(political_affiliation);
                if (ethnicity != null)
                    mLocationDTO.setEthnicity(ethnicity.getBytes(Charset.forName("UTF-8")));
                mLocationDTO.setRent_owned(rent_owned);
                if (education != null)
                    mLocationDTO.setEducation(education.getBytes(Charset.forName("UTF-8")));
                mLocationDTO.setModification_ts(modification_ts);
*/

                LocationDTO mLocationDTO = new LocationDTO();
                mLocationDTO.setId(id);
                mLocationDTO.setCountry(country);
                mLocationDTO.setState(state);
                mLocationDTO.setCity(city);
                mLocationDTO.setZipcode(zipcode);
                mLocationDTO.setLatitude(latitude);
                mLocationDTO.setLongitude(longitude);
                mLocationDTO.setMetrocode(metrocode);
                mLocationDTO.setAreacode(areacode);
                mLocationDTO.setGmt_offset(gmt_offset);
                mLocationDTO.setCbsa_code(cbsa_code);
                mLocationDTO.setCsa_code(csa_code);
                mLocationDTO.setMd_code(md_code);
                mLocationDTO.setMd_title(md_title);
                mLocationDTO.setIncome(income);
                mLocationDTO.setPolitical_affiliation(political_affiliation);
                mLocationDTO.setEthnicity(ethnicity);
                mLocationDTO.setRent_owned(rent_owned);
                mLocationDTO.setEducation(education);
                mLocationDTO.setModification_ts(modification_ts);

//
//                WeakReference mWeakReference = new WeakReference(mLocationDTO);
//                locationCache.put(id, mWeakReference);


                SoftReference mSoftReference = new SoftReference(mLocationDTO);
                locationCache.put(id, mSoftReference);
                count++;

                if (count == t1) {
                    System.out.println();
                    for (SoftReference w : locationCache.values()) {
                        if (w.get() == null) {
                            countForNullForT1++;
                        }
                    }
                    System.out.println("Map Null count before gc:" + countForNullForT1);
                    System.out.println("Map Used Heap Memory before gc:" + RamUsageEstimator.humanReadableUnits(RamUsageEstimator.sizeOfAll(locationCache)));

                    System.out.println("Total Used Heap Memory:"
                            + (runtime.totalMemory() - runtime.freeMemory()) / mb + "mb");
                    System.out.println(locationCache.size());
                } else if (count == t2) {
                    System.out.println();
                    for (SoftReference w : locationCache.values()) {
                        if (w.get() == null) {
                            countForNullForT2++;
                        }
                    }
                    System.out.println("Map Null count before gc:" + countForNullForT2);
                    System.out.println("Map Used Heap Memory before gc:" + RamUsageEstimator.humanReadableUnits(RamUsageEstimator.sizeOfAll(locationCache)));
                    System.out.println("Total Used Heap Memory:"
                            + (runtime.totalMemory() - runtime.freeMemory()) / mb + "mb");
                    System.out.println(locationCache.size());
                } else if (count == t3) {
                    System.out.println();
                    for (SoftReference w : locationCache.values()) {
                        if (w.get() == null) {
                            countForNullForT3++;
                        }
                    }
                    System.out.println("Map Null count before gc:" + countForNullForT3);
                    System.out.println("Map Used Heap Memory before gc:" + RamUsageEstimator.humanReadableUnits(RamUsageEstimator.sizeOfAll(locationCache)));

                    System.out.println("Total Used Heap Memory:"
                            + (runtime.totalMemory() - runtime.freeMemory()) / mb + "mb");
                    System.out.println(locationCache.size());
                } else if (count == 970393) {
                    System.out.println();
                    for (SoftReference w : locationCache.values()) {
                        if (w.get() == null) {
                            countForNullForT4++;
                        }
                    }
                    System.out.println("Map Null count before gc:" + countForNullForT4);
                    System.out.println("Map Used Heap Memory before gc:" + RamUsageEstimator.humanReadableUnits(RamUsageEstimator.sizeOfAll(locationCache)));

                    System.out.println("Total Used Heap Memory:"
                            + (runtime.totalMemory() - runtime.freeMemory()) / mb + "mb");
                    System.out.println(locationCache.size());

                    SoftReference<LocationDTO> result1 = locationCache.get(40526);
                    SoftReference<LocationDTO> result2 = locationCache.get(40527);
                    System.out.println(result1.get().getCity());
                    System.out.println(result2.get().getCity());
                }


                // locationCache.put(id, mLocationDTO);

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


//            for (TIntObjectIterator it = locationCache.iterator(); it.hasNext(); ) {
//                it.advance();
//                if(it.value() == null){
//                    count++;
//                }
//            }


//            for(WeakReference w:locationCache.values()){
//                if(w.get() == null){
//                    count++;
//                }
//            }


//            System.gc();

//            for (TIntObjectIterator it = locationCache.iterator(); it.hasNext(); ) {
//                it.advance();
//                if(it.value() == null){
//                    count++;
//                }
//            }

//            for(WeakReference w:locationCache.values()){
//                if(w.get() == null){
//                    count++;
//                }
//            }


//
//            for(SoftReference w:locationCache.values()){
//                if(w.get() == null){
//                    count++;
//                }
//            }
//            System.out.println("Size after gc:" + RamUsageEstimator.humanReadableUnits(RamUsageEstimator.sizeOfAll(locationCache)));
            // System.out.println("count after gc:" + count);

//            WeakReference<LocationDTO> result = locationCache.get(40527);

//             System.out.println(result.get());
            // System.out.println(locationCache.get(40527).get().getCity());
            //System.out.println(SizeOf.deepSizeOf());

        }
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

    private static String byteArrayToString(byte[] byteArray) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(new String(byteArray, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}