package application.models;

import application.SqliteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by RunningEXE on 3/1/2017.
 */
public class LoginModel {

    Connection connection;

    public LoginModel() {
        connection = SqliteConnection.Connector();
        //Insert if statement here for if connection is null.
    }

    public boolean isDbConnected() {
        try {
            return !connection.isClosed(); //returns a true/false value depending on database connectivity.
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isLogin(String user, String pass) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        finally{
            preparedStatement.close();
            resultSet.close();
        }
    }

}
