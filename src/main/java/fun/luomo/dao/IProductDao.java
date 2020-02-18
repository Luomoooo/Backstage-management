package fun.luomo.dao;

import fun.luomo.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/14 16:46
 */

public interface IProductDao  {

    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;

    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product (id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            " values(#{id},#{productNum},#{productName},#{cityName},#{departureTimeStr},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws  Exception;
}
