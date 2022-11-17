package localhost.devValidation.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import localhost.devValidation.valid.CheckDate;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Person {

  @NotNull
  @NotBlank
  private String name;

  @CheckDate(formats = {"dd.MM.yyyy"})
  private String birthday;
}
