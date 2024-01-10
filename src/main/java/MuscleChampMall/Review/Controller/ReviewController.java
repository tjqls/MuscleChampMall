package MuscleChampMall.Review.Controller;

import MuscleChampMall.Review.Entity.Review;
import MuscleChampMall.Review.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

  private final ReviewService reviewService;

  @GetMapping("/list")
  public String list(Model model){

    List<Review> reviewList = this.reviewService.getAll();

    model.addAttribute("reviewList", reviewList);

    return "review/list";
  }

  @GetMapping(value = "/detail/{id}")
  public String detail(Model model,
                       @PathVariable("id") Long id){

    Review review = this.reviewService.findById(id);

    model.addAttribute("review", review);

    return "review/detail";
  }
}
