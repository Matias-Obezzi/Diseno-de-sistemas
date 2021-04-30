package as.edu.utn.frba.dds.qmp.sastre;

import as.edu.utn.frba.dds.qmp.Uniforme;
import as.edu.utn.frba.dds.qmp.prenda.Prenda;

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
