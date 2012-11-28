package enhancer;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class GenericCache {

    private final static Cache<MethodKey, Object> cache = CacheBuilder.newBuilder().maximumSize(100).recordStats().expireAfterWrite(1, TimeUnit.DAYS).build();

    public static void setValue(MethodKey m, Object ret) {
        cache.put(m, ret);
    }

    public static Object getValue(MethodKey m) {
        return cache.getIfPresent(m);
    }
}
