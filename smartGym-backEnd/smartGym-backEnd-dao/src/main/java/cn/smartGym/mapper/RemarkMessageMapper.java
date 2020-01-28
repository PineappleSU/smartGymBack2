package cn.smartGym.mapper;

import cn.smartGym.pojo.RemarkMessage;
import cn.smartGym.pojo.RemarkMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemarkMessageMapper {
    long countByExample(RemarkMessageExample example);

    int deleteByExample(RemarkMessageExample example);

    int deleteByPrimaryKey(Long reamrkId);

    int insert(RemarkMessage record);

    int insertSelective(RemarkMessage record);

    List<RemarkMessage> selectByExample(RemarkMessageExample example);

    RemarkMessage selectByPrimaryKey(Long reamrkId);

    int updateByExampleSelective(@Param("record") RemarkMessage record, @Param("example") RemarkMessageExample example);

    int updateByExample(@Param("record") RemarkMessage record, @Param("example") RemarkMessageExample example);

    int updateByPrimaryKeySelective(RemarkMessage record);

    int updateByPrimaryKey(RemarkMessage record);
}