package kr.park.nhnpre.util;

import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016-12-22.
 */
public class EmailCheck {
    public static boolean checkEmail(String email){
        if(email == null) {
            return false;
        }
        return Pattern.matches(
                "[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+",
                email.trim());
    }
}
