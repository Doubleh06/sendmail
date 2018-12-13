package com.vtyc.sendmail.dao.second;



import com.vtyc.sendmail.entity.PtMstr;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author fonlin
 * @date 2018/4/19
 */
@Component
public interface CqPtMstrDao extends Mapper<PtMstr>, MySqlMapper<PtMstr> {

    @Select("select count(*) from pt_mstr;")
    Integer getTotal();
}
