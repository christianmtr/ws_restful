package pro.christianmtr.tesis.ws.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCrimesChicago {
    public List<EntityCrimesChicago> getAllCrimesChicago() {
        List<EntityCrimesChicago> list = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Connector.getConexion();
            String sql = "SELECT " +
                    "\"ID\", " +
                    "\"Case_Number\", " +
                    "\"Date\", \"Block\", " +
                    "\"IUCR\", \"Primary_Type\", " +
                    "\"Description\", " +
                    "\"Location_Description\", " +
                    "\"Arrest\", \"Domestic\", " +
                    "\"Beat\", " +
                    "\"District\", " +
                    "\"Ward\", " +
                    "\"Community_Area\", " +
                    "\"FBI_Code\", " +
                    "\"X_Coordinate\", " +
                    "\"Y_Coordinate\", " +
                    "\"Year\", " +
                    "\"Updated_On\", " +
                    "\"Latitude\", " +
                    "\"Longitude\", " +
                    "\"Location\" " +
                    "FROM crimes_chicago;";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            EntityCrimesChicago ecc = null;

            while (rs.next()) {
                ecc = new EntityCrimesChicago();
                ecc.setID(rs.getString("ID"));
                ecc.setCase_Number(rs.getString("Case_Number"));
                ecc.setDate(rs.getString("Date"));
                ecc.setBlock(rs.getString("Block"));
                ecc.setIUCR(rs.getString("IUCR"));
                ecc.setPrimary_Type(rs.getString("Primary_Type"));
                ecc.setDescription(rs.getString("Description"));
                ecc.setLocation_Description(rs.getString("Location_Description"));
                ecc.setArrest(rs.getString("Arrest"));
                ecc.setDomestic(rs.getString("Domestic"));
                ecc.setBeat(rs.getString("Beat"));
                ecc.setDistrict(rs.getString("District"));
                ecc.setWard(rs.getString("Ward"));
                ecc.setCommunity_Area(rs.getString("Community_Area"));
                ecc.setFBI_Code(rs.getString("FBI_Code"));
                ecc.setX_Coordinate(rs.getString("X_Coordinate"));
                ecc.setY_Coordinate(rs.getString("Y_Coordinate"));
                ecc.setYear(rs.getString("Year"));
                ecc.setUpdated_On(rs.getString("Updated_On"));
                ecc.setLatitude(rs.getString("Latitude"));
                ecc.setLongitude(rs.getString("Longitude"));
                ecc.setLocation(rs.getString("Location"));
            }

            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return list;
    }

    public List<EntityCrimesChicago> getSomeCrimesChicago(int quantity) {
        List<EntityCrimesChicago> list = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Connector.getConexion();
            String sql = "SELECT * FROM crimes_chicago LIMIT " + quantity + ";";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            EntityCrimesChicago ecc = null;

            while (rs.next()) {
                ecc = new EntityCrimesChicago();
                ecc.setID(rs.getString(1));
                ecc.setCase_Number(rs.getString(2));
                ecc.setDate(rs.getString(3));
                ecc.setBlock(rs.getString(4));
                ecc.setIUCR(rs.getString(5));
                ecc.setPrimary_Type(rs.getString(6));
                ecc.setDescription(rs.getString(7));
                ecc.setLocation_Description(rs.getString(8));
                ecc.setArrest(rs.getString(9));
                ecc.setDomestic(rs.getString(10));
                ecc.setBeat(rs.getString(11));
                ecc.setDistrict(rs.getString(12));
                ecc.setWard(rs.getString(13));
                ecc.setCommunity_Area(rs.getString(14));
                ecc.setFBI_Code(rs.getString(15));
                ecc.setX_Coordinate(rs.getString(16));
                ecc.setY_Coordinate(rs.getString(17));
                ecc.setYear(rs.getString(18));
                ecc.setUpdated_On(rs.getString(19));
                ecc.setLatitude(rs.getString(20));
                ecc.setLongitude(rs.getString(21));
                ecc.setLocation(rs.getString(22));
                list.add(ecc);
            }

            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return list;
    }

    public EntityCrimesChicago getOneCrimeChicago(String id) {
        EntityCrimesChicago one_crime = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Connector.getConexion();
            String sql = "SELECT * FROM crimes_chicago WHERE 'ID' = " + id + ";";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            one_crime = new EntityCrimesChicago();

            one_crime.setID(rs.getString(1));
            one_crime.setCase_Number(rs.getString(2));
            one_crime.setDate(rs.getString(3));
            one_crime.setBlock(rs.getString(4));
            one_crime.setIUCR(rs.getString(5));
            one_crime.setPrimary_Type(rs.getString(6));
            one_crime.setDescription(rs.getString(7));
            one_crime.setLocation_Description(rs.getString(8));
            one_crime.setArrest(rs.getString(9));
            one_crime.setDomestic(rs.getString(10));
            one_crime.setBeat(rs.getString(11));
            one_crime.setDistrict(rs.getString(12));
            one_crime.setWard(rs.getString(13));
            one_crime.setCommunity_Area(rs.getString(14));
            one_crime.setFBI_Code(rs.getString(15));
            one_crime.setX_Coordinate(rs.getString(16));
            one_crime.setY_Coordinate(rs.getString(17));
            one_crime.setYear(rs.getString(18));
            one_crime.setUpdated_On(rs.getString(19));
            one_crime.setLatitude(rs.getString(20));
            one_crime.setLongitude(rs.getString(21));
            one_crime.setLocation(rs.getString(22));

            return one_crime;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return one_crime;
    }

}
