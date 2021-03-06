package com.bob.test.controller;

import java.io.UnsupportedEncodingException;

import com.bob.test.config.BaseControllerTest;
import org.junit.Test;


/**
 * @since 2017年3月21日 下午7:09:02
 * @version $Id$
 * @author JiangJibo
 *
 */
public class ExceptionControllerTest extends BaseControllerTest {

	/* (non-Javadoc)
	 * @see com.bob.test.config.BaseControllerTest#init()
	 */
	@Override
	protected void init() {

	}

	@Test
	public void testExceptionResolver() throws UnsupportedEncodingException {
		String result = this.getRequest("/exception", "");
		result = new String(result.getBytes(), "UTF-8");
		System.out.println("异常信息为:[" + result + "]");
	}

}
