package as.edu.utn.frba.dds.qmp.dominio;

import as.edu.utn.frba.dds.qmp.dominio.prenda.Categoria;
import as.edu.utn.frba.dds.qmp.dominio.prenda.Prenda;
import as.edu.utn.frba.dds.qmp.exceptions.CategoriaIncorrectaDePrendaException;

public class Atuendo {
  private Prenda calzado;
  private Prenda parteInferior;
  private Prenda parteSuperior;
  private Prenda accesorio;

  public Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    this(parteSuperior, parteInferior, calzado, null);
  }

  public Atuendo (Prenda parteSuperior, Prenda parteInferior, Prenda calzado, Prenda accesorio) {
    this.parteSuperior(parteSuperior);
    this.parteInferior(parteInferior);
    this.calzado(calzado);
    this.accesorio(accesorio);
  }

  public void calzado(Prenda prenda) {
    evaluarCategoriaPrenda(prenda, Categoria.CALZADO);
    this.calzado = prenda;
  }

  public void parteInferior(Prenda prenda) {
    evaluarCategoriaPrenda(prenda, Categoria.PARTE_INFERIOR);
    this.parteInferior = prenda;
  }

  public void parteSuperior(Prenda prenda) {
    evaluarCategoriaPrenda(prenda, Categoria.PARTE_SUPERIOR);
    this.parteSuperior = prenda;
  }

  public void accesorio(Prenda prenda) {
    evaluarCategoriaPrenda(prenda, Categoria.ACCESORIO);
    this.accesorio = prenda;
  }

  private void evaluarCategoriaPrenda(Prenda prenda, Categoria categoriaEsperada) {
    if (prenda == null) {
      return;
    }
    if (!prenda.categoria().equals(categoriaEsperada)) {
      throw new CategoriaIncorrectaDePrendaException(prenda.categoria(), categoriaEsperada);
    }
  }
}
