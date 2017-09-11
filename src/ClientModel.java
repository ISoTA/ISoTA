import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientModel
{

	private Long id;

	public Long getID()
	{
		return this.id;
	}

	private Integer revisionNum; // OKPO

	public Integer getRevisionNum()
	{
		return this.revisionNum;
	}

	public void setRevisionNum(Integer newRevisionNum)
	{
		this.revisionNum = newRevisionNum;
	}

	private Date registrationDate;

	public Date getRegistrationDate()
	{
		return this.registrationDate;
	}

	public void setRegistrationDate(Date newRegistrationDate)
	{
		this.registrationDate = newRegistrationDate;
	}

	private String adress;

	public String getAdress()
	{
		return this.adress;
	}

	public void setAdress(String newAdress)
	{
		this.adress = newAdress;
	}

	private String FIO;

	public String getFIO()
	{
		return this.FIO;
	}

	public void setFIO(String newFIO)
	{
		this.FIO = newFIO;
	}

	private Integer UID;

	public Integer getUID()
	{
		return this.UID;
	}

	public void setUID(Integer newUID)
	{
		this.UID = newUID;
	}

	private Integer phoneNumber;

	public Integer getPhoneNumber()
	{
		return this.phoneNumber;
	}

	public void setPhoneNumber(Integer newPhoneNumber)
	{
		this.phoneNumber = newPhoneNumber;
	}

	// юр лица

	private String directorFIO;

	public String getDirectorFIO()
	{
		return this.directorFIO;
	}

	public void setDirectorFIO(String newDirectorFIO)
	{
		this.directorFIO = newDirectorFIO;
	}

	private Integer directorUID;

	public Integer getDirectorUID()
	{
		return this.directorUID;
	}

	public void setDirectorUID(Integer newDirectorUID)
	{
		this.directorUID = newDirectorUID;
	}

	private String directorAdress;

	public String getDirectorAdress()
	{
		return this.directorAdress;
	}

	public void setDirectorAdress(String newDirectorAdress)
	{
		this.directorAdress = newDirectorAdress;
	}
	
	private Integer directorNumber;
	
	public Integer getDirectorNumber()
	{
		return this.directorNumber;
	}
	
	public void setDirectorNumber(Integer newDirectorNumber)
	{
		this.directorNumber = newDirectorNumber;
	}
	
	
	private Integer capitalSum;

	public Integer getCapitalSum()
	{
		return this.capitalSum;
	}

	public void setCapitalSum(Integer newCapitalSum)
	{
		this.capitalSum = newCapitalSum;
	}

	
}
