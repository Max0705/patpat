package com.etc.dao;

import com.etc.entity.UserFollow;
import com.etc.entity.UserFollowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFollowMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    int countByExample(UserFollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    int deleteByExample(UserFollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    int deleteByPrimaryKey(Integer followid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    int insert(UserFollow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    int insertSelective(UserFollow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    List<UserFollow> selectByExample(UserFollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    UserFollow selectByPrimaryKey(Integer followid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserFollow record, @Param("example") UserFollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    int updateByExample(@Param("record") UserFollow record, @Param("example") UserFollowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    int updateByPrimaryKeySelective(UserFollow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_follow
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    int updateByPrimaryKey(UserFollow record);
}