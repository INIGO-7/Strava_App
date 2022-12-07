package server.gateway;

public interface ILoginGateway {
	public String register(String email, String password); //Password no necesaria, meter el tokenizer de pass en trycatch y obviar
	public String login(String email, String password);
}
