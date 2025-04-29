package cart.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cart.dao.BaseDAO;
import cart.dao.ProductDAO;
import cart.model.entity.Product;

public class ProductDAOImpl extends BaseDAO implements ProductDAO{

	@Override
	public List<Product> findAllProducts() {
		String sql="select product_id,product_name,price,qty,image_base64 from product";
		try (PreparedStatement pstmt=conn.prepareStatement(sql)){
			try(ResultSet rs=pstmt.executeQuery()){
				List <Product> products=new ArrayList<Product>();
				while(rs.next()) {
					Product product=new Product();
					product.setProductID(rs.getInt("product_id"));
					product.setProductName(rs.getString("product_name"));
					product.setPrice(rs.getInt("price"));
					product.setQty(rs.getInt("qty"));
					product.setImageBase64(rs.getString("image_base64"));
					products.add(product);
				}
				return products;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void add(Product product) {
		String sql="insert into product(product_name,price,qty,image_base64) values(?,?,?,?)" ;
		try (PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setInt(3, product.getQty());
			pstmt.setString(4, product.getImageBase64());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer productID) {
		String sql="delete from product where product_id =?" ;
		try (PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setInt(1, productID);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
