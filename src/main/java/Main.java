import com.carrotsearch.sizeof.RamUsageEstimator;

import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {


        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            getLocation(connection);

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

            //STEP 5: Extract data from result set
            while (result.next()) {
                //Retrieve by column name
                int id = result.getInt("id");
                String country = result.getString("country");
                String state = result.getString("state");
                String city = result.getString("city");
                String zipcode = result.getString("zipcode");
                double latitude = result.getDouble("latitude");
                double longitude = result.getDouble("longitude");
                int metrocode = result.getInt("metrocode");
                int areacode = result.getInt("areacode");
                int gmt_offset = result.getInt("gmt_offset");
                int cbsa_code = result.getInt("cbsa_code");
                int csa_code = result.getInt("csa_code");
                int md_code = result.getInt("md_code");
                String md_title = result.getString("md_title");
                int income = result.getInt("income");
                int political_affiliation = result.getInt("political_affiliation");
                String ethnicity = result.getString("ethnicity");
                double rent_owned = result.getDouble("rent_owned");
                String education = result.getString("education");
                Date modification_ts = result.getDate("modification_ts");



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

            int count = 0;

//            for (TIntObjectIterator it = locationCache.iterator(); it.hasNext(); ) {
//                it.advance();
//                if(it.value() == null){
//                    count++;
//                }
//            }

            for(SoftReference w:locationCache.values()){
                if(w.get() == null){
                    count++;
                }
            }

//            for(WeakReference w:locationCache.values()){
//                if(w.get() == null){
//                    count++;
//                }
//            }

            //System.out.println("count before gc:" + count);
            System.out.println("Size before gc:" + RamUsageEstimator.humanReadableUnits(RamUsageEstimator.sizeOfAll(locationCache)));
            count = 0;


            System.gc();

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



            for(SoftReference w:locationCache.values()){
                if(w.get() == null){
                    count++;
                }
            }
            System.out.println("Size after gc:" + RamUsageEstimator.humanReadableUnits(RamUsageEstimator.sizeOfAll(locationCache)));
            // System.out.println("count after gc:" + count);
            System.out.println("Used Memory:"
                    + (runtime.totalMemory() - runtime.freeMemory()) / mb + "mb");
            System.out.println(locationCache.size());
//            WeakReference<LocationDTO> result = locationCache.get(40527);
            SoftReference<LocationDTO> result = locationCache.get(40527);
//             System.out.println(result.get());
           // System.out.println(locationCache.get(40527).get().getCity());
            //System.out.println(SizeOf.deepSizeOf());

        }
    }

    public static String byteArrayToString(byte[] byteArray) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(new String(byteArray, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}