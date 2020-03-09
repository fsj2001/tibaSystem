package priv.tiba.dao;

import org.apache.ibatis.annotations.Param;
import priv.tiba.pojo.User;

public interface UserDao {

    //查找用户
    public User findUser(@Param("userId") String userId, @Param("password") String password);

    //添加用户
    public int addUser(User user);

    //修改用户信息
    public int modifyUser(String userId, String password);

    //查找用户数量
    public int getUserAmount(String userId);
}
