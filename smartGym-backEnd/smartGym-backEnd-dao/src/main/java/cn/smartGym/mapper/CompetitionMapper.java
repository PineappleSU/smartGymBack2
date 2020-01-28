package cn.smartGym.mapper;

import cn.smartGym.pojo.Competition;
import cn.smartGym.pojo.CompetitionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompetitionMapper {
    long countByExample(CompetitionExample example);

    int deleteByExample(CompetitionExample example);

    int deleteByPrimaryKey(String competitionId);

    int insert(Competition record);

    int insertSelective(Competition record);

    List<Competition> selectByExample(CompetitionExample example);

    Competition selectByPrimaryKey(String competitionId);

    int updateByExampleSelective(@Param("record") Competition record, @Param("example") CompetitionExample example);

    int updateByExample(@Param("record") Competition record, @Param("example") CompetitionExample example);

    int updateByPrimaryKeySelective(Competition record);

    int updateByPrimaryKey(Competition record);
}