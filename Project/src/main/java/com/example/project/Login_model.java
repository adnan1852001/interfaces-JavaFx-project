package com.example.project.Useless;

import com.example.project.PostgreSQL_Connection;

import java.sql.*;

public class Login_model {
    private final Connection conn;
    private static String UserType;

    public Login_model() {
        conn = PostgreSQL_Connection.connect();

        if (conn == null) {
            System.out.println("error_connection login model");
        }
    }

    /**
     * @return true if the database is connected and false otherwise
     */
    public boolean isDBConnected() {
        try {
            return !conn.isClosed();
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean LoginNow(String user, String pass) throws SQLException {
        PreparedStatement prepStatement = null;
        ResultSet resultSet = null;

        String query = "select * from account where username = ? and password = ?";

        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, user);
            prepStatement.setString(2, pass);

            resultSet = prepStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public static String get_UserType() {
        return UserType;
    }
}







//public class Login_model {
//    private final Connection conn;
//    private static String UserType;
//
//    public Login_model() {
//        conn = PostgreSQL_Connection.connect();
//
//        if (conn == null) {
//            System.out.println("error_connection login model");
//        }
//    }
//
//    /**
//     * @return true if the data base is connected and false otherwise
//     */
//    public boolean isDBConnected() {
//        try {
//            return !conn.isClosed();
//        } catch (SQLException ex) {
//            return false;
//        }
//    }
//
//    public boolean LoginNow(String user, String pass) throws SQLException, UsernameNotFoundException, PasswordMismatchException {
//        PreparedStatement prepStatement = null;
//        ResultSet resultSet = null;
//
//        String query = "SELECT * FROM system_user WHERE username = ? AND password = ?";
//        try {
//            prepStatement = conn.prepareStatement(query);
//            prepStatement.setString(1, user);
//            prepStatement.setString(2, pass);
//
//            resultSet = prepStatement.executeQuery();
//
//            while(resultSet.next()) {
//                UserType = resultSet.getString(2);
//            }
//
//            return resultSet.next();
//
//        } catch (SQLException ex) {
//            if (ex.getErrorCode() == 1049) {
//                throw new UsernameNotFoundException("The user name is not found.");
//            } else if (ex.getErrorCode() == 1062) {
//                throw new PasswordMismatchException("The password is incorrect.");
//            } else {
//                throw ex;
//            }
//        } finally {
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException ex) {
//                    // ignore
//                }
//            }
//            if (prepStatement != null) {
//                try {
//                    prepStatement.close();
//                } catch (SQLException ex) {
//                    // ignore
//                }
//            }
//        }
//    }
//
////    public boolean LoginNow(String user, String pass) throws SQLException {
////        String SQL = "SELECT * FROM system_user WHERE username = ? AND password = ?;";
////        ResultSet rs = null;
////
////        try (
////                PreparedStatement pstmt = conn.prepareStatement(SQL);
////        ) {
////            pstmt.setString(1, user);
////            pstmt.setString(2, pass);
////
////            rs = pstmt.executeQuery();
////
////            while(rs.next()) {
////                UserType = rs.getString(2);
////            }
////
////            return rs.next();
////        } catch (SQLException ex) {
////            System.out.println(ex.getMessage());
////            return false;
////        }
////    }
//
//    public static String get_UserType() {
//        return UserType;
//    }
//}
