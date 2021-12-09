package inactiveClasses;

import inactiveClasses.Product;

import java.util.Collection;

public interface ProductService {

    public abstract void createProduct(Product product);
    public abstract void updateProduct(Integer Id, Product product);
    public abstract void deleteProduct(Integer Id);
    public abstract Collection<Product> getProducts();
}
