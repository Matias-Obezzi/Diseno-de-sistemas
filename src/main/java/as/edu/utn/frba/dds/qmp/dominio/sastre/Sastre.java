package as.edu.utn.frba.dds.qmp.dominio.sastre;

import as.edu.utn.frba.dds.qmp.dominio.Atuendo;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;

public abstract class Sastre {
  public Uniforme fabricarUniforme() {
    return new Uniforme(
            this.fabricarParteSuperior(),
            this.fabricarParteInferior(),
            this.fabricarCalzado()
    );
  }

  protected abstract Prenda fabricarParteSuperior();

  protected abstract Prenda fabricarParteInferior();

  protected abstract Prenda fabricarCalzado();
}
