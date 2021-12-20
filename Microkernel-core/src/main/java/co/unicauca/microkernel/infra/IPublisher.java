/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.infra;

/**
 *
 * @author ahurtado
 */
public interface IPublisher {

    /**
     *
     * @param msg
     * Mensaje a ser publicado a través de un servicio de mensajería
     */
    public void publicar(String msg);
}
