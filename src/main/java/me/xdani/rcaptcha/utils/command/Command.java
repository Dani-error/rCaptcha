package me.xdani.rcaptcha.utils.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
public @interface Command {
    String usage() default "";

    String description() default "";

    String name();

    String[] aliases() default {};

    boolean inGameOnly() default true;

    String permission() default "";
}

