package fun.luomo.dao;

import fun.luomo.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/18 15:14
 */
public interface ISysLogDao {

    @Insert("insert into sysLog(id,visitTime,username,ip,url,executionTime,method)" +
            " values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;

    @Select("select * from syslog")
    List<SysLog> findAll() throws Exception;


}
