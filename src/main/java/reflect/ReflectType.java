package reflect;

import utils.CommonUtils;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 反射的类型
 *
 * @Author: wuxiaobing
 * @Date 2017/12/25
 **/
public class ReflectType<K extends Serializable & Cloneable> {
    public Map<String, Person> map;
    public Map.Entry<String, Person> entry;
    public K k;
    public K[] kArr;
    public List<K>[] kListArr;
    private List<? extends Number> listNum;
    private List<? super String> listStr;

    private static Class clazz = ReflectType.class;

    public <T> T test(T t) {
        return t;
    }

    /**
     * ParameterizedType(参数化类型),代表整个泛型
     *
     * @throws NoSuchFieldException
     */
    public static void testParameterizedType() throws NoSuchFieldException {
        Field field = clazz.getDeclaredField("map");
        Type ptType = field.getGenericType();//获得字段的type
        if (ptType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) ptType;
            CommonUtils.print("RawType---->" + type.getRawType().getTypeName());
            CommonUtils.print("OwnerType---->" + type.getOwnerType());
            CommonUtils.print("ActualTypeArguments---->");
            for (Type type2 : type.getActualTypeArguments()) {
                CommonUtils.print(type2.getTypeName());
            }
        }
        ParameterizedType type1 = (ParameterizedType) clazz.getDeclaredField("entry").getGenericType();
        CommonUtils.print("OwnerType---->" + type1.getOwnerType().getTypeName());
    }

    /**
     * TypeVariable(类型变量),代表泛型中变量的类型
     *
     * @throws NoSuchFieldException
     * @throws NoSuchMethodException
     */
    public static void testTypeVariable() throws NoSuchFieldException, NoSuchMethodException {
        Type vtType = clazz.getDeclaredField("k").getGenericType();
        if (vtType instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) vtType;
            CommonUtils.print(typeVariable);
            CommonUtils.print("Bounds---->");
            //获得当前类型的上限类型
            for (Type type : typeVariable.getBounds()) {
                CommonUtils.print(type);
            }
            //返回声明泛型的地方
            CommonUtils.print("GenericDeclaration---->" + typeVariable.getGenericDeclaration());
        }

        Type type = clazz.getMethod("test", Object.class).getGenericReturnType();
        if (type instanceof TypeVariable) {
            CommonUtils.print(type.getTypeName());
            TypeVariable typeVariable = (TypeVariable) type;
            //返回声明泛型的地方
            CommonUtils.print(typeVariable.getGenericDeclaration());
        }
    }

    /**
     * 泛型数组类型
     *
     * @throws NoSuchFieldException
     */
    public static void testGenericArrayType() throws NoSuchFieldException {
        Type type = clazz.getDeclaredField("kArr").getGenericType();
        if (type instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type;
            //返回泛型数组中元素的Type类型
            CommonUtils.print(genericArrayType.getGenericComponentType());
        }
    }

    /**
     * 通配的泛型
     *
     * @throws NoSuchFieldException
     */
    public static void testWildcardType() throws NoSuchFieldException {
        Type type1 = clazz.getDeclaredField("listStr").getGenericType();
        if (type1 instanceof ParameterizedType) {
            ParameterizedType genericArrayType = (ParameterizedType) type1;
            //获得通配符类型
            Type[] types = genericArrayType.getActualTypeArguments();
            CommonUtils.print("UpperBounds---->");
            for (Type type2 : types) {
                if (type2 instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type2;
                    System.out.println(Arrays.asList(wildcardType.getLowerBounds()));
                }
            }
        }

    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        testParameterizedType();
        testTypeVariable();
        testGenericArrayType();
        testWildcardType();
    }
}

class Person {
    private String id;
    private String name;
}
