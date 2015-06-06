package ro.esolutions.nemetschek.security.token;

/**
 * Created by virgil on 4/20/15.
 * for project nemetschek-broker
 */
public interface TokenProvider {
	String  getUsernameForToken(String token);

	void removeToken(String token);

	String createToken();

	void removeTokenForUser(String username);
}
