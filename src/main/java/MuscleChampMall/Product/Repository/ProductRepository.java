package MuscleChampMall.Product.Repository;

import MuscleChampMall.Product.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , Long> {
}
