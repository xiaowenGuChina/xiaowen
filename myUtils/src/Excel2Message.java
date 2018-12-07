import com.sun.deploy.util.ArrayUtil;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.Scanner;

public class Excel2Message {
    public static void main(String[] args) throws TransformerException, ParserConfigurationException {

        ArrayList list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            String text = scanner.nextLine().trim();
            if ("".equals(text))
            {
                break;
            }

            list.add(text.split("[^a-zA-Z\\_]")[0]);
            list.add(text.split("[^a-zA-Z\\_]")[1]);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)+"-");
        }
        Java2xml java2xml = new Java2xml();
        String[] array = (String[]) list.toArray(new String[list.size()]);
        java2xml.createXml(array);
    }

}
