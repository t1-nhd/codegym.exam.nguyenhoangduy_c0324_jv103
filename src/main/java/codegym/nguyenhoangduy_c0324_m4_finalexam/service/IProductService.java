package codegym.nguyenhoangduy_c0324_m4_finalexam.service;

import codegym.nguyenhoangduy_c0324_m4_finalexam.model.Product;
import codegym.nguyenhoangduy_c0324_m4_finalexam.model.ProductSearchDTO;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void save(Product product);
    void detele(Long id);
    List<Product> getProductsSearch(ProductSearchDTO search);
}
