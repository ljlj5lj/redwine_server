package com.lj.redwine.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lj.redwine.dao.FavoritesDao;
import com.lj.redwine.pojo.Favorites;
import com.lj.redwine.pojo.Redwine;
import com.lj.redwine.pojo.User;
import com.lj.redwine.service.FavoritesService;

@Service("favoritesService")
public class FavoritesServiceImpl implements FavoritesService {
	@Resource
	FavoritesDao favoritesDao;

	public boolean addFavorites(Favorites favorites) {
		// TODO Auto-generated method stub
		return this.favoritesDao.addFavorites(favorites);
	}

	public Favorites queryFavoritesById(int id) {
		// TODO Auto-generated method stub
		return this.favoritesDao.queryFavoritesById(id);
	}

	public boolean deleteFavorites(int id) {
		// TODO Auto-generated method stub
		return this.favoritesDao.deleteFavorites(id);
	}

	public User queryUserByFavoritesId(int id) {
		// TODO Auto-generated method stub
		return this.favoritesDao.queryUserByFavoritesId(id);
	}

	public Redwine queryFavoritesByRedWineId(int id) {
		// TODO Auto-generated method stub
		return this.favoritesDao.queryFavoritesByRedWineId(id);
	}

	public List<Favorites> findAllFavorites() {
		// TODO Auto-generated method stub
		return this.favoritesDao.findAllFavorites();
	}

	public List<Favorites> queryFavoritesByUserId(int id) {
		// TODO Auto-generated method stub
		return this.favoritesDao.queryFavoritesByUserId(id);
	}

	public Favorites findFavorites(int redwine_id, int user_id) {
		// TODO Auto-generated method stub
		return this.favoritesDao.findFavorites(redwine_id, user_id);
	}
	
}
