package MuscleChampMall.Review.Entity;

import MuscleChampMall.Base.BaseEntity;
import MuscleChampMall.Member.Entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Review extends BaseEntity {

  private String content;

  private Double starScore;

  @ManyToOne
  private Member author;
}
