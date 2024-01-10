package MuscleChampMall.Review.Service;

import MuscleChampMall.Review.Entity.Review;
import MuscleChampMall.Review.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

  private final ReviewRepository reviewRepository;

  public List<Review> getAll() {
   return this.reviewRepository.findAll();
  }

}
