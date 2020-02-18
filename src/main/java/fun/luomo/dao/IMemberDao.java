package fun.luomo.dao;

import fun.luomo.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author Luomo
 * @since 2020/2/16 13:50
 */
public interface IMemberDao {


    @Select("select * from muser where id = #{id}")
    public Member findById(String id) throws Exception;

}
