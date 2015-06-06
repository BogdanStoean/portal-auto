package ro.rocknrolla.portal_auto.security;

import org.springframework.security.core.context.SecurityContextHolder;

public final class CurrentAuthenticatedUser {

	private CurrentAuthenticatedUser() {
	}

	public static String getUsername() {
		if(SecurityContextHolder.getContext() == null){
			return null;
		}
		if(SecurityContextHolder.getContext().getAuthentication() == null){
			return null;
		}
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
