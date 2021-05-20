package as.edu.utn.frba.dds.qmp.dominio.sugerencia.generadorSugerencias;

import as.edu.utn.frba.dds.qmp.dominio.Atuendo;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneradorSugerencias {
  public List<Atuendo> generadorSugerenciasDesde(List<Prenda> prendasAptas) {
    // Si, se que esta feo el repetir 3 veces lo mismo. Intente hacerlo con un Predicate como parametro
    // de una funcion llamada prendaCumple y que haga el filter dandole test al predicate, pero me parecio
    // mucho mas feo y engorroso que lo que esta abajo :(
    Set<Prenda> prendasSuperiores = prendasAptas.stream().filter(Prenda::esParteSuperior).collect(Collectors.toSet());
    Set<Prenda> prendasInferiores = prendasAptas.stream().filter(Prenda::esParteInferior).collect(Collectors.toSet());
    Set<Prenda> calzados = prendasAptas.stream().filter(Prenda::esCalzado).collect(Collectors.toSet());
    Set<Prenda> accesorios = prendasAptas.stream().filter(Prenda::esAccesorio).collect(Collectors.toSet());
    return Sets
      .cartesianProduct(prendasSuperiores, prendasInferiores, calzados, accesorios)
      .stream()
      .map((list) -> new Atuendo(list.get(0), list.get(1), list.get(2), list.get(3)))
      .collect(Collectors.toList());
  }
}
