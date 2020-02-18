package fun.luomo.service.impl;

import com.github.pagehelper.PageHelper;
import fun.luomo.dao.IOrderDao;
import fun.luomo.domain.Orders;
import fun.luomo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/15 16:56
 */
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Orders> findAll(int page, int pageSize) throws Exception {

        PageHelper.startPage(page, pageSize);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(String orderId) throws Exception {

        return orderDao.findById(orderId);
    }
}
