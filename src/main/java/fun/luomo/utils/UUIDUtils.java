package fun.luomo.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @author Luomo
 * @since 2020/2/15 13:36
 */
public class UUIDUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Test
    public void fun1() {
        System.out.println(getUUID());
    }

}
