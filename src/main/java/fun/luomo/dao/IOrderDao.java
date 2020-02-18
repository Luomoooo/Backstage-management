package fun.luomo.dao;

import fun.luomo.domain.Member;
import fun.luomo.domain.Orders;
import fun.luomo.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/15 16:58
 */
public interface IOrderDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "fun.luomo.dao.IProductDao.findById"))

    })
    List<Orders> findAll() throws Exception;


    @Select("select * from orders where id = #{orderId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class,
                    one = @One(select = "fun.luomo.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class,
                    one = @One(select = "fun.luomo.dao.IMemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "fun.luomo.dao.ITravellerDao.findByOrdersId"))


    })
    Orders findById(String orderId) throws Exception;
}
