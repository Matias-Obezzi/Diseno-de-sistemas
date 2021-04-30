package as.edu.utn.frba.dds.qmp.sastre;

import as.edu.utn.frba.dds.qmp.prenda.BorradorPrenda;
import as.edu.utn.frba.dds.qmp.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.prenda.TipoDePrenda;
import as.edu.utn.frba.dds.qmp.prenda.material.Color;
import as.edu.utn.frba.dds.qmp.prenda.material.TipoDeMaterial;

public class SastreJohnson extends Sastre {

  @Override
  protected Prenda fabricarParteSuperior() {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.CAMISA_MANGAS_LARGAS);
    borrador.colorPrincipal(new Color(255, 255, 255));
    borrador.tipoMaterial(TipoDeMaterial.TELA);
    return borrador.confirmar();
  }

  @Override
  protected Prenda fabricarParteInferior() {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.PANTALON);
    borrador.colorPrincipal(new Color(0, 0, 0));
    borrador.tipoMaterial(TipoDeMaterial.TELA);
    return borrador.confirmar();
  }

  @Override
  protected Prenda fabricarCalzado() {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.ZAPATOS);
    borrador.colorPrincipal(new Color(0, 0, 0));
    borrador.tipoMaterial(TipoDeMaterial.CUERO);
    return borrador.confirmar();
  }
}
