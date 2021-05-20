package as.edu.utn.frba.dds.qmp.dominio.prenda;

import as.edu.utn.frba.dds.qmp.dominio.prenda.material.Color;
import as.edu.utn.frba.dds.qmp.dominio.prenda.material.Material;
import as.edu.utn.frba.dds.qmp.dominio.prenda.material.TipoDeMaterial;
import as.edu.utn.frba.dds.qmp.dominio.prenda.material.Trama;

public class Prenda {
  private TipoDePrenda tipo;
  private Material material;

  public Prenda(TipoDePrenda tipo, Material material) {
    this.tipo = tipo;
    this.material = material;
  }

  public TipoDePrenda tipo() {
    return tipo;
  }

  public Categoria categoria() {
    return tipo.categoria();
  }

  public Material material() {
    return material;
  }

  public Trama trama() {
    return material.trama();
  }

  public TipoDeMaterial tipoMaterial() {
    return material.tipo();
  }

  public Color colorPrincipal() {
    return material.colorPrincipal();
  }

  public Color colorSecundario() {
    return material.colorSecundario();
  }
}
