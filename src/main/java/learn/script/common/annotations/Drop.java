package script.common.annotations;

import java.lang.annotation.*;

/**
 * Created by flysLi on 2018/12/17.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Drop {
    String type() default "";
}
