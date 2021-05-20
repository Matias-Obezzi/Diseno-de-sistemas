package as.edu.utn.frba.dds.qmp.dominio.prenda;

import as.edu.utn.frba.dds.qmp.dominio.prenda.material.TipoDeMaterial;
import as.edu.utn.frba.dds.qmp.exceptions.TipoMaterialInvalidoParaCategoriaException;

import java.util.ArrayList;

public enum TipoDePrenda {
  ZAPATOS(
    Categoria.CALZADO,
    new ArrayList<TipoDeMaterial>() {
      {
        add(TipoDeMaterial.ALGODON);
        add(TipoDeMaterial.ACETATO);
        add(TipoDeMaterial.LANA);
        add(TipoDeMaterial.PIQUE);
        add(TipoDeMaterial.TELA);
      }
    }
  ),
  ZAPATILLAS(
    Categoria.CALZADO,
    new ArrayList<TipoDeMaterial>() {
      {
        add(TipoDeMaterial.ALGODON);
        add(TipoDeMaterial.ACETATO);
        add(TipoDeMaterial.LANA);
        add(TipoDeMaterial.PIQUE);
        add(TipoDeMaterial.CUERO);
      }
    }
  ),
  CAMISA_MANGAS_CORTAS(
    Categoria.PARTE_SUPERIOR,
    new ArrayList<TipoDeMaterial>() {
      {
        add(TipoDeMaterial.ACETATO);
        add(TipoDeMaterial.PIQUE);
        add(TipoDeMaterial.CUERO);
      }
    }
  ),
  CAMISA_MANGAS_LARGAS(
    Categoria.PARTE_SUPERIOR,
    new ArrayList<TipoDeMaterial>() {
      {
        add(TipoDeMaterial.ACETATO);
        add(TipoDeMaterial.PIQUE);
        add(TipoDeMaterial.CUERO);
      }
    }
  ),
  CHOMBA(
    Categoria.PARTE_SUPERIOR,
    new ArrayList<TipoDeMaterial>() {
      {
        add(TipoDeMaterial.ACETATO);
        add(TipoDeMaterial.CUERO);
      }
    }
  ),
  PANTALON(
    Categoria.PARTE_INFERIOR,
    new ArrayList<TipoDeMaterial>() {
      {
        add(TipoDeMaterial.PIQUE);
        add(TipoDeMaterial.CUERO);
      }
    }
  );

  private Categoria categoria;
  private ArrayList<TipoDeMaterial> materialesInvalidos;

  TipoDePrenda(Categoria categoria, ArrayList<TipoDeMaterial> materialesInvalidos) {
    this.categoria = categoria;
    this.materialesInvalidos = materialesInvalidos;
  }

  public void validarMaterial(TipoDeMaterial material) throws Exception {
    if (materialesInvalidos.stream().anyMatch(el -> el.equals(material))) {
      throw new TipoMaterialInvalidoParaCategoriaException(material, categoria);
    }
  }

  public Categoria categoria() {
    return categoria;
  }
}
