package MuscleChampMall.Review.Service;

import MuscleChampMall.Base.Exception.DataNotFoundException;
import MuscleChampMall.Member.Entity.Member;
import MuscleChampMall.Review.Entity.Review;
import MuscleChampMall.Review.Repository.ReviewRepository;
import MuscleChampMall.Review.dto.ReviewCreateForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
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

  public Review create(ReviewCreateForm reviewCreateForm, Member author) {

    Review review = Review.builder()
        .content(reviewCreateForm.getContent())
        .starScore(reviewCreateForm.getStarScore())
        .author(author)
        .build();
    this.reviewRepository.save(review);

    return review;
  }

  public void modifyValidate(Member author, Review review) {

    if (review == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 게시글입니다.");
    }

    if (!author.getUsername().equals(review.getAuthor().getUsername())) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정 권한이 없습니다.");
    }
  }

  public void modify(Review review, ReviewCreateForm reviewCreateForm) {

    review = review.toBuilder()
        .content(reviewCreateForm.getContent())
        .starScore(reviewCreateForm.getStarScore())
        .modifyDate(LocalDateTime.now())
        .build();

    this.reviewRepository.save(review);
  }
}
