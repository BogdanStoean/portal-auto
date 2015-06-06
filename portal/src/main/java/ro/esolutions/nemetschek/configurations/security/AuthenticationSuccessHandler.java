package ro.esolutions.nemetschek.configurations.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ro.esolutions.nemetschek.security.token.TokenProvider;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: marius
 * Date: 4/16/15
 * Time: 3:13 PM
 */

@Component
public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

	private final ObjectMapper mapper;

	@Resource
	private TokenProvider inMemoryTokenProvider;

	@Value("${broker.domain_name}")
	private String domainName;

	@Autowired
	public AuthenticationSuccessHandler(MappingJackson2HttpMessageConverter messageConverter) {
		this.mapper = messageConverter.getObjectMapper();
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		String token = inMemoryTokenProvider.createToken();
		addTokenToCookie(response, token);
		Writer out = response.getWriter();

		mapper.writeValue(out, authentication);
	}

	private void addTokenToCookie(HttpServletResponse response, String token) {
		Cookie authToken = new Cookie("authToken", token);

		if (!StringUtils.isEmpty(domainName)) {
			authToken.setDomain(domainName);
		}
		response.addCookie(authToken);
	}

}
