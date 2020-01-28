package cn.smartGym.mapper;

import cn.smartGym.pojo.AppUser;
import cn.smartGym.pojo.AppUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppUserMapper {
    long countByExample(AppUserExample example);

    int deleteByExample(AppUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(AppUser record);

    int insertSelective(AppUser record);

    List<AppUser> selectByExample(AppUserExample example);

    AppUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") AppUser record, @Param("example") AppUserExample example);

    int updateByExample(@Param("record") AppUser record, @Param("example") AppUserExample example);

    int updateByPrimaryKeySelective(AppUser record);

    int updateByPrimaryKey(AppUser record);
}