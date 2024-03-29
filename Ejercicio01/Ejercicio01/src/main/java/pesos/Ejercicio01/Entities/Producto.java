package pesos.Ejercicio01.Entities;
import pesos.Ejercicio01.enumeration.TipoProducto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Producto")
@Data
@NoArgsConstructor
@Builder



public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Tipo")
    @Enumerated(EnumType.STRING)
    private TipoProducto tipo;

    @Column(name="TiempoEstimadoCocina")
    private int tiempoEstimadoCocina;
    @Column(name="Denominacion")
    private String denominacion;
    @Column(name="PrecioVenta")
    private double precioVenta;
    @Column(name="precioCompra")
    private double precioCompra;
    @Column(name="StocKActual")
    private int stockActual;
    @Column(name="StockMinimo")
    private int stockMinimo;
    @Column(name="UnidadMedida")
    private String unidadMedida;
    @Column(name="receta")
    private String receta;



        public Producto(Long id, TipoProducto tipo, int tiempoEstimadoCocina, String denominacion, double precioVenta, double precioCompra, int stockActual, int stockMinimo, String unidadMedida, String receta) {
            this.id = id;
            this.tipo = tipo;
            this.tiempoEstimadoCocina = tiempoEstimadoCocina;
            this.denominacion = denominacion;
            this.precioVenta = precioVenta;
            this.precioCompra = precioCompra;
            this.stockActual = stockActual;
            this.stockMinimo = stockMinimo;
            this.unidadMedida = unidadMedida;
            this.receta = receta;
        }
}
