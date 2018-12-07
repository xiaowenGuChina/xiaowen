import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SSLSupports {

    public static void sslQuery() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, null, null);
        SSLEngine en = context.createSSLEngine();
        System.out
                .println("支持的协议: " + Arrays.asList(en.getSupportedProtocols()));
        System.out.println("启用的协议: " + Arrays.asList(en.getEnabledProtocols()));
        System.out.println("支持的加密套件: "
                + Arrays.asList(en.getSupportedCipherSuites()));
        System.out.println("启用的加密套件: "
                + Arrays.asList(en.getEnabledCipherSuites()));
        System.out.println("支持的协议: " + Arrays.asList(en.getSupportedProtocols()));
        System.out.println("启用的协议: " + Arrays.asList(en.getEnabledProtocols()));
        System.out.println("支持的加密套件: "
                + Arrays.asList(en.getSupportedCipherSuites()));
        System.out.println("启用的加密套件: "
                + Arrays.asList(en.getEnabledCipherSuites()));
    }
}
