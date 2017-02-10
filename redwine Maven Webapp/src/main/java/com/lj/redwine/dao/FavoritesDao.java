package com.lj.redwine.dao;

import java.util.List;



import org.apache.ibatis.annotations.Param;

import com.lj.redwine.pojo.Favorites;
import com.lj.redwine.pojo.Redwine;
import com.lj.redwine.pojo.User;

public interface FavoritesDao {
	//添加我的收藏
	public boolean addFavorites(Favorites favorites);
			
	//通过id查询我的收藏
	public Favorites queryFavoritesById(int id);
			
	//删除我的收藏  
	public boolean deleteFavorites(int id); 
		    
	//根据我的收藏id查询用户
	public User queryUserByFavoritesId(int id);
		
	//根据我的收藏id查询红酒
	public Redwine queryFavoritesByRedWineId(int id);
		
	//查询所有我的收藏
	public List<Favorites> findAllFavorites();
	
	//根据用户id查询我的收藏
	public List<Favorites> queryFavoritesByUserId(int id);
	
	//查询红酒在我的收藏是否存在
	public Favorites findFavorites(@Param(value="redwine_id") int redwine_id, @Param(value="user_id") int user_id);
}
