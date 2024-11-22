package com.apostle.blogging_platform_api.validations;

import com.apostle.blogging_platform_api.enums.PostStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostStatusValidation implements ConstraintValidator<ValidPostStatus, String> {
    @Override
    public boolean isValid(String postStatus, ConstraintValidatorContext constraintValidatorContext) {
        List<String> postStatusEnums= Arrays.asList("DRAFT", "PUBLISH");
        return postStatusEnums.contains(postStatus) ;
    }
}
