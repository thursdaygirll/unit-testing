package com.utch.practica1;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    void findAll_debeRetornarListaDeProductos() {
        Producto p1 = new Producto(1L, "Laptop", 15999.99);
        Producto p2 = new Producto(2L, "Mouse", 299.50);

        when(productoRepository.findAll()).thenReturn(List.of(p1, p2));

        List<Producto> resultado = productoService.findAll();

        assertThat(resultado).hasSize(2);
        assertThat(resultado)
                .extracting(Producto::getNombre)
                .containsExactly("Laptop", "Mouse");

        verify(productoRepository).findAll();
    }

    @Test
    void create_debeGuardarYRetornarProducto() {
        Producto nuevo = new Producto(null, "Teclado", 549.00);
        Producto guardado = new Producto(1L, "Teclado", 549.00);

        when(productoRepository.save(any(Producto.class))).thenReturn(guardado);

        Producto resultado = productoService.create(nuevo);

        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getNombre()).isEqualTo("Teclado");
        assertThat(resultado.getPrecio()).isEqualTo(549.00);

        verify(productoRepository, times(1)).save(nuevo);
    }

    @Test
    void findAll_debeRetornarListaVacia() {
        when(productoRepository.findAll()).thenReturn(Collections.emptyList());

        List<Producto> resultado = productoService.findAll();

        assertThat(resultado).isEmpty();

        verify(productoRepository).findAll();
    }
}
