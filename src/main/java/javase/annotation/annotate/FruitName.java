package javase.annotation.annotate;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 水果名称注解
 */
@Target(FIELD) //注解用于什么地方
@Retention(RUNTIME) //什么时候使用该注解
@Documented  //注解是否将包含在JavaDoc中
public @interface FruitName {
    String value() default "";
}