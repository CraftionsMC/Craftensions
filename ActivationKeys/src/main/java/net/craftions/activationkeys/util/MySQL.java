/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.activationkeys.util;

import java.sql.*;

public class MySQL {

    public String sql;
    private Connection con;


    public MySQL(String sql){
        this.sql = sql;
    }

    // TODO !! Fix error: java.sql.SQLException: Operation not allowed after ResultSet closed
    // -> return connection and close it when finished processing with rs.
    // -> do not close it in this method!!!
    public ResultSet executeQuery(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(this.getConnectionString(), Config.mysql_username, Config.mysql_password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void executeUpdate() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(this.getConnectionString(), Config.mysql_username, Config.mysql_password);
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close(){
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private String getConnectionString(){
        return "jdbc:mysql://" + Config.mysql_host + ":" + Config.mysql_port + "/" + Config.mysql_database;
    }
}
