package as.edu.utn.frba.dds.qmp.domain.alerta.tipoAlerta;

import as.edu.utn.frba.dds.qmp.services.notificacion.Notificacion;
import as.edu.utn.frba.dds.qmp.services.notificacion.NotificacionApp;
import as.edu.utn.frba.dds.qmp.services.notificacion.NotificacionEmail;

public class AlertaGranizo implements TipoAlerta {
  @Override
  public void notificar() {
    new NotificacionApp().enviar("Evite salir en auto");
    new NotificacionEmail().enviar("Alerta de granizo en su zona");
  }
}
