package as.edu.utn.frba.dds.qmp.domain.prenda;

import as.edu.utn.frba.dds.qmp.domain.prenda.material.TipoDeMaterial;
import as.edu.utn.frba.dds.qmp.exceptions.TipoMaterialInvalidoParaCategoriaException;

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
    ),
    0,
    99
  ),
  ZAPATILLAS(
    Categoria.CALZADO,
    Arrays.asList(
      TipoDeMaterial.ALGODON,
      TipoDeMaterial.ACETATO,
      TipoDeMaterial.LANA,
      TipoDeMaterial.PIQUE,
      TipoDeMaterial.CUERO
    ),
    0,
    99
  ),
  CAMISA_MANGAS_CORTAS(
    Categoria.PARTE_SUPERIOR,
    Arrays.asList(
      TipoDeMaterial.ACETATO,
      TipoDeMaterial.PIQUE,
      TipoDeMaterial.CUERO
    ),
    20,
    99
  ),
  CAMISA_MANGAS_LARGAS(
    Categoria.PARTE_SUPERIOR,
    Arrays.asList(
      TipoDeMaterial.ACETATO,
      TipoDeMaterial.PIQUE,
      TipoDeMaterial.CUERO
    ),
    0,
    20
  ),
  CHOMBA(
    Categoria.PARTE_SUPERIOR,
    Arrays.asList(
      TipoDeMaterial.ACETATO,
      TipoDeMaterial.CUERO
    ),
    20,
    99
  ),
  PANTALON(
    Categoria.PARTE_INFERIOR,
    Arrays.asList(
      TipoDeMaterial.PIQUE,
      TipoDeMaterial.CUERO
    ),
    0,
    99
  );

  private Categoria categoria;
  private List<TipoDeMaterial> materialesInvalidos;
  private int temperaturaMinima;
  private int temperaturaMaxima;

  TipoDePrenda(Categoria categoria, List<TipoDeMaterial> materialesInvalidos, int temperaturaMinima, int temperaturaMaxima) {
    this.categoria = categoria;
    this.materialesInvalidos = materialesInvalidos;
    this.temperaturaMinima = temperaturaMinima;
    this.temperaturaMaxima = temperaturaMaxima;
  }

  public void validarMaterial(TipoDeMaterial material) throws Exception {
    if (materialesInvalidos.stream().anyMatch(el -> el.equals(material))) {
      throw new TipoMaterialInvalidoParaCategoriaException(material, categoria);
    }
  }

  public boolean temperaturaValida(int temperatura) {
    return temperatura >= this.temperaturaMinima && temperatura <= this.temperaturaMaxima;
  }

  public Categoria categoria() {
    return categoria;
  }
}
