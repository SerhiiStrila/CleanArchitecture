package com.strila.petproject.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Serhii Strila on 1/11/17
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationScope {

}
