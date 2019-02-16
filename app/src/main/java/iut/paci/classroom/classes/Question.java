package iut.paci.classroom.classes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Question {




    //les methodes de la classe Friend

    public static Question getFriendFromJson(String json){
        Gson gson = new Gson();
        Question friend = gson.fromJson(json, Question.class);
        return friend;
    }

    public static List<Question> getListOfFriendsFromJson(String json){
        Gson gson = new Gson();
        Type type = new TypeToken<List<Question>>(){}.getType();
        List<Question> friends = gson.fromJson(json, type);
        return friends;
    }
}
