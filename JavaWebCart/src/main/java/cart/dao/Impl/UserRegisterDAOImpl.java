package cart.dao.Impl;

import java.sql.PreparedStatement;

import cart.model.entity.User;

public class UserRegisterDAOImpl extends BaseDao implements UserRegisterDAO{

	@Override
	public int addUser(User user) {
		String sql ="insert int user(username,hash_password,hash_salt,email) value(?,?,?,?))";
		try (PreparedStatement pstmt =conn.prepareStatement(sql)){
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getHashPassword());
			pstmt.setString(3, user.getHashSalt());
			pstmt.setString(4, user.getEmail());
			
			int rowcount = pstmt.executeUpdate();//執行更新
			return rowcount; //1 表成功
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int emailConfirmOK(String username) {
		String sql ="UPDATE user SET completed = true WHERE username=?";
		try(PreparedStatement pstmt =conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			
			int rowcount = pstmt.executeUpdate();//執行更新
			return rowcount; //1 表成功
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	
}
