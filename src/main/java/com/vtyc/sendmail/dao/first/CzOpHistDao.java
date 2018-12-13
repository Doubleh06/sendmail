package com.vtyc.sendmail.dao.first;



import com.vtyc.sendmail.entity.OpHist;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.Date;

/**
 * @author fonlin
 * @date 2018/4/19
 */
@Component
public interface CzOpHistDao extends Mapper<OpHist>, MySqlMapper<OpHist> {

    @Select("select top 1 credat from op_hist order by op_date DESC;")
    Date getCredat();
}
