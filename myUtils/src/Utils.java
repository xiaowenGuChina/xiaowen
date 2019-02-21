import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Utils {
    public static List  map2List(Map map) {
        List values = new ArrayList();
        Iterator it = map.keySet().iterator();

        while(it.hasNext()) {
            values.add(map.get(it.next().toString()));
        }
        return values;
    }

    /**
     *
     * 功能描述: 答应完整错误信息
     *
     * @param:
     * @return:
     * @author: guxw
     * @date: 2019/2/21 16:30
     */
    public static void main(String[] args) {
        try {
            String aa = "";
            System.out.println(aa.substring(3));

        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw, true));
            String str = sw.toString();
            System.out.println("==========");

            System.out.println(str);
        }
    }
}
