package ro.esolutions.nemetschek.configurations.security;

import org.springframework.security.core.context.SecurityContextHolder;

public final class CurrentAuthenticatedUser {

	private CurrentAuthenticatedUser() {
	}

	public static String getUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
