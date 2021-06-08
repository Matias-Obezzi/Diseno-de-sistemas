package as.edu.utn.frba.dds.qmp.domain.prenda.material;

public class Material {
  private Trama trama;
  private TipoDeMaterial tipo;
  private Color colorPrincipal;
  private Color colorSecundario;

  public Material(TipoDeMaterial tipoDeMaterial,
                  Color colorPrincipal, Color colorSecundario) {
    this(tipoDeMaterial, colorPrincipal, colorSecundario, Trama.LISA);
  }

  public Material(TipoDeMaterial tipoDeMaterial,
                  Color colorPrincipal, Color colorSecundario,
                  Trama trama) {
    this.trama = trama;
    this.tipo = tipoDeMaterial;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  public Trama trama() {
    return trama;
  }

  public void trama(Trama trama) {
    this.trama = trama;
  }

  public TipoDeMaterial tipo() {
    return tipo;
  }

  public void tipo(TipoDeMaterial tipo) {
    this.tipo = tipo;
  }

  public Color colorPrincipal() {
    return colorPrincipal;
  }

  public void colorPrincipal(Color color) {
    this.colorPrincipal = color;
  }

  public Color colorSecundario() {
    return colorSecundario;
  }

  public void colorSecundario(Color color) {
    this.colorSecundario = color;
  }
}
