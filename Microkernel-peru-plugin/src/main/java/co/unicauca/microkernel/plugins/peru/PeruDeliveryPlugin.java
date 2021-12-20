package co.unicauca.microkernel.plugins.peru;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

public class PeruDeliveryPlugin implements IDeliveryPlugin {

    /**
     * El cálculo de Perú es una mezcla de peso y distancia.
     * pero prima la distancia
     * @param delivery envío
     * @return costo del envío
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();
        double weight = product.getWeight();
        double distance = delivery.getDistance();

        double cost;

        if (distance <= 20) {

            cost = (weight <= 10) ? 2 : 6;

        } else {

            cost = 10;

        }

        return cost;

    }
}
