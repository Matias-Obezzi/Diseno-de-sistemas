package as.edu.utn.frba.dds.qmp.exceptions;

import as.edu.utn.frba.dds.qmp.dominio.prenda.Categoria;
import as.edu.utn.frba.dds.qmp.dominio.prenda.material.TipoDeMaterial;

public class TipoMaterialInvalidoParaCategoriaException extends RuntimeException {
  public TipoMaterialInvalidoParaCategoriaException(TipoDeMaterial material, Categoria categoria) {
    super(String.format(
      "El material %s es invalido para la categoria %s",
      material.toString(),
      categoria.toString()
    ));
  }
}
