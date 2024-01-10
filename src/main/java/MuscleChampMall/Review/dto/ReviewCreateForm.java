package MuscleChampMall.Review.dto;

import MuscleChampMall.Member.Entity.Member;
import lombok.Getter;

@Getter
public class ReviewCreateForm {

  private String content;

  private Double starScore;

  private Member author;
}
