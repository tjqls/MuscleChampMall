package MuscleChampMall.Review.Service;

import MuscleChampMall.Base.Exception.DataNotFoundException;
import MuscleChampMall.Review.Entity.Review;
import MuscleChampMall.Review.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

  private final ReviewRepository reviewRepository;

  public List<Review> getAll() {
   return this.reviewRepository.findAll();
  }

  public Review findById(Long id) {
    Optional<Review> review = this.reviewRepository.findById(id);
    if (review.isPresent()){
      return review.get();
    } throw new DataNotFoundException("review not found");
  }
}
