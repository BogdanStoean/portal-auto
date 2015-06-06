package ro.rocknrolla.portal_auto.security;

import org.springframework.security.core.context.SecurityContextHolder;

public final class CurrentAuthenticatedUser {

	private CurrentAuthenticatedUser() {
	}

	public static String getUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
