package pesos.Ejercicio01.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Cliente")
@Data
@AllArgsConstructor
@Builder





public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "Nombre")
    private String nombre;
    @Column(name="Apellido")
    private String apellido;
    @Column(name= "Telefono")
    private String telefono;
    @Column(name= "Email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn( name= "cliente_id")
    @Builder.Default
    private List<Domicilio> domicilios= new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn( name= "cliente_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    public Cliente(){
    }
    public void addDomicilio (Domicilio domicilio) {
        domicilios.add(domicilio);
    }
    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }





}
