package com.ssm.movie.dao;

import com.ssm.movie.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    /**
     * 注册用户
     * @param user
     */
    @Insert("insert into user(name,email,password,emailStatus,registerTime,code) values(#{name},#{email},#{password},#{emailStatus},#{registerTime},#{code})")
    void saveUser(User user) ;

    /**
     * 注册验证
     * @return
     */
    @Select("select * from user where email = #{email}")
    List<User> findByEmail(String email);

   @Update("update user set emailStatus = 'Y' where id = #{id}")
    void updateEmailStatus(int id);

   @Select("select * from user where code = #{code}")
   List<User> findByCode(String code);
}
