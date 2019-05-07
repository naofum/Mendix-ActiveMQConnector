package activemqconnector.helper;

import org.apache.activemq.ActiveMQConnectionFactory;
import activemqconnector.proxies.AMQConfiguration;

public class ActiveMQConnectorHelper {
	public static ActiveMQConnectionFactory createConnectionFactory(AMQConfiguration configuration) {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(configuration.getEndpoint());
		String username = configuration.getUsername();
		if (username != null) factory.setUserName(username);
		String password = configuration.getPassword();
		if (password != null) factory.setPassword(password);
		return factory;
	}
}
