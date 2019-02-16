package iut.paci.classroom.classes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Friend {




    //les methodes de la classe Friend

    public static Friend getFriendFromJson(String json){
        Gson gson = new Gson();
        Friend friend = gson.fromJson(json, Friend.class);
        return friend;
    }

    public static List<Friend> getListOfFriendsFromJson(String json){
        Gson gson = new Gson();
        Type type = new TypeToken<List<Friend>>(){}.getType();
        List<Friend> friends = gson.fromJson(json, type);
        return friends;
    }
}
