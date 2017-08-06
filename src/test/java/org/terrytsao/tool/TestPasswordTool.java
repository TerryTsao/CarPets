package org.terrytsao.tool;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPasswordTool {

	@Test
	public void test() {
		String hashed = PasswordTool.hashpw("dxy");
		System.out.println(hashed);

		assertTrue(PasswordTool.checkpw("dxy", hashed));
	}

}
