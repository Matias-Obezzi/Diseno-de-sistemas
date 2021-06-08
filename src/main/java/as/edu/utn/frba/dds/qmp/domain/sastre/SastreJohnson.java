package as.edu.utn.frba.dds.qmp.domain.sastre;

import as.edu.utn.frba.dds.qmp.domain.prenda.BorradorPrenda;
import as.edu.utn.frba.dds.qmp.domain.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.domain.prenda.TipoDePrenda;
import as.edu.utn.frba.dds.qmp.domain.prenda.material.Color;
import as.edu.utn.frba.dds.qmp.domain.prenda.material.TipoDeMaterial;

public class SastreJohnson extends Sastre {

  @Override
  protected Prenda fabricarParteSuperior() throws Exception {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.CAMISA_MANGAS_LARGAS);
    borrador.colorPrincipal(new Color(255, 255, 255));
    borrador.tipoMaterial(TipoDeMaterial.TELA);
    return borrador.confirmar();
  }

  @Override
  protected Prenda fabricarParteInferior() throws Exception {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.PANTALON);
    borrador.colorPrincipal(new Color(0, 0, 0));
    borrador.tipoMaterial(TipoDeMaterial.TELA);
    return borrador.confirmar();
  }

  @Override
  protected Prenda fabricarCalzado() throws Exception {
    BorradorPrenda borrador = new BorradorPrenda(TipoDePrenda.ZAPATOS);
    borrador.colorPrincipal(new Color(0, 0, 0));
    borrador.tipoMaterial(TipoDeMaterial.CUERO);
    return borrador.confirmar();
  }
}
