package fun.luomo.service;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import fun.luomo.domain.Orders;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/15 16:55
 */
public interface IOrderService {

    List<Orders> findAll(int page,int pageSize) throws Exception;

    Orders findById(String orderId) throws Exception;
}
