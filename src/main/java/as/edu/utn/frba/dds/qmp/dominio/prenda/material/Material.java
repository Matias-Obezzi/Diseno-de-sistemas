package as.edu.utn.frba.dds.qmp.dominio.prenda.material;

public class Material {
  private Trama trama = Trama.LISA;
  private TipoDeMaterial tipo;
  private Color colorPrincipal;
  private Color colorSecundario;

  public Material(Trama trama, TipoDeMaterial tipoDeMaterial,
                  Color colorPrincipal, Color colorSecundario) {
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
