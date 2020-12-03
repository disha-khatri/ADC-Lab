/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//  in case you geeing JMS factory error go to this link https://stackoverflow.com/questions/34232856/glassfish-error-class-java-lang-runtimeexception

package msbean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Phoenix
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myqueue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MsgBean implements MessageListener {
    
    public MsgBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm=(TextMessage)message;
            System.out.println("Message :"+tm.getText());
        } catch (JMSException ex) {
            Logger.getLogger(MsgBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
