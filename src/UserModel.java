import java.sql.*;

public class UserModel
{
	private Integer id;

	public Integer getID()
	{
		return this.id;
	}

	private String login;

	public String getLogin()
	{
		return this.login;
	}

	public void setLogin(String newLogin)
	{
		this.login = newLogin;
	}

	private String password;
}