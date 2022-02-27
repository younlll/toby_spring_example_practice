package tobyspring.practice;

import tobyspring.practice.user.dao.UserDao;
import tobyspring.practice.user.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDaoMainTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new UserDao() {
            @Override
            public Connection getConnection() throws ClassNotFoundException, SQLException {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_study", "root", "root");
                return c;
            }
        };
        User user = new User();
        user.setId("thisisid");
        user.setName("yuna");
        user.setPassword("thisispw");

        dao.add(user);

        System.out.println(user.getId() +  " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_study", "root", "root");
        return c;
    }
}
