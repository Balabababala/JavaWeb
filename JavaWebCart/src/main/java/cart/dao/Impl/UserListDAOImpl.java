package cart.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cart.dao.BaseDao;
import cart.dao.UserListDAO;
import cart.model.entity.User;

public class UserListDAOImpl extends BaseDao implements UserListDAO{

	@Override
	public List<User> findAllUser() {
		List<User> users=new ArrayList<User>();
		String sql ="select id,username,hash_password,hash_salt,email,completed from user";
		try (PreparedStatement pstmt=conn.prepareStatement(sql)){
			try (ResultSet rs=pstmt.executeQuery()){
				if(rs.next()) {
					User user= new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setHashPassword(rs.getString("hash_password"));
					user.setHashSalt(rs.getString("hash_salt"));
					user.setEmail(rs.getString("email"));
					user.setCompleted(rs.getBoolean("completed"));
					
					users.add(user);
				}
				return users;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
