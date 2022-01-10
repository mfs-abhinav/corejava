package com.abhi.reflection;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class MyPrinter {
	private static final long serialVersionUID = 3438430366597490630L;

	private static final Set<Class<?>> WRAPPER_TYPES = new HashSet<Class<?>>() {
		{

			add(Boolean.class);
			add(Character.class);
			add(Byte.class);
			add(Short.class);
			add(Integer.class);
			add(Long.class);
			add(Float.class);
			add(Double.class);
			add(String.class);
		}
	};

	public static String printAllFields(Object object) throws IllegalArgumentException, IllegalAccessException {

		Class<?> classObject = object.getClass();

		StringBuilder printer = new StringBuilder();

		printer.append(object.getClass().getName());
		printer.append("[ ");

		Field[] fields = classObject.getDeclaredFields();
		int fieldsLength = fields.length;

		for (int i = 0; i < fieldsLength; i++) {

			Field field = fields[i];
			field.setAccessible(true);

			if (i != 0) {
				printer.append(", ");
			}

			if (field.getType().isPrimitive()) {

				printer.append(field.getName());
				printer.append(" : ");
				printer.append(field.get(object));
			} else {

				Object childObject = field.get(object);

				if (WRAPPER_TYPES.contains(childObject.getClass())) {

					printer.append(field.getName());
					printer.append(" : ");
					printer.append(String.valueOf(field.get(object)));
				} else {
					printer.append(printAllFields(childObject));
				}
			}
		}

		printer.append("]");

		return printer.toString();
	}
}