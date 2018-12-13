package com.vtyc.sendmail.dao.first;



import com.vtyc.sendmail.entity.WcMstr;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author fonlin
 * @date 2018/4/19
 */
@Component
public interface CzWcMstrDao extends Mapper<WcMstr>, MySqlMapper<WcMstr> {

    @Select("select count(*) from wc_mstr;")
    Integer getTotal();
}
