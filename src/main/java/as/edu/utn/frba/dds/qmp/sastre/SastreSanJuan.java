package as.edu.utn.frba.dds.qmp.sastre;

import as.edu.utn.frba.dds.qmp.prenda.BorradorPrenda;
import as.edu.utn.frba.dds.qmp.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.prenda.TipoDePrenda;
import as.edu.utn.frba.dds.qmp.prenda.material.Color;
import as.edu.utn.frba.dds.qmp.prenda.material.TipoDeMaterial;

public class SastreSanJuan extends Sastre {

  @Override
  protected Prenda fabricarParteSuperior() {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.CHOMBA);
    borrador.colorPrincipal(new Color(0, 255, 0));
    borrador.tipoMaterial(TipoDeMaterial.PIQUE);
    return borrador.confirmar();
  }

  @Override
  protected Prenda fabricarParteInferior() {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.PANTALON);
    borrador.colorPrincipal(new Color(125, 125, 125));
    borrador.tipoMaterial(TipoDeMaterial.ACETATO);
    return borrador.confirmar();
  }

  @Override
  protected Prenda fabricarCalzado() {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.ZAPATILLAS);
    borrador.colorPrincipal(new Color(255, 255, 255));
    borrador.tipoMaterial(TipoDeMaterial.TELA);
    return borrador.confirmar();
  }
}
