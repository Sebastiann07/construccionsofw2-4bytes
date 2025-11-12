package app.infrastructure.adapter.in.rest.auth.response;

public class TokenResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private long expiresIn;
    private String username;
    private String role;

    public TokenResponse() {}

    public TokenResponse(String accessToken, long expiresIn, String username, String role) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.username = username;
        this.role = role;
    }

    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }
    public long getExpiresIn() { return expiresIn; }
    public void setExpiresIn(long expiresIn) { this.expiresIn = expiresIn; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}