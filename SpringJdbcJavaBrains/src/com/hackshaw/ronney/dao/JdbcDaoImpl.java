package com.hackshaw.ronney.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hackshaw.ronney.model.Circle;

public class JdbcDaoImpl {

    private static final String sql = "select * from circle where id = (?)";

    public Circle getCircle(int circleId) {

        Connection conn = DbConnectionUtil.getConn();
        Circle circle = null;
        try {

            PreparedStatement ps;
            ResultSet rs;

            ps = conn.prepareStatement(sql);
            ps.setInt(1, circleId);

            rs = ps.executeQuery();

            if (rs.next()) {
                circle = new Circle(circleId, rs.getString("name"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return circle;
    }

}
