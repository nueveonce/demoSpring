
package prueba.demoPrueba.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller /*

*/
@RequestMapping("/")/*
configurar la url que  va escuchar  este controlador
*/
public class PortalControlador {
    @GetMapping("/")/*
    mapea la url cuando se ingresa la barra
    */
    public  String index(){
        return "index.html";
    }
}
