package rabbitmq;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitConnection {
    private static Connection connection;
    private static ConnectionFactory factory;
    private static String hostPorts = "10.206.19.188:5672";
    private static String username = "admin";
    private static String password = "admin123";

    static {
        Address[] addrArr = getAddRess();
        factory = new ConnectionFactory();
        factory.setAutomaticRecoveryEnabled(true);
        factory.setVirtualHost("/");
        factory.setUsername(username);
        factory.setPassword(password);
        try {
            connection = factory.newConnection(addrArr);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static Address[] getAddRess() {
        String[] hostPortsAddr = hostPorts.split(",");
        Address[] addrArr = new Address[hostPortsAddr.length];
        for (int i = 0, length = hostPortsAddr.length; i < length; i++) {
            addrArr[i] = parserAddressStr(hostPortsAddr[i]);
        }
        return addrArr;
    }

    private static Address parserAddressStr(String str) {
        return new Address(str.split(":")[0],
                Integer.valueOf(str.split(":")[1]));
    }

    public static Connection getConnection() {
        return connection;
    }
}
