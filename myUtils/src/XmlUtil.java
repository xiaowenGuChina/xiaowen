import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;


public class XmlUtil {
    public static String xml2JSON(byte[] xml) throws  DocumentException {
        org.dom4j.Document document = DocumentHelper.parseText(new String(xml));
        JSONObject json = new JSONObject();
        Element root =document.getRootElement();
        json.put(root.getName(), iterateElement(root));

        String replace = json.toString().replace("[", "");
        String replace1 = replace.replace("]", "");
        return replace1;
    }

    private static JSONObject iterateElement(Element element) {
        List node = element.elements();
        Element et = null;
        JSONObject obj = new JSONObject();
        JSONArray list = null;
        for (int i = 0; i < node.size(); i++) {
            list = new JSONArray();
            et = (Element) node.get(i);
            if (et.getTextTrim().equals("")) {
                if (et.elements().size() == 0) {
                    continue;
                }
                if (obj.containsKey(et.getName())) {
                    list = (JSONArray) obj.get(et.getName());
                }
                list.add(iterateElement(et));
                obj.put(et.getName(), list);
            } else {
                if (obj.containsKey(et.getName())) {
                    list = (JSONArray) obj.get(et.getName());
                }
                list.add(et.getTextTrim());
                obj.put(et.getName(), list);
            }
        }
        return obj;
    }
}
