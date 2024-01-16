package MuscleChampMall.Review.Controller;

import MuscleChampMall.Member.Entity.Member;
import MuscleChampMall.Member.Service.MemberService;
import MuscleChampMall.Review.Entity.Review;
import MuscleChampMall.Review.Service.ReviewService;
import MuscleChampMall.Review.dto.ReviewCreateForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

  private final ReviewService reviewService;

  private final MemberService memberService;

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

  @GetMapping("/create")
  public String create(ReviewCreateForm reviewCreateForm) {
    return "review/create";
  }

  @PostMapping("/create")
  public String create(@Valid ReviewCreateForm reviewCreateForm,
                       BindingResult bindingResult,
                       Principal principal) {

    if (bindingResult.hasErrors()) return "review/create";

    Member author = this.memberService.findByUsername(principal.getName());

    Review review = this.reviewService.create(reviewCreateForm, author);

    return "redirect:/review/list";
  }

  @GetMapping("/modify/{id}")
  public String modify(@PathVariable("id") Long id,
                       ReviewCreateForm reviewCreateForm) {
    return "review/create";
  }

  @PostMapping("/modify/{id}")
  public String modify(@Valid ReviewCreateForm reviewCreateForm,
                       @PathVariable("id") Long id,
                       BindingResult bindingResult,
                       Principal principal) {

    if (bindingResult.hasErrors()) return "review/create";

    Member author = this.memberService.findByUsername(principal.getName());

    Review review = this.reviewService.findById(id);

    this.reviewService.modifyValidate(author, review);

    this.reviewService.modify(review, reviewCreateForm);

    return String.format("redirect:/review/detail/%s", id);
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") Long id,
                       Principal principal) {

    Review review = this.reviewService.findById(id);

    Member author = this.memberService.findByUsername(principal.getName());

    this.reviewService.deleteValidate(review, author);

    this.reviewService.delete(review);

    return "redirect:/review/list";

  }
}
