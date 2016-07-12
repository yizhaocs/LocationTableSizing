import gnu.trove.map.hash.TIntObjectHashMap;

import java.lang.ref.WeakReference;
import java.sql.*;

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
         TIntObjectHashMap<WeakReference<LocationDTO>> locationCache = new TIntObjectHashMap<WeakReference<LocationDTO>>();
        //Map<Integer, LocationDTO> locationCache = new HashMap<Integer, LocationDTO>();
        //Map<Integer, WeakReference<LocationDTO>> locationCache = new HashMap<Integer, WeakReference<LocationDTO>>();
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


                WeakReference nWeakReference = new WeakReference(mLocationDTO);
                locationCache.put(id, nWeakReference);

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
         //   System.gc();
            System.out.println("Used Memory:"
                    + (runtime.totalMemory() - runtime.freeMemory()) / mb + "mb");
            System.out.println(locationCache.size());
            //System.out.println(SizeOf.deepSizeOf());

        }
    }
}