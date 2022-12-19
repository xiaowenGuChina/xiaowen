package yaml;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.Map;

/**
 * @author JH
 * @date 2022年12月19日 09:25
 */
public class YamlUtils {
    public static Map<String, Object> yaml2Map(String str) {
        Map<String, Object> resultMap;
        Yaml yaml = new Yaml();
        if(StringUtils.startsWith(str, "---")) {
            Object load = yaml.load(str);
            if(!ObjectUtils.isEmpty(load) && load instanceof List) {
                List<Map<String, Object>> list = (List<Map<String, Object>>) load;
                resultMap = list.get(0);
            } else {
                resultMap = yaml.loadAs(str, Map.class);
            }
        } else {
            resultMap = yaml.loadAs(str, Map.class);
        }
        return resultMap;
    }
}
