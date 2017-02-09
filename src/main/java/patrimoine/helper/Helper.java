package patrimoine.helper;

import javax.servlet.http.HttpSession;

/**
 * Created by LAMOOT Alexandre on 27/01/2017.
 */
public class Helper {

    public static boolean isConnect(HttpSession session){
        boolean isConnect = false;
        if(session.getAttribute("administrator") != null){
            if(!session.getAttribute("administrator").equals(""))
                isConnect = true;
            else
                isConnect = false;
        }else
            isConnect = false;
        return isConnect;
    }
}
