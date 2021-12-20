/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.plugins.uruguay.plugin;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

/**
 *
 * @author ahurtado
 */
public class UruguayDeliveryPlugin implements IDeliveryPlugin{

    @Override
    public double calculateCost(Delivery delivery) {
        return 20.0;
    }
    
}
