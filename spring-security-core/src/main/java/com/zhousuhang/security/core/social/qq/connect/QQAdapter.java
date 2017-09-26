package com.zhousuhang.security.core.social.qq.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import com.zhousuhang.security.core.social.qq.api.QQ;
import com.zhousuhang.security.core.social.qq.api.QQUserInfo;

public class QQAdapter implements ApiAdapter<QQ>{

	@Override
	public UserProfile fetchUserProfile(QQ api) {
		return null;
	}

	@Override
	public void setConnectionValues(QQ api, ConnectionValues values) {
		QQUserInfo userInfo = api.getUserInfo();
		values.setDisplayName(userInfo.getNickname());
		values.setImageUrl(userInfo.getFigureurl_1());
		values.setProfileUrl(null);
		values.setProviderUserId(userInfo.getOpenId());
	}

	@Override
	public boolean test(QQ api) {
		return true;
	}

	@Override
	public void updateStatus(QQ api, String arg1) {
		
	}

}
