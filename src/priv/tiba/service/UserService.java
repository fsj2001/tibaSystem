package priv.tiba.service;

import priv.tiba.pojo.User;

public interface UserService {

    //查找用户
    public User findUser(String userId, String password);

    //注册
    public int addUser(String userId, String password);

    //修改密码
    public int updatePwd(String userId, String password);

    //查找用户数目
    public int getUsersAmount(String userId);
}
