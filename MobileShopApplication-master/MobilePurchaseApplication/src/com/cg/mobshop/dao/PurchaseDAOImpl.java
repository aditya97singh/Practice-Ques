package com.cg.mobshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;

public class PurchaseDAOImpl implements PurchaseDAO {
	Connection connection;
	public PurchaseDAOImpl() throws PurchaseException {
		// TODO Auto-generated constructor stub
		connection = DBConnection.getConnection();
	}
	
	public int generateId()
	{
		int id = 0;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select id_gen.nextval from dual");
			if(rs.next())
				id = rs.getInt(1);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return id;
	}
	
	@Override
	public int addPurchaseDetails(PurchaseDetails pr) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO purchasedetails VALUES" + "(?,?,?,?,sysdate,?)";
		try 
		{
			PreparedStatement ps = connection.prepareStatement(sql);
			int id = generateId();
			ps.setInt(1, id);
			ps.setString(2, pr.getCustName());
			ps.setString(3, pr.getMailId());
			ps.setString(4, pr.getPhoneNo());
			ps.setInt(5, pr.getMobileId());
			int rowcount = ps.executeUpdate();
			if (rowcount == 1)
				return id;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
}
	
	@Override
	public ArrayList<Mobile> getMobileList() {
		// TODO Auto-generated method stub
		String sql = "SELECT mobileid, name, price, quantity FROM mobiles";
		ArrayList<Mobile> list = new ArrayList<>();
		try {
			Statement ps = connection.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next())
			{
				Mobile mob = new Mobile();
				mob.setMobileId(rs.getInt("mobileId"));
				mob.setName(rs.getString("name"));
				mob.setPrice(rs.getDouble("price"));
				mob.setQuantity(rs.getInt("quantity"));
				list.add(mob);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public ArrayList<Mobile> getMobileList(int min, int max) {
		// TODO Auto-generated method stub
		ArrayList<Mobile> list = new ArrayList<>();
		String sql = "select mobileid, name, price, quantity from mobiles where price between ? and ?";
		try{
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, min);
			st.setInt(2, max);
			ResultSet rs = st.executeQuery();
			
			while (rs.next())
			{
				Mobile mob = new Mobile();
				mob.setMobileId(rs.getInt("mobileId"));
				mob.setName(rs.getString("name"));
				mob.setPrice(rs.getDouble("price"));
				mob.setQuantity(rs.getInt("quantity"));
				list.add(mob);
			}	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Mobile updateMobileDetails(Mobile mob) {
		// TODO Auto-generated method stub
		String sql = " UPDATE mobiles SET price = ?, quantity = ? where mobileid = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, mob.getPrice());
			ps.setInt(2, mob.getQuantity());
			ps.setInt(3, mob.getMobileId());
			
			int row = ps.executeUpdate();
			if (row == 0)
				throw new PurchaseException("Mobile id is invalid ... ");
			return mob;
		} 
		catch(SQLException e)
		{
			e.printStackTrace();
		} catch (PurchaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mob;
	}
}
