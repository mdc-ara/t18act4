package es.medac.t18act4;

/**
 *
 * @author asier.ruiz
 */
public class Sabor {
    private int id;
    private String sabor;
    private double precio;

    public Sabor(int id, String s, double p){
        this.id=id;
        this.sabor=s;
        this.precio=p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }    
}
