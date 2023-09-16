package pesos.Ejercicio01;
import pesos.Ejercicio01.Entities.*;
import pesos.Ejercicio01.enumeration.EstadoPedido;

import pesos.Ejercicio01.enumeration.TipoEnvio;
import pesos.Ejercicio01.enumeration.FormadePago;
import pesos.Ejercicio01.enumeration.TipoProducto;
import pesos.Ejercicio01.Repositories.ClienteRepository;
import pesos.Ejercicio01.Repositories.FacturaRepository;
import pesos.Ejercicio01.Repositories.PedidoRepository;
import pesos.Ejercicio01.Repositories.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Ejercicio01Application {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	RubroRepository rubroRepository;







	public static void main(String[] args) {

		SpringApplication.run(Ejercicio01Application.class, args);
		System.out.println("Estoy funcionado hoy");

	}
	@Bean
	CommandLineRunner init (ClienteRepository clienteRepository, PedidoRepository pedidoRepository, FacturaRepository facturaRepository, RubroRepository rubroRepository ) {
		return args -> {
			System.out.println("................Estoy funcionando.......");

			Cliente cliente = Cliente.builder()
					.nombre("Magali")
					.apellido("Gil")
					.telefono("261203189")
					.email("magalisa@gmail.com")
					.build();



			Domicilio domicilio1 = Domicilio.builder()
					.calle("Viamonte")
					.localidad("Lujan de Cuyo")
					.numero("3049")
					.build();

			Pedido pedido1 = Pedido.builder()
					.estado(EstadoPedido.INICIADO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.build();

			Pedido pedido2 = Pedido.builder()
					.estado(EstadoPedido.PREPARACION)
					.tipoEnvio(TipoEnvio.RETIRAR)
					.build();

			double descuento1 = 100.00; // O
			double precioSinDescuento1 = 400; //

			double totalConDescuento1 = precioSinDescuento1 - descuento1;

			double descuento2 = 4590.0; //
			double precioSinDescuento2 = 2000; //

			double totalConDescuento2 = precioSinDescuento2 - descuento2;

			cliente.addDomicilio(domicilio1);
			cliente.addPedido(pedido1);
			cliente.addPedido(pedido2);

			clienteRepository.save(cliente);


			DetallePedido detalle1Pedido1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(7000.00)
					.build();
			pedido1.agregarDetallePedido(detalle1Pedido1);

			DetallePedido detalle2Pedido1 = DetallePedido.builder()
					.cantidad(4)
					.subtotal(10000.00)
					.build();
			pedido1.agregarDetallePedido(detalle2Pedido1);

			pedidoRepository.save(pedido1);

			DetallePedido detalle1Pedido2 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(4000.00)
					.build();
			pedido2.agregarDetallePedido(detalle1Pedido2);

			DetallePedido detalle2Pedido2 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(8000.00)
					.build();
			pedido2.agregarDetallePedido(detalle2Pedido2);

			pedidoRepository.save(pedido2);

			Factura factura1 = Factura.builder()
					.numero(001)
					.formadePago(FormadePago.EFECTIVO)
					.descuento(309.00)
					.total(3500)
					.pedido(pedido1)
					.build();

			Factura factura2 = Factura.builder()
					.numero(002)
					.formadePago(FormadePago.TARJETA)
					.descuento(4000.00)
					.total(18000)
					.pedido(pedido2)
					.build();

			pedido1.setDescAplicado(309.00);
			pedido1.setTotal(totalConDescuento1);
			pedido1.setFactura(factura1);
			facturaRepository.save(factura1);
			pedidoRepository.save(pedido1);


			pedido2.setDescAplicado(4000.0);
			pedido2.setTotal(totalConDescuento2);
			pedido2.setFactura(factura2);
			facturaRepository.save(factura2);
			pedidoRepository.save(pedido2);

			Rubro rubro = Rubro.builder()
					.denominacion("Local")
					.build();

			Producto producto1= Producto.builder()
					.tipo(TipoProducto.INSUMO)
					.tiempoEstimadoCocina(28)
					.denominacion("Local")
					.precioVenta(2.00)
					.precioCompra(100)
					.stockActual(8)
					.stockMinimo(3)
					.unidadMedida("kilos")
					.receta("....")
					.build();

			Producto producto2= Producto.builder()
					.tipo(TipoProducto.INSUMO)
					.tiempoEstimadoCocina(21)
					.denominacion("Local")
					.precioVenta(2.00)
					.precioCompra(1.00)
					.stockActual(5)
					.stockMinimo(2)
					.unidadMedida("kilos")
					.receta("....")
					.build();

			rubro.addProducto(producto1);
			rubro.addProducto(producto2);
			rubroRepository.save(rubro);


		};
	}


}

