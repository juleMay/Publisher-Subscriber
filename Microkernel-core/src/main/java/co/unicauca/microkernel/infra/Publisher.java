/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.infra;

import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
import co.unicauca.microkernel.common.interfaces.IPublisherPlugin;
import co.unicauca.microkernel.infra.IPublisher;
import co.unicauca.microkernel.plugin.manager.PluginManager;

/**
 *
 * @author ahurtado
 */
public class Publisher {

    public Publisher() {
    }
    
    public void publish(String msg){
        PluginManager manager = PluginManager.getInstance();
        IPublisherPlugin publisher = manager.getPublisherPlugin("publisherTech"); 
        publisher.publish(msg);
    }    
}
