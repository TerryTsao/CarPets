package org.terrytsao.tool;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordTool {

	public static String hashpw(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public static boolean checkpw(String plaintext, String hashed) {
		return BCrypt.checkpw(plaintext, hashed);
	}
}
