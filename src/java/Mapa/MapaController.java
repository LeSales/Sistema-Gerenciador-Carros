package Mapa;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

@ViewScoped
@ManagedBean
public class MapaController {
    
    public String lat = "-22.7457115";
    public String lng = "-40.4865772";
    
    public void adicionarMarcacao(){

//        System.out.println("Adicuionandn marcaçao");
//        RequestContext.getCurrentInstance().execute("window.alert(\"OiOi\");");
 //       RequestContext.getCurrentInstance().execute("addm2("+lat+","+lng+")");

    }

}

