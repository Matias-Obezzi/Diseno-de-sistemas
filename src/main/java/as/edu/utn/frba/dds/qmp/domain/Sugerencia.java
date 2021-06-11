package as.edu.utn.frba.dds.qmp.domain;

import java.util.List;

public class Sugerencia {
  private List<Atuendo> atuendos;

  public Sugerencia(List<Atuendo> atuendos) {
    this.atuendos = atuendos;
  }

  public List<Atuendo> atuendos() {
    return this.atuendos;
  }
}
