package com.kg.xmlhttprequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @desc A singleton database access class for MySQL
 * @author Ramindu
 */
public final class MysqlConnect {
    public Connection conn;
    private Statement statement;
    public static MysqlConnect db;
    public static Object getDbCon;

    private MysqlConnect() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "library";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized MysqlConnect getDbCon() {
        if (db == null) {
            db = new MysqlConnect();
        }
        return db;

    }

    /**
     *
     * @param query String The query to be executed
     * @return a ResultSet object containing the results or null if not available
     * @throws SQLException
     */
    public ArrayList<Object> resultSetToArrayList(String query) throws SQLException {
        statement = db.conn.createStatement();
        ResultSet rs = statement.executeQuery(query);
        System.out.println("Hellooo");
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList<Object> list1 = new ArrayList<Object>();
        while (rs.next()) {
            HashMap<Object, Object> row = new HashMap<>(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getObject(i));
                System.out.println("hash=" + md.getColumnName(i) + " " + rs.getObject(i));
            }
            list1.add(row);
            System.err.println("list=" + list1);

        }

        return list1;
    }

    /**
     * @desc Method to insert data to a table
     * @param insertQuery String The Insert query
     * @return boolean
     * @throws SQLException
     */
    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;

    }

}