package ro.esolutions.nemetschek.security.token.memory;

import org.springframework.stereotype.Component;
import ro.esolutions.nemetschek.configurations.security.CurrentAuthenticatedUser;
import ro.esolutions.nemetschek.security.token.TokenProvider;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by virgil on 4/20/15.
 * for project nemetschek-broker
 */
@Component
public class InMemoryTokenProvider implements TokenProvider {

	/**
	 * key: token </br>
	 * value: username
	 */
	private static Map<String, String> tokenRepository = new HashMap<>();

	@Override
	public synchronized String getUsernameForToken(String token) {
		return tokenRepository.get(token);
	}

	@Override
	public synchronized void removeToken(String token) {
		tokenRepository.remove(token);
	}

	@Override
	public synchronized String createToken() {
		String currentUser = CurrentAuthenticatedUser.getUsername();
		invalidateExistingTokensForUser(currentUser);
		String encodedToken = createEncodedToken();
		tokenRepository.put(encodedToken, CurrentAuthenticatedUser.getUsername());
		return encodedToken;
	}

	@Override
	public void removeTokenForUser(String username) {
		invalidateExistingTokensForUser(username);
	}

	private void invalidateExistingTokensForUser(String currentUser) {
		Map<String, String> newRepository = new HashMap<>();
		if (tokenRepository.containsValue(currentUser)) {
			for (Map.Entry<String, String> token : tokenRepository.entrySet()) {
				if (token.getValue().equals(currentUser)) {
					continue;
				}
				newRepository.put(token.getKey(), token.getValue());
			}
		}
		tokenRepository = newRepository;
	}

	private String createEncodedToken() {
		return encodeToken(UUID.randomUUID().toString());
	}

	private String encodeToken(String token) {
		return Base64.getUrlEncoder().encodeToString(token.getBytes());
	}
}
