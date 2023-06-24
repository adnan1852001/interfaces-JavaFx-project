package com.example.project;

import java.sql.Connection;
import java.sql.SQLException;
import org.postgresql.ds.PGSimpleDataSource;

import java.sql.DatabaseMetaData;

public class PostgreSQL_Connection {
    //Connect to the PostgreSQL database using PGSimpleDataSource
    public static Connection connect() {
        PGSimpleDataSource source = new PGSimpleDataSource();
        source.setServerName("localhost");
        source.setDatabaseName("Project");
        source.setUser("postgres");
        source.setPassword("hassan2003");
        source.setCurrentSchema("STDAttend");

        Connection conn = null;

        try {
            conn = source.getConnection();
            System.out.println("Connected to server successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;  // will return Connection object
    }

    /**
     * Dummy function
     */
    public static Connection connect_metaData() {
        PGSimpleDataSource source = new PGSimpleDataSource();
        source.setServerName("localhost");
        source.setDatabaseName("Project");
        source.setUser("postgres");
        source.setPassword("hassan2003");
        source.setCurrentSchema("STDAttend");

        Connection con = null;
        try {
            con = source.getConnection();

            DatabaseMetaData metadata = con.getMetaData();
            System.out.println("DBMS Name: " + metadata.getDatabaseProductName());
            System.out.println("DBMS Version: " + metadata.getDatabaseProductVersion());
            System.out.println("Logged User: " + metadata.getUserName());
            System.out.println("JDBC Driver: " + metadata.getDriverName());
            System.out.println("Driver Version: " + metadata.getDriverVersion());
            System.out.println("Server URL: " + metadata.getURL());
            System.out.println("Max connections: " + metadata.getMaxConnections());


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return con;  // will return Connection object
    }
}