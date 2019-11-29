package API.reflect;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo01 {

    /**
     * 1. getFields()方法和getDeclaredFields ()方法的区别
     * getFields()：获得某个类的所有的公共（public）的字段，包括父类中的字段。
     * getDeclaredFields()：获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
     * 同样类似的还有getConstructors()和getDeclaredConstructors()、getMethods()和getDeclaredMethods()，
     * 这两者分别表示获取某个类的方法、构造函数。
     */

    public static void main(String[] args) throws Exception {
        board1();

    }

    static void board() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class classObj = SubEntity.class;
        Object obj1 = classObj.getDeclaredConstructor().newInstance();
    }


    public static void board1() throws Exception {
        String classFullName = "API.reflect.Entity";
        JSONObject valueMap = new JSONObject();
        valueMap.put("name", "riden");
        valueMap.put("age", 20);
        Object res = setFieldValueByReflect2(classFullName, valueMap);
        System.out.println();
    }


    static Object setFieldValueByReflect2(String className, JSONObject valueMap) throws Exception {
        // 获取类对象
        Class classObj = Class.forName(className);
        // 创建实例
        Object obj = classObj.getDeclaredConstructor().newInstance();
        Field[] fields = classObj.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            String methodName = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            String fieldType = field.getType().toString();
            String insertValue = valueMap.getString(fieldName);
            if(insertValue == null){
                continue;
            }
            Method method;
            switch (fieldType){
                case "class java.lang.String":
                    method = classObj.getDeclaredMethod(methodName,String.class);
                    method.invoke(obj,insertValue);
                    break;
                case "class java.lang.Integer":
                    method = classObj.getDeclaredMethod(methodName,Integer.class);
                    method.invoke(obj,Integer.valueOf(insertValue));
                    break;
            }
        }
        return obj;
    }

    /**
     * 创建Class对象的方式
     */
    static void getClassObj() throws Exception {
        // 1. 实例对象.getClass()
        Entity entity = new Entity();
        Class c1 = entity.getClass();

        // 2. 通过类的class属性: Entity.class
        Class c2 = Entity.class;

        // 3. 通过Class.forName(),会抛出异常
        Class c3 = Class.forName("API.reflect.Entity");
    }

    /**
     * 通过反射创建实例对象的方式
     */
    static void createInstanceByReflect() throws Exception {
        Class classObj = Entity.class;
        // 1. 通过Class对象的newInstance()方法,这种方式只会调用类的无参构造器,否者InstantiationException
        Object obj = classObj.newInstance();

        // 2. 使用Class对象获取Constructor对象,然后通过该对象调用newInstance()方法创建对象
        // 2.1 无参构造器
        Object obj2 = classObj.getDeclaredConstructor().newInstance();
        // 2.2 有参构造器
        Object obj3 = classObj.getDeclaredConstructor(String.class, Integer.class).newInstance("riden", 20);
        // 2.2.1
        Class[] parameters = new Class[]{String.class, Integer.class};
        Object obj4 = classObj.getDeclaredConstructor(parameters).newInstance("benzene", 22);


    }


    /**
     * 通过反射对类属性注入值(含父类)
     *
     * @param className 类全名
     * @param valueMap  值集合
     * @return
     */
    public static Object setFieldValueByReflect(String className, JSONObject valueMap) {
        try {
            // 获取类对象
            Class<?> classObj = Class.forName(className);
            // 获取该类父类类对象
            Class<?> superClassObj = classObj.getSuperclass();
            Object obj = classObj.getDeclaredConstructor().newInstance();
            Field[] fields = classObj.getDeclaredFields();
            Field[] superClassFields = superClassObj.getDeclaredFields();
            List<Field> fieldObjs = new ArrayList<>();
            for (int i = 0; i < fields.length; i++) {
                fieldObjs.add(fields[i]);
            }
            for (int i = 0; i < superClassFields.length; i++) {
                fieldObjs.add(superClassFields[i]);
            }
            List<String> fieldListCamelCase = new ArrayList<>();
            for (int i = 0; i < fieldObjs.size(); i++) {
                String fieldName = fieldObjs.get(i).getName();
                fieldListCamelCase.add(fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            }
            for (int i = 0; i < fieldObjs.size(); i++) {
                Field field = fieldObjs.get(i);
                String methodName = "set" + fieldListCamelCase.get(i);
                String type = field.getGenericType().toString();
                Object setValue = valueMap.get(field.getName().toUpperCase());
                if (setValue == null) {
                    continue;
                }
                String setValue_ = setValue.toString();
                Method method = null;
                switch (type) {
                    case "class java.lang.String":
                        method = classObj.getMethod(methodName, String.class);
                        method.invoke(obj, setValue_);
                        break;
                    case "class java.lang.Long":
                        method = classObj.getMethod(methodName, Long.class);
                        method.invoke(obj, Long.parseLong(setValue_));
                        break;
                    case "class java.math.BigDecimal":
                        method = classObj.getMethod(methodName, BigDecimal.class);
                        method.invoke(obj, new BigDecimal(setValue_));
                        break;
                    case "class java.util.Date":
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(setValue_);
                        method = classObj.getMethod(methodName, Date.class);
                        method.invoke(obj, date);
                        break;
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
