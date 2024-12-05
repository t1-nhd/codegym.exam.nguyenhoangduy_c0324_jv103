package codegym.nguyenhoangduy_c0324_m4_finalexam.service;

import codegym.nguyenhoangduy_c0324_m4_finalexam.model.Product;
import codegym.nguyenhoangduy_c0324_m4_finalexam.model.ProductSearchDTO;
import codegym.nguyenhoangduy_c0324_m4_finalexam.repository.IProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void detele(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsSearch(ProductSearchDTO search) {
        return null;
    }
}
