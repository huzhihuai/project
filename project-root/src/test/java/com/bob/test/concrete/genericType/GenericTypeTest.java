/**
 * Copyright(C) 2017 MassBot Co. Ltd. All rights reserved.
 *
 */
package com.bob.test.concrete.genericType;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bob.config.mvc.model.CacheModel;
import org.junit.Test;
import org.springframework.core.GenericCollectionTypeResolver;
import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;


/**
 * @since 2017年3月2日 下午3:50:59
 * @version $Id$
 * @author JiangJibo
 *
 */
@SuppressWarnings("deprecation")
public class GenericTypeTest {

	public Map<String, CacheModel> map;

	private List<CacheModel> list;

	public List<CacheModel> getStudents() {
		return new ArrayList<CacheModel>();
	}

	public Map<String, CacheModel> getMap() {
		return new HashMap<String, CacheModel>();
	}

	@Test
	public void testMethodGenericType() {
		Method method = ReflectionUtils.findMethod(GenericTypeTest.class, "getStudents");
		Type[] types = method.getGenericExceptionTypes();
		for (Type type : types) {
			System.out.println(type.getClass());
			System.out.println(type.getTypeName());
		}
	}

	@Test
	public void testGetGenericType() {
		Method method = ReflectionUtils.findMethod(GenericTypeTest.class, "getStudents");
		Class<?> valueType = GenericCollectionTypeResolver.getCollectionReturnType(method);
		System.out.println(valueType);
	}

	@Test
	public void testGetMapKeyType() {
		Method method = ReflectionUtils.findMethod(GenericTypeTest.class, "getMap");
		Class<?> keyType = GenericCollectionTypeResolver.getMapKeyReturnType(method);
		Class<?> valueType = GenericCollectionTypeResolver.getMapValueReturnType(method);
		System.out.println(keyType + ":" + valueType);
	}

	@Test
	public void testGetType() {
		ResolvableType type = ResolvableType.forField(ReflectionUtils.findField(getClass(), "map"));
		System.out.println(type.asMap()); // java.util.Map<java.lang.String,com.bob.student.model.Student>
		System.out.println(type.getGeneric(0).resolve()); // class java.lang.String
		System.out.println(type.getGeneric(1).resolve()); // class com.bob.student.model.Student
		System.out.println(type.getGeneric(1)); // com.bob.student.model.Student
	}

	@Test
	public void testGenericList() {
		ResolvableType type = ResolvableType.forField(ReflectionUtils.findField(getClass(), "list"));
		System.out.println(type.as(List.class)); // java.util.List<com.bob.student.model.Student>
		System.out.println(type.getGeneric(0)); // com.bob.student.model.Student
		System.out.println(type.getGeneric(0).resolve()); // class com.bob.student.model.Student
	}

	@Test
	public void testResolvabeMethpd() {
		Method method = ReflectionUtils.findMethod(GenericTypeTest.class, "getMap");
		ResolvableType type = ResolvableType.forMethodReturnType(method).as(Map.class);
		System.out.println(type.getGeneric(0).resolve());
		System.out.println(type.getGeneric(1).resolve());
	}

}
