package as.edu.utn.frba.dds.qmp.dominio.prenda;

import as.edu.utn.frba.dds.qmp.dominio.prenda.material.TipoDeMaterial;
import as.edu.utn.frba.dds.qmp.exceptions.TipoMaterialInvalidoParaCategoriaException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TipoDePrenda {
  ZAPATOS(
    Categoria.CALZADO,
    Arrays.asList(
      TipoDeMaterial.ALGODON,
      TipoDeMaterial.ACETATO,
      TipoDeMaterial.LANA,
      TipoDeMaterial.PIQUE,
      TipoDeMaterial.CUERO
    )
  ),
  ZAPATILLAS(
    Categoria.CALZADO,
    Arrays.asList(
      TipoDeMaterial.ALGODON,
      TipoDeMaterial.ACETATO,
      TipoDeMaterial.LANA,
      TipoDeMaterial.PIQUE,
      TipoDeMaterial.CUERO
    )
  ),
  CAMISA_MANGAS_CORTAS(
    Categoria.PARTE_SUPERIOR,
    Arrays.asList(
      TipoDeMaterial.ACETATO,
      TipoDeMaterial.PIQUE,
      TipoDeMaterial.CUERO
    )
  ),
  CAMISA_MANGAS_LARGAS(
    Categoria.PARTE_SUPERIOR,
    Arrays.asList(
      TipoDeMaterial.ACETATO,
      TipoDeMaterial.PIQUE,
      TipoDeMaterial.CUERO
    )
  ),
  CHOMBA(
    Categoria.PARTE_SUPERIOR,
    Arrays.asList(
      TipoDeMaterial.ACETATO,
      TipoDeMaterial.CUERO
    )
  ),
  PANTALON(
    Categoria.PARTE_INFERIOR,
    Arrays.asList(
      TipoDeMaterial.PIQUE,
      TipoDeMaterial.CUERO
    )
  );

  private Categoria categoria;
  private List<TipoDeMaterial> materialesInvalidos;

  TipoDePrenda(Categoria categoria, List<TipoDeMaterial> materialesInvalidos) {
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
