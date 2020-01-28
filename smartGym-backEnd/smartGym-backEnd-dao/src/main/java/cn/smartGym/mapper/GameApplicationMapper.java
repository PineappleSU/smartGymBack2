package cn.smartGym.mapper;

import cn.smartGym.pojo.GameApplication;
import cn.smartGym.pojo.GameApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameApplicationMapper {
    long countByExample(GameApplicationExample example);

    int deleteByExample(GameApplicationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GameApplication record);

    int insertSelective(GameApplication record);

    List<GameApplication> selectByExample(GameApplicationExample example);

    GameApplication selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GameApplication record, @Param("example") GameApplicationExample example);

    int updateByExample(@Param("record") GameApplication record, @Param("example") GameApplicationExample example);

    int updateByPrimaryKeySelective(GameApplication record);

    int updateByPrimaryKey(GameApplication record);
}