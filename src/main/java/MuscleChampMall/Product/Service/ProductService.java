package MuscleChampMall.Product.Service;

import MuscleChampMall.Product.Entity.Product;
import MuscleChampMall.Product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
}
