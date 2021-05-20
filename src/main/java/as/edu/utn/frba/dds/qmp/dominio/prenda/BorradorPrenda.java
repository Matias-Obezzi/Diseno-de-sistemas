package as.edu.utn.frba.dds.qmp.dominio.prenda;

import as.edu.utn.frba.dds.qmp.dominio.prenda.material.Color;
import as.edu.utn.frba.dds.qmp.dominio.prenda.material.Material;
import as.edu.utn.frba.dds.qmp.dominio.prenda.material.TipoDeMaterial;
import as.edu.utn.frba.dds.qmp.dominio.prenda.material.Trama;

public class BorradorPrenda {
  private TipoDePrenda tipoDePrenda;
  private Material material;

  public BorradorPrenda(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = tipoDePrenda;
  }

  public void tipo(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = tipoDePrenda;
  }

  public void material(Material material) {
    this.material = material;
  }

  public void trama(Trama trama) {
    this.material.trama(trama);
  }

  public void tipoMaterial(TipoDeMaterial tipoDeMaterial) throws Exception {
    this.tipoDePrenda.validarMaterial(tipoDeMaterial);
    this.material.tipo(tipoDeMaterial);
  }

  public void colorPrincipal(Color color) {
    this.material.colorPrincipal(color);
  }

  public void colorSecundario(Color color) {
    this.material.colorSecundario(color);
  }

  public Prenda confirmar() throws Exception {
    tipoDePrenda.validarMaterial(this.material.tipo());
    return new Prenda(this.tipoDePrenda, this.material);
  }
}
