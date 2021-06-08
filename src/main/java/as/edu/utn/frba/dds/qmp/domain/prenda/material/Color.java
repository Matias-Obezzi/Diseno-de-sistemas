package as.edu.utn.frba.dds.qmp.domain.prenda.material;

public class Color {
  private int r;
  private int g;
  private int b;

  public Color(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public int r() {
    return r;
  }

  public int g() {
    return g;
  }

  public int b() {
    return b;
  }
}
