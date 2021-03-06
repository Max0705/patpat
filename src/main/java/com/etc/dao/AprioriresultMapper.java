package com.etc.dao;

import com.etc.entity.Aprioriresult;
import com.etc.entity.AprioriresultExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component

public interface AprioriresultMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AprioriResult
     *
     * @mbggenerated Mon Jul 23 15:55:20 CST 2018
     */
    int countByExample(AprioriresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AprioriResult
     *
     * @mbggenerated Mon Jul 23 15:55:20 CST 2018
     */
    int deleteByExample(AprioriresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AprioriResult
     *
     * @mbggenerated Mon Jul 23 15:55:20 CST 2018
     */
    int insert(Aprioriresult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AprioriResult
     *
     * @mbggenerated Mon Jul 23 15:55:20 CST 2018
     */
    int insertSelective(Aprioriresult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AprioriResult
     *
     * @mbggenerated Mon Jul 23 15:55:20 CST 2018
     */
    List<Aprioriresult> selectByExample(AprioriresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AprioriResult
     *
     * @mbggenerated Mon Jul 23 15:55:20 CST 2018
     */
    int updateByExampleSelective(@Param("record") Aprioriresult record, @Param("example") AprioriresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table AprioriResult
     *
     * @mbggenerated Mon Jul 23 15:55:20 CST 2018
     */
    int updateByExample(@Param("record") Aprioriresult record, @Param("example") AprioriresultExample example);
}