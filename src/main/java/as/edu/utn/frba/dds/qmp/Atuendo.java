package as.edu.utn.frba.dds.qmp;

import as.edu.utn.frba.dds.qmp.prenda.Prenda;
import java.util.ArrayList;

public class Atuendo {
  ArrayList<Prenda> prendas = new ArrayList<Prenda>();

  public void agregarPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public ArrayList<Prenda> prendas() {
    return this.prendas;
  }
}
