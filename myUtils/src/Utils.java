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
}
