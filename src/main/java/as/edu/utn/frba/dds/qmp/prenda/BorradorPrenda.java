package as.edu.utn.frba.dds.qmp.prenda;

import as.edu.utn.frba.dds.qmp.prenda.material.Color;
import as.edu.utn.frba.dds.qmp.prenda.material.Material;
import as.edu.utn.frba.dds.qmp.prenda.material.TipoDeMaterial;
import as.edu.utn.frba.dds.qmp.prenda.material.Trama;

public class BorradorPrenda {
  private TipoDePrenda tipoDePrenda;
  private Material material;

  public BorradorPrenda(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = tipoDePrenda;
  }

  public TipoDePrenda tipo() {
    return this.tipoDePrenda;
  }

  public void tipo(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = tipoDePrenda;
  }

  public Categoria categoria() {
    return this.tipoDePrenda.categoria();
  }

  public Material material() {
    return this.material;
  }

  public void material(Material material) {
    this.material = material;
  }

  public Trama trama() {
    return this.material.trama();
  }

  public void trama(Trama trama) {
    this.material.trama(trama);
  }

  public TipoDeMaterial tipoMaterial() {
    return this.material.tipo();
  }

  public void tipoMaterial(TipoDeMaterial tipoDeMaterial) {
    try {
      this.tipoDePrenda.validarMaterial(tipoDeMaterial);
      this.material.tipo(tipoDeMaterial);
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
    }
  }

  public Color colorPrincipal() {
    return this.material.colorPrincipal();
  }

  public void colorPrincipal(Color color) {
    this.material.colorPrincipal(color);
  }

  public Color colorSecundario() {
    return this.material.colorSecundario();
  }

  public void colorSecundario(Color color) {
    this.material.colorSecundario(color);
  }

  public Prenda confirmar() {
    try {
      tipoDePrenda.validarMaterial(this.material.tipo());
      return new Prenda(this.tipoDePrenda, this.material);
    } catch (Exception exception) {
      System.out.println(exception.getMessage());
      return null;
    }
  }
}
