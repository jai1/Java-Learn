package learningSecurity;

import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

public class Main {

	public static void main(String[] args) throws Exception {
	  SSLContext ctx=SSLContext.getInstance("TLS");
	  KeyManagerFactory kmf=KeyManagerFactory.getInstance("SUNX509");
	  KeyStore ks=KeyStore.getInstance("PKCS12");
	  System.out.println("AlgorithName " + kmf.getAlgorithm());
	  System.out.println("Default Algorithm Name " + KeyManagerFactory.getDefaultAlgorithm());
	  System.out.println("Key Store Type " + ks.getType());
	  System.out.println("Default Key Store Type " +KeyStore.getDefaultType());
	}

}


