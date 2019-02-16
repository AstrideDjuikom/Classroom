package iut.paci.classroom.classes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Answer {




    //les methodes de la classe Friend

    public static Answer getFriendFromJson(String json){
        Gson gson = new Gson();
        Answer friend = gson.fromJson(json, Answer.class);
        return friend;
    }

    public static List<Answer> getListOfFriendsFromJson(String json){
        Gson gson = new Gson();
        Type type = new TypeToken<List<Answer>>(){}.getType();
        List<Answer> friends = gson.fromJson(json, type);
        return friends;
    }
}
