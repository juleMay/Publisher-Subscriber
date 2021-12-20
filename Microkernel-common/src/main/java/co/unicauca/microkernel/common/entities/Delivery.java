package co.unicauca.microkernel.common.entities;

/**
 * Envio
 * @author Libardo, Julio
 */
public class Delivery {

    private Product product;
    private double distance;
    /**
     * Código del país donde será entregado el producto.
     * */
    private String countryCode;

    private String address;
    private String city;
    private double price;

    public Delivery(Product product, double distance, String countryCode) {
        this.product = product;
        this.distance = distance;
        this.countryCode = countryCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
