package pesos.Ejercicio01.Entities;
import pesos.Ejercicio01.enumeration.FormadePago;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;



import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Factura")
@Data
@Builder



public class Factura implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Numero")
    private int numero;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="Fecha")
    public Date fecha;
    @Column(name="Descuento")
    private Double descuento;
    @Column(name="Total")
    private int total;
    @Enumerated(EnumType.STRING)
    private FormadePago formadePago;

    public Factura(){

    }

    public Factura(Long id, int numero, Date fecha, double descuento, int total, FormadePago formadePago, Pedido pedido) {
        this.id = id;
        this.numero = numero;
        this.fecha = fecha;
        this.descuento = descuento;
        this.total = total;
        this.formadePago = formadePago;
        this.pedido = pedido;
    }

    @OneToOne(mappedBy = "factura")

    private Pedido pedido;
}
