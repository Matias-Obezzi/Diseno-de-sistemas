package as.edu.utn.frba.dds.qmp.domain.alerta.tipoAlerta;

import as.edu.utn.frba.dds.qmp.services.notificacion.NotificacionApp;

public class AlertaTormenta implements TipoAlerta {
  @Override
  public void notificar() {
    new NotificacionApp().enviar("Lleve paraguas, tormenta en su zona");
  }
}
