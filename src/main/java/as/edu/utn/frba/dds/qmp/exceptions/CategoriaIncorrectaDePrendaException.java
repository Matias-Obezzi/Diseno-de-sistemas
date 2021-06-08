package as.edu.utn.frba.dds.qmp.exceptions;

import as.edu.utn.frba.dds.qmp.domain.prenda.Categoria;

public class CategoriaIncorrectaDePrendaException extends RuntimeException {
  public CategoriaIncorrectaDePrendaException(Categoria categoriaPrenda, Categoria categoriaEsperada) {
    super(String.format(
      "La prenda debia ser de la categoria %s y era de la categoria %s",
      categoriaPrenda.toString(),
      categoriaEsperada.toString()
    ));
  }
}
