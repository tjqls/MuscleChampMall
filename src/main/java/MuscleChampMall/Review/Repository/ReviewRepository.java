package MuscleChampMall.Review.Repository;

import MuscleChampMall.Review.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review , Long> {
}
