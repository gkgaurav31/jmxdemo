package com.test;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class Controller {

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub

	        ObjectName objectName = null;
	        try {
	        	System.out.println("Registering...");
	            objectName = new ObjectName("com.test:type=basic,name=game");
	        } catch (MalformedObjectNameException e) {
	            e.printStackTrace();
	        }
	        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
	        Game gameObj = new Game();
	        try {
	            server.registerMBean(gameObj, objectName);
	        } catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException e) {
	            e.printStackTrace();
	        }
	        
	        System.out.println("Before while loop...");
	        while (true) {
	            // to ensure application does not terminate
	        }
	    }
	
}
