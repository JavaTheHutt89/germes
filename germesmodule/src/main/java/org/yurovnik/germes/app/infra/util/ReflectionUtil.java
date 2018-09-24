package org.yurovnik.germes.app.infra.util;


import org.yurovnik.germes.app.infra.exception.ConfigurationException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReflectionUtil {

    private ReflectionUtil() {
    }

    public static <T> T createInstance(Class<T> clz)
            throws ConfigurationException {
        try {
            return clz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ConfigurationException(e);
        }
    }

    public static List<String> findSimilarFields(Class<?> clz1, Class<?> clz2)
            throws  ConfigurationException{
        try {
            Field[] fields = clz1.getDeclaredFields();
            List<String> targedFields = Stream.of(clz2.getDeclaredFields())
                    .map(Field::getName)
                    .collect(Collectors.toList());
            return Stream.of(fields)
                    .map(Field::getName)
                    .filter(targedFields::contains)
                    .collect(Collectors.toList());
        }catch (SecurityException ex){
            throw new ConfigurationException(ex);
        }
    }

    public static  void copyFields(Object src, Object dest, List<String> fields)
            throws ConfigurationException {
        Checks.checkParameter(src != null,"Source object os not initialized");
        Checks.checkParameter(dest != null,
                    "Destination object is not initialized");
        try {
            for (String field : fields){
                Field fld = src.getClass().getDeclaredField(field);
                if (fld != null){
                    fld.setAccessible(true);
                    Object value = fld.get(src);
                    Field fldDest = dest.getClass().getDeclaredField(field);
                    if (fldDest != null){
                        fldDest.setAccessible(true);
                        fldDest.set(dest, value);
                    }
                }
            }
        }catch (SecurityException | ReflectiveOperationException | IllegalArgumentException ex){
            throw new ConfigurationException(ex);
        }
    }
}
