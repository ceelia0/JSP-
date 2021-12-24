package utils;

public class validate {
  public static boolean checkPass(String inputPass, String userPass) {
    if (inputPass.equals(userPass)) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean checkPerm(int role) {
    if (role == 0) { //管理员 admin
      return true;
    } else {
      return false;
    }
  }
}
