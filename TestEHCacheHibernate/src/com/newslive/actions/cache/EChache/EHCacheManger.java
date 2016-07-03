package com.newslive.actions.cache.EChache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class EHCacheManger {

	private static Cache newsCache ;
	
	private static EHCacheManger manager = new EHCacheManger();

	private EHCacheManger() {
		//URL url = getClass().getResource("/config/ehcache.xml");
				EHCacheManger.newsCache = CacheManager.getInstance().getCache("com.newslive.actions.db.entity.News");
	}

	public static Cache getCache() {
		return EHCacheManger.newsCache;
	}

}
