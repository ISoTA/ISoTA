import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ReportModel
{

	private Long id;

	public Long getID()
	{
		return this.id;
	}

	public void setID(Long newID)
	{
		this.id = newID;
	}

	private Long clientID;

	public Long getClientID()
	{
		return this.clientID;
	}

	public void setClientID(Long newClientID)
	{
		this.clientID = newClientID;
	}

	private Date operationDate;

	public Date getOperationDate()
	{
		return this.operationDate;
	}

	public void setOperationDate(Date newOperationDate)
	{
		this.operationDate = newOperationDate;
	}

	private String kod;

	public String getKod()
	{
		return this.kod;
	}

	public void setKod(String newKod)
	{
		this.kod = newKod;
	}

	private Float sum;

	public Float getSum()
	{
		return this.sum;
	}

	public void setSum(float newSum)
	{
		this.sum = newSum;
	}

	private Float paid;

	public Float getPaid()
	{
		return this.paid;
	}

	public void setPaid(float newPaid)
	{
		this.paid = newPaid;
	}

	private Float returned;

	public Float getReturned()
	{
		return this.returned;
	}

	public void setReturned(float newReturned)
	{
		this.returned = newReturned;
	}

	private Float overpayment;

	public Float getOverpayment()
	{
		return this.overpayment;
	}

	public void setOverpayment(float newOverpayment)
	{
		this.overpayment = newOverpayment;
	}