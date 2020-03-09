package priv.tiba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import priv.tiba.dao.UserDao;
import priv.tiba.pojo.User;
import priv.tiba.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(String userId, String password) {
        return userDao.findUser(userId, DigestUtils.md5DigestAsHex(password.getBytes()));
    }

    @Override
    public int addUser(String userId, String password) {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userDao.addUser(user);
        return 1;
    }

    @Override
    public int updatePwd(String userId, String password) {
        userDao.modifyUser(userId, DigestUtils.md5DigestAsHex(password.getBytes()));
        return 1;
    }

    @Override
    public int getUsersAmount(String userId) {
        return userDao.getUserAmount(userId);
    }
}
