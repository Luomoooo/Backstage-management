package fun.luomo.service.impl;

import fun.luomo.dao.IProductDao;
import fun.luomo.domain.Product;
import fun.luomo.service.IProductService;
import fun.luomo.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/14 16:49
 */

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        product.setId(UUIDUtils.getUUID());
        System.out.println(product);
        productDao.save(product);
    }
}
