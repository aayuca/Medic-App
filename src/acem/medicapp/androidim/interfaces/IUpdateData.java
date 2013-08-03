package acem.medicapp.androidim.interfaces;
import acem.medicapp.androidim.types.FriendInfo;
import acem.medicapp.androidim.types.MessageInfo;


public interface IUpdateData {
	public void updateData(MessageInfo[] messages, FriendInfo[] friends, FriendInfo[] unApprovedFriends, String userKey);

}
