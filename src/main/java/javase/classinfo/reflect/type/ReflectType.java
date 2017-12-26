package javase.classinfo.reflect.type;

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
     * 1.Type[] getActualTypeArguments();--返回表示此类型实际类型参数的 Type 对象的数组
     * 2.Type getRawType();--返回 Type 对象，表示声明此类型的类或接口
     * 3.Type getOwnerType();--返回 Type 对象，表示此类型是其成员之一的类型
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
        CommonUtils.print("OwnerType---->" + type1.getOwnerType());
    }

    /**
     * TypeVariable(类型变量),代表泛型中变量的类型
     * 1.Type[] getBounds();--获得该类型变量的上限
     * 2.D getGenericDeclaration();--获取声明该类型变量实体(即申明泛型的地方，为一个Class, Constructor或 Method)
     * 3.String getName();--获取类型变量在源码中定义的名称
     * 4.AnnotatedType[] getAnnotatedBounds();
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
     * 1.Type getGenericComponentType();--返回泛型数组中元素的Type类型
     *
     * @throws NoSuchFieldException
     */
    public static void testGenericArrayType() throws NoSuchFieldException {
        Type type = clazz.getDeclaredField("kArr").getGenericType();
        if (type instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type;
            //返回泛型数组中元素的Type类型
            CommonUtils.print("GenericComponentType---->");
            CommonUtils.print(genericArrayType.getGenericComponentType());
        }
    }

    /**
     * 通配的泛型
     * 1.Type[] getUpperBounds();--获得泛型的上边界
     * 2.Type[] getLowerBounds();--获得泛型的下边界
     *
     * @throws NoSuchFieldException
     */
    public static void testWildcardType() throws NoSuchFieldException {
        Type type1 = clazz.getDeclaredField("listStr").getGenericType();
        if (type1 instanceof ParameterizedType) {
            ParameterizedType genericArrayType = (ParameterizedType) type1;
            //获得通配符类型
            Type[] types = genericArrayType.getActualTypeArguments();
            CommonUtils.print("LowerBounds---->");
            for (Type type2 : types) {
                if (type2 instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type2;
                    System.out.println(Arrays.asList(wildcardType.getLowerBounds()));
                }
            }
        }
    }

    public static void gitTest(){
        System.out.println("this is a test");
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        testParameterizedType();
        testTypeVariable();
        testGenericArrayType();
        testWildcardType();
        gitTest();
    }
}

class Person {
    private String id;
    private String name;
}
