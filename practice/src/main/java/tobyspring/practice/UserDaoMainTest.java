package tobyspring.practice;

import tobyspring.practice.user.dao.UserDao;
import tobyspring.practice.user.domain.User;

import java.sql.SQLException;

public class UserDaoMainTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new UserDao();

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
}
