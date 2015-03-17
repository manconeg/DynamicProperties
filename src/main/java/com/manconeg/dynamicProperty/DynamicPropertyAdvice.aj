package com.manconeg.dynamicProperty;

import java.lang.reflect.Field;

public aspect DynamicPropertyAdvice {
    pointcut dynamicPropertyField(): get(@DynamicProperty String *.*);

    before(DynamicProperty dynamicProperty): dynamicPropertyField() && @annotation(dynamicProperty) {
        String value = DynamicProperties.getProperty(dynamicProperty.value());
        if(value == null) value = "";

        try {
            Object targetObject = thisJoinPoint.getThis();
            Field field = targetObject.getClass().getDeclaredField(thisJoinPoint.getSignature().getName());
            boolean isAccessible = field.isAccessible();

            field.setAccessible(true);
            field.set(targetObject, value);
            field.setAccessible(isAccessible);
        } catch(NoSuchFieldException e) {
            e.printStackTrace();
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
