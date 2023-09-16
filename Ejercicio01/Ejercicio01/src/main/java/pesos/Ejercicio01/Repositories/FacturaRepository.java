package pesos.Ejercicio01.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pesos.Ejercicio01.Entities.Factura;
@Repository
public interface FacturaRepository extends JpaRepository <Factura,Long> {

}
