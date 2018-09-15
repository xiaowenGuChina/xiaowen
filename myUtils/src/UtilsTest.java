import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UtilsTest {

    @Test
    public void map2List() {
        HashMap map = new HashMap();
        map.put("asd","123");
        map.put("wsx",456);
        List list = Utils.map2List(map);
        System.out.println(list);

    }
}