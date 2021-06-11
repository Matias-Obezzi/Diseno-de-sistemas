package as.edu.utn.frba.dds.qmp.services.sugerencia;

import as.edu.utn.frba.dds.qmp.domain.Atuendo;
import as.edu.utn.frba.dds.qmp.domain.Sugerencia;
import as.edu.utn.frba.dds.qmp.domain.prenda.Prenda;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class GeneradorSugerencias {
  public abstract Sugerencia sugerencias(List<Prenda> prendas);

  public Sugerencia generadorSugerenciasDesde(List<Prenda> prendasAptas) {
    Set<Prenda> prendasSuperiores = prendasAptas.stream().filter(Prenda::esParteSuperior).collect(Collectors.toSet());
    Set<Prenda> prendasInferiores = prendasAptas.stream().filter(Prenda::esParteInferior).collect(Collectors.toSet());
    Set<Prenda> calzados = prendasAptas.stream().filter(Prenda::esCalzado).collect(Collectors.toSet());
    Set<Prenda> accesorios = prendasAptas.stream().filter(Prenda::esAccesorio).collect(Collectors.toSet());
    List<Atuendo> atuendos = Sets
            .cartesianProduct(prendasSuperiores, prendasInferiores, calzados, accesorios)
            .stream()
            .map((list) -> new Atuendo(list.get(0), list.get(1), list.get(2), list.get(3)))
            .collect(Collectors.toList());
    return new Sugerencia(atuendos);
  }
}
