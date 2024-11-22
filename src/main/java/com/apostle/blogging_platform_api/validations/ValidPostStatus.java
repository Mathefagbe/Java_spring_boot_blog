package com.apostle.blogging_platform_api.validations;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PostStatusValidation.class)
public @interface ValidPostStatus {
    String message() default "Invalid post status. Allowed values are DRAFT and PUBLISH.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
