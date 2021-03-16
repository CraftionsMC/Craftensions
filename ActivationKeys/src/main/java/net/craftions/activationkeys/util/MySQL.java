/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.activationkeys.util;

import java.sql.*;

public class MySQL {

    public String sql;

    public MySQL(String sql){
        this.sql = sql;
    }

    public ResultSet executeQuery(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(this.getConnectionString(), Config.mysql_username, Config.mysql_password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            con.close();
            return rs;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void executeUpdate() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(this.getConnectionString(), Config.mysql_username, Config.mysql_password);
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            con.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private String getConnectionString(){
        return "jdbc:mysql://" + Config.mysql_host + ":" + Config.mysql_port + "/" + Config.mysql_database;
    }
}
