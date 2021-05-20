package as.edu.utn.frba.dds.qmp.dominio.sastre;

import as.edu.utn.frba.dds.qmp.dominio.Atuendo;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;

public abstract class Sastre {
  public Atuendo fabricarUniforme() {
    return new Atuendo(
            this.fabricarParteSuperior(),
            this.fabricarParteInferior(),
            this.fabricarCalzado()
    );
  }

  protected abstract Prenda fabricarParteSuperior();

  protected abstract Prenda fabricarParteInferior();

  protected abstract Prenda fabricarCalzado();
}
