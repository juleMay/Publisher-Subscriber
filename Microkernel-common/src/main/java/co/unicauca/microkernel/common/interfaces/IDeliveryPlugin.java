package co.unicauca.microkernel.common.interfaces;

import co.unicauca.microkernel.common.entities.Delivery;

public interface IDeliveryPlugin {

    /**
     * Establece el costo de envi­o en dolares.
     *
     * @param delivery envi­o
     * @return costo del envi­o
     */
    double calculateCost(Delivery delivery);

}
