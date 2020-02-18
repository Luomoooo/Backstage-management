package fun.luomo.service;

import fun.luomo.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Luomo
 * @since 2020/2/14 16:45
 */
public interface IProductService {

    public List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
