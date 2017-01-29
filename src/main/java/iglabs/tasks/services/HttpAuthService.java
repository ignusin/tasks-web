package iglabs.tasks.services;

import java.security.MessageDigest;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import iglabs.tasks.dao.UserDAO;
import iglabs.tasks.entities.User;

@Component
public class HttpAuthService implements AuthService {
	private final static String NAME_KEY = "tasks-name";
	private final static String TOKEN_KEY = "tasks-token";

	@Autowired
	private UserDAO userDAO;
	
	
	private String md5hash(String source) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(source.getBytes());
			byte[] hash = md5.digest();
			
			StringBuilder sb = new StringBuilder();
			for (byte b: hash) {
				String hex = Integer.toHexString(0xFF & b);
				if (hex.length() == 1) {
					sb.append("0");
				}
				sb.append(hex);
			}
			
			return sb.toString();
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@Override
	public void authenticate(HttpServletRequest httpRequest,
		HttpServletResponse httpResponse, String name, String password) {
		
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
		
		if (StringUtils.isEmpty(password)) {
			throw new IllegalArgumentException("Password cannot be empty");
		}
		
		Cookie nameCookie = new Cookie(NAME_KEY, name);
		nameCookie.setPath(httpRequest.getContextPath());
		
		Cookie tokenCookie = new Cookie(TOKEN_KEY, md5hash(name + ":" + password));
		tokenCookie.setPath(httpRequest.getContextPath());
		
		httpResponse.addCookie(nameCookie);
		httpResponse.addCookie(tokenCookie);
	}
	
	@Override
	@Transactional
	public boolean isAuthenticated(HttpServletRequest httpRequest) {
		Cookie[] cookies = httpRequest.getCookies();
		
		if (cookies == null) {
			return false;
		}
		
		Cookie nameCookie = Stream.of(cookies)
			.filter(x -> NAME_KEY.equals(x.getName()))
			.findFirst()
			.orElse(null);
		
		Cookie tokenCookie = Stream.of(cookies)
			.filter(x -> TOKEN_KEY.equals(x.getName()))
			.findFirst()
			.orElse(null);
		
		if (nameCookie == null || tokenCookie == null) {
			return false;
		}
		
		User user = userDAO.findByName(nameCookie.getValue());
		if (user == null) {
			return false;
		}
		
		String calculatedToken = md5hash(user.getName() + ":" + user.getPassword());
		boolean tokensEqual = StringUtils.equals(calculatedToken, tokenCookie.getValue());
		
		return tokensEqual;
	}
	
	@Override
	public void signOut(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		Cookie nameCookie = new Cookie(NAME_KEY, null);
		nameCookie.setPath(httpRequest.getContextPath());
		nameCookie.setMaxAge(0);
		
		Cookie tokenCookie = new Cookie(TOKEN_KEY, null);
		tokenCookie.setPath(httpRequest.getContextPath());
		tokenCookie.setMaxAge(0);
		
		httpResponse.addCookie(nameCookie);
		httpResponse.addCookie(tokenCookie);
	}
}
