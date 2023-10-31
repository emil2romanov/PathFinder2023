package bf.softuni.pathfinder.validation.validators;


import bf.softuni.pathfinder.model.dto.binding.UserRegisterBindingModel;
import bf.softuni.pathfinder.validation.annotations.PasswordMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserRegisterBindingModel> {

    private String message;

    @Override
    public void initialize (PasswordMatch constraintAnnotation) {

        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid (UserRegisterBindingModel userRegisterBindingModel, ConstraintValidatorContext context) {

        final String password = userRegisterBindingModel.getPassword();
        final String confirmPassword = userRegisterBindingModel.getConfirmPassword();

        if (password == null && confirmPassword == null) {

            return true;
        } else {

            boolean passwordMatch = password != null && password.equals(confirmPassword);

            if (!passwordMatch) {

                HibernateConstraintValidatorContext hibernateContext =
                        context.unwrap(HibernateConstraintValidatorContext.class);

                hibernateContext
                        .buildConstraintViolationWithTemplate(message)
                        .addPropertyNode("confirmPassword")
                        .addConstraintViolation()
                        .disableDefaultConstraintViolation();
            }

            return passwordMatch;
        }
    }
}