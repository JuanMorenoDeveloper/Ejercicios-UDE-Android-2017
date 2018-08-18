package uy.edu.ude.app.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by juan on 07/07/17.
 */

public class UserCredentialDb {
  private Map<String, String> users = new HashMap<>();
  public UserCredentialDb(){
    //K->User, V->Password
    users.put("cat", "black");
    users.put("dog", "brown");
    users.put("bird", "blue");
  }
  public Map<String, String> getUsers(){
    return users;
  }
  public boolean exists(String user){
    return users.containsKey(user);
  }
  public String getPasswordFrom(String user) throws Exception{
    if(exists(user)){
      return users.get(user);
    }
    throw new Exception("User not found");
  }
}
