package localhost.devValidation.valid;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Stream;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckDateLogic implements ConstraintValidator<CheckDate, String> {

  private String[] formats;

  @Override
  public void initialize(CheckDate checkDate) {
    formats = checkDate.formats();
  }

  @Override
  public boolean isValid(String date, ConstraintValidatorContext cvc) {
    if (date == null || Objects.equals(date, "")) {
      return true;
    }
    return Stream.of(formats).anyMatch(format -> check(date, format));
  }

  private boolean check(String dateString, String format) {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      Date date = sdf.parse(dateString);
      if (Objects.equals(dateString, sdf.format(date))) {
        return true;
      }
    } catch (Exception ignored) {
    }
    return false;
  }
}
