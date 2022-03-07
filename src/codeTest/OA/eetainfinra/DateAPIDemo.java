//package codeTest.OA.eetainfinra;
//
//import java.lang.reflect.Method;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.Date;
//import java.util.List;
//
//public class DateAPIDemo {
//    public <T> T getMaxDate(List<T> dates) {
//        return (T) dates.stream().map(v -> (Date) v).max(Date::compareTo).get();
//    }
//
//    public static void main(String[] args) throws NoSuchMethodException {
//        Method method = DateAPIDemo.class.getDeclaredMethod("getMaxDate", List.class);
//        Type[] parameterTypes = method.getGenericParameterTypes();
//        Type parameterType = parameterTypes[0];
//        ParameterizedType parameterizedType = (ParameterizedType) parameterizedType;
//        Type[] typeArguments = parameterizedType.getActualTypeArguments();
//        for(Type typeArgument: typeArguments){
//            System.out.println(typeArgument.getTypeName());
//        }
//
//    }
//}
