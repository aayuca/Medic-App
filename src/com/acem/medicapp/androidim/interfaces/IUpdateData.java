package com.acem.medicapp.androidim.interfaces;
import com.acem.medicapp.androidim.types.FriendInfo;
import com.acem.medicapp.androidim.types.MessageInfo;


public interface IUpdateData {
	public void updateData(MessageInfo[] messages, FriendInfo[] friends, FriendInfo[] unApprovedFriends, String userKey);

}
