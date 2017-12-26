package json.gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/26
 **/
public class ParameterizedTypeImpl implements ParameterizedType {
    private Type raw;
    private Type owner;
    private Type[] args;

    public ParameterizedTypeImpl(Type raw, Type owner,Type[] args) {
        this.raw = raw;
        this.owner = owner;
        this.args = args != null ? args : new Type[0];
    }

    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }

    @Override
    public Type getRawType() {
        return raw;
    }

    @Override
    public Type getOwnerType() {
        return owner;
    }
}
