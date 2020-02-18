package fun.luomo.dao;

import fun.luomo.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/16 13:53
 */
public interface ITravellerDao {

    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId = #{orderId})")
    public List<Traveller> findByOrdersId(String orderId);

}
